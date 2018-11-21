package com.guigu.instructional.recruitstudent.service;

import java.util.List;

import com.guigu.instructional.po.StudentInfo;

/**       
 * 学员信息管理
 */

public interface StudentInfoService {
	
	// 添加学员信息
	public boolean addStudentInfo(StudentInfo studentInfo);
	
	// 修改学员信息
	public boolean updateStudentInfo(StudentInfo studentInfo);
	
	// 删除学员信息
	public boolean deleteStudentInfo(Integer studentId);
	
	// 根据学员id查找学员信息
	public StudentInfo getStudentInfo(Integer studentId) ;
	
	// 根据条件获取所有学员信息
	public List<StudentInfo> getStudentInfoList(StudentInfo studentInfo);
	
}


