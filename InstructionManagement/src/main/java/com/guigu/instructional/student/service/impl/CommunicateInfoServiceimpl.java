package com.guigu.instructional.student.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guigu.instructional.po.CommunicationInfo;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.recruitstudent.service.StudentInfoService;
import com.guigu.instructional.student.mapper.CommunicationInfoMapper;
import com.guigu.instructional.student.service.CommunicateInfoService;

@Service("communicateInfoServiceImpl")
@Transactional
public class CommunicateInfoServiceimpl implements CommunicateInfoService {

	@Resource(name = "communicationInfoMapper")
	private CommunicationInfoMapper communicationInfoMapper;

	@Resource(name = "studentInfoServiceImpl")
	private StudentInfoService studentInfoService;

	@Override
	public boolean addCommunicateInfo(CommunicationInfo communicationInfo) {

		int i = communicationInfoMapper.insertSelective(communicationInfo);

		if (i > 0) {
			return true;
		}

		return false;
	}

	@Override
	public boolean updateCommunicateInfo(CommunicationInfo communicationInfo) {

		int i = communicationInfoMapper.updateByPrimaryKeySelective(communicationInfo);

		if (i > 0) {
			return true;
		}

		return false;
	}

	@Override
	public boolean deleteCommunicateInfo(Integer communicateInfoId) {
		int i = communicationInfoMapper.deleteByPrimaryKey(communicateInfoId);
		if (i > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<CommunicationInfo> getCommunicateInfoList(StudentInfo studentInfo) {
		List<StudentInfo> student_list = new ArrayList<>();
		// 根据学员姓名查找符合条件的学员id
		student_list = studentInfoService.getStudentInfoList(studentInfo);
		// 以studentId为公共桥梁依次遍历查找
		List<CommunicationInfo> ci_list = communicationInfoMapper.selectByExample(null);
		List<CommunicationInfo> find_list = new ArrayList<>();
		if (ci_list != null) {
			for (int i = 0; i < ci_list.size(); i++) {
				for (int j = 0; j < student_list.size(); j++) {
					CommunicationInfo ci = ci_list.get(i);
					StudentInfo si = student_list.get(j);
					if (ci.getStudentId() == si.getStudentId()) {
						find_list.add(ci);
					}
				}
			}
		}
		return find_list;
	}

	@Override
	public CommunicationInfo getCommunicateInfo(Integer communicateInfoId) {
		return communicationInfoMapper.selectByPrimaryKey(communicateInfoId);
	}

}
