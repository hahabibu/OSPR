package com.guigu.instructional.student.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.StudentWriteGrade;
import com.guigu.instructional.recruitstudent.service.StudentInfoService;
import com.guigu.instructional.student.service.impl.StudentWriteGradeServiceimpl;
import com.guigu.instructional.system.service.StaffInfoService;

@Controller
@RequestMapping("/student/studentwritegrade/")
public class StudentWriteGradeController {

	@Resource(name = "studentWriteGradeServiceImpl")
	private StudentWriteGradeServiceimpl studentWriteGradeService;
	@Resource(name="studentInfoServiceImpl")
	private StudentInfoService studentInfoService;
	@Resource(name="staffInfoServiceImpl")
	private StaffInfoService staffInfoService;
	//添加UI
		@RequestMapping("addStudentWriteGradeUI.action")
		public String addStudentWriteGradeUI(Model model) {
			List<StudentInfo> studentList=studentInfoService.getStudentInfoList(null);
			List<StaffInfo> staffList=staffInfoService.getStaffInfoList(null);
			model.addAttribute("studentList", studentList);
			model.addAttribute("staffList", staffList);
			return "student/studentwritegrade/studentwritegrade_add";
			
		}
	// 添加成绩
	@RequestMapping("addStudentWriteGrade.action")
	public String addStudentWriteGrade(StudentWriteGrade studentWriteGrade, Model model) {

		boolean remark = studentWriteGradeService.addStudentWriteGrade(studentWriteGrade);

		if (remark) {
			model.addAttribute("info", "添加学生成绩成功!");
		} else {
			model.addAttribute("info", "沟通记录添加失败!");
		}

		// 添加完成后跳转到列表页面即可
		return listStudentWriteGrade(null, model);

	}
	//列出成绩
	@RequestMapping("listStudentWriteGrade.action")
	public String listStudentWriteGrade(StudentInfo studentInfo, Model model) {
		
		List<StudentWriteGrade> list =studentWriteGradeService.getStudentWriteGradeList(studentInfo);
		List<StudentInfo> studentList=studentInfoService.getStudentInfoList(null);
		List<StaffInfo> staffList=staffInfoService.getStaffInfoList(null);
		//根据ID封装学生姓名
		for(int i=0;i<list.size();i++) {
			for(int j=0;j<studentList.size();j++) {
			if(list.get(i).getStudentId()==studentList.get(j).getStudentId())
				list.get(i).setStudentName(studentList.get(j).getStudentName());
			}
		}
		//根据ID封装负责人姓名
		for(int i=0;i<list.size();i++) {
			for(int j=0;j<staffList.size();j++) {
			if(list.get(i).getStaffId()==staffList.get(j).getStaffId())
				list.get(i).setStaffName(staffList.get(j).getStaffName());
			}
		}
		
		model.addAttribute("list", list);

		return "student/studentwritegrade/studentwritegrade_list";
	}

	//更新UI
	@RequestMapping("updateStudentWriteGradeUI.action")
	public String updateStudentWriteGradeUI(Integer writeGradeId,Model model) {
		List<StudentInfo> studentList=studentInfoService.getStudentInfoList(null);
		List<StaffInfo> staffList=staffInfoService.getStaffInfoList(null);
		StudentWriteGrade studentWriteGrade=studentWriteGradeService.getStudentWriteGrade(writeGradeId);
		
		model.addAttribute("studentWriteGrade",studentWriteGrade);
		model.addAttribute("studentList", studentList);
		model.addAttribute("staffList", staffList);
		return "student/studentwritegrade/studentwritegrade_update";
		
	}
	//更新操作
	@RequestMapping("updateStudentWriteGrade.action")
	public String updateStudentWriteGrade(StudentWriteGrade studentWriteGrade,Model model) {
		
		boolean remark=studentWriteGradeService.updateStudentWriteGrade(studentWriteGrade);
		if(remark) {
			model.addAttribute("info", "修改成绩成功！");
		}else {
			model.addAttribute("info", "修改成绩失败！");
		}
		return listStudentWriteGrade(null,model);
		
	}
	//删除成绩
	@RequestMapping("deleteStudentWriteGrade.action")
	public String deleteStudentWriteGrade(Integer writeGradeId,Model model) {

		boolean remark=studentWriteGradeService.deleteStudentWriteGrade(writeGradeId);
		if(remark) {
			model.addAttribute("info", "删除成绩成功！");
		}else {
			model.addAttribute("info", "删除成绩失败！");
		}
		return listStudentWriteGrade(null,model);
	}

}
