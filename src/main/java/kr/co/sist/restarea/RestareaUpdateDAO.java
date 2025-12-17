package kr.co.sist.restarea;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.dao.DbConn;

public class RestareaUpdateDAO {

	private static RestareaUpdateDAO ruDAO;

	private RestareaUpdateDAO() {

	}// RestareaUpdateDAO

	public static RestareaUpdateDAO getInstance() {
		if (ruDAO == null) {
			ruDAO = new RestareaUpdateDAO();
		} // end if

		return ruDAO;
	}// getInstance

	public AmenitiesDTO selectAmenities(int restareaCode) throws SQLException {
		AmenitiesDTO aDTO = null;

		DbConn dbCon = DbConn.getInstance("jdbc/dbcp");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = dbCon.getConn();

			StringBuilder selectAmenities = new StringBuilder();
			selectAmenities.append(
					"	select sleeping_room, shower_room, rest_hub, nursing_room, pharmacy, agriculture_market, car_wash, car_repair	")
					.append("	from rest_area_flag	").append("	where rest_area_code=?	");

			pstmt = con.prepareStatement(selectAmenities.toString());

			pstmt.setInt(1, restareaCode);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				aDTO = new AmenitiesDTO();
				aDTO.setRestareaCode(restareaCode);
				aDTO.setSleepingRoom(rs.getString("sleeping_room"));
				aDTO.setShowerRoom(rs.getString("shower_room"));
				aDTO.setRestHub(rs.getString("rest_hub"));
				aDTO.setNursingRoom(rs.getString("nursing_room"));
				aDTO.setPharmacy(rs.getString("pharmacy"));
				aDTO.setAgricultureMarket(rs.getString("agriculture_market"));
				aDTO.setCarWash(rs.getString("car_wash"));
				aDTO.setCarRepair(rs.getString("car_repair"));
			} // end while

		} finally {
			dbCon.dbClose(rs, pstmt, con);
		} // end finally

		return aDTO;
	}// selectAmenities

	public RestareaDetailDTO selectRestareaDetail(int restareaCode) throws SQLException {
		RestareaDetailDTO rdDTO = null;

		DbConn dbCon = DbConn.getInstance("jdbc/dbcp");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = dbCon.getConn();

			StringBuilder selectRestareaDetail = new StringBuilder();
			selectRestareaDetail.append(
					"	select rest_area_name, line, title_img, title_phrase, address, latitude, longitude, rest_area_tel, gas_station_tel, famous_food, parking_scale	")
					.append("	from rest_area_detail	").append("	where rest_area_code=?	");

			pstmt = con.prepareStatement(selectRestareaDetail.toString());

			pstmt.setInt(1, restareaCode);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				rdDTO = new RestareaDetailDTO();
				rdDTO.setRestareaCode(restareaCode);
				rdDTO.setName(rs.getString("rest_area_name"));
				rdDTO.setLine(rs.getString("line"));
				rdDTO.setImg(rs.getString("title_img"));
				rdDTO.setPhrase(rs.getString("title_phrase"));
				rdDTO.setAddress(rs.getString("address"));
				rdDTO.setLatitude(rs.getDouble("latitude"));
				rdDTO.setLongitude(rs.getDouble("longitude"));
				rdDTO.setRestareaTel(rs.getString("rest_area_tel"));
				rdDTO.setGasstationTel(rs.getString("gas_station_tel"));
				rdDTO.setFood(rs.getString("famous_food"));
				rdDTO.setScale(rs.getString("parking_scale"));
			} // end while

		} finally {
			dbCon.dbClose(rs, pstmt, con);
		} // end finally

		return rdDTO;
	}// selectRestareaDetail

	public List<ExtraFacilitiesDTO> selectExtraFacilities(int restareaCode) throws SQLException {
		List<ExtraFacilitiesDTO> efDTOList = new ArrayList<ExtraFacilitiesDTO>();

		DbConn dbCon = DbConn.getInstance("jdbc/dbcp");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = dbCon.getConn();

			StringBuilder selectExtraFacilities = new StringBuilder();
			selectExtraFacilities.append("	select facility_code, facility_name, facility_img, facility_phrase	")
					.append("	from extra_facilities	").append("	where rest_area_code=?	");

			pstmt = con.prepareStatement(selectExtraFacilities.toString());

			pstmt.setInt(1, restareaCode);

			rs = pstmt.executeQuery();

			ExtraFacilitiesDTO efDTO = null;

			while (rs.next()) {
				efDTO = new ExtraFacilitiesDTO();
				efDTO.setRestareaCode(restareaCode);
				efDTO.setFacilityCode(rs.getString("facility_code"));
				efDTO.setName(rs.getString("facility_name"));
				efDTO.setImg(rs.getString("facility_img"));
				efDTO.setPhrase(rs.getString("facility_phrase"));

				efDTOList.add(efDTO);
			} // end while

		} finally {
			dbCon.dbClose(rs, pstmt, con);
		} // end finally

		return efDTOList;
	}// selectExtraFacilities

	public int updateAmenities(int restareaCode, AmenitiesDTO aDTO) throws SQLException {
		int result = 0;

		DbConn dbCon = DbConn.getInstance("jdbc/dbcp");

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = dbCon.getConn();

			StringBuilder updateAmenities = new StringBuilder();
			updateAmenities.append("	update rest_area_flag	").append(
					"	set sleeping_room = ?, shower_room = ?, rest_hub = ?, nursing_room = ?, pharmacy = ?, agriculture_market = ?, car_wash = ?, car_repair = ?	")
					.append("	where rest_area_code=?  ");

			pstmt = con.prepareStatement(updateAmenities.toString());

			pstmt.setString(1, aDTO.getSleepingRoom());
			pstmt.setString(2, aDTO.getShowerRoom());
			pstmt.setString(3, aDTO.getRestHub());
			pstmt.setString(4, aDTO.getNursingRoom());
			pstmt.setString(5, aDTO.getPharmacy());
			pstmt.setString(6, aDTO.getAgricultureMarket());
			pstmt.setString(7, aDTO.getCarWash());
			pstmt.setString(8, aDTO.getCarRepair());
			pstmt.setInt(9, restareaCode);

			result = pstmt.executeUpdate();
		} finally {
			dbCon.dbClose(null, pstmt, con);
		} // end finally

		return result;
	}// updateAmenities

	public int updateRestareaDetail(int restareaCode, RestareaDetailDTO rdDTO) throws SQLException {
		int result = 0;

		DbConn dbCon = DbConn.getInstance("jdbc/dbcp");

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = dbCon.getConn();

			StringBuilder updateRestareaDetail = new StringBuilder();
			updateRestareaDetail.append("	update rest_area_detail	").append(
					"	set rest_area_name = ?, line = ?, title_img = ?, title_phrase = ?, address = ?, latitude = ?, longitude = ?, rest_area_tel = ?, gas_station_tel = ?, famous_food = ?, parking_scale = ?, update_date = sysdate	")
					.append("	where rest_area_code=?  ");

			pstmt = con.prepareStatement(updateRestareaDetail.toString());

			pstmt.setString(1, rdDTO.getName());
			pstmt.setString(2, rdDTO.getLine());
			pstmt.setString(3, rdDTO.getImg());
			pstmt.setString(4, rdDTO.getPhrase());
			pstmt.setString(5, rdDTO.getAddress());
			pstmt.setDouble(6, rdDTO.getLatitude());
			pstmt.setDouble(7, rdDTO.getLongitude());
			pstmt.setString(8, rdDTO.getRestareaTel());
			pstmt.setString(9, rdDTO.getGasstationTel());
			pstmt.setString(10, rdDTO.getFood());
			pstmt.setString(11, rdDTO.getScale());
			pstmt.setInt(12, restareaCode);

			result = pstmt.executeUpdate();
		} finally {
			dbCon.dbClose(null, pstmt, con);
		} // end finally

		return result;
	}// updateRestareaDetail

	public int deleteExtraFacilities(int restareaCode) throws SQLException {
		int result = 0;

		DbConn dbCon = DbConn.getInstance("jdbc/dbcp");

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = dbCon.getConn();

			String deleteExtraFacilities = ("	delete from extra_facilities where rest_area_code = ?	");

			pstmt = con.prepareStatement(deleteExtraFacilities);

			pstmt.setInt(1, restareaCode);

			result = pstmt.executeUpdate();
		} finally {
			dbCon.dbClose(null, pstmt, con);
		} // end finally

		return result;
	}// deleteExtraFacilities

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

	public int deleteRestarea(int restareaCode) throws SQLException {
		int result = 0;

		DbConn dbCon = DbConn.getInstance("jdbc/dbcp");

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = dbCon.getConn();

			StringBuilder updateOneRestarea = new StringBuilder();
			updateOneRestarea.append("	update rest_area_detail	").append("	set delete_flag = 'Y'   ")
					.append("	where rest_area_code=?  ");

			pstmt = con.prepareStatement(updateOneRestarea.toString());

			pstmt.setInt(1, restareaCode);

			result = pstmt.executeUpdate();
		} finally {
			dbCon.dbClose(null, pstmt, con);
		} // end finally

		return result;
	}// deleteRestarea

}// class
