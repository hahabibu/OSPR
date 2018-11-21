package com.guigu.instructional.po;

import java.util.Date;

public class StudentWriteGrade {
    private Integer writeGradeId;

    private Integer studentId;

    private Integer staffId;

    private String writeGradeSubject;

    private String writeGrade;

    private Date writeGradeTime;

    private String writeGradeNote;
    
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

	public Integer getWriteGradeId() {
        return writeGradeId;
    }

    public void setWriteGradeId(Integer writeGradeId) {
        this.writeGradeId = writeGradeId;
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

    public String getWriteGradeSubject() {
        return writeGradeSubject;
    }

    public void setWriteGradeSubject(String writeGradeSubject) {
        this.writeGradeSubject = writeGradeSubject == null ? null : writeGradeSubject.trim();
    }

    public String getWriteGrade() {
        return writeGrade;
    }

    public void setWriteGrade(String writeGrade) {
        this.writeGrade = writeGrade == null ? null : writeGrade.trim();
    }

    public Date getWriteGradeTime() {
        return writeGradeTime;
    }

    public void setWriteGradeTime(Date writeGradeTime) {
        this.writeGradeTime = writeGradeTime;
    }

    public String getWriteGradeNote() {
        return writeGradeNote;
    }

    public void setWriteGradeNote(String writeGradeNote) {
        this.writeGradeNote = writeGradeNote == null ? null : writeGradeNote.trim();
    }
}