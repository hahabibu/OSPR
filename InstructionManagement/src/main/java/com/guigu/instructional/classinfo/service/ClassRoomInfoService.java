package com.guigu.instructional.classinfo.service;

import java.util.List;

import com.guigu.instructional.po.ClassroomInfo;



public interface ClassRoomInfoService {
	
	public boolean add_classroomInfo(ClassroomInfo classroomInfo) throws Exception;
	
	public boolean update_classroomInfo(ClassroomInfo classroomInfo) throws Exception;
	
	public List<ClassroomInfo> findclassroomInfoList(ClassroomInfo classroomInfo) throws Exception;
	
	public ClassroomInfo getclassroomInfo(Integer id) throws Exception; 
	
	public boolean delete_classroomInfo(Integer id) throws Exception;
	
}
