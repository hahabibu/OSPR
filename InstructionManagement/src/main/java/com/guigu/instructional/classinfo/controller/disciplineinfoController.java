package com.guigu.instructional.classinfo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.classinfo.service.DisciplineinfoService;
import com.guigu.instructional.po.DisciplineInfo;


@Controller
@RequestMapping("/classinfo/disciplineinfo")
public class disciplineinfoController {
	
	
	@Resource(name="disciplineinfoService")
	private DisciplineinfoService disciplineinfoService ;
	
	@RequestMapping("addDisciplineinfo.action")
	public String addDisciplineinfo(DisciplineInfo disciplineInfo,Model model) throws Exception {
		
		boolean mark = disciplineinfoService.add_disciplineinfo(disciplineInfo);
		
		if(mark) {
			model.addAttribute("info", "课程信息添加成功");
		}else {
			model.addAttribute("info", "课程信息添加失败");
		}
		
		return listDisciplineinfo(null,model);
	}

	@RequestMapping("listDisciplineinfo.action")
	private String listDisciplineinfo(DisciplineInfo disciplineInfo, Model model) throws Exception {
		
		List<DisciplineInfo> listDisciplineInfo = disciplineinfoService.findDisciplineInfoList(disciplineInfo);
		
		model.addAttribute("listDisciplineinfo", listDisciplineInfo);
		
		return "classinfo/disciplineinfo/disciplineinfo_list";
	}
	
	@RequestMapping("updateDisciplineinfo.action")
	private String updateDisciplineinfo(DisciplineInfo disciplineInfo,Model model) throws Exception{
		
		
		boolean remark = disciplineinfoService.update_disciplineinfo(disciplineInfo);
		
		if(remark) {
			model.addAttribute("info", "信息修改成功");
		}else {
			model.addAttribute("info", "信息修改失败");
		}
		
		return listDisciplineinfo(null, model);
	}
	
	@RequestMapping("getDisciplineinfo.action")
	public String getDisciplineinfo(Integer disciplineId,Model model) throws Exception{
		
		DisciplineInfo disciplineInfo = disciplineinfoService.getDisciplineInfo(disciplineId);
		
		model.addAttribute("dis", disciplineInfo);
		
		return "classinfo/disciplineinfo/disciplineinfo_update";
	}
	
	@RequestMapping("deleteDisciplineinfo.action")
	private String deleteDisciplineinfo(Integer disciplineId,Model model) throws Exception{
		
		boolean remark = disciplineinfoService.delete_disciplineinfo(disciplineId);
		if(remark) {
			model.addAttribute("info", "信息删除成功");
		}else {
			model.addAttribute("info", "信息删除失败");
		}
		return listDisciplineinfo(null, model);
	}
	
	@RequestMapping("page.action")
	private String listPageDisinfo(DisciplineInfo disciplineInfo, Model model) throws Exception {
		
		List<DisciplineInfo> listDisciplineInfo = disciplineinfoService.findDisciplineInfoList(disciplineInfo);
		
		model.addAttribute("listDisciplineinfo", listDisciplineInfo);
		
		return "classinfo/disciplineinfo/disciplineinfo_list";
	}
}
