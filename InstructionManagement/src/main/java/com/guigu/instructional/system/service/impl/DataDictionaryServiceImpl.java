package com.guigu.instructional.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guigu.instructional.po.DataDictionary;
import com.guigu.instructional.po.DataDictionaryExample;
import com.guigu.instructional.po.DataDictionaryExample.Criteria;
import com.guigu.instructional.system.mapper.DataDictionaryMapper;
import com.guigu.instructional.system.service.DataDictionaryService;

@Service("dataDictionaryServiceImpl")
@Transactional
public class DataDictionaryServiceImpl implements DataDictionaryService {

	@Resource(name ="dataDictionaryMapper")
	private DataDictionaryMapper dataDictionaryMapper;

	@Override
	public boolean addDataDictionary(DataDictionary dataDictionary) {

		int i = dataDictionaryMapper.insertSelective(dataDictionary);

		if (i > 0) {
			return true;
		}

		return false;
	}

	@Override
	public boolean updateDataDictionary(DataDictionary dataDictionary) {

		int i = dataDictionaryMapper.updateByPrimaryKeySelective(dataDictionary);

		if (i > 0) {
			return true;
		}

		return false;
	}
	
	@Override
	public boolean deleteDataDictionary(Integer dataId) {
		int i = dataDictionaryMapper.deleteByPrimaryKey(dataId);
		if (i > 0) {
			return true;
		}

		return false;
	}

	@Override
	public List<DataDictionary> getDataDictionaryList(DataDictionary dataDictionary) {
		
		DataDictionaryExample dataDictionaryExample = new DataDictionaryExample();
		// 创建数据字典的查找条件
		Criteria criteria = dataDictionaryExample.createCriteria();
		if (dataDictionary != null) {
			// 根据数据字典的类型进行查找
			if (dataDictionary.getDataType() != null) {
				if(!dataDictionary.getDataType().equals("-1")) {
					// 如果是默认选项则不会拼接查找条件
					criteria.andDataTypeEqualTo(dataDictionary.getDataType());
				}
			}
			
			// 根据数据字典的名称进行查找
			if(dataDictionary.getDataContent()!=null) {
				criteria.andDataContentLike("%"+dataDictionary.getDataContent().trim()+"%");
			}
		}

		return dataDictionaryMapper.selectByExample(dataDictionaryExample);
	}

	@Override
	public DataDictionary getDataDictionary(Integer dataId) {
		return dataDictionaryMapper.selectByPrimaryKey(dataId);
	}

}
