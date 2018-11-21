package com.guigu.instructional.marketactive.controller;
/**       
 * 邮件管理相关
 */

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.marketactive.service.EmailInfoService;
import com.guigu.instructional.marketactive.service.TemplateInfoService;
import com.guigu.instructional.po.EmailInfo;
import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.po.TemplateInfo;
import com.guigu.instructional.system.service.StaffInfoService;

@Controller
@RequestMapping("/marketactive/emailinfo/")
public class EmailInfoController {

	@Resource(name = "emailInfoServiceImpl")
	private EmailInfoService emailInfoService;

	@Resource(name = "templateInfoServiceImpl")
	private TemplateInfoService templateInfoService;

	@Resource(name = "staffInfoServiceImpl")
	private StaffInfoService staffInfoService;

	// 添加数据前先转发相关数据到添加页面
	@RequestMapping("addEmailInfoUI.action")
	public String addEmailInfoUI(EmailInfo emailInfo, Model model) {
		// 获取相关的邮件模板（邮件模板标识为2）
		TemplateInfo templateInfo = new TemplateInfo();
		templateInfo.setTemplateType("邮件模板");
		List<TemplateInfo> templateInfo_list = templateInfoService.getTemplateInfoList(templateInfo);
		model.addAttribute("templateInfo_list", templateInfo_list);
		// 转发数据到指定的添加页面
		return "marketactive/emailinfo/emailinfo_send";
	}

	// 添加数据
	@RequestMapping("addEmailInfo.action")
	public String addEmailInfo(EmailInfo emailInfo, Model model, HttpServletRequest request) {
		// 通过传入的数据判断是发送还是保存操作
		String type = request.getParameter("type");
		// 处理人（发送方、发送时间、发送状态需要自行指定）
		emailInfo.setStaffId(1);// 此处默认是1（之后指定当前登录者为发送者）
		emailInfo.setEmailTime(new Date());
		/**
		 * 此处限制：需要判断当前传入邮箱编号是否为null，如果为null则说明邮件信息不存在
		 * 需要添加数据，如果传入编号不为null，则说明邮件已存在，是经过修改后提交的数据 则执行修改操作即可
		 */
		boolean remark = false;
		if (emailInfo.getEmailId() == null) {
			if (type.equals("1")) {
				// 发送操作
				emailInfo.setEmailState("1");
				model.addAttribute("info", "邮件信息已发送成功！");
			} else if (type.equals("0")) {
				// 保存到指定邮箱操作
				emailInfo.setEmailState("0");
				model.addAttribute("info", "邮件信息已存至草稿箱！");
			}
			remark = emailInfoService.addEmailInfo(emailInfo);
		} else {
			// 修改数据
			emailInfo.setEmailState("1");
			remark = emailInfoService.updateEmailInfo(emailInfo);
		}

		// 判断是否操作成功
		if (!remark) {
			model.addAttribute("info", "操作失败！");
		}
		return listEmailInfo(null, model);
	}

	@RequestMapping("updateEmailInfoUI.action")
	public String updateEmailInfoUI(Integer emailId, Model model) {
		// 根据id查找指定的邮件数据，转发数据到添加页面
		EmailInfo emailInfo = emailInfoService.getEmailInfo(emailId);
		if (emailInfo != null) {
			model.addAttribute("emailInfo", emailInfo);
		}
		// 获取相关的邮件模板（邮件模板标识为2）
		TemplateInfo templateInfo = new TemplateInfo();
		templateInfo.setTemplateType("2");
		List<TemplateInfo> templateInfo_list = templateInfoService.getTemplateInfoList(templateInfo);
		model.addAttribute("templateInfo_list", templateInfo_list);
		// 转发数据到指定的添加页面
		return "marketactive/emailinfo/emailinfo_send";
	}

	// 获取当前所有的邮件信息
	@RequestMapping("listEmailInfo.action")
	public String listEmailInfo(EmailInfo emailInfo, Model model) {
		List<EmailInfo> list = emailInfoService.getEmailInfoList(emailInfo);
		// 遍历查找每个发送者员工的姓名并设置
		for (int i = 0; i < list.size(); i++) {
			EmailInfo ei = list.get(i);
			StaffInfo si = staffInfoService.getStaffInfo(ei.getStaffId());
			ei.setStaffName(si.getStaffName());
		}
		model.addAttribute("list", list);
		return "marketactive/emailinfo/emailinfo_list";
	}

	// 删除邮件信息
	@RequestMapping("deleteEmailInfo.action")
	public String deleteEmailInfo(Integer emailId, Model model) {
		boolean remark = emailInfoService.deleteEmailInfo(emailId);
		if (remark) {
			model.addAttribute("info", "邮件信息删除成功");
		} else {
			model.addAttribute("info", "邮件信息删除失败");
		}
		return listEmailInfo(null, model);
	}

	// 根据邮件编号显示邮件信息
	@RequestMapping("showEmailInfo.action")
	public String showEmailInfo(Integer emailId, Model model) {
		EmailInfo emailInfo = emailInfoService.getEmailInfo(emailId);
		// 根据发送人id查找发送者姓名，随后将数据转发到指定页的页面显示
		StaffInfo staffInfo = staffInfoService.getStaffInfo(emailInfo.getStaffId());
		if (staffInfo != null) {
			model.addAttribute("staffName", staffInfo.getStaffName());
		}
		model.addAttribute("emailInfo", emailInfo);
		return "marketactive/emailinfo/emailinfo_show";
	}
}
