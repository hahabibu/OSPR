package com.guigu.instructional.system.controller;
/**       
 * <p>project_name:GuiguManager</p>
 * <p>package_name:com.tmt.instructional.system.controller.AuthortyChangeController</p>
 * <p>description：</p>
 * <p>@author：童梦涛<p>   
 * <p> date:2018年8月20日上午12:41:38 </p>
 * <p>comments：    </p>
 * <p>@version  jdk1.9</p>
 * 
 * <p>Copyright (c) 2018, 493352276@qq.com All Rights Reserved. </p>    
 */

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.RoleInfo;
import com.guigu.instructional.system.service.RoleInfoService;

@Controller
@RequestMapping("/system/authortychange/")
public class AuthortyChangeController {

	@Resource(name = "roleInfoServiceImpl")
	private RoleInfoService roleInfoService;
	
	@RequestMapping("listAuthortyChange.action")
	public String listAuthortyChange(RoleInfo roleInfo,Model model) {
		List<RoleInfo> list = roleInfoService.getRoleInfoList(roleInfo);

		model.addAttribute("list", list);

		return "system/authortychange/authorty_changelist";
	}
	
	@RequestMapping("AuthortyChangeUI.action")
	public String AuthortyChangeUI() {
		
		return null;
	}
	 
	
}


