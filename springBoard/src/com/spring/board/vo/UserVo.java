package com.spring.board.vo;

public class UserVo {
	private String USER_ID;   
	private String USER_PW;   
	private String USER_NAME;   
	private String USER_PHONE1;   
	private String USER_PHONE2;   
	private String USER_PHONE3;   
	private String USER_ADDR1;    
	private String USER_ADDR2;  
	private String USER_COMPANY;  
	private String CREATOR;       
	private String CREATE_TIME;   
	private String MODIFIER;      
	private String MODIFIED_TIME;
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getUSER_PW() {
		return USER_PW;
	}
	public void setUSER_PW(String uSER_PW) {
		USER_PW = uSER_PW;
	}
	public String getUSER_NAME() {
		return USER_NAME;
	}
	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	public String getUSER_PHONE1() {
		return USER_PHONE1;
	}
	public void setUSER_PHONE1(String uSER_PHONE1) {
		USER_PHONE1 = uSER_PHONE1;
	}
	public String getUSER_PHONE2() {
		return USER_PHONE2;
	}
	public void setUSER_PHONE2(String uSER_PHONE2) {
		USER_PHONE2 = uSER_PHONE2;
	}
	public String getUSER_PHONE3() {
		return USER_PHONE3;
	}
	public void setUSER_PHONE3(String uSER_PHONE3) {
		USER_PHONE3 = uSER_PHONE3;
	}
	public String getUSER_ADDR1() {
		return USER_ADDR1;
	}
	public void setUSER_ADDR1(String uSER_ADDR1) {
		USER_ADDR1 = uSER_ADDR1;
	}
	public String getUSER_ADDR2() {
		return USER_ADDR2;
	}
	public void setUSER_ADDR2(String uSER_ADDR2) {
		USER_ADDR2 = uSER_ADDR2;
	}
	public String getUSER_COMPANY() {
		return USER_COMPANY;
	}
	public void setUSER_COMPANY(String uSER_COMPANY) {
		USER_COMPANY = uSER_COMPANY;
	}
	public String getCREATOR() {
		return CREATOR;
	}
	public void setCREATOR(String cREATOR) {
		CREATOR = cREATOR;
	}
	public String getCREATE_TIME() {
		return CREATE_TIME;
	}
	public void setCREATE_TIME(String cREATE_TIME) {
		CREATE_TIME = cREATE_TIME;
	}
	public String getMODIFIER() {
		return MODIFIER;
	}
	public void setMODIFIER(String mODIFIER) {
		MODIFIER = mODIFIER;
	}
	public String getMODIFIED_TIME() {
		return MODIFIED_TIME;
	}
	public void setMODIFIED_TIME(String mODIFIED_TIME) {
		MODIFIED_TIME = mODIFIED_TIME;
	}
	@Override
	public String toString() {
		return "UserVo [USER_ID=" + USER_ID + ", USER_PW=" + USER_PW + ", USER_NAME=" + USER_NAME + ", USER_PHONE1="
				+ USER_PHONE1 + ", USER_PHONE2=" + USER_PHONE2 + ", USER_PHONE3=" + USER_PHONE3 + ", USER_ADDR1="
				+ USER_ADDR1 + ", USER_ADDR2=" + USER_ADDR2 + ", USER_COMPANY=" + USER_COMPANY + ", CREATOR=" + CREATOR
				+ ", CREATE_TIME=" + CREATE_TIME + ", MODIFIER=" + MODIFIER + ", MODIFIED_TIME=" + MODIFIED_TIME + "]";
	}
	
	
}
