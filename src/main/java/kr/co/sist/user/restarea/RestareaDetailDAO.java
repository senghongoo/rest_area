package kr.co.sist.user.restarea;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.dao.DbConn;


public class RestareaDetailDAO {

    private static RestareaDetailDAO rdDAO;

    private RestareaDetailDAO() {
    }

    public static RestareaDetailDAO getInstance() {
        if (rdDAO == null) {
            rdDAO = new RestareaDetailDAO();
        }
        return rdDAO;
    }

    /** 휴게소 상세 정보 1개 */
    public RestareaDetailDTO selectDetail(int rest_area_code) throws SQLException {
        RestareaDetailDTO dto = null;

        String sql = 
        		"SELECT rest_area_code, rest_area_name, title_img, title_phrase, "
        		+ "address, latitude, longitude, rest_area_tel, gas_station_tel, famous_food, "
        		+ "parking_scale, line, add_date, update_date "
        		+ "FROM rest_area_detail WHERE rest_area_code=?";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = DbConn.getInstance("jdbc/dbcp").getConn();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, rest_area_code);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                dto = new RestareaDetailDTO(
                        rs.getInt("rest_area_code"),
                        rs.getString("rest_area_name"),
                        rs.getString("title_img"),
                        rs.getString("title_phrase"),
                        rs.getString("address"),
                        rs.getDouble("latitude"),
                        rs.getDouble("longitude"),
                        rs.getString("rest_area_tel"),
                        rs.getString("gas_station_tel"),
                        rs.getString("famous_food"),
                        rs.getString("parking_scale"),
                        rs.getString("line"),
                        rs.getDate("add_date"),
                        rs.getDate("update_date"));
            }

        } finally {
            DbConn.getInstance("jdbc/dbcp").dbClose(rs, pstmt, con);
        }

        return dto;
    }
    
    /** 전체 휴게소 목록을 노선(line)별로 조회 */
    public List<RestareaDetailDTO> selectAllRestareas() throws SQLException {
        List<RestareaDetailDTO> list = new ArrayList<>();
        
        // 정렬: 노선(line) 순서대로, 같은 노선 내에서는 휴게소 이름 순서대로 정렬
        String sql = 
                "SELECT rest_area_code, rest_area_name, title_img, title_phrase, "
                + "address, latitude, longitude, rest_area_tel, gas_station_tel, famous_food, "
                + "parking_scale, line, add_date, update_date "
                + "FROM rest_area_detail ORDER BY line, rest_area_name";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = DbConn.getInstance("jdbc/dbcp").getConn();
            pstmt = con.prepareStatement(sql);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                RestareaDetailDTO dto = new RestareaDetailDTO(
                        rs.getInt("rest_area_code"),
                        rs.getString("rest_area_name"),
                        rs.getString("title_img"),
                        rs.getString("title_phrase"),
                        rs.getString("address"),
                        rs.getDouble("latitude"),
                        rs.getDouble("longitude"),
                        rs.getString("rest_area_tel"),
                        rs.getString("gas_station_tel"),
                        rs.getString("famous_food"),
                        rs.getString("parking_scale"),
                        rs.getString("line"),
                        rs.getDate("add_date"),
                        rs.getDate("update_date"));
                list.add(dto);
            }

        } finally {
            DbConn.getInstance("jdbc/dbcp").dbClose(rs, pstmt, con);
        }

        return list;
    }


    /** 볼거리 (facility_code 앞글자='1') */
    public List<ExtraFacilitiesDTO> selectLookPlace(int rest_area_code) throws SQLException {
        return selectFacilities(rest_area_code, "1");
    }

    /** 먹거리 (facility_code 앞글자='2') */
    public List<ExtraFacilitiesDTO> selectFoodPlace(int rest_area_code) throws SQLException {
        return selectFacilities(rest_area_code, "2");
    }

    /** 편의시설 (facility_code 앞글자='3') */
    public List<ExtraFacilitiesDTO> selectConveniencePlace(int rest_area_code) throws SQLException {
        return selectFacilities(rest_area_code, "3");
    }

    /** 공통조회 */
    private List<ExtraFacilitiesDTO> selectFacilities(int rest_area_code, String prefix) throws SQLException {

        List<ExtraFacilitiesDTO> list = new ArrayList<>();

        String sql = "SELECT facility_code, facility_name, facility_img, facility_phrase, rest_area_code "
                + "FROM extra_facilities WHERE rest_area_code=? AND facility_code LIKE ? ORDER BY facility_code";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = DbConn.getInstance("jdbc/dbcp").getConn();
            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, rest_area_code);
            pstmt.setString(2, prefix + "%");

            rs = pstmt.executeQuery();

            while (rs.next()) {
                ExtraFacilitiesDTO dto = new ExtraFacilitiesDTO(
                        rs.getString("facility_code"),
                        rs.getString("facility_name"),
                        rs.getString("facility_img"),
                        rs.getString("facility_phrase"),
                        rs.getInt("rest_area_code"));
                list.add(dto);
            }

        } finally {
            DbConn.getInstance("jdbc/dbcp").dbClose(rs, pstmt, con);
        }

        return list;
    }

}