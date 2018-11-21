package com.guigu.instructional.finance.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.finance.service.StaffSalaryService;
import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.po.StaffSalary;
import com.guigu.instructional.system.service.StaffInfoService;


/**       
 * <p>project_name:GuiguManager</p>
 * <p>package_name:com.tmt.instructional.finance.controller.StaffSalaryController</p>
 * <p>description：</p>
 * <p>@author：童梦涛<p>   
 * <p> date:2018年8月19日下午10:10:58 </p>
 * <p>comments：    </p>
 * <p>@version  jdk1.9</p>
 * 
 * <p>Copyright (c) 2018, 493352276@qq.com All Rights Reserved. </p>    
 */

@Controller
@RequestMapping("/finance/staffsalary/")
public class StaffSalaryController {
	
	@Resource(name="staffSalaryServiceImpl")
	private StaffSalaryService staffSalaryService;

	@Resource(name="staffInfoServiceImpl")
	private StaffInfoService staffInfoService;
	
	@RequestMapping("listStaffSalary.action")
	public String listStaffSalary(StaffSalary staffSalary,Model model) {
		List<StaffSalary> list=staffSalaryService.getStaffSalaryList(staffSalary);
		//根据staffSalary.getstaffid查 staffname  领取人、财务人 姓名
		for(StaffSalary staffSalaryA:list) {
			int staffId=staffSalaryA.getStaffId();
			StaffInfo staffInfo=staffInfoService.getStaffInfo(staffId);
			staffSalaryA.setStaffName(staffInfo.getStaffName());
			
			int staStaffId=staffSalaryA.getStaStaffId();
			StaffInfo staffInfo2=staffInfoService.getStaffInfo(staStaffId);
			staffSalaryA.setStaStaffName(staffInfo2.getStaffName());
		}
		
			
		model.addAttribute("list",list);
		
		return "finance/staffsalary/staffsalary_list";
	}
	
	@RequestMapping("updateStaffSalaryUI.action")
	public String updateStaffSalaryUI(int staffSalaryId,Model model) {

		StaffSalary staffSalary=staffSalaryService.getStaffSalaryById(staffSalaryId);
		model.addAttribute("staffSalary",staffSalary);
		
		List<StaffInfo> stafflist=staffInfoService.getStaffInfoList(null);
		model.addAttribute("stafflist",stafflist);
		
		List<StaffInfo> stastafflist=staffInfoService.getStaffInfoList(null);
		model.addAttribute("stastafflist",stastafflist);
		return "finance/staffsalary/staffsalary_update";
	}	
	
	@RequestMapping("updateStaffSalary.action")
	public String updateStaffSalary(StaffSalary staffSalary,Model model) {
		
		boolean mark = staffSalaryService.updateStaffSalary(staffSalary);
		if (mark) {
			model.addAttribute("info", "修改薪水信息成功！");
		} else {
			model.addAttribute("info", "修改薪水信息失败！");
		}

		return listStaffSalary(null, model);
	}
	
	@RequestMapping("deleteStaffSalary.action")
	public String deleteStaffSalary(StaffSalary staffSalary,Model model) {
		int staffSalaryId=staffSalary.getStaffSalaryId();
		boolean mark = staffSalaryService.deleteStaffSalary(staffSalaryId);
		if (mark) {
			model.addAttribute("info", "删除薪水信息成功！");
		} else {
			model.addAttribute("info", "删除薪水信息失败！");
		}
		return listStaffSalary(null, model);
	}
	
	@RequestMapping("addStaffSalaryUI.action")
	public String addStaffSalaryUI(Model model) {
		
		List<StaffInfo> stafflist=staffInfoService.getStaffInfoList(null);
		model.addAttribute("stafflist",stafflist);
		
		List<StaffInfo> stastafflist=staffInfoService.getStaffInfoList(null);
		model.addAttribute("stastafflist",stastafflist);
		
		return "finance/staffsalary/staffsalary_add";
	}	
	@RequestMapping("addStaffSalary.action")
	public String addStaffSalary(StaffSalary staffSalary,Model model) {
		boolean mark=staffSalaryService.addStaffSalary(staffSalary);
		if (mark) {
			model.addAttribute("info", "添加薪水信息成功！");
		} else {
			model.addAttribute("info", "添加薪水信息失败！");
		}

		return listStaffSalary(null, model);
	}

}


