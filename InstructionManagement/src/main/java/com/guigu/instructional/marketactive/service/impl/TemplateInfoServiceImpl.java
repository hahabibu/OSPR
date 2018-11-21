package com.guigu.instructional.marketactive.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guigu.instructional.marketactive.mapper.TemplateInfoMapper;
import com.guigu.instructional.marketactive.service.TemplateInfoService;
import com.guigu.instructional.po.TemplateInfo;
import com.guigu.instructional.po.TemplateInfoExample;
import com.guigu.instructional.po.TemplateInfoExample.Criteria;

/**       
 * 模板管理  
 */

@Service("templateInfoServiceImpl")
@Transactional()
public class TemplateInfoServiceImpl implements TemplateInfoService{

	@Resource(name="templateInfoMapper")
	private TemplateInfoMapper templateInfoMapper;
	
	@Override
	public boolean addTemplateInfo(TemplateInfo templateInfo) {
		int i = templateInfoMapper.insertSelective(templateInfo);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateTemplateInfo(TemplateInfo templateInfo) {
		int i=templateInfoMapper.updateByPrimaryKeySelective(templateInfo);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteTemplateInfo(Integer templateId) {
		int i=templateInfoMapper.deleteByPrimaryKey(templateId);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public TemplateInfo getTemplateInfoById(Integer templateId) {
		return templateInfoMapper.selectByPrimaryKey(templateId);
	}

	@Override
	public List<TemplateInfo> getTemplateInfoList(TemplateInfo templateInfo) {
		TemplateInfoExample templateInfoExample = new TemplateInfoExample();
		Criteria criteria = templateInfoExample.createCriteria();
		if(templateInfo!=null) {
			if(templateInfo.getTemplateTitle()!=null) {
				criteria.andTemplateTitleLike("%"+templateInfo.getTemplateTitle().trim()+"%");
			}
			// 根据模板类型进行区分
			if(templateInfo.getTemplateType()!=null) {
				// 如果不是默认选择所有内容则不拼接查找条件
				if(!templateInfo.getTemplateType().equals("所有内容")) {
					criteria.andTemplateTypeEqualTo(templateInfo.getTemplateType());
				}
			}
		}
		return templateInfoMapper.selectByExample(templateInfoExample);
	}
}


