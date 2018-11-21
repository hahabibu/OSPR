package com.guigu.instructional.marketactive.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.marketactive.service.MarketActiveService;
import com.guigu.instructional.po.DataDictionary;
import com.guigu.instructional.po.MarketActive;
import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.system.service.DataDictionaryService;
import com.guigu.instructional.system.service.StaffInfoService;
import com.guigu.instructional.utils.WebUtils;

/**
 * 营销活动相关
 */

@Controller
@RequestMapping("/marketactive/marketactive/")
public class MarketActiveController {

	@Resource(name = "marketActiveServiceImpl")
	private MarketActiveService marketActiveService;

	@Resource(name = "staffInfoServiceImpl")
	private StaffInfoService staffInfoService;
	
	@Resource(name = "dataDictionaryServiceImpl")
	private DataDictionaryService dataDictionaryService ;

	// 相关数据
//	private Map<String, Integer> activeState_map = WebUtils.getActivestate();
//	private Map<String, Integer> activeType_map = WebUtils.getActivetype();
//	private Map<String, Integer> activeRefectEstimate_map =  WebUtils.getActiverefectestimate();
	private Map<String, Integer> activeState_map = new LinkedHashMap<>();
	private Map<String, Integer> activeType_map = new LinkedHashMap<>();
	private Map<String, Integer> activeRefectEstimate_map =  new LinkedHashMap<>();
	
	public void pack() {
		// 根据需求查找数据并通过WebUtils进行封装
		DataDictionary dd = new DataDictionary();
		dd.setDataType("活动状态类型");
		List<DataDictionary>  activeState_list = dataDictionaryService.getDataDictionaryList(dd);
		activeState_map = WebUtils.pack(activeState_list);
		
		dd.setDataType("活动类型");
		List<DataDictionary>  activeType_list = dataDictionaryService.getDataDictionaryList(dd);
		activeType_map = WebUtils.pack(activeType_list);
		
		dd.setDataType("反应类型");
		List<DataDictionary>  activeRefectEstimate_list = dataDictionaryService.getDataDictionaryList(dd);
		activeRefectEstimate_map = WebUtils.pack(activeRefectEstimate_list);
	}

	// 添加数据前需转发封装数据
	@RequestMapping("addMarketActiveUI.action")
	public String addMarketActiveUI(Model model) {
		// 将涉及到的相关数据转发到添加页面
		pack();// 封装数据
		model.addAttribute("activeState_map", activeState_map);
		model.addAttribute("activeType_map", activeType_map);
		model.addAttribute("activeRefectEstimate_map", activeRefectEstimate_map);

		return "marketactive/marketactive/marketactive_add";
	}

	// 添加数据
	@RequestMapping("addMarketActive.action")
	public String addMarketActive(MarketActive marketActive, Model model) {
		// 此处设置处理该活动的员工id为1
		marketActive.setStaffId(1);

		boolean remark = marketActiveService.addMarketActive(marketActive);
		if (remark) {
			model.addAttribute("info", "活动添加成功！");
		} else {
			model.addAttribute("info", "活动添加失败!");
		}

		return listMarketActive(null, model);

	}

	// 列出活动列表
	@RequestMapping("listMarketActive.action")
	public String listMarketActive(MarketActive marketActive, Model model) {
		List<MarketActive> list = marketActiveService.getMarketActiveList(marketActive);

		pack();// 封装数据
		model.addAttribute("activeState_map", activeState_map);
		model.addAttribute("list", list);
		
		// 遍历查找每个发送者员工的姓名并设置
		for (int i = 0; i < list.size(); i++) {
			MarketActive ma = list.get(i);
			StaffInfo si = staffInfoService.getStaffInfo(ma.getStaffId());
			ma.setStaffName(si.getStaffName());
		}

		return "marketactive/marketactive/marketactive_list";
	}

	// 修改活动信息之前先进行数据回显
	@RequestMapping("updateMarketActiveUI.action")
	public String updateMarketActiveUI(Integer activeId, Model model) {
		// 根据活动编号获取活动信息
		MarketActive marketActive = marketActiveService.getMarketActive(activeId);
		model.addAttribute("marketActive", marketActive);
		// 将相关的数据也进行转发
		pack();// 封装数据
		model.addAttribute("activeState_map", activeState_map);
		model.addAttribute("activeType_map", activeType_map);
		model.addAttribute("activeRefectEstimate_map", activeRefectEstimate_map);

		return "marketactive/marketactive/marketactive_update";
	}

	// 修改活动信息
	@RequestMapping("updateMarketActive.action")
	public String updateMarketActive(MarketActive marketActive, Model model) {
		boolean remark = marketActiveService.updateMarketActive(marketActive);
		if (remark) {
			model.addAttribute("info", "活动信息修改成功");
		} else {
			model.addAttribute("info", "活动信息修改失败");
		}
		return listMarketActive(null, model);
	}

	@RequestMapping("deleteMarketActive.action")
	public String deleteMarketActive(Integer activeId, Model model) {
		boolean remark = marketActiveService.deleteMarketActive(activeId);
		if (remark) {
			model.addAttribute("info", "活动信息删除成功");
		} else {
			model.addAttribute("info", "活动信息删除失败");
		}
		return listMarketActive(null, model);
	}

}
