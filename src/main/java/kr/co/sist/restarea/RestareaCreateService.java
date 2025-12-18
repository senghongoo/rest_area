package kr.co.sist.restarea;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import kr.co.sist.dao.DbConn;

public class RestareaCreateService {

	private static RestareaCreateService rcs;

	private RestareaCreateService() {

	}// RestareaCreateService

	public static RestareaCreateService getInstance() {
		if (rcs == null) {
			rcs = new RestareaCreateService();
		} // end if

		return rcs;
	}// getInstance

	public int searchRestareaCode(String line) {
		int restareaCode = 0;

		RestareaCreateDAO rcDAO = RestareaCreateDAO.getInstance();

		try {
			restareaCode = rcDAO.selectRestareaCode(line);
		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch

		return restareaCode;
	}// searchRestareaCode

	public boolean addRestarea(int restareaCode, AmenitiesDTO aDTO, RestareaDetailDTO rdDTO,
			List<ExtraFacilitiesDTO> efDTOList) throws SQLException {
		boolean flag = false;

		DbConn dbCon = DbConn.getInstance("jdbc/dbcp");
		Connection con = null;

		try {
			con = dbCon.getConn();
			con.setAutoCommit(false);

			RestareaCreateDAO rcDAO = RestareaCreateDAO.getInstance();

			int addRdDTOResult = 0;
			int addADTOResult = 0;
			int addEfDTOResult = 0;

			addRdDTOResult = rcDAO.insertRestareaDetail(restareaCode, rdDTO);
			addADTOResult = rcDAO.insertAmenities(restareaCode, aDTO);

			for (ExtraFacilitiesDTO efDTO : efDTOList) {
				addEfDTOResult += rcDAO.insertExtraFacilities(restareaCode, efDTO);
			} // end for

			if (addRdDTOResult == 1 && addADTOResult == 1 && addEfDTOResult == efDTOList.size()) {
				con.commit();
				flag = true;
			} else {
				con.rollback();
			} // end if
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbCon.dbClose(null, null, con);
		} // end finally

		return flag;
	}// addRestarea

}// class
