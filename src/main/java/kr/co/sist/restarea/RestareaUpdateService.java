package kr.co.sist.restarea;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.dao.DbConn;

public class RestareaUpdateService {

	private static RestareaUpdateService rus;

	private RestareaUpdateService() {

	}// RestareaUpdateService

	public static RestareaUpdateService getInstance() {
		if (rus == null) {
			rus = new RestareaUpdateService();
		} // end if

		return rus;
	}// getInstance

	public AmenitiesDTO searchAmenities(int restareaCode) {
		AmenitiesDTO aDTO = null;

		RestareaUpdateDAO ruDAO = RestareaUpdateDAO.getInstance();

		try {
			aDTO = ruDAO.selectAmenities(restareaCode);
		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch

		return aDTO;
	}// searchAmenities

	public RestareaDetailDTO searchRestareaDetail(int restareaCode) {
		RestareaDetailDTO rdDTO = null;

		RestareaUpdateDAO ruDAO = RestareaUpdateDAO.getInstance();

		try {
			rdDTO = ruDAO.selectRestareaDetail(restareaCode);
		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch

		return rdDTO;
	}// searchRestareaDetail

	public List<ExtraFacilitiesDTO> searchExtraFacilities(int restareaCode) {
		List<ExtraFacilitiesDTO> efDTOList = new ArrayList<ExtraFacilitiesDTO>();

		RestareaUpdateDAO ruDAO = RestareaUpdateDAO.getInstance();

		try {
			efDTOList = ruDAO.selectExtraFacilities(restareaCode);
		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch

		return efDTOList;
	}// searchExtraFacilities

	public boolean modifyRestarea(int restareaCode, AmenitiesDTO aDTO, RestareaDetailDTO rdDTO, List<ExtraFacilitiesDTO> efDTOList) throws SQLException {
		boolean flag = false;

		DbConn dbCon = DbConn.getInstance("jdbc/dbcp");
		Connection con = null;

		try {
			con = dbCon.getConn();
			con.setAutoCommit(false);

			RestareaUpdateDAO ruDAO = RestareaUpdateDAO.getInstance();

			int modifyRdDTOResult = 0;
			int modifyADTOResult = 0;
			int modifyEfDTOResult = 0;

			modifyRdDTOResult = ruDAO.updateRestareaDetail(restareaCode, rdDTO);
			modifyADTOResult = ruDAO.updateAmenities(restareaCode, aDTO);

			ruDAO.deleteExtraFacilities(restareaCode);

			for (ExtraFacilitiesDTO efDTO : efDTOList) {
				modifyEfDTOResult += ruDAO.insertExtraFacilities(restareaCode, efDTO);
			} // end for

			if (modifyRdDTOResult == 1 && modifyADTOResult == 1 && modifyEfDTOResult == efDTOList.size()) {
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
	}// modifyRestarea

	public boolean removeRestarea(int restareaCode) {
		boolean flag = false;

		RestareaUpdateDAO ruDAO = RestareaUpdateDAO.getInstance();

		try {
			int result = ruDAO.deleteRestarea(restareaCode);
			flag = (result == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch

		return flag;
	}// removeRestarea

}// class
