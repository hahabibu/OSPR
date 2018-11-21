package com.guigu.instructional.classinfo.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.instructional.classinfo.mapper.DisciplineInfoMapper;
import com.guigu.instructional.po.DisciplineInfo;
import com.guigu.instructional.po.DisciplineInfoExample;
import com.guigu.instructional.po.DisciplineInfoExample.Criteria;
import com.guigu.instructional.classinfo.service.DisciplineinfoService;



@Service("disciplineinfoService")
public class DisciplineinfoServiceImpl implements DisciplineinfoService{

	@Resource(name="disciplineInfoMapper")
	private DisciplineInfoMapper disciplineInfoMapper;
	
	@Override
	public boolean add_disciplineinfo(DisciplineInfo disciplineInfo) throws Exception {
		// TODO Auto-generated method stub
		
		int i = disciplineInfoMapper.insert(disciplineInfo);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update_disciplineinfo(DisciplineInfo disciplineInfo) throws Exception {
		
		int i = disciplineInfoMapper.updateByPrimaryKeySelective(disciplineInfo);
		
		
		if(i>0) {
			return true;
		}
		return false;
		
	}

	@Override
	public List<DisciplineInfo> findDisciplineInfoList(DisciplineInfo disciplineInfo) throws Exception {
		
		DisciplineInfoExample disciplineInfoExample = new DisciplineInfoExample();
		
		Criteria criteria = disciplineInfoExample.createCriteria();
		
		if(disciplineInfo!=null) {
			if(disciplineInfo.getDisciplineId()!=null) {
				criteria.andDisciplineBringEqualTo(disciplineInfo.getDisciplineId());
			}
			if(disciplineInfo.getDisciplineName()!=null) {
				criteria.andDisciplineNameLike("%"+disciplineInfo.getDisciplineName()+"%");
			}
		}
		
		return disciplineInfoMapper.selectByExample(disciplineInfoExample);
	}

	@Override
	public DisciplineInfo getDisciplineInfo(Integer id) throws Exception {
		
		
		return disciplineInfoMapper.selectByPrimaryKey(id);
		
	}

	@Override
	public boolean delete_disciplineinfo(Integer id) throws Exception {
		
		int i = disciplineInfoMapper.deleteByPrimaryKey(id);
		
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public List<DisciplineInfo> findDisciplineInfoList(int startIndex, int pageSize) throws Exception {
		
		List<DisciplineInfo> DisciplineInfoList = new  ArrayList<>();
		
		for(int i=startIndex+1;i<=pageSize;i++) {
			DisciplineInfoList.add(disciplineInfoMapper.selectByPrimaryKey(i));
			System.out.println(disciplineInfoMapper.selectByPrimaryKey(i));
		}
	
		
		
		return DisciplineInfoList;
	}


}
