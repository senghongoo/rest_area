package kr.co.sist.restarea;

import java.util.Date;

public class RestareaManageDTO {

	private String name, address, restareaTel, amenities;
	private Date addDate, updateDate;

	public RestareaManageDTO() {
		super();
	}

	public RestareaManageDTO(String name, String address, String restareaTel, String amenities, Date addDate,
			Date updateDate) {
		super();
		this.name = name;
		this.address = address;
		this.restareaTel = restareaTel;
		this.amenities = amenities;
		this.addDate = addDate;
		this.updateDate = updateDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRestareaTel() {
		return restareaTel;
	}

	public void setRestareaTel(String restareaTel) {
		this.restareaTel = restareaTel;
	}

	public String getAmenities() {
		return amenities;
	}

	public void setAmenities(String amenities) {
		this.amenities = amenities;
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
		return "RestareaManageDTO [name=" + name + ", address=" + address + ", restareaTel=" + restareaTel
				+ ", Amenities=" + amenities + ", addDate=" + addDate + ", updateDate=" + updateDate + "]";
	}

}// class
