package com.guigu.instructional.po;

import java.util.Date;

public class TrackRecordInfo {
    private Integer trackRecordId;

    private Integer studentId;

    private String trackRecordTitle;

    private String trackRecordContent;

    private Date trackRecordTime;

    private Integer enrollment;

    private Date nextRecordTime;
    
    // 添加学员姓名属性、学员意向状态详细描述
    private String studentName;
    
    private String enrollmentDescr;
    
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public String getEnrollmentDescr() {
		return enrollmentDescr;
	}

	public void setEnrollmentDescr(String enrollmentDescr) {
		this.enrollmentDescr = enrollmentDescr;
	}

	public Integer getTrackRecordId() {
        return trackRecordId;
    }

    public void setTrackRecordId(Integer trackRecordId) {
        this.trackRecordId = trackRecordId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getTrackRecordTitle() {
        return trackRecordTitle;
    }

    public void setTrackRecordTitle(String trackRecordTitle) {
        this.trackRecordTitle = trackRecordTitle == null ? null : trackRecordTitle.trim();
    }

    public String getTrackRecordContent() {
        return trackRecordContent;
    }

    public void setTrackRecordContent(String trackRecordContent) {
        this.trackRecordContent = trackRecordContent == null ? null : trackRecordContent.trim();
    }

    public Date getTrackRecordTime() {
        return trackRecordTime;
    }

    public void setTrackRecordTime(Date trackRecordTime) {
        this.trackRecordTime = trackRecordTime;
    }

    public Integer getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Integer enrollment) {
        this.enrollment = enrollment;
    }

    public Date getNextRecordTime() {
        return nextRecordTime;
    }

    public void setNextRecordTime(Date nextRecordTime) {
        this.nextRecordTime = nextRecordTime;
    }

}