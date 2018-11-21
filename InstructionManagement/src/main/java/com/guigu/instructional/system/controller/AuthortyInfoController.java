package com.guigu.instructional.system.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.type.IntegerTypeHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.AuthortyInfo;
import com.guigu.instructional.system.service.AuthortyInfoService;
import com.guigu.instructional.system.service.RoleInfoService;
import com.guigu.instructional.system.service.StaffInfoService;

/**
 * <p>
 * project_name:GuiguManager
 * </p>
 * <p>
 * package_name:listAnthorty.AuthortyInfoController
 * </p>
 * <p>
 * description：
 * </p>
 * <p>
 * 
 * @author：童梦涛
 *             <p>
 *             <p>
 *             date:2018年8月17日上午11:25:22
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
@RequestMapping("/system/authorty/")
public class AuthortyInfoController {

	@Resource(name = "authortyInfoServiceImpl")
	private AuthortyInfoService authortyInfoService;

	@Resource(name = "staffInfoServiceImpl")
	private StaffInfoService staffInfoService;

	@Resource(name = "roleInfoServiceImpl")
	private RoleInfoService roleInfoService;

	// 查看权限信息，此处进行数据回显
	@RequestMapping("getAuthortyInfo.action")
	public String getAuthortyInfo(Model model) {

		return "system/authorty/authorty_add";
	}

	// 查看权限信息（可以进行修改操作）

	// 添加子级权限信息(数据回显部分)
	@RequestMapping("addAuthortyInfoUI.action")
	public String addAuthortyInfoUI(Integer authortyId, Model model) {
		// 根据权限id获取相应的权限信息，进行数据回显
		AuthortyInfo pAuthortyInfo = authortyInfoService.getAuthortyInfo(authortyId);

		// 将查找到的数据转发到相应的jsp页面
		model.addAttribute("authortyInfo", pAuthortyInfo);

		return "system/authorty/authorty_add";
	}

	// 添加子级权限信息
	@RequestMapping("addAuthortyInfo.action")
	public String addAuthortyInfo(AuthortyInfo authortyInfo, Model model) {
		boolean remark = authortyInfoService.addAuthortyInfo(authortyInfo);
		if (remark) {
			model.addAttribute("info", "权限信息已成功添加");
		} else {
			model.addAttribute("info", "权限信息添加失败");
		}
		return listAuthortyInfo(null, model);
	}

	// 修改权限信息（进行数据回显）
	@RequestMapping("updateAuthortyInfoUI.action")
	public String updateAuthortyInfoUI(Integer authortyId, Model model) {
		// 根据权限id获取相应的权限信息，进行数据回显
		AuthortyInfo authortyInfo = authortyInfoService.getAuthortyInfo(authortyId);
		// 根据当前等级编号查找父级等级对应的数据（权限）
		Integer cClass = authortyInfo.getAuthortyClass();
		Integer pClass = 0; // 默认是根目录
		if (cClass != 0) {
			pClass = cClass - 1;
		}
		// 将数据进行封装随后进行查找
		AuthortyInfo pai = new AuthortyInfo();
		pai.setAuthortyClass(pClass);
		List<AuthortyInfo> pai_list = authortyInfoService.getAuthotryInfoList(pai);

		// 将查找到的数据转发到相应的jsp页面
		model.addAttribute("pai_list", pai_list);
		model.addAttribute("authortyInfo", authortyInfo);

		return "system/authorty/authorty_update";
	}

	// 修改权限信息
	@RequestMapping("updateAuthortyInfo.action")
	public String updateAuthortyInfo(AuthortyInfo authortyInfo, Model model) {
		boolean remark = authortyInfoService.updateAuthortyInfo(authortyInfo);
		if (remark) {
			model.addAttribute("info", "权限信息已成功修改");
		} else {
			model.addAttribute("info", "权限信息修改失败");
		}

		return listAuthortyInfo(null, model);
	}

	// 返回所有的权限信息
	@RequestMapping("listAuthortyInfo.action")
	public String listAuthortyInfo(AuthortyInfo authortyInfo, Model model) {
		List<AuthortyInfo> all_list = authortyInfoService.getAuthotryInfoList(authortyInfo);
		List<AuthortyInfo> list = new ArrayList<>();
		// 根据当前获取的权限进行遍历，填充上级权限名称
		for (int i = 0; i < all_list.size(); i++) {
			for (int j = 0; j < all_list.size(); j++) {
				// 子节点的上级id==父节点的编号id作为等价条件
				AuthortyInfo pai = all_list.get(i);
				AuthortyInfo cai = all_list.get(j);
				if (pai.getAuthortyId() == cai.getAuthortyPid()) {
					cai.setAuthortyPName(pai.getAuthortyName());
				}
			}
		}
		// 排除掉等级编号为-1的内容
		for (int i = 0; i < all_list.size(); i++) {
			if (all_list.get(i).getAuthortyId() != -1) {
				list.add(all_list.get(i));
			}
		}
		// 将当前所有权限进行显示
		model.addAttribute("list", list);

		return "system/authorty/authorty_show";
	}

	// 删除指定的权限信息
	// 修改权限信息（进行数据回显）
	@RequestMapping("deleteAuthortyInfo.action")
	public String deleteAuthortyInfo(Integer authortyId, Model model) {
		boolean remark = authortyInfoService.deleteAuthortyInfo(authortyId);
		if (remark) {
			model.addAttribute("info", "权限信息已成功删除");
		} else {
			model.addAttribute("info", "权限信息删除失败");
		}
		return listAuthortyInfo(null, model);
	}
}
