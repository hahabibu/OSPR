package com.guigu.instructional.student.service;

import java.util.List;

import com.guigu.instructional.po.EvaluationInfo;

/**       
 * 学员评价相关
 */

public interface EvaluationInfoService {
	
	// 添加学员评价记录
	public boolean addEvaluationInfo(EvaluationInfo evaluationInfo);
	
	// 修改学员评价记录
	public boolean updateEvaluationInfo(EvaluationInfo evaluationInfo);
	
	
	// 删除学员评价记录
	public boolean deleteEvaluationInfo(Integer evaluationId);

	// 根据评价编号查找学员评价记录
	public EvaluationInfo getEvaluationInfo(Integer evaluationId);
	
	// 根据条件查找学员评价记录
	public List<EvaluationInfo> getEvaluationInfoList(EvaluationInfo evaluationInfo);
}


