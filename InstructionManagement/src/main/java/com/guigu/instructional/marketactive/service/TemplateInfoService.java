package com.guigu.instructional.marketactive.service;

import java.util.List;

import com.guigu.instructional.po.TemplateInfo;

/**
 * 模板管理
 */

public interface TemplateInfoService {

	// 添加模板短信
	public boolean addTemplateInfo(TemplateInfo templateInfo);

	// 修改模板短信
	public boolean updateTemplateInfo(TemplateInfo templateInfo);

	// 根据id删除模板短信
	public boolean deleteTemplateInfo(Integer templateId);

	// 根据id查找模板信息
	public TemplateInfo getTemplateInfoById(Integer templateId);

	// 获取所有模板信息
	public List<TemplateInfo> getTemplateInfoList(TemplateInfo templateInfo);

}
