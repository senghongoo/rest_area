package kr.co.sist.restarea;

import java.util.Date;

public class RestareaManageDTO {

	private int restareaCode;
	private String name, line, restareaTel, address;
	private Date addDate, updateDate;

	public RestareaManageDTO() {
		super();
	}

	public RestareaManageDTO(int restareaCode, String name, String line, String restareaTel, String address,
			Date addDate, Date updateDate) {
		super();
		this.restareaCode = restareaCode;
		this.name = name;
		this.line = line;
		this.restareaTel = restareaTel;
		this.address = address;
		this.addDate = addDate;
		this.updateDate = updateDate;
	}

	public int getRestareaCode() {
		return restareaCode;
	}

	public void setRestareaCode(int restareaCode) {
		this.restareaCode = restareaCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getRestareaTel() {
		return restareaTel;
	}

	public void setRestareaTel(String restareaTel) {
		this.restareaTel = restareaTel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "RestareaManageDTO [restareaCode=" + restareaCode + ", name=" + name + ", line=" + line
				+ ", restareaTel=" + restareaTel + ", address=" + address + ", addDate=" + addDate + ", updateDate="
				+ updateDate + "]";
	}

}// class
