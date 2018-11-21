package com.guigu.instructional.student.service;

import java.util.List;

import com.guigu.instructional.po.CommunicationInfo;
import com.guigu.instructional.po.StudentInfo;

public interface CommunicateInfoService {

	public boolean addCommunicateInfo(CommunicationInfo communicationInfo);
	
	public boolean updateCommunicateInfo(CommunicationInfo communicationInfo);
	
	public boolean deleteCommunicateInfo(Integer communicateInfoId);
	
	public List<CommunicationInfo> getCommunicateInfoList(StudentInfo studentInfo);
	
	public CommunicationInfo getCommunicateInfo(Integer communicateInfoId);
}
