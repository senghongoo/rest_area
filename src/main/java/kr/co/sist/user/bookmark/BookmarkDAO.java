package kr.co.sist.user.bookmark;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.co.sist.dao.DbConn;

public class BookmarkDAO {
	private static BookmarkDAO bDAO;
	
	private BookmarkDAO() {
		
	}// BookmarkDAO
	
	public static BookmarkDAO getInstance() {
		if(bDAO == null) {
			bDAO = new BookmarkDAO();
		}// end if
		return bDAO;
	}//getInstance
	
	public void insertBookmark(String id, int code) throws SQLException {
		
		DbConn dbCon = DbConn.getInstance("jdbc/dbcp");
		Connection con = null;
		PreparedStatement pstmt=null;
		
		try {
		// 1.JNDI 사용객체 생성
		// 2.DataSource 얻기
		// 3.Connection 얻기
			con = dbCon.getConn();
		// 4.쿼리문 생성 객체 얻기
			String insertBookmark = "INSERT INTO BOOKMARK(USER_ID, REST_AREA_CODE) VALUES (?,?)";
			pstmt = con.prepareStatement(insertBookmark);
		// 5.바인드 반수에 값 설정
			pstmt.setString(1, id);
			pstmt.setInt(2, code);
		// 6.조회 결과 얻기
			pstmt.executeUpdate();
		} finally {
			// 7.연결 끊기
			dbCon.dbClose(null, pstmt, con);
		}// finally
	}// insertBookmark
	
	public void deleteBookmark(String id, int code) throws SQLException {
		
		DbConn dbCon = DbConn.getInstance("jdbc/dbcp");
		Connection con = null;
		PreparedStatement pstmt=null;
		
		try {
			// 1.JNDI 사용객체 생성
			// 2.DataSource 얻기
			// 3.Connection 얻기
			con = dbCon.getConn();
			// 4.쿼리문 생성 객체 얻기
			String deleteBookmark = "delete FROM BOOKMARK WHERE USER_ID=? and  REST_AREA_CODE=?";
			pstmt = con.prepareStatement(deleteBookmark);
			// 5.바인드 반수에 값 설정
			pstmt.setString(1, id);
			pstmt.setInt(2, code);
			// 6.조회 결과 얻기
			pstmt.executeUpdate();
		} finally {
			// 7.연결 끊기
			dbCon.dbClose(null, pstmt, con);
		}// finally
	}// deleteBookmark
	
}// class
