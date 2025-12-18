package kr.co.sist.restarea;

import java.sql.SQLException;
import java.util.List;

public class RestareaManageService {

	private static RestareaManageService rms;

	private RestareaManageService() {

	}// RestareaManageService

	public static RestareaManageService getInstance() {
		if (rms == null) {
			rms = new RestareaManageService();
		} // end if

		return rms;
	}// getInstance

	public int searchTotalCnt(RangeDTO rDTO) {
		int totalCnt = 0;

		RestareaManageDAO rmDAO = RestareaManageDAO.getInstance();

		try {
			totalCnt = rmDAO.selectTotalCnt(rDTO);
		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch

		return totalCnt;
	}// searchTotalCnt

	public int pageScale() {
		return 10;
	}// pageScale

	public int totalPage(int totalCnt, int pageScale) {
		return (int) Math.ceil((double) totalCnt / pageScale);
	}// totalPage

	public int startNum(int currentPage, int pageScale) {
		return (currentPage - 1) * pageScale + 1;
	}// startNum

	public int endNum(int startNum, int pageScale) {
		return startNum + pageScale - 1;
	}// endNum

	public String pagination(RangeDTO rDTO) {
		StringBuilder pagination = new StringBuilder();

		int pageNumber = 3;

		int startPage = ((rDTO.getCurrentPage() - 1) / pageNumber) * pageNumber + 1;

		int endPage = (((startPage - 1) + pageNumber) / pageNumber) * pageNumber;

		if (rDTO.getTotalPage() <= endPage) {
			endPage = rDTO.getTotalPage();
		} // end if

		int movePage = 0;
		StringBuilder prevMark = new StringBuilder();

		prevMark.append("<li class='page-item disabled'><a class='page-link' href='#' aria-label='Previous'>"
				+ "<span aria-hidden='true'>&laquo;</span>"
				+ "</a></li>");

		if (rDTO.getCurrentPage() > pageNumber) {
			movePage = startPage - 1;
			prevMark.delete(0, prevMark.length());
			prevMark.append("<li class='page-item'><a class='page-link' href='").append(rDTO.getUrl()).append("?currentPage=").append(movePage);
			
			if( rDTO.getKeyword() != null && !rDTO.getKeyword().isEmpty() ) {
				prevMark.append("&keyword=").append(rDTO.getKeyword());
			}//end if
			
			prevMark.append("' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>");
		} // end if

		StringBuilder pageLink = new StringBuilder();
		movePage = startPage;

		while (movePage <= endPage) {
			if (movePage == rDTO.getCurrentPage()) {
				pageLink.append("<li class='page-item'><a class='page-link' href='#'>").append(movePage).append("</a></li>");
			} else {
				pageLink.append("<li class='page-item'><a class='page-link' href='").append(rDTO.getUrl()).append("?currentPage=")
						.append(movePage);
				
				if( rDTO.getKeyword() != null && !rDTO.getKeyword().isEmpty() ) {
					pageLink.append("&keyword=").append(rDTO.getKeyword());
				}//end if
				
				pageLink.append("'>").append(movePage).append("</a></li>");
			} // end else

			movePage++;
		} // end while

		StringBuilder nextMark = new StringBuilder("<li class='page-item disabled'><a class='page-link' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
		if (rDTO.getTotalPage() > endPage) {
			movePage = endPage + 1;
			nextMark.delete(0, nextMark.length());
			nextMark.append("<li class='page-item'><a class='page-link' href='").append(rDTO.getUrl()).append("?currentPage=")
					.append(movePage);
			
			if( rDTO.getKeyword() != null && !rDTO.getKeyword().isEmpty() ) {
				nextMark.append("&keyword=").append(rDTO.getKeyword());
			}//end if
			
			nextMark.append("'><span aria-hidden='true'>&raquo;</span></a></li>");
		} // end if

		pagination.append(prevMark).append(pageLink).append(nextMark);

		return pagination.toString();
	}// pagination

	public List<RestareaManageDTO> searchRestareaList(RangeDTO rDTO) {
		List<RestareaManageDTO> list = null;

		RestareaManageDAO rmDAO = RestareaManageDAO.getInstance();

		try {
			list = rmDAO.selectRangeRestarea(rDTO);
		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch

		return list;
	}// searchRestareaList

}// class
