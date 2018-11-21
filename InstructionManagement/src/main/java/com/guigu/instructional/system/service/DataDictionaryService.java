package com.guigu.instructional.system.service;

import java.util.List;

import com.guigu.instructional.po.DataDictionary;

public interface DataDictionaryService {

	public boolean addDataDictionary(DataDictionary dataDictionary);
	
	public boolean updateDataDictionary(DataDictionary dataDictionary);
	
	public boolean deleteDataDictionary(Integer dataId);
	
	public List<DataDictionary> getDataDictionaryList(DataDictionary dataDictionary);
	
	public DataDictionary getDataDictionary(Integer dataId);
}
