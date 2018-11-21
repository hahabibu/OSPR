package com.guigu.instructional.student.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guigu.instructional.po.EvaluationInfo;
import com.guigu.instructional.po.EvaluationInfoExample;
import com.guigu.instructional.po.EvaluationInfoExample.Criteria;
import com.guigu.instructional.student.mapper.EvaluationInfoMapper;
import com.guigu.instructional.student.service.EvaluationInfoService;

/**       
 * 学员评价相关  
 */
@Service("evaluationInfoServiceImpl")
@Transactional
public class EvaluationInfoServiceImpl implements EvaluationInfoService{

	@Resource(name="evaluationInfoMapper")
	private EvaluationInfoMapper evaluationInfoMapper;
	
	@Override
	public boolean addEvaluationInfo(EvaluationInfo evaluationInfo) {
		int i = evaluationInfoMapper.insertSelective(evaluationInfo);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateEvaluationInfo(EvaluationInfo evaluationInfo) {
		int i = evaluationInfoMapper.updateByPrimaryKeySelective(evaluationInfo);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteEvaluationInfo(Integer evaluationId) {
		int i = evaluationInfoMapper.deleteByPrimaryKey(evaluationId);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public EvaluationInfo getEvaluationInfo(Integer evaluationId) {
		return evaluationInfoMapper.selectByPrimaryKey(evaluationId);
	}

	@Override
	public List<EvaluationInfo> getEvaluationInfoList(EvaluationInfo evaluationInfo) {
		
		EvaluationInfoExample evaluationInfoExample = new EvaluationInfoExample();
		Criteria criteria = evaluationInfoExample.createCriteria();
		if(evaluationInfo!=null) {
			// 根据评价主体进行查找
			if(evaluationInfo.getEvaluationTile()!=null) {
				// 如果默认为所有内容则不拼接查找条件
				if(!evaluationInfo.getEvaluationTile().equals("-1")) {
					criteria.andEvaluationTileLike("%"+evaluationInfo.getEvaluationTile().trim()+"%");
				}
			}
		}
		return evaluationInfoMapper.selectByExample(evaluationInfoExample);
	}

}


