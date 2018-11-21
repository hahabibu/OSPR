package com.guigu.instructional.student.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.CommunicationInfo;
import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.recruitstudent.service.StudentInfoService;
import com.guigu.instructional.student.service.impl.CommunicateInfoServiceimpl;
import com.guigu.instructional.system.service.StaffInfoService;

@Controller
@RequestMapping("/student/communicateinfo/")
public class CommunicateInfoController {

	@Resource(name = "communicateInfoServiceImpl")
	private CommunicateInfoServiceimpl communicateInfoService;
	@Resource(name="studentInfoServiceImpl")
	private StudentInfoService studentInfoService;
	@Resource(name="staffInfoServiceImpl")
	private StaffInfoService staffInfoService;
	//添加UI
		@RequestMapping("addCommunicateInfoUI.action")
		public String addCommunicateInfoUI(Model model) {
			List<StudentInfo> studentList=studentInfoService.getStudentInfoList(null);
			List<StaffInfo> staffList=staffInfoService.getStaffInfoList(null);
			model.addAttribute("studentList", studentList);
			model.addAttribute("staffList", staffList);
			return "student/communicateinfo/communicateinfo_add";
			
		}
	// 添加评价
	@RequestMapping("addCommunicateInfo.action")
	public String addCommunicateInfo(CommunicationInfo communicationInfo, Model model) {

		boolean remark = communicateInfoService.addCommunicateInfo(communicationInfo);

		if (remark) {
			model.addAttribute("info", "添加沟通记录成功!");
		} else {
			model.addAttribute("info", "沟通记录添加失败!");
		}

		// 添加完成后跳转到列表页面即可
		return listCommunicateInfo(null, model);

	}

	//列出评价
	@RequestMapping("listCommunicateInfo.action")
	public String listCommunicateInfo(StudentInfo studentInfo, Model model) {

		List<CommunicationInfo> list =communicateInfoService.getCommunicateInfoList(studentInfo) ;
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

		return "student/communicateinfo/communicateinfo_list";
	}

	//更新UI
	@RequestMapping("updateCommunicateInfoUI.action")
	public String updateCommunicateInfoUI(Integer communicationId,Model model) {
		List<StudentInfo> studentList=studentInfoService.getStudentInfoList(null);
		List<StaffInfo> staffList=staffInfoService.getStaffInfoList(null);
		CommunicationInfo communicationInfo=communicateInfoService.getCommunicateInfo(communicationId);
		
		model.addAttribute("communicationInfo",communicationInfo);
		model.addAttribute("studentList", studentList);
		model.addAttribute("staffList", staffList);
		return "student/communicateinfo/communicateinfo_update";
		
	}
	//更新操作
	@RequestMapping("updateCommunicateInfo.action")
	public String updateCommunicateInfo(CommunicationInfo communicationInfo,Model model) {

		boolean remark=communicateInfoService.updateCommunicateInfo(communicationInfo);
		if(remark) {
			model.addAttribute("info", "修改记录成功！");
		}else {
			model.addAttribute("info", "修改记录失败！");
		}
		return listCommunicateInfo(null,model);
		
	}
	//删除记录
	@RequestMapping("deleteCommunicateInfo.action")
	public String deleteCommunicateInfo(Integer communicationId,Model model) {
		boolean remark=communicateInfoService.deleteCommunicateInfo(communicationId);
		
		if(remark) {
			model.addAttribute("info", "删除记录成功！");
		}else {
			model.addAttribute("info", "删除记录失败！");
		}
		return listCommunicateInfo(null,model);
	}
	


}
