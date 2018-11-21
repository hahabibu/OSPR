package com.guigu.instructional.recruitstudent.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guigu.instructional.po.AuditionInfo;
import com.guigu.instructional.po.AuditionInfoExample;
import com.guigu.instructional.po.AuditionInfoExample.Criteria;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.recruitstudent.mapper.AuditionInfoMapper;
import com.guigu.instructional.recruitstudent.mapper.StudentInfoMapper;
import com.guigu.instructional.recruitstudent.service.AuditionInfoService;
import com.guigu.instructional.recruitstudent.service.StudentInfoService;

/**
 * 试听记录相关内容
 */
@Service("auditionInfoServiceImpl")
@Transactional
public class AuditionInfoServiceImpl implements AuditionInfoService {

	@Resource(name = "auditionInfoMapper")
	private AuditionInfoMapper auditionInfoMapper;

	@Resource(name = "studentInfoServiceImpl")
	private StudentInfoService studentInfoService;

	@Override
	public boolean addAuditionInfo(AuditionInfo auditionInfo) {
		int i = auditionInfoMapper.insertSelective(auditionInfo);
		if (i > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateAuditionInfo(AuditionInfo auditionInfo) {
		int i = auditionInfoMapper.updateByPrimaryKeySelective(auditionInfo);
		if (i > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteAuditionInfo(Integer auditionId) {
		int i = auditionInfoMapper.deleteByPrimaryKey(auditionId);
		if (i > 0) {
			return true;
		}
		return false;
	}

	@Override
	public AuditionInfo getAuditionInfo(Integer auditionId) {
		return auditionInfoMapper.selectByPrimaryKey(auditionId);
	}

	@Override
	public List<AuditionInfo> getAuditionInfoList(StudentInfo studentInfo, AuditionInfo auditionInfo) {
		/**
		 * 由于根据学员姓名查找的数据可能有多个，因此需要 先查找符合学员姓名的条件的数据，随后查找符合其他条件
		 * 的学员信息，再将两个列表进行筛选从而获取公共的数据即可
		 */
		AuditionInfoExample auditionInfoExample = new AuditionInfoExample();
		Criteria criteria = auditionInfoExample.createCriteria();
		List<StudentInfo> studentListByName = new ArrayList<>();
		List<AuditionInfo> auditionListByCondition = new ArrayList<>();
		List<AuditionInfo> findList = new ArrayList<>();
		// 查找条件：根据学员姓名查找、根据试听课程查找

		// 根据传入的学生姓名关键字进行查找，封装指定的id信息
		studentListByName = studentInfoService.getStudentInfoList(studentInfo);

		// 根据试听课程查找符合条件的学员信息
		if (auditionInfo != null) {
			// 判断传入的试听课程是否为空
			if (auditionInfo.getAuditionCourse() != null) {
				if (!auditionInfo.getAuditionCourse().equals("")) {
					// 封装数据查找信息
					criteria.andAuditionCourseLike("%"+auditionInfo.getAuditionCourse()+"%");
				}
			}
		}
		auditionListByCondition = auditionInfoMapper.selectByExample(auditionInfoExample);
		// 联合查找数据
		for (int i = 0; i < studentListByName.size(); i++) {
			for (int j = 0; j < auditionListByCondition.size(); j++) {
				// 如果学员id相同则匹配
				StudentInfo si = studentListByName.get(i);
				AuditionInfo ai = auditionListByCondition.get(j);
				if (si.getStudentId().equals(ai.getStudentId())) {
					findList.add(ai);
				}
			}
		}
		return findList;
	}

}
