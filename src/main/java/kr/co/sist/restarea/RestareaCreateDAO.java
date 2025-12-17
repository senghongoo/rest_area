package kr.co.sist.restarea;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.sist.dao.DbConn;

public class RestareaCreateDAO {

	private static RestareaCreateDAO rcDAO;

	private RestareaCreateDAO() {

	}// RestareaCreateDAO

	public static RestareaCreateDAO getInstance() {
		if (rcDAO == null) {
			rcDAO = new RestareaCreateDAO();
		} // end if

		return rcDAO;
	}// getInstance

	public int selectRestareaCode(String line) throws SQLException {
		int restareaCode = 0;

		DbConn dbCon = DbConn.getInstance("jdbc/dbcp");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = dbCon.getConn();

			String selectRestareaCode = "	select max(rest_area_code) code from rest_area_detail where line = ?	";

			pstmt = con.prepareStatement(selectRestareaCode);

			pstmt.setString(1, line);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				restareaCode = rs.getInt("code");
			} // end if
		} finally {
			dbCon.dbClose(rs, pstmt, con);
		} // end finally

		return restareaCode;
	}// selectRestareaCode

	public int insertAmenities(int restareaCode, AmenitiesDTO aDTO) throws SQLException {
		int result = 0;

		DbConn dbCon = DbConn.getInstance("jdbc/dbcp");

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = dbCon.getConn();

			String insertAmenities = "	insert into rest_area_flag(rest_area_code, sleeping_room, shower_room, rest_hub, nursing_room, pharmacy, agriculture_market, car_wash, car_repair) values(?,?,?,?,?,?,?,?,?)	";
			pstmt = con.prepareStatement(insertAmenities);

			pstmt.setInt(1, restareaCode);
			pstmt.setString(2, aDTO.getSleepingRoom());
			pstmt.setString(3, aDTO.getShowerRoom());
			pstmt.setString(4, aDTO.getRestHub());
			pstmt.setString(5, aDTO.getNursingRoom());
			pstmt.setString(6, aDTO.getPharmacy());
			pstmt.setString(7, aDTO.getAgricultureMarket());
			pstmt.setString(8, aDTO.getCarWash());
			pstmt.setString(9, aDTO.getCarRepair());

			result = pstmt.executeUpdate();
		} finally {
			dbCon.dbClose(null, pstmt, con);
		} // end finally

		return result;
	}// insertAmenities

	public int insertRestareaDetail(int restareaCode, RestareaDetailDTO rdDTO) throws SQLException {
		int result = 0;

		DbConn dbCon = DbConn.getInstance("jdbc/dbcp");

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = dbCon.getConn();

			String insertRestareaDetail = "	insert into rest_area_detail(rest_area_code, rest_area_name, line, title_img, title_phrase, address, latitude, longitude, rest_area_tel, gas_station_tel, famous_food, parking_scale, delete_flag, update_date) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 'N', sysdate)	";
			pstmt = con.prepareStatement(insertRestareaDetail);

			pstmt.setInt(1, restareaCode);
			pstmt.setString(2, rdDTO.getName());
			pstmt.setString(3, rdDTO.getLine());
			pstmt.setString(4, rdDTO.getImg());
			pstmt.setString(5, rdDTO.getPhrase());
			pstmt.setString(6, rdDTO.getAddress());
			pstmt.setDouble(7, rdDTO.getLatitude());
			pstmt.setDouble(8, rdDTO.getLongitude());
			pstmt.setString(9, rdDTO.getRestareaTel());
			pstmt.setString(10, rdDTO.getGasstationTel());
			pstmt.setString(11, rdDTO.getFood());
			pstmt.setString(12, rdDTO.getScale());

			result = pstmt.executeUpdate();
		} finally {
			dbCon.dbClose(null, pstmt, con);
		} // end finally

		return result;
	}// insertRestareaDetail

	public int insertExtraFacilities(int restareaCode, ExtraFacilitiesDTO efDTO) throws SQLException {
		int result = 0;

		DbConn dbCon = DbConn.getInstance("jdbc/dbcp");

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = dbCon.getConn();

			String insertExtraFacilities = "	insert into extra_facilities(rest_area_code, facility_code, facility_name, facility_img, facility_phrase) values(?,?,?,?,?)	";

			pstmt = con.prepareStatement(insertExtraFacilities);

			pstmt.setInt(1, restareaCode);
			pstmt.setString(2, efDTO.getFacilityCode());
			pstmt.setString(3, efDTO.getName());
			pstmt.setString(4, efDTO.getImg());
			pstmt.setString(5, efDTO.getPhrase());

			result = pstmt.executeUpdate();
		} finally {
			dbCon.dbClose(null, pstmt, con);
		} // end finally

		return result;
	}// insertExtraFacilities

}// class
