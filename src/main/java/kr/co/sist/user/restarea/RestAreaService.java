package kr.co.sist.user.restarea;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RestAreaService {
	public List<RestAreaDTO> searchAllRestArea(){
		List<RestAreaDTO> list = new ArrayList<RestAreaDTO>();
		
		RestAreaDAO raDAO = RestAreaDAO.getInstance();
		
		try {
			list = raDAO.selectAllRestArea();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}// searchAllRestArea
	
	public List<Integer> searchBookMarkRestArea(String id){
		List<Integer> list = new ArrayList<Integer>();
		
		RestAreaDAO raDAO = RestAreaDAO.getInstance();
		
		try {
			list = raDAO.selectBookMarkRestArea(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}// searchBookMarkRestArea
	
	public List<String> searchAllLine(){
		List<String> list = new ArrayList<String>();
		
		RestAreaDAO raDAO = RestAreaDAO.getInstance();
		
		try {
			list = raDAO.selectAllLine();
		} catch (SQLException e) {
			e.printStackTrace();
		}// end catch
		
		return list;
	}// searchBookMarkRestArea
	
	
	
	
}// class
