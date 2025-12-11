package kr.co.sist.member;

import java.util.Date;

public class MemberDetailDTO {

	private String id, name, tel, phone, email, gender, postcode, address, addressDetail;
	private Date birth;

	public MemberDetailDTO() {
		super();
	}

	public MemberDetailDTO(String id, String name, String tel, String phone, String email, String gender,
			String postcode, String address, String addressDetail, Date birth) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
		this.postcode = postcode;
		this.address = address;
		this.addressDetail = addressDetail;
		this.birth = birth;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "MemberDetailDTO [id=" + id + ", name=" + name + ", tel=" + tel + ", phone=" + phone + ", email=" + email
				+ ", gender=" + gender + ", postcode=" + postcode + ", address=" + address + ", addressDetail="
				+ addressDetail + ", birth=" + birth + "]";
	}

}// class
