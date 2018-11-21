package com.guigu.instructional.recruitstudent.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.StudentInfoExample;
import com.guigu.instructional.po.StudentInfoExample.Criteria;
import com.guigu.instructional.po.TrackRecordInfo;
import com.guigu.instructional.recruitstudent.mapper.StudentInfoMapper;
import com.guigu.instructional.recruitstudent.mapper.TrackRecordInfoMapper;
import com.guigu.instructional.recruitstudent.service.TrackRecordService;

/**       
 * 跟踪记录相关
 */
@Service("trackRecordServiceImpl")
@Transactional
public class TrackRecordServiceImpl implements TrackRecordService{

	@Resource(name="trackRecordInfoMapper")
	private TrackRecordInfoMapper trackRecordInfoMapper ;
	
	@Resource(name="studentInfoMapper")
	private StudentInfoMapper studentInfoMapper;
	
	@Override
	public boolean addTrackRecordInfo(TrackRecordInfo trackRecordInfo) {
		int i = trackRecordInfoMapper.insertSelective(trackRecordInfo);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateTrackRecordInfo(TrackRecordInfo trackRecordInfo) {
		int i = trackRecordInfoMapper.updateByPrimaryKeySelective(trackRecordInfo);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteTrackRecordInfo(Integer trackRecordId) {
		int i = trackRecordInfoMapper.deleteByPrimaryKey(trackRecordId);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public TrackRecordInfo getTrackRecordInfo(Integer trackRecordId) {
		return trackRecordInfoMapper.selectByPrimaryKey(trackRecordId);
	}

	@Override
	public List<TrackRecordInfo> getTrackRecordInfoList(StudentInfo studentInfo) {
		StudentInfoExample studentInfoExample = new StudentInfoExample();
		Criteria criteria = studentInfoExample.createCriteria();
		if(studentInfo!=null) {
			// 根据学员姓名查找
			if(studentInfo.getStudentName()!=null) {
				if(!studentInfo.getStudentName().equals("")) {
					criteria.andStudentNameLike("%"+studentInfo.getStudentName()+"%");
				}
			}
			// 根据学员意向状态查找
			if(studentInfo.getStudentState()!=null) {
				// 如果不是默认查找全部则不拼接查找条件
				if(studentInfo.getStudentState()!=-1) {
					criteria.andStudentStateEqualTo(studentInfo.getStudentState());
				}
			}
		}
		// 获取查找的学生列表，根据学生列表id一一遍历相应的跟踪记录
		List<StudentInfo> student_list = studentInfoMapper.selectByExample(studentInfoExample);
		List<TrackRecordInfo> all_trackRecordInfo_list = trackRecordInfoMapper.selectByExample(null);
		List<TrackRecordInfo> find_trackRecordInfo_list = new ArrayList<>();
		for(int i=0;i<student_list.size();i++) {
			// 如果student_id相同则相应地添加记录
			for(int j=0;j<all_trackRecordInfo_list.size();j++) {
				StudentInfo si = student_list.get(i);
				TrackRecordInfo tri = all_trackRecordInfo_list.get(j);
				if(si.getStudentId().equals(tri.getStudentId())) {
					// 添加记录到查找列表
					find_trackRecordInfo_list.add(tri);
				}
			}
		}
		return find_trackRecordInfo_list;
	}

}


