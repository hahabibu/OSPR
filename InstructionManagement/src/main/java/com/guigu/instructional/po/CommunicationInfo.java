package com.guigu.instructional.po;

import java.util.Date;

public class CommunicationInfo {
	private Integer communicationId;

	private Integer studentId;

	private Integer staffId;

	private Date communicationTime;

	private String communicationContent;

	// 添加学生姓名属性和员工姓名属性
	private String studentName;

	private String staffName;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStaffName() {
		return staffName;
	}
	
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public Integer getCommunicationId() {
		return communicationId;
	}

	public void setCommunicationId(Integer communicationId) {
		this.communicationId = communicationId;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public Date getCommunicationTime() {
		return communicationTime;
	}

	public void setCommunicationTime(Date communicationTime) {
		this.communicationTime = communicationTime;
	}

	public String getCommunicationContent() {
		return communicationContent;
	}

	public void setCommunicationContent(String communicationContent) {
		this.communicationContent = communicationContent == null ? null : communicationContent.trim();
	}
}