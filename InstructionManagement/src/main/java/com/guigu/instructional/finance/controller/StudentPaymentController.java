package com.guigu.instructional.finance.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.finance.service.StudentPaymentService;
import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.po.StudentPayment;
import com.guigu.instructional.system.service.StaffInfoService;

/**       
 * <p>project_name:GuiguManager</p>
 * <p>package_name:com.tmt.instructional.system.controller.StudentPaymentController</p>
 * <p>description：</p>
 * <p>@author：童梦涛<p>   
 * <p> date:2018年8月18日上午11:17:35 </p>
 * <p>comments：    </p>
 * <p>@version  jdk1.9</p>
 * 
 * <p>Copyright (c) 2018, 493352276@qq.com All Rights Reserved. </p>    
 */

@Controller
@RequestMapping("/finance/studentpayment/")
public class StudentPaymentController {

	@Resource(name="studentPaymentServiceImpl")
	private StudentPaymentService studentPaymentService;
	
/*	@Resource(name="studentInfoServiceImpl")
	private StudentInfoService studentInfoService;*/
	
	@Resource(name="staffInfoServiceImpl")
	private StaffInfoService staffInfoService;
	
	@RequestMapping("listStudentPayment.action")
	public String listStudentPayment(StudentPayment studentPayment,Model model) {
		List<StudentPayment> list=studentPaymentService.getStudentPaymentList(studentPayment);
		model.addAttribute("list",list);
		
		return "finance/studentpayment/studentpayment_list";
	}
	
	@RequestMapping("updateStudentPaymentUI.action")
	public String updateStudentPaymentUI(int paymentId,Model model) {

		StudentPayment studentPayment=studentPaymentService.getStudentPaymentByPaymentId(paymentId);
		model.addAttribute("StudentPayment",studentPayment);
		
		
//		model.addAttribute("studentlist",studentlist); 学生先不写
		
		List<StaffInfo> stafflist=staffInfoService.getStaffInfoList(null);
		model.addAttribute("stafflist",stafflist);
		return "finance/studentpayment/studentpayment_update";
	}
	
	@RequestMapping("updateStudentPayment.action")
	public String updateStudentPayment(StudentPayment studentPayment,Model model) {
		
		boolean mark = studentPaymentService.updateStudentPayment(studentPayment);
		if (mark) {
			model.addAttribute("info", "修改缴费信息成功！");
		} else {
			model.addAttribute("info", "修改缴费信息失败！");
		}

		return listStudentPayment(null, model);
	}
	
	@RequestMapping("deleteStudentPayment.action")
	public String deleteStudentPayment(StudentPayment studentPayment,Model model) {
		int paymentId=studentPayment.getPaymentId();
		boolean mark = studentPaymentService.deleteStudentPayment(paymentId);
		if (mark) {
			model.addAttribute("info", "删除缴费信息成功！");
		} else {
			model.addAttribute("info", "删除缴费信息失败！");
		}
		return listStudentPayment(null, model);
	}
	
	@RequestMapping("addStudentPaymentUI.action")
	public String addStudentPaymentUI(Model model) {
		
		//学生 先不写
		
		List<StaffInfo> stafflist=staffInfoService.getStaffInfoList(null);
		model.addAttribute("stafflist",stafflist);
		return "finance/studentpayment/studentpayment_add";
	}
	
	@RequestMapping("addStudentPayment.action")
	public String addStudentPayment(StudentPayment studengPayment,Model model) {
		boolean mark=studentPaymentService.addStudentPayment(studengPayment);
		if (mark) {
			model.addAttribute("info", "添加缴费信息成功！");
		} else {
			model.addAttribute("info", "添加缴费信息失败！");
		}

		return listStudentPayment(null, model);
	}
}


