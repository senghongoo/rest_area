package kr.co.sist.user.bookmark;

import java.sql.SQLException;

public class BookmarkService {
	private static BookmarkService bs;
	
	private BookmarkService() {
		
	}// BookmarkService
	
	public static BookmarkService getInstance() {
		if(bs == null) {
			bs = new BookmarkService();
		}// end if
		return bs;
	}//getInstance
	
	public boolean addBookmark(String id, int code) {
		boolean flag = false;
		
		BookmarkDAO bDAO = BookmarkDAO.getInstance();
		
		try {
			bDAO.insertBookmark(id, code);
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}// end catch
		
		return flag;
	}// addBookmark
	
	public boolean removeBookmark(String id, int code) {
		boolean flag = false;
		
		BookmarkDAO bDAO = BookmarkDAO.getInstance();
		
		try {
			bDAO.deleteBookmark(id, code);
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}// end catch
		
		return flag;
	}// removeBookmark
	
}
