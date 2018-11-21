package com.guigu.instructional.classinfo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.ClassroomInfo;
import com.guigu.instructional.classinfo.service.ClassRoomInfoService;

@Controller
@RequestMapping("/classinfo/classroominfo")
public class ClassroomInfoController {
	
	@Resource(name="classroomInfoinfoService")
	private ClassRoomInfoService classRoomInfoService ;
	
	@RequestMapping("addclassroominfo.action")
	public String addDisciplineinfo(ClassroomInfo classroomInfo,Model model) throws Exception {
		
		boolean mark = classRoomInfoService.add_classroomInfo(classroomInfo);
		
		if(mark) {
			model.addAttribute("info", "课程信息添加成功");
		}else {
			model.addAttribute("info", "课程信息添加失败");
		}
		
		return listClassroomInfo(null,model);
	}
	
	@RequestMapping("listClassroomInfo.action")
	private String listClassroomInfo(ClassroomInfo classroomInfo,Model model) throws Exception {
		
		List<ClassroomInfo> listClassroomInfo = classRoomInfoService.findclassroomInfoList(classroomInfo);
		
		model.addAttribute("listClassroomInfo", listClassroomInfo);
		
		return "classinfo/classroominfo/classroominfo_list";
	}
	
	@RequestMapping("updateClassroomInfo.action")
	private String updateClassroomInfo(ClassroomInfo classroomInfo,Model model) throws Exception{
		
		
		boolean remark = classRoomInfoService.update_classroomInfo(classroomInfo);
		
		if(remark) {
			model.addAttribute("info", "信息修改成功");
		}else {
			model.addAttribute("info", "信息修改失败");
		}
		
		return listClassroomInfo(null, model);
	}
	
	@RequestMapping("getClassroomInfo.action")
	public String getClassroomInfo(Integer classroomId,Model model) throws Exception{
		
		ClassroomInfo classroomInfo = classRoomInfoService.getclassroomInfo(classroomId);
		System.out.println(classroomId);
		model.addAttribute("classroomInfo", classroomInfo);
		
		return "classinfo/classroominfo/classroominfo_update";
	}
	
	@RequestMapping("deleteClassroomInfo.action")
	private String deleteClassroomInfo(Integer classroomId,Model model) throws Exception{
		
		boolean remark = classRoomInfoService.delete_classroomInfo(classroomId);
		if(remark) {
			model.addAttribute("info", "信息删除成功");
		}else {
			model.addAttribute("info", "信息删除失败");
		}
		
		return listClassroomInfo(null, model);
	}
}
