package com.guigu.instructional.classinfo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.system.service.StaffInfoService;

@Controller
@RequestMapping("/classinfo/teacher")
public class TeacherController {
	
	
	@Resource(name="staffInfoServiceImpl")
	private StaffInfoService staffInfoService;
	
	@RequestMapping("addStaffInfo.action")
	public String addStaffInfo(StaffInfo staffInfo, Model model) throws Exception{
		
		staffInfo.setStaffState("1");
		
		// 设置该角色为教师角色(定死)
		staffInfo.setRoleId(4);
		
		boolean remark = staffInfoService.addStaff(staffInfo);
	
		
		if(remark) {
			model.addAttribute("info","教师信息添加成功");
		}else {
			model.addAttribute("info","教师信息添加失败");
		}
				
		return listStaffInfo(null,model);
	}
	
	@RequestMapping("listStaffInfo.action")
	public String listStaffInfo(StaffInfo staffInfo,Model model) throws Exception{
		
		// 此处仅仅是查找教师信息（根据员工的角色编号进行查找，此处定死教师编号为4）
		if(staffInfo==null) {
			staffInfo = new StaffInfo();
		}
		staffInfo.setRoleId(4);
		
		List<StaffInfo> staffInfos = staffInfoService.getStaffInfoList(staffInfo);
		
		model.addAttribute("staffInfos", staffInfos);
		
		return "classinfo/teacher/teacher_list";
	}
	
	@RequestMapping("showStaffInfo.action")
	public String showStaffInfo(Integer staffId,Model model) throws Exception {
		
		StaffInfo staffInfo = staffInfoService.getStaffInfo(staffId);
		
		model.addAttribute("staffInfo", staffInfo);
		
		return "system/staffinfo/staffinfo_show";
		
	}
	
	@RequestMapping("updateStaffInfo.action")
	private String updateStaffInfo(StaffInfo staffInfo,Model model) throws Exception{
		
		boolean remark = staffInfoService.updateStaff(staffInfo);
		
		if(remark) {
			model.addAttribute("info", "信息修改成功");
		}else {
			model.addAttribute("info", "信息修改失败");
		}
		
		return listStaffInfo(null, model);
	}
	
	@RequestMapping("getStaffInfo.action")
	public String getStaffInfo(Integer staffId,Model model) throws Exception{
		
		StaffInfo staffInfo = staffInfoService.getStaffInfo(staffId);

		model.addAttribute("sta", staffInfo);
		
		return "classinfo/teacher/teacher_update";
	}
	
	@RequestMapping("deleteStaffInfo.action")
	private String deleteStaffInfo(Integer staffId,Model model) throws Exception{
		
		boolean remark = staffInfoService.deleteStaff(staffId);
		
		if(remark) {
			model.addAttribute("info", "信息删除成功");
		}else {
			model.addAttribute("info", "信息删除失败");
		}
		
		return listStaffInfo(null, model);
	}
}
