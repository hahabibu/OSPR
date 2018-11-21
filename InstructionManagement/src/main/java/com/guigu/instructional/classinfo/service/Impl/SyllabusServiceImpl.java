package com.guigu.instructional.classinfo.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.instructional.classinfo.mapper.SyllabusInfoMapper;
import com.guigu.instructional.classinfo.service.syllabusService;
import com.guigu.instructional.po.SyllabusInfo;
import com.guigu.instructional.po.SyllabusInfoExample;
import com.guigu.instructional.po.SyllabusInfoExample.Criteria;
@Service("syllabusInfoService")
public class SyllabusServiceImpl implements syllabusService{

	@Resource(name="syllabusInfoMapper")
	private SyllabusInfoMapper syllabusInfoMapper;
	
	@Override
	public boolean add_syllabusInfo(SyllabusInfo syllabusInfo) throws Exception {
		int i = syllabusInfoMapper.insert(syllabusInfo);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update_syllabusInfo(SyllabusInfo syllabusInfo) throws Exception {
		int i = syllabusInfoMapper.updateByPrimaryKeySelective(syllabusInfo);
		
		
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public List<SyllabusInfo> findsyllabusInfoList(SyllabusInfo syllabusInfo) throws Exception {
		SyllabusInfoExample syllabusInfoExample = new SyllabusInfoExample();
		
		Criteria criteria = syllabusInfoExample.createCriteria();
		
		if(syllabusInfo!=null) {
			if(syllabusInfo.getSyllabusId()!=null) {
				criteria.andSyllabusIdEqualTo(syllabusInfo.getSyllabusId());
			}
			if(syllabusInfo.getSyllabusName()!=null) {
				criteria.andSyllabusNameLike("%"+syllabusInfo.getSyllabusName()+"%");
			}
		}
		
		return syllabusInfoMapper.selectByExample(syllabusInfoExample);
	}

	@Override
	public SyllabusInfo getsyllabusInfo(Integer id) throws Exception {
		return syllabusInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean delete_syllabusInfo(Integer id) throws Exception {
		int i = syllabusInfoMapper.deleteByPrimaryKey(id);
		
		if(i>0) {
			return true;
		}
		return false;
	}
	
}
