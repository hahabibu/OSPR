package com.guigu.instructional.student.controller;
/**       
 * 学员管理相关   
 */

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.classinfo.service.ClassInfoService;
import com.guigu.instructional.po.ClassInfo;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.recruitstudent.service.StudentInfoService;
import com.guigu.instructional.utils.WebUtils;

@Controller
@RequestMapping("/student/student/")
public class StudentInfoController {

	// 直接引用招生管理中的学生管理内容（只不过两者管理的学生类型不同）
	@Resource(name = "studentInfoServiceImpl")
	private StudentInfoService studentInfoService;

	@Resource(name = "ClassInfoService")
	private ClassInfoService classInfoService;

	Map<String, Integer> studentState_map = WebUtils.getStudentState();

	// 添加学员数据之前需转发相关的数据
	@RequestMapping("addStudentInfoUI.action")
	public String addStudentInfoUI(StudentInfo studentInfo, Model model) {
		model.addAttribute("studentState_map", studentState_map);
		return "student/student/student_add";
	}

	// 添加学员信息
	@RequestMapping("addStudentInfo.action")
	public String addStudentInfo(StudentInfo studentInfo, Model model) {
		// 招生管理涉及到负责员工，此处是默认当前登录员工作为负责人(默认为1，之后修改)
		studentInfo.setStaffId(1);
		// 此处添加学员信息默认班级Id为-1
		studentInfo.setClassId(-1);

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
		// 默认是意向学员显示
		// 如果传入的数据studentInfo为null则自定义创造条件即可
		if (studentInfo == null) {
			studentInfo = new StudentInfo();
		}
		studentInfo.setStudentType("正式学员");
		List<StudentInfo> list = studentInfoService.getStudentInfoList(studentInfo);

		try {
			// 根据学员班级id设置相应的学员名称
			for (int i = 0; i < list.size(); i++) {
				StudentInfo si = list.get(i);
				ClassInfo ci = classInfoService.getClassInfoInfo(si.getClassId());
				if (ci != null) {
					si.setClassName(ci.getClassName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("list", list);
		return "student/student/student_list";
	}

	// 修改学员信息，需要进行数据回显
	@RequestMapping("updateStudentInfoUI.action")
	public String updateStudentInfoUI(Integer studentId, Model model) {
		// 根据学员id获取学员信息
		StudentInfo studentInfo = studentInfoService.getStudentInfo(studentId);
		model.addAttribute("studentInfo", studentInfo);
		model.addAttribute("studentState_map", studentState_map);
		return "student/student/student_update";
	}

	// 根据获取的数据修改学员信息
	@RequestMapping("updateStudentInfo.action")
	public String updateStudentInfo(StudentInfo studentInfo, Model model) {
		// 根据学员id获取学员信息
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

}
