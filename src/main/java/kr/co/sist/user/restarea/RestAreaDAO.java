package kr.co.sist.user.restarea;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.dao.DbConn;

public class RestAreaDAO {
	private static RestAreaDAO raDAO;

	private RestAreaDAO() {
	}// RestAreaDAO

	public static RestAreaDAO getInstance() {
		if (raDAO == null) {
			raDAO = new RestAreaDAO();
		} // end if
		return raDAO;
	}// getInstance
	
	/**
	 * 존재하는 모든 휴게소를 휴게소 목록에 표기할 dto를 조회
	 * @return
	 * @throws SQLException
	 */
	public List<RestAreaDTO> selectAllRestArea() throws SQLException{
		List<RestAreaDTO> list = new ArrayList<RestAreaDTO>();
		
		DbConn dbCon = DbConn.getInstance("jdbc/dbcp");
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		try {
		// 1.JNDI 사용객체 생성
		// 2.DataSource 얻기
		// 3.Connection 얻기
			con = dbCon.getConn();
		// 4.쿼리문 생성 객체 얻기
			String selectAllRestArea = "select rad.REST_AREA_CODE, rad.REST_AREA_NAME, rad.LINE, rad.REST_AREA_TEL, raf.SLEEPING_ROOM, raf.SHOWER_ROOM, raf.REST_HUB, raf.NURSING_ROOM, raf.PHARMACY, raf.AGRICULTURE_MARKET, raf.CAR_WASH, raf.CAR_REPAIR from REST_AREA_DETAIL rad, REST_AREA_FLAG raf where rad.REST_AREA_CODE=raf.REST_AREA_CODE AND rad.DELETE_FLAG='N'";
			pstmt = con.prepareStatement(selectAllRestArea);
		// 5.바인드 반수에 값 설정
			
		// 6.조회 결과 얻기
			RestAreaDTO raDTO=null;
			rs = pstmt.executeQuery();
			while(rs.next()) {
				raDTO = new RestAreaDTO();
				raDTO.setRestAreaCode(rs.getInt("REST_AREA_CODE"));
				raDTO.setRestAreaName(rs.getString("REST_AREA_NAME"));
				raDTO.setLine(rs.getString("Line"));
				raDTO.setTel(rs.getString("REST_AREA_TEL"));
				raDTO.setSleepingRoom(rs.getString("SLEEPING_ROOM"));
				raDTO.setShowerRoom(rs.getString("SHOWER_ROOM"));
				raDTO.setRestHub(rs.getString("REST_HUB"));
				raDTO.setNursingRoom(rs.getString("NURSING_ROOM"));
				raDTO.setPharmacy(rs.getString("PHARMACY"));
				raDTO.setAgricultureMarket(rs.getString("AGRICULTURE_MARKET"));
				raDTO.setCarWash(rs.getString("CAR_WASH"));
				raDTO.setCarRepair(rs.getString("CAR_REPAIR"));
				list.add(raDTO);
			}// end while
		} finally {
			// 7.연결 끊기
			dbCon.dbClose(rs, pstmt, con);
		}// finally
		
		return list;
	}// selectAllRestArea
	
	/**
	 * 즐겨찾기한 휴게소 코드를 조회하는 method
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public List<Integer> selectBookMarkRestArea(String id) throws SQLException{
		List<Integer> list = new ArrayList<Integer>();
		
		DbConn dbCon = DbConn.getInstance("jdbc/dbcp");
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		try {
		// 1.JNDI 사용객체 생성
		// 2.DataSource 얻기
		// 3.Connection 얻기
			con = dbCon.getConn();
		// 4.쿼리문 생성 객체 얻기
			String selectAllDept = "select REST_AREA_CODE from BOOKMARK where USER_ID=?";
			pstmt = con.prepareStatement(selectAllDept);
		// 5.바인드 반수에 값 설정
			pstmt.setString(1, id);
		// 6.조회 결과 얻기
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getInt("REST_AREA_CODE"));
			}// end while
		} finally {
			// 7.연결 끊기
			dbCon.dbClose(rs, pstmt, con);
		}// finally
		
		return list;
	}// selectBookMarkRestArea
	
	public List<String> selectAllLine() throws SQLException{
		List<String> list = new ArrayList<String>();
		
		DbConn dbCon = DbConn.getInstance("jdbc/dbcp");
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		try {
		// 1.JNDI 사용객체 생성
		// 2.DataSource 얻기
		// 3.Connection 얻기
			con = dbCon.getConn();
		// 4.쿼리문 생성 객체 얻기
			String selectAllLine = "SELECT distinct(LINE) line FROM REST_AREA_DETAIL";
			pstmt = con.prepareStatement(selectAllLine);
		// 5.바인드 반수에 값 설정
		// 6.조회 결과 얻기
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("line"));
			}// end while
		} finally {
			// 7.연결 끊기
			dbCon.dbClose(rs, pstmt, con);
		}// finally
		
		return list;
	}// selectAllLine
	
}// class
