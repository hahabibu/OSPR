package com.guigu.instructional.recruitstudent.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.AuditionInfo;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.recruitstudent.service.AuditionInfoService;
import com.guigu.instructional.recruitstudent.service.StudentInfoService;

/**
 * 试听记录相关
 */
@Controller
@RequestMapping("/recruitstudent/auditioninfo/")
public class AuditionController {

	@Resource(name = "auditionInfoServiceImpl")
	private AuditionInfoService auditionInfoService;

	@Resource(name = "studentInfoServiceImpl")
	private StudentInfoService studentInfoService;

	// 添加数据前需要将意向学员的信息进行转发
	@RequestMapping("addAuditionInfoUI.action")
	public String addAuditionInfoUI(Model model) {
		// 获取意向学员的数据信息
		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setStudentType("意向学员");
		List<StudentInfo> student_list = studentInfoService.getStudentInfoList(studentInfo);
		model.addAttribute("student_list", student_list);
		return "recruitstudent/auditioninfo/auditioninfo_add";
	}

	// 添加意向学员信息
	@RequestMapping("addAuditionInfo.action")
	public String addAuditionInfo(AuditionInfo auditionInfo, Model model) {
		boolean remark = auditionInfoService.addAuditionInfo(auditionInfo);
		if (remark) {
			model.addAttribute("info", "试听记录添加成功");
		} else {
			model.addAttribute("info", "试听记录添加失败");
		}
		return listAuditionInfo(null, null, model);
	}

	// 列出所有意向学员的信息
	@RequestMapping("listAuditionInfo.action")
	public String listAuditionInfo(StudentInfo studentInfo, AuditionInfo auditionInfo, Model model) {
		List<AuditionInfo> list = auditionInfoService.getAuditionInfoList(studentInfo, auditionInfo);
		model.addAttribute("list", list);
		
		// 依次遍历所有试听记录信息，通过StudentId作为查找桥梁将学员姓名传入并显示
		for(int i=0;i<list.size();i++) {
			AuditionInfo af = list.get(i);
			StudentInfo sf = studentInfoService.getStudentInfo(af.getStudentId());
			// 设置学员姓名属性
			af.setStudentName(sf.getStudentName());
		}
		
		return "recruitstudent/auditioninfo/auditioninfo_list";
	}

	// 修改试听记录信息（需要进行数据回显）
	@RequestMapping("updateAuditionInfoUI.action")
	public String updateAuditionInfoUI(Integer auditionId, Model model) {
		// 根据试听记录编号获取学员记录相关信息
		AuditionInfo auditionInfo = auditionInfoService.getAuditionInfo(auditionId);
		if (auditionInfo != null) {
			model.addAttribute("auditionInfo", auditionInfo);
		}
		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setStudentType("意向学员");
		List<StudentInfo> student_list = studentInfoService.getStudentInfoList(studentInfo);
		model.addAttribute("student_list", student_list);
		return "recruitstudent/auditioninfo/auditioninfo_update";
	}

	// 修改意向学员信息
	@RequestMapping("updateAuditionInfo.action")
	public String updateAuditionInfo(AuditionInfo auditionInfo, Model model) {
		boolean remark = auditionInfoService.updateAuditionInfo(auditionInfo);
		if (remark) {
			model.addAttribute("info", "试听记录修改成功");
		} else {
			model.addAttribute("info", "试听记录修改失败");
		}
		return listAuditionInfo(null, null, model);
	}
	
	// 删除意向学员信息
	@RequestMapping("deleteAuditionInfo.action")
	public String deleteAuditionInfo(Integer auditionId, Model model) {
		boolean remark = auditionInfoService.deleteAuditionInfo(auditionId);
		if (remark) {
			model.addAttribute("info", "试听记录删除成功");
		} else {
			model.addAttribute("info", "试听记录删除失败");
		}
		return listAuditionInfo(null, null, model);
	}
}
