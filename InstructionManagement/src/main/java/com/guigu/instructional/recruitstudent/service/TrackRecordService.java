package com.guigu.instructional.recruitstudent.service;

import java.util.List;

import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.TrackRecordInfo;

/**       
 * 跟踪记录相关 
 */

public interface TrackRecordService {
	// 添加跟踪记录
	public boolean addTrackRecordInfo(TrackRecordInfo trackRecordInfo);
	
	// 修改跟踪记录
	public boolean updateTrackRecordInfo(TrackRecordInfo trackRecordInfo);
	
	// 删除跟踪记录
	public boolean deleteTrackRecordInfo(Integer trackRecordId);
	
	// 根据记录编号获取数据
	public TrackRecordInfo getTrackRecordInfo(Integer trackRecordId);
	
	// (根据学员信息)获取所有的记录数据
	public List<TrackRecordInfo> getTrackRecordInfoList(StudentInfo studentInfo);

}


