package com.guigu.instructional.classinfo.service;

import java.util.List;

import com.guigu.instructional.po.SyllabusInfo;


public interface syllabusService {
	
	public boolean add_syllabusInfo(SyllabusInfo syllabusInfo) throws Exception;
	
	public boolean update_syllabusInfo(SyllabusInfo syllabusInfo) throws Exception;
	
	public List<SyllabusInfo> findsyllabusInfoList(SyllabusInfo syllabusInfo) throws Exception;
	
	public SyllabusInfo getsyllabusInfo(Integer id) throws Exception; 
	
	public boolean delete_syllabusInfo(Integer id) throws Exception;
	
}
