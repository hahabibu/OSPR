package com.guigu.instructional.system.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.DataDictionary;
import com.guigu.instructional.system.service.DataDictionaryService;

@Controller
@RequestMapping("/system/datadictionary/")
public class DataDictionaryController {

	@Resource(name = "dataDictionaryServiceImpl")
	private DataDictionaryService dataDictionaryService;
	// 添加数据字典
	@RequestMapping("addDataDictionary.action")
	public String addDataDictionary(DataDictionary dataDictionary, Model model) {

		boolean remark = dataDictionaryService.addDataDictionary(dataDictionary);

		if (remark) {
			model.addAttribute("info", "添加数据字典成功!");
		} else {
			model.addAttribute("info", "数据字典添加失败!");
		}
		// 添加完成后跳转到列表页面即可
		return listDataDictionary(null, model);
	}
	//列出所有的数据字典
	@RequestMapping("listDataDictionary.action")
	public String listDataDictionary(DataDictionary dataDictionary, Model model) {
		List<DataDictionary> list = dataDictionaryService.getDataDictionaryList(dataDictionary);
		List<String> dataType_list = new ArrayList<>(); 
		// 获取当前数据字典的所有类型并传递数据
		for(int i=0;i<list.size();i++) {
			String type = list.get(i).getDataType();
			if(!dataType_list.contains(type)) {
				dataType_list.add(type);
			}
		}
		model.addAttribute("dataType_list", dataType_list);
		model.addAttribute("list", list);
		return "system/datadictionary/datadictionary_list";
	}

	// 获取指定的数据字典信息进行数据回显并跳转到修改页面
	@RequestMapping("updateDataDictionaryUI.action")
	public String updateDataDictionaryUI(Integer dataId,Model model) {
		
		DataDictionary dataDictionary=dataDictionaryService.getDataDictionary(dataId);
		model.addAttribute("dataDictionary",dataDictionary);
		
		return "system/datadictionary/datadictionary_update";
		
	}
	// 更新操作
	@RequestMapping("updateDataDictionary.action")
	public String updateDataDictionary(DataDictionary dataDictionary,Model model) {
		
		boolean remark=dataDictionaryService.updateDataDictionary(dataDictionary);
		if(remark) {
			model.addAttribute("info", "修改数据字典成功！");
		}else {
			model.addAttribute("info", "修改数据字典失败！");
		}
		return listDataDictionary(null,model);
		
	}
	// 删除数据字典内容
	@RequestMapping("deleteDataDictionary.action")
	public String deleteDataDictionary(Integer dataId,Model model) {
		
		boolean remark=dataDictionaryService.deleteDataDictionary(dataId);
		if(remark) {
			model.addAttribute("info", "删除数据字典成功！");
		}else {
			model.addAttribute("info", "删除数据字典失败！");
		}
		return listDataDictionary(null,model);
	}
}
