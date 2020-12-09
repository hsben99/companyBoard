package com.spring.board.vo;

public class MemberVo {
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String postNo;
	private String address;
	private String company;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostNo() {
		return postNo;
	}

	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", postNo=" + postNo
				+ ", address=" + address + ", company=" + company + ", getId()=" + getId() + ", getPw()=" + getPw()
				+ ", getName()=" + getName() + ", getPhone()=" + getPhone() + ", getPostNo()=" + getPostNo()
				+ ", getAddress()=" + getAddress() + ", getCompany()=" + getCompany() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
