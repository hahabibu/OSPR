package com.guigu.instructional.classinfo.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.instructional.classinfo.mapper.ClassroomInfoMapper;
import com.guigu.instructional.po.ClassroomInfo;
import com.guigu.instructional.po.ClassroomInfoExample;
import com.guigu.instructional.po.ClassroomInfoExample.Criteria;
import com.guigu.instructional.classinfo.service.ClassRoomInfoService;


@Service("classroomInfoinfoService")
public class ClassRoomInfoServiceImpl implements ClassRoomInfoService{

	
	@Resource(name="classroomInfoMapper")
	private ClassroomInfoMapper classroomInfoMapper;
	
	@Override
	public boolean add_classroomInfo(ClassroomInfo classroomInfo) throws Exception {
		int i = classroomInfoMapper.insert(classroomInfo);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update_classroomInfo(ClassroomInfo classroomInfo) throws Exception {
		int i = classroomInfoMapper.updateByPrimaryKeySelective(classroomInfo);
		
		
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public List<ClassroomInfo> findclassroomInfoList(ClassroomInfo classroomInfo) throws Exception {
		ClassroomInfoExample classroomInfoExample = new ClassroomInfoExample();
		
		Criteria criteria = classroomInfoExample.createCriteria();
		
		if(classroomInfo!=null) {
			if(classroomInfo.getClassroomId()!=null) {
				criteria.andClassroomIdEqualTo(classroomInfo.getClassroomId());
			}
			if(classroomInfo.getClassroomName()!=null) {
				criteria.andClassroomNameLike("%"+classroomInfo.getClassroomName()+"%");
			}
		}
		
		return classroomInfoMapper.selectByExample(classroomInfoExample);
	}

	@Override
	public ClassroomInfo getclassroomInfo(Integer id) throws Exception {
		return classroomInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean delete_classroomInfo(Integer id) throws Exception {
		int i = classroomInfoMapper.deleteByPrimaryKey(id);
		
		if(i>0) {
			return true;
		}
		return false;
	}

}
