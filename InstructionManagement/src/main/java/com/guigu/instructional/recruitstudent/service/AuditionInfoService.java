package com.guigu.instructional.recruitstudent.service;

import java.util.List;

import com.guigu.instructional.po.AuditionInfo;
import com.guigu.instructional.po.StudentInfo;

/**       
 * 试听记录相关内容 
 */

public interface AuditionInfoService {
	
	// 添加试听记录
	public boolean addAuditionInfo(AuditionInfo auditionInfo);
	
	// 修改试听记录
	public boolean updateAuditionInfo(AuditionInfo auditionInfo);
	
	// 删除试听记录
	public boolean deleteAuditionInfo(Integer auditionId);
	
	// 根据编号查找试听记录
	public AuditionInfo getAuditionInfo(Integer auditionId);
	
	// 查找所有的试听纪录
	public List<AuditionInfo> getAuditionInfoList(StudentInfo studentInfo,AuditionInfo auditionInfo);

}


