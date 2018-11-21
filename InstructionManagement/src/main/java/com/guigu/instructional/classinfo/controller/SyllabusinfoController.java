package com.guigu.instructional.classinfo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.classinfo.service.syllabusService;
import com.guigu.instructional.po.SyllabusInfo;

@Controller
@RequestMapping("/classinfo/syllabusinfo")
public class SyllabusinfoController {
	
	@Resource(name="syllabusInfoService")
	private syllabusService syllabusservice ;
	
	@RequestMapping("addSyllabusinfo.action")
	public String addDisciplineinfo(SyllabusInfo syllabusInfo,Model model) throws Exception {
		
		boolean mark = syllabusservice.add_syllabusInfo(syllabusInfo);
		
		if(mark) {
			model.addAttribute("info", "课程信息添加成功");
		}else {
			model.addAttribute("info", "课程信息添加失败");
		}
		
		return listSyllabusInfo(null,model);
	}
	
	@RequestMapping("listSyllabusinfo.action")
	private String listSyllabusInfo(SyllabusInfo syllabusInfo,Model model) throws Exception {
		
		List<SyllabusInfo> listSyllabusInfo = syllabusservice.findsyllabusInfoList(syllabusInfo);
		
		model.addAttribute("listDisciplineinfo", listSyllabusInfo);
		
		return "classinfo/syllabusinfo/syllabusinfo_list";
	}
	
	@RequestMapping("updateSyllabusinfo.action")
	private String updateSyllabusinfo(SyllabusInfo syllabusInfo,Model model) throws Exception{
		
		
		boolean remark = syllabusservice.update_syllabusInfo(syllabusInfo);
		
		if(remark) {
			model.addAttribute("info", "信息修改成功");
		}else {
			model.addAttribute("info", "信息修改失败");
		}
		
		return listSyllabusInfo(null, model);
	}
	
	@RequestMapping("getSyllabusinfo.action")
	public String getSyllabusinfo(Integer syllabusId,Model model) throws Exception{
		
		SyllabusInfo syllabusinfoId = syllabusservice.getsyllabusInfo(syllabusId);
		
		model.addAttribute("syllabusinfoId", syllabusinfoId);
		
		return "classinfo/syllabusinfo/syllabusinfo_update";
	}
	
	@RequestMapping("deleteSyllabusinfo.action")
	private String deleteSyllabusinfo(Integer syllabusId,Model model) throws Exception{
		
		boolean remark = syllabusservice.delete_syllabusInfo(syllabusId);
		
		System.out.println(syllabusId);
		
		if(remark) {
			model.addAttribute("info", "信息删除成功");
		}else {
			model.addAttribute("info", "信息删除失败");
		}
		
		return listSyllabusInfo(null, model);
	}
}
