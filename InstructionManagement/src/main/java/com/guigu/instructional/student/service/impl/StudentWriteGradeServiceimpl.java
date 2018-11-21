package com.guigu.instructional.student.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guigu.instructional.po.CommunicationInfo;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.StudentWriteGrade;
import com.guigu.instructional.po.StudentWriteGradeExample;
import com.guigu.instructional.po.StudentWriteGradeExample.Criteria;
import com.guigu.instructional.recruitstudent.service.StudentInfoService;
import com.guigu.instructional.student.mapper.StudentWriteGradeMapper;
import com.guigu.instructional.student.service.StudentWriteGradeService;

@Service("studentWriteGradeServiceImpl")
@Transactional
public class StudentWriteGradeServiceimpl implements StudentWriteGradeService {

	@Resource(name ="studentWriteGradeMapper")
	private StudentWriteGradeMapper studentWriteGradeMapper;
	
	@Resource(name = "studentInfoServiceImpl")
	private StudentInfoService studentInfoService;

	@Override
	public boolean addStudentWriteGrade(StudentWriteGrade studentWriteGrade) {

		int i = studentWriteGradeMapper.insertSelective(studentWriteGrade);

		if (i > 0) {
			return true;
		}

		return false;
	}

	@Override
	public boolean updateStudentWriteGrade(StudentWriteGrade studentWriteGrade) {

		int i = studentWriteGradeMapper.updateByPrimaryKeySelective(studentWriteGrade);

		if (i > 0) {
			return true;
		}

		return false;
	}

	@Override
	public boolean deleteStudentWriteGrade(Integer studentWriteGradeId) {
		int i = studentWriteGradeMapper.deleteByPrimaryKey(studentWriteGradeId);

		if (i > 0) {
			return true;
		}

		return false;
	}
	@Override
	public List<StudentWriteGrade> getStudentWriteGradeList(StudentInfo studentInfo) {
		
		
		List<StudentInfo> student_list = new ArrayList<>();
		// 根据学员姓名查找符合条件的学员id
		student_list = studentInfoService.getStudentInfoList(studentInfo);
		// 以studentId为公共桥梁依次遍历查找
		List<StudentWriteGrade> swg_list = studentWriteGradeMapper.selectByExample(null);
		List<StudentWriteGrade> find_list = new ArrayList<>();
		if (swg_list != null) {
			for (int i = 0; i < swg_list.size(); i++) {
				for (int j = 0; j < student_list.size(); j++) {
					StudentWriteGrade swg = swg_list.get(i);
					StudentInfo si = student_list.get(j);
					if (swg.getStudentId() == si.getStudentId()) {
						find_list.add(swg);
					}
				}
			}
		}
		return find_list;
		
	}

	@Override
	public StudentWriteGrade getStudentWriteGrade(Integer studentWriteGradeId) {
		return studentWriteGradeMapper.selectByPrimaryKey(studentWriteGradeId);
	}

	


}
