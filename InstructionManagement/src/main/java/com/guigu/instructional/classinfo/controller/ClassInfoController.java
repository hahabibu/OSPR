package com.guigu.instructional.classinfo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.classinfo.service.ClassInfoService;
import com.guigu.instructional.classinfo.service.ClassRoomInfoService;
import com.guigu.instructional.classinfo.service.DisciplineinfoService;
import com.guigu.instructional.classinfo.service.syllabusService;
import com.guigu.instructional.po.ClassInfo;
import com.guigu.instructional.po.ClassroomInfo;
import com.guigu.instructional.po.DisciplineInfo;
import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.SyllabusInfo;
import com.guigu.instructional.recruitstudent.service.StudentInfoService;
import com.guigu.instructional.system.service.StaffInfoService;

@Controller
@RequestMapping("/classinfo/classinfo")
public class ClassInfoController {

	@Resource(name = "ClassInfoService")
	private ClassInfoService classInfoService;

	@Resource(name = "staffInfoServiceImpl")
	private StaffInfoService staffInfoService;

	@Resource(name = "syllabusInfoService")
	private syllabusService syllabusservice;

	@Resource(name = "classroomInfoinfoService")
	private ClassRoomInfoService classRoomInfoService;

	@Resource(name = "disciplineinfoService")
	private DisciplineinfoService disciplineinfoService;
	
	@Resource(name = "studentInfoServiceImpl")
	private StudentInfoService studentInfoService;

	@RequestMapping("addClassinfo.action")
	public String addClassinfo(ClassInfo classInfo, Model model) throws Exception {

		System.out.println(classInfo);
		boolean remark = classInfoService.add_ClassInfo(classInfo);
		if (remark) {
			model.addAttribute("info", "信息添加成功");
		} else {
			model.addAttribute("info", "信息添加失败");
		}

		List<StaffInfo> liStaffInfos = staffInfoService.getStaffInfoList(null);
		model.addAttribute("liStaffInfos", liStaffInfos);
		return listClassInfo(null, model);
	}

	@RequestMapping("SelectStaff.action")
	public String SelectStaff(Model model) throws Exception {

		// 此处设定只能查找教师信息(教师角色编号设定为4)
		StaffInfo si = new StaffInfo();
		si.setRoleId(4);
		List<StaffInfo> liStaffInfos = staffInfoService.getStaffInfoList(si);
		model.addAttribute("liStaffInfos", liStaffInfos);

		List<DisciplineInfo> listDisci = disciplineinfoService.findDisciplineInfoList(null);
		model.addAttribute("listDisci", listDisci);

		List<SyllabusInfo> listSyl = syllabusservice.findsyllabusInfoList(null);
		model.addAttribute("listSyl", listSyl);

		List<ClassroomInfo> lisClar = classRoomInfoService.findclassroomInfoList(null);
		model.addAttribute("lisClar", lisClar);

		return "classinfo/classinfo/classinfo_add";
	}

	@RequestMapping("listClassInfo.action")
	public String listClassInfo(ClassInfo classInfo, Model model) throws Exception {

		List<ClassInfo> listClassinfo = classInfoService.findClassInfoList(classInfo);

		model.addAttribute("listClassinfo", listClassinfo);

		return "classinfo/classinfo/classinfo_list";

	}

	@RequestMapping("getClassInfo.action")
	public String getClassInfo(Integer classId, Model model) throws Exception {

		ClassInfo classinfo = classInfoService.getClassInfoInfo(classId);
		model.addAttribute("classinfo", classinfo);

		// 此处设定只能查找教师信息(教师角色编号设定为4)
		StaffInfo si = new StaffInfo();
		si.setRoleId(4);
		List<StaffInfo> liStaffInfos = staffInfoService.getStaffInfoList(si);
		model.addAttribute("liStaffInfos", liStaffInfos);

		List<DisciplineInfo> listDisci = disciplineinfoService.findDisciplineInfoList(null);
		model.addAttribute("listDisci", listDisci);

		List<SyllabusInfo> listSyl = syllabusservice.findsyllabusInfoList(null);
		model.addAttribute("listSyl", listSyl);

		List<ClassroomInfo> lisClar = classRoomInfoService.findclassroomInfoList(null);
		model.addAttribute("lisClar", lisClar);

		return "/classinfo/classinfo/classinfo_update";

	}

	@RequestMapping("updateClassInfo.action")
	public String updateClassInfo(ClassInfo classInfo, Model model) throws Exception {
		boolean remark = classInfoService.update_ClassInfo(classInfo);

		if (remark) {
			model.addAttribute("info", "信息修改成功");
		} else {
			model.addAttribute("info", "信息修改失败");
		}
		return listClassInfo(null, model);
	}

	@RequestMapping("deleteClassInfo.action")
	public String deleteClassInfo(Integer classId, Model model) throws Exception {

		boolean remark = classInfoService.delete_ClassInfoInfo(classId);

		if (remark) {
			model.addAttribute("info", "信息删除成功");
		} else {
			model.addAttribute("info", "信息删除失败");
		}
		return listClassInfo(null, model);
	}
	
	// 显示当前班级所有学员信息
	@RequestMapping("listStudentInfo.action")
	public String listStudentInfo(Integer classId, StudentInfo studentInfo,Model model) throws Exception {
		// 根据班级编号获取当前班级所有的学生信息，可以进行添加和移除操作
		// 获取所有学员信息，通过遍历查找是否符合
		List<StudentInfo> si_list = studentInfoService.getStudentInfoList(studentInfo);
		List<StudentInfo> list = new ArrayList<>();
		// 如果学员对应的班级编号不为null则进入下一步的判断
		for(int i=0;i<si_list.size();i++) {
			StudentInfo si = si_list.get(i);
			if(si.getClassId()!=null) {
				if(si.getClassId()==classId) {
					list.add(si);
				}
			}
		}
		// 将当前的班级id一并传入
		model.addAttribute("classId", classId);
		model.addAttribute("list", list);
		return "/classinfo/classinfo/student_management";
	}
	
	// 移除学员
	@RequestMapping("removeStudent.action")
	public String removeStudent(Integer studentId, HttpServletRequest request,Model model) throws Exception {
		Integer classId = Integer.valueOf(request.getParameter("classId"));
		// 根据传入的学生信息，将该学生模拟移除该班级（即置其classId为-1，而非真正删除该学生信息）
		StudentInfo si = studentInfoService.getStudentInfo(studentId);
		if(si!=null) {
			si.setClassId(-1);
		}
		boolean remark = studentInfoService.updateStudentInfo(si);
		if(remark) {
			model.addAttribute("info", "已成功将该学生移出该班级！！");
		}else {
			model.addAttribute("info", "操作失败！！");
		}
		return listStudentInfo(classId, null, model);
	}
	
	// 添加学员，需要获取当前所有空置学员的信息（班级id为-1的学员）
	@RequestMapping("addStudentUI.action")
	public String addStudentUI(HttpServletRequest request, Model model) throws Exception {
		String classId = request.getParameter("classId");
		// 将传入的班级id（传入到下一个jsp页面（添加学生的页面））
		model.addAttribute("classId", classId);
		// 查找当前所有班级id为-1的学员信息(即闲置的正式学员信息)
		StudentInfo si = new StudentInfo();
		si.setClassId(-1);
		si.setStudentType("正式学员");
		List<StudentInfo> list = studentInfoService.getStudentInfoList(si);
		model.addAttribute("list", list);
		return "classinfo/classinfo/listResveStudent";
	}
	
	@RequestMapping("addStudent.action")
	public String addStudent(Integer studentId,HttpServletRequest request, Model model) throws Exception {
		Integer classId = Integer.valueOf(request.getParameter("classId"));
		ClassInfo classInfo = classInfoService.getClassInfoInfo(classId);
		// 通过学生编号studentId查找学生信息，随后将学生班级进行修改
		StudentInfo studentInfo = studentInfoService.getStudentInfo(studentId);
		studentInfo.setClassId(classId);
		boolean remark = studentInfoService.updateStudentInfo(studentInfo);
		if(remark) {
			model.addAttribute("info", "该学生已成功加入"+classInfo.getClassName());
		}else {
			model.addAttribute("info", "操作失败！！");
		}
		return	listStudentInfo(classId,null, model);

	}
	
}
