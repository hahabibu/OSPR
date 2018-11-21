package com.guigu.instructional.recruitstudent.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.DataDictionary;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.recruitstudent.service.StudentInfoService;
import com.guigu.instructional.system.service.DataDictionaryService;
import com.guigu.instructional.utils.WebUtils;

/**
 * 招生线索相关
 */

@Controller
@RequestMapping("/recruitstudent/recruitstudent/")
public class RecruitStudentController {
	@Resource(name = "studentInfoServiceImpl")
	private StudentInfoService studentInfoService;

	@Resource(name = "dataDictionaryServiceImpl")
	private DataDictionaryService dataDictionaryService ;

	Map<String, Integer> studentState_map = new LinkedHashMap<>();
	
	public void pack() {
		// 根据需求查找数据并通过WebUtils进行封装
		DataDictionary dd = new DataDictionary();
		dd.setDataType("意向状态类型");
		List<DataDictionary>  studentState_list = dataDictionaryService.getDataDictionaryList(dd);
		studentState_map = WebUtils.pack(studentState_list);
	}

	// 添加学员数据之前需转发相关的数据
	@RequestMapping("addStudentInfoUI.action")
	public String addStudentInfoUI(StudentInfo studentInfo, Model model) {
		pack(); // 封装数据
		model.addAttribute("studentState_map", studentState_map);
		return "recruitstudent/recruitstudent/recruitstudent_add";
	}

	// 添加学员信息
	@RequestMapping("addStudentInfo.action")
	public String addStudentInfo(StudentInfo studentInfo, Model model) {
		// 招生管理涉及到负责员工，此处是默认当前登录员工作为负责人(默认为1，之后修改)
		studentInfo.setStaffId(1);

		boolean remark = studentInfoService.addStudentInfo(studentInfo);
		if (remark) {
			model.addAttribute("info", "学生信息添加成功！");
		} else {
			model.addAttribute("info", "学生信息添加失败！");
		}

		return listStudentInfo(null, model);
	}

	// 获取学员信息列表
	@RequestMapping("listStudentInfo.action")
	public String listStudentInfo(StudentInfo studentInfo, Model model) {
		// 如果传入的数据studentInfo为null则自定义创造条件即可
		if (studentInfo == null) {
			studentInfo = new StudentInfo();
		}
		studentInfo.setStudentType("意向学员");
		List<StudentInfo> list = studentInfoService.getStudentInfoList(studentInfo);
		model.addAttribute("list", list);
		pack(); // 封装数据
		model.addAttribute("studentState_map", studentState_map);
		return "recruitstudent/recruitstudent/recruitstudent_list";
	}

	// 修改学员信息，需要进行数据回显
	@RequestMapping("updateStudentInfoUI.action")
	public String updateStudentInfoUI(Integer studentId, Model model) {
		pack(); // 封装数据
		// 根据学员id获取学员信息
		StudentInfo studentInfo = studentInfoService.getStudentInfo(studentId);
		model.addAttribute("studentInfo", studentInfo);
		model.addAttribute("studentState_map", studentState_map);
		return "recruitstudent/recruitstudent/recruitstudent_update";
	}

	// 根据获取的数据修改学员信息
	@RequestMapping("updateStudentInfo.action")
	public String updateStudentInfo(StudentInfo studentInfo, Model model) {
		boolean remark = studentInfoService.updateStudentInfo(studentInfo);
		if (remark) {
			model.addAttribute("info", "学生信息修改成功！");
		} else {
			model.addAttribute("info", "学生信息修改失败！");
		}
		return listStudentInfo(null, model);
	}

	// 根据学员id删除学生信息
	@RequestMapping("deleteStudentInfo.action")
	public String deleteStudentInfo(Integer studentId, Model model) {
		// 根据学员id获取学员信息
		boolean remark = studentInfoService.deleteStudentInfo(studentId);
		if (remark) {
			model.addAttribute("info", "学生信息删除成功！");
		} else {
			model.addAttribute("info", "学生信息删除失败！");
		}
		return listStudentInfo(null, model);
	}

	// 领取学员信息（即将学员转为正式学员）
	@RequestMapping("updateStudentType.action")
	public String updateStudentType(Integer studentId, Model model) {
		// 根据学员id获取学员信息
		StudentInfo studentInfo = studentInfoService.getStudentInfo(studentId);
		// 修改学员类型，将其转为正式学员
		studentInfo.setStudentType("正式学员");
		// 此时班级默认为-1（表示没有指定的班级）
		studentInfo.setClassId(-1);
		boolean remark = studentInfoService.updateStudentInfo(studentInfo);
		if (remark) {
			model.addAttribute("info", "该学生已转为正式学员，在学员管理模块可查阅该学生信息！");
		} else {
			model.addAttribute("info", "学生信息修改失败！");
		}
		return listStudentInfo(null, model);
	}
}
