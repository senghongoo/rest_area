package kr.co.sist.member;

import java.util.Date;

public class MemberManageDTO {

	private String id, email;
	private Date joinDate;

	public MemberManageDTO() {
		super();
	}

	public MemberManageDTO(String id, String email, Date joinDate) {
		super();
		this.id = id;
		this.email = email;
		this.joinDate = joinDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "MemberManageDTO [id=" + id + ", email=" + email + ", joinDate=" + joinDate + "]";
	}

}// class
