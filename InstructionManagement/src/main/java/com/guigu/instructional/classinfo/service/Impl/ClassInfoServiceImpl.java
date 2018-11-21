package com.guigu.instructional.classinfo.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.instructional.classinfo.mapper.ClassInfoMapper;
import com.guigu.instructional.classinfo.service.ClassInfoService;
import com.guigu.instructional.po.ClassInfo;
import com.guigu.instructional.po.ClassInfoExample;
import com.guigu.instructional.po.ClassInfoExample.Criteria;
@Service("ClassInfoService")
public class ClassInfoServiceImpl implements ClassInfoService{

	@Resource(name="classInfoMapper")
	private ClassInfoMapper classInfoMapper;
	
	@Override
	public boolean add_ClassInfo(ClassInfo classInfo) throws Exception {
		int i = classInfoMapper.insert(classInfo);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update_ClassInfo(ClassInfo classInfo) throws Exception {
		int i = classInfoMapper.updateByPrimaryKey(classInfo);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public List<ClassInfo> findClassInfoList(ClassInfo classInfo) throws Exception {
		ClassInfoExample classroomInfoExample = new ClassInfoExample();
		
		Criteria criteria = classroomInfoExample.createCriteria();
		
		if(classInfo!=null) {
			if(classInfo.getClassroomId()!=null) {
				criteria.andClassIdEqualTo(classInfo.getClassId());
			}
			if(classInfo.getClassName()!=null) {
				criteria.andClassNameLike("%"+classInfo.getClassName()+"%");
			}
		}
		List<ClassInfo> list = classInfoMapper.selectByExample(classroomInfoExample);
		List<ClassInfo> find_list = new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getClassId()!=-1) {
				find_list.add(list.get(i));
			}
		}
		return find_list;
	}

	@Override
	public ClassInfo getClassInfoInfo(Integer id) throws Exception {
		
		return classInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean delete_ClassInfoInfo(Integer id) throws Exception {
		int i = classInfoMapper.deleteByPrimaryKey(id);
		if(i>0) {
			return true;
		}
		return false;
	}
	
}
