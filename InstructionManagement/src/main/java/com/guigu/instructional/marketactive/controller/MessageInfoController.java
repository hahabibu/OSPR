package com.guigu.instructional.marketactive.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.marketactive.service.MessageInfoService;
import com.guigu.instructional.marketactive.service.TemplateInfoService;
import com.guigu.instructional.po.MessageInfo;
import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.po.TemplateInfo;
import com.guigu.instructional.system.service.StaffInfoService;

/**
 * 短信管理相关控制层
 */

@Controller
@RequestMapping("/marketactive/messageinfo/")
public class MessageInfoController {

	@Resource(name = "messageInfoServiceImpl")
	private MessageInfoService messageInfoService;

	@Resource(name = "templateInfoServiceImpl")
	private TemplateInfoService templateInfoService;
	
	@Resource(name = "staffInfoServiceImpl")
	private StaffInfoService staffInfoService;

	// 添加短信内容之前需要将相关数据转发到指定界面
	@RequestMapping("addMessageInfoUI.action")
	public String addMessageInfoUI(MessageInfo messageInfo, Model model) {
		// 查找相关的短信模板内容(短信模板标识为1)
		TemplateInfo templateInfo = new TemplateInfo();
		templateInfo.setTemplateType("短信模板");
		List<TemplateInfo> templateInfo_list = templateInfoService.getTemplateInfoList(templateInfo);
		model.addAttribute("templateInfo_list", templateInfo_list);
		return "marketactive/messageinfo/messageinfo_send";
	}

	// 添加短信内容
	@RequestMapping("addMessageInfo.action")
	public String addMessageInfo(MessageInfo messageInfo, Model model) {
		// 处理人（发送方、发送时间、发送状态需要自行指定）
		messageInfo.setStaffId(1);// 此处默认是1（之后指定当前登录者为发送者）
		messageInfo.setMessageTime(new Date());
		// 此处1为已发送的内容
		messageInfo.setMessageState("1");
		boolean remark = messageInfoService.addMessageInfo(messageInfo);
		if (remark) {
			model.addAttribute("info", "短信记录添加成功！");
		} else {
			model.addAttribute("info", "电信记录添加失败！");
		}
		return listMessageInfo(null, model);
	}

	// 列出所有短信内容
	@RequestMapping("listMessageInfo.action")
	public String listMessageInfo(MessageInfo messageInfo, Model model) {
		List<MessageInfo> list = messageInfoService.getMessageInfoList(messageInfo);
		
		// 遍历查找每个发送者员工的姓名并设置
		for(int i=0;i<list.size();i++) {
			MessageInfo mi = list.get(i);
		 	StaffInfo si = staffInfoService.getStaffInfo(mi.getStaffId());
		 	mi.setStaffName(si.getStaffName());
		}
		
		model.addAttribute("list", list);
		return "marketactive/messageinfo/messageinfo_list";
	}

	// 查看某条短信内容
	@RequestMapping("showMessageInfo.action")
	public String showMessageInfo(Integer messageId1, Model model) {
		MessageInfo messageInfo = messageInfoService.getMessageInfo(messageId1);
		// 根据id查找当前发送人的员工名称
		StaffInfo staffInfo = staffInfoService.getStaffInfo(messageInfo.getStaffId());
		if(staffInfo!=null) {
			// 将发送者的名称传到指定页面
			model.addAttribute("staffName", staffInfo.getStaffName());
		}
		model.addAttribute("messageInfo", messageInfo);
		return "marketactive/messageinfo/messageinfo_show";
	}

	// 删除短信内容
	@RequestMapping("deleteMessageInfo.action")
	public String deleteMessageInfo(Integer messageId1, Model model) {
		boolean remark = messageInfoService.deleteMessageInfo(messageId1);
		if (remark) {
			model.addAttribute("info", "短信记录删除成功！");
		} else {
			model.addAttribute("info", "短信记录删除失败");
		}
		return listMessageInfo(null, model);
	}

}
