package kr.co.sist.restarea;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kr.co.sist.dao.DbConn;

public class RestareaManageDAO {

	private static RestareaManageDAO rmDAO;

	private RestareaManageDAO() {
		
	}// RestareaManageDAO

	public static RestareaManageDAO getInstance() {
		if (rmDAO == null) {
			rmDAO = new RestareaManageDAO();
		} // end if

		return rmDAO;
	}// getInstance

	public int selectTotalCnt( RangeDTO rDTO ) throws SQLException {
		int totalCnt = 0;

		DbConn dbCon = DbConn.getInstance("jdbc/dbcp");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = dbCon.getConn();

			StringBuilder selectTotal = new StringBuilder();
			selectTotal.append("select count(*) cnt from rest_area_detail where delete_flag = 'N'");
			
			if( rDTO.getKeyword() != null && !rDTO.getKeyword().isEmpty()){
				selectTotal.append(" and instr(rest_area_name,?) != 0");
			}//end if
			
			pstmt = con.prepareStatement(selectTotal.toString());

			if( rDTO.getKeyword() != null && !rDTO.getKeyword().isEmpty()){
				pstmt.setString(1, rDTO.getKeyword());
			}//end if
			
			rs = pstmt.executeQuery();

			if (rs.next()) {
				totalCnt = rs.getInt("cnt");
			} // end if
		} finally {
			dbCon.dbClose(rs, pstmt, con);
		} // end finally

		return totalCnt;
	}// selectTotalCnt

	public List<RestareaManageDTO> selectRangeRestarea(RangeDTO rDTO) throws SQLException {
		List<RestareaManageDTO> list = new ArrayList<RestareaManageDTO>();

		DbConn dbCon = DbConn.getInstance("jdbc/dbcp");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = dbCon.getConn();

			StringBuilder selectRangeRestarea = new StringBuilder();
			selectRangeRestarea
			.append("	select rest_area_code, rest_area_name, line, 	     ")
			.append("	rest_area_tel, address, add_date, update_date 	     ")
			.append("	from (	select rest_area_code, rest_area_name, line, ")
			.append("	rest_area_tel, address, add_date, update_date, 	     ")
			.append("	row_number() over( order by add_date desc ) rnum     ")
			.append("	from rest_area_detail								 ")
			.append("	where  delete_flag = 'N'  						     ");
			
			if( rDTO.getKeyword() != null && !rDTO.getKeyword().isEmpty()){
				selectRangeRestarea.append(" and instr(rest_area_name,?) != 0");
			}//end if
			
			selectRangeRestarea
			.append("	) where rnum between ? and ?					     ");
			
			pstmt = con.prepareStatement(selectRangeRestarea.toString());
			
			int pstmtIdx=0;
			if( rDTO.getKeyword() != null && !rDTO.getKeyword().isEmpty()){
				pstmt.setString(++pstmtIdx, rDTO.getKeyword());
			}//end if
			
			pstmt.setInt(++pstmtIdx, rDTO.getStartNum());
			pstmt.setInt(++pstmtIdx, rDTO.getEndNum());

			rs = pstmt.executeQuery();

			RestareaManageDTO rmDTO = null;

			while (rs.next()) {
				rmDTO = new RestareaManageDTO();
				rmDTO.setRestareaCode(rs.getInt("rest_area_code"));
				rmDTO.setName(rs.getString("rest_area_name"));
				rmDTO.setLine(rs.getString("line"));
				rmDTO.setAddress(rs.getString("address"));
				rmDTO.setRestareaTel(rs.getString("rest_area_tel"));
				rmDTO.setAddDate(rs.getDate("add_date"));
				rmDTO.setUpdateDate(rs.getDate("update_date"));

				list.add(rmDTO);
			} // end while
		} finally {
			dbCon.dbClose(rs, pstmt, con);
		} // end finally

		return list;
	}// selectRangeRestarea

}// class
