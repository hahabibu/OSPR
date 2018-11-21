package com.guigu.instructional.system.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.system.service.StaffInfoService;

/**       
 * 员工管理
 */

@Controller
@RequestMapping("/system/staffinfo/")
public class StaffInfoController {
	
	@Resource(name="staffInfoServiceImpl")
	private StaffInfoService staffInfoService;
	
	// 添加员工信息
	@RequestMapping("addStaffInfo.action")
	public String addStaffInfo(StaffInfo staffInfo,Model model) {
		staffInfo.setStaffState("1");
		boolean remark = staffInfoService.addStaff(staffInfo);
		if(remark) {
			model.addAttribute("info","员工信息添加成功");
		}else {
			model.addAttribute("info","员工信息添加失败");
		}
		// 添加完成之后跳转到列表页面
		return listStaffInfo(null, model);
	}
	
	// 列出员工信息
	@RequestMapping("listStaffInfo.action")
	public String listStaffInfo(StaffInfo staffInfo,Model model) {
		List<StaffInfo> list = staffInfoService.getStaffInfoList(staffInfo);
		model.addAttribute("list",list);
		return "system/staffinfo/staffinfo_list";
	}
	
	// 查询单个员工详细信息
	@RequestMapping("showStaffInfo.action")
	public String showStaffInfo(Integer staffId,Model model) {
		StaffInfo staffInfo = staffInfoService.getStaffInfo(staffId);
		model.addAttribute("staffInfo", staffInfo);
		return "system/staffinfo/staffinfo_show";
	}
	
	// 获取要修改用户信息进行数据回显
	@RequestMapping("updateStaffInfoUI.action")
	public String updateStaffInfoUI(Integer staffId,Model model) {
		// 根据id查找用户信息，并将数据回显
		StaffInfo staffInfo = staffInfoService.getStaffInfo(staffId);
		model.addAttribute("staffInfo", staffInfo);
		return "system/staffinfo/staffinfo_update";
	}
	
	// 修改用户信息
	@RequestMapping("updateStaffInfo.action")
	public String updateStaffInfo(StaffInfo staffInfo,Model model) {
		boolean remark = staffInfoService.updateStaff(staffInfo);
		if(remark) {
			model.addAttribute("info","员工信息修改成功");
		}else {
			model.addAttribute("info","员工信息修改失败");
		}
		// 修改完成之后跳转到列表页面
		return listStaffInfo(null, model);
	}
	
	// 删除员工信息
	@RequestMapping("deleteStaffInfo.action")
	public String deleteStaffInfo(Integer staffId,Model model) {
		// 此处是根据id先查找到指定的用户信息在进行操作
		StaffInfo staffInfo = staffInfoService.getStaffInfo(staffId);
		staffInfo.setStaffState("0");
		// 此处删除员工是通过修改员工状态为0作为删除，而非真正意义上的删除
		boolean remark = staffInfoService.updateStaff(staffInfo);
		if(remark) {
			model.addAttribute("info","员工信息删除成功");
		}else {
			model.addAttribute("info","员工信息删除失败");
		}
		// 修改完成之后跳转到列表页面
		return listStaffInfo(null, model);
	}

}


