package kr.co.sist.restarea;

public class RangeDTO {

	private int startNum, endNum;
	private int totalPage = 0;
	private int currentPage = 1;
	private String keyword, url;

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "RangeDTO [startNum=" + startNum + ", endNum=" + endNum + ", totalPage=" + totalPage + ", currentPage="
				+ currentPage + ", keyword=" + keyword + ", url=" + url + "]";
	}

}// class
