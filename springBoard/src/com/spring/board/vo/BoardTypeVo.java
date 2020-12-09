package com.spring.board.vo;

public class BoardTypeVo {
	private String CODE_TYPE;
	private String CODE_ID;
	private String CODE_NAME;
	private String CREATOR;
	private String CREATE_TIME;
	private String MODIFIER;
	private String MODIFIED_TIME;

	public String getCODE_TYPE() {
		return CODE_TYPE;
	}

	public void setCODE_TYPE(String cODE_TYPE) {
		CODE_TYPE = cODE_TYPE;
	}

	public String getCODE_ID() {
		return CODE_ID;
	}

	public void setCODE_ID(String cODE_ID) {
		CODE_ID = cODE_ID;
	}

	public String getCODE_NAME() {
		return CODE_NAME;
	}

	public void setCODE_NAME(String cODE_NAME) {
		CODE_NAME = cODE_NAME;
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

}
