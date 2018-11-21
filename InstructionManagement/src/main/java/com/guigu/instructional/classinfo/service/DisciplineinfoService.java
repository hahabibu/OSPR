package com.guigu.instructional.classinfo.service;

import java.util.List;

import com.guigu.instructional.po.DisciplineInfo;


public interface DisciplineinfoService {
	
	
	public boolean add_disciplineinfo(DisciplineInfo disciplineInfo) throws Exception;
	
	public boolean update_disciplineinfo(DisciplineInfo disciplineInfo) throws Exception;
	
	public List<DisciplineInfo> findDisciplineInfoList(DisciplineInfo disciplineInfo) throws Exception;
	
	public DisciplineInfo getDisciplineInfo(Integer id) throws Exception; 
	
	public boolean delete_disciplineinfo(Integer id) throws Exception;
	
	public List<DisciplineInfo> findDisciplineInfoList(int startIndex, int pageSize) throws Exception;
}
