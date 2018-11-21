package com.guigu.instructional.student.service;

import java.util.List;

import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.StudentWriteGrade;

public interface StudentWriteGradeService {

	public boolean addStudentWriteGrade(StudentWriteGrade studentWriteGrade);

	public boolean updateStudentWriteGrade(StudentWriteGrade communicationInfo);

	public boolean deleteStudentWriteGrade(Integer studentWriteGradeId);

	public List<StudentWriteGrade> getStudentWriteGradeList(StudentInfo studentInfo);

	public StudentWriteGrade getStudentWriteGrade(Integer studentWriteGradeId);
}
