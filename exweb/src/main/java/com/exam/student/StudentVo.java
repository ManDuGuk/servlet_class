package com.exam.student;

public class StudentVo {
	
	//Value
	//Object

	private String memId;
	private String memName;
	private int memPoint;
	
	//변수에 직접접근하지 못하게 하고 메소드를 이용해서 접하게 하는법==캡슐화
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public int getMemPoint() {
		return memPoint;
	}
	public void setMemPoint(int memPoint) {
		this.memPoint = memPoint;
	}
	
	

	
	
	
	
}
