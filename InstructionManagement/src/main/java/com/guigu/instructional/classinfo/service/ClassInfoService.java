package com.guigu.instructional.classinfo.service;

import java.util.List;

import com.guigu.instructional.po.ClassInfo;

public interface ClassInfoService {
	
	public boolean add_ClassInfo(ClassInfo classInfo) throws Exception;
	
	public boolean update_ClassInfo(ClassInfo classInfo) throws Exception;
	
	public List<ClassInfo> findClassInfoList(ClassInfo classInfo) throws Exception;
	
	public ClassInfo getClassInfoInfo(Integer id) throws Exception; 
	
	public boolean delete_ClassInfoInfo(Integer id) throws Exception;
	
}
