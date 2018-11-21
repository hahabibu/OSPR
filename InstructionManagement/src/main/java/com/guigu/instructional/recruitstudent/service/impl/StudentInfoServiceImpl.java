package com.guigu.instructional.recruitstudent.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.StudentInfoExample;
import com.guigu.instructional.po.StudentInfoExample.Criteria;
import com.guigu.instructional.recruitstudent.mapper.StudentInfoMapper;
import com.guigu.instructional.recruitstudent.service.StudentInfoService;

/**       
 * 学员信息管理相关
 */
@Service("studentInfoServiceImpl")
@Transactional
public class StudentInfoServiceImpl implements StudentInfoService{

	@Resource(name="studentInfoMapper")
	private StudentInfoMapper studentInfoMapper;
	
	@Override
	public boolean addStudentInfo(StudentInfo studentInfo) {
		int i = studentInfoMapper.insertSelective(studentInfo);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateStudentInfo(StudentInfo studentInfo) {
		int i = studentInfoMapper.updateByPrimaryKeySelective(studentInfo);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteStudentInfo(Integer studentId) {
		int i = studentInfoMapper.deleteByPrimaryKey(studentId);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public StudentInfo getStudentInfo(Integer studentId) {
		return studentInfoMapper.selectByPrimaryKey(studentId);
	}

	@Override
	public List<StudentInfo> getStudentInfoList(StudentInfo studentInfo) {
		// 封装查找的条件
		StudentInfoExample studentInfoExample  = new StudentInfoExample();
		Criteria criteria = studentInfoExample.createCriteria();
		if(studentInfo!=null) {
			// 根据学员姓名关键字查找
			if(studentInfo.getStudentName()!=null) {
				if(!studentInfo.getStudentName().equals("")) {
					criteria.andStudentNameLike("%"+studentInfo.getStudentName()+"%");
				}
			}
			// 根据学员意向进行查找
			if(studentInfo.getStudentState()!=null) {
				// 如果默认是查找所有内容则不拼接查找条件
				if(studentInfo.getStudentState()!= -1) {
					criteria.andStudentStateEqualTo(studentInfo.getStudentState());
				}
			}
			// 根据学员类型查找
			if(studentInfo.getStudentType()!=null) {
				if(!studentInfo.getStudentType().equals("")) {
					criteria.andStudentTypeEqualTo(studentInfo.getStudentType().trim());
				}
			}
			// 根据班级id进行查找
			if(studentInfo.getClassId()!=null) {
				criteria.andClassIdEqualTo(studentInfo.getClassId());
			}
		}
		return studentInfoMapper.selectByExample(studentInfoExample);
	}
}


