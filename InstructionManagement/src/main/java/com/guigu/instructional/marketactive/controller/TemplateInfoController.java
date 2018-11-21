package com.guigu.instructional.marketactive.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.marketactive.service.TemplateInfoService;
import com.guigu.instructional.po.TemplateInfo;

/**
 * 模板管理控制层
 */

@Controller
@RequestMapping("/marketactive/templateinfo/")
public class TemplateInfoController {

	@Resource(name = "templateInfoServiceImpl")
	private TemplateInfoService templateInfoService;

	// 添加模板短信
	@RequestMapping("addTemplateInfo.action")
	public String addTemplateInfo(TemplateInfo templateInfo, Model model) {

		boolean remark = templateInfoService.addTemplateInfo(templateInfo);
		if (remark) {
			model.addAttribute("info", "模板信息添加成功");
		} else {
			model.addAttribute("info", "模板信息添加失败");
		}
		return listTemplateInfo(null,model);
	}

	// 获取所有模板信息
	@RequestMapping("listTemplateInfo.action")
	public String listTemplateInfo(TemplateInfo templateInfo,Model model) {
		List<TemplateInfo> list = templateInfoService.getTemplateInfoList(templateInfo);
		model.addAttribute("list", list);
		return "marketactive/template/template_list";
	}
	
	// 模板短信 数据回显
	@RequestMapping("updateTemplateInfoUI.action")
	public String updateTemplateInfoUI(Integer templateId,Model model) {
		// 根据id查找指定的模板信息
		TemplateInfo templateInfo = templateInfoService.getTemplateInfoById(templateId);
		model.addAttribute("templateInfo",templateInfo);
		return "marketactive/template/template_update";
	}

	// 修改模板信息
	@RequestMapping("updateTemplateInfo.action")
	public String updateTemplateInfo(TemplateInfo templateInfo,Model model) {
		// 修改模板信息
		boolean remark = templateInfoService.updateTemplateInfo(templateInfo);
		if (remark) {
			model.addAttribute("info", "模板信息修改成功");
		} else {
			model.addAttribute("info", "模板信息修改失败");
		}
		return listTemplateInfo(null,model);
	}
	
	// 删除模板信息
	@RequestMapping("deleteTemplateInfo.action")
	public String deleteTemplateInfo(Integer templateId,Model model) {
		// 删除模板信息
		boolean remark = templateInfoService.deleteTemplateInfo(templateId);
		if (remark) {
			model.addAttribute("info", "模板信息删除成功");
		} else {
			model.addAttribute("info", "模板信息删除失败");
		}
		return listTemplateInfo(null,model);
	}
}
