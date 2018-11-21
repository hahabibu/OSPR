package com.guigu.instructional.system.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.RoleInfo;
import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.system.service.RoleInfoService;
import com.guigu.instructional.system.service.StaffInfoService;

/**
 * <p>
 * project_name:GuiguManager
 * </p>
 * <p>
 * package_name:com.tmt.instructional.system.controller.RoleInfoController
 * </p>
 * <p>
 * description：
 * </p>
 * <p>
 * 
 * @author：童梦涛
 *             <p>
 *             <p>
 *             date:2018年8月16日上午10:38:26
 *             </p>
 *             <p>
 *             comments：
 *             </p>
 *             <p>
 * @version jdk1.9
 *          </p>
 * 
 *          <p>
 *          Copyright (c) 2018, 493352276@qq.com All Rights Reserved.
 *          </p>
 */

@Controller
@RequestMapping("/system/roleinfo/")
public class RoleInfoController {

	@Resource(name = "roleInfoServiceImpl")
	private RoleInfoService roleInfoService;

	@Resource(name = "staffInfoServiceImpl")
	private StaffInfoService staffInfoService;

	@RequestMapping("addRoleInfo.action")
	public String addRoleInfo(RoleInfo roleInfo, Model model) {
		roleInfo.setRoleState("1");

		boolean remake = roleInfoService.addRoleInfo(roleInfo);

		if (remake) {
			model.addAttribute("info", "添加角色成功");
		} else {
			model.addAttribute("info", "添加角色失败");
		}
		return listRoleInfo(null, model);
	}

	@RequestMapping("listRoleInfo.action")
	public String listRoleInfo(RoleInfo roleInfo, Model model) {

		List<RoleInfo> list = roleInfoService.getRoleInfoList(roleInfo);

		model.addAttribute("list", list);

		return "system/roleinfo/roleinfo_list";
	}

	@RequestMapping("updateRoleInfoUI.action")
	public String updateRoleInfoUI(int roleId, Model model) {
		RoleInfo roleInfo = roleInfoService.getRoleInfo(roleId);
		model.addAttribute("roleInfo", roleInfo);

		return "system/roleinfo/roleinfo_update";
	}

	@RequestMapping("updateRoleInfo.action")
	public String updateRoleInfo(RoleInfo roleInfo, Model model) {
		boolean mark = roleInfoService.updateRoleInfo(roleInfo);
		if (mark) {
			model.addAttribute("info", "修改角色成功！");
		} else {
			model.addAttribute("info", "修改角色失败！");
		}

		return listRoleInfo(null, model);
	}

	@RequestMapping("deleteRoleInfo.action")
	public String deleteRoleInfo(RoleInfo roleInfo, Model model) {

		roleInfo.setRoleState("0");
		boolean mark = roleInfoService.updateRoleInfo(roleInfo);
		if (mark) {
			model.addAttribute("info", "删除角色成功！");
		} else {
			model.addAttribute("info", "删除角色失败！");
		}

		return listRoleInfo(null, model);
	}

	
	
	@RequestMapping("roleChangeUI.action")
	public String roleChangeUI(int staffId, Model model) {
		StaffInfo staffInfo = staffInfoService.getStaffInfo(staffId);
		model.addAttribute("staffInfo", staffInfo);

		// 查询所有的角色
		List<RoleInfo> list = roleInfoService.getRoleInfoList(null);
		model.addAttribute("rolelist", list);
		return "system/roleinfo/role_change";
	}
	
	@RequestMapping("roleChange.action")
	public String roleChange(StaffInfo staffInfo,Model model) {
		boolean mark=staffInfoService.updateStaff(staffInfo);

		if(mark) {
			model.addAttribute("info","角色变更成功！");
		}else {
			model.addAttribute("info","角色变更失败！");
		}
		return listStaffRoleInfo(null, model);
	}
	
	
	//角色变更显示   和上面的差不多，return地址不同
	@RequestMapping("listStaffRoleInfo.action")
	public String listStaffRoleInfo(StaffInfo staffInfo,Model model) {
		List<StaffInfo>list=staffInfoService.getStaffInfoList(staffInfo);
		
		model.addAttribute("list",list);		
		
		return "system/roleinfo/staffinfo_role_list";
	}
}
