package com.guigu.instructional.student.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.DataDictionary;
import com.guigu.instructional.po.EvaluationInfo;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.recruitstudent.service.StudentInfoService;
import com.guigu.instructional.student.service.EvaluationInfoService;
import com.guigu.instructional.system.service.DataDictionaryService;
import com.guigu.instructional.utils.WebUtils;

/**       
 * 学员评价相关
 */

@Controller
@RequestMapping("/student/evaluationinfo/")
public class EvaluationInfoController {
	
	@Resource(name="evaluationInfoServiceImpl")
	private EvaluationInfoService evaluationInfoService;
	
	@Resource(name="studentInfoServiceImpl")
	private StudentInfoService studentInfoService;
	
	// 定义相关的数据
	@Resource(name = "dataDictionaryServiceImpl")
	private DataDictionaryService dataDictionaryService ;

	Map<String, Integer> evaluationTitle_map = new LinkedHashMap<>();
	
	public void pack() {
		// 根据需求查找数据并通过WebUtils进行封装
		DataDictionary dd = new DataDictionary();
		dd.setDataType("学员评价主题类型");
		List<DataDictionary>  evaluationTitle_list = dataDictionaryService.getDataDictionaryList(dd);
		evaluationTitle_map = WebUtils.pack(evaluationTitle_list);
	}
	
	@RequestMapping("addEvaluationInfoUI.action")
	public String addEvaluationInfoUI(Model model) {
		// 转发相关的数据
		pack(); // 封装数据
		model.addAttribute("evaluationTitle_map", evaluationTitle_map);
		
		return "student/evaluationinfo/evaluationinfo_add";
	}
	
	@RequestMapping("addEvaluationInfo.action")
	public String addEvaluationInfo(EvaluationInfo evaluationInfo,Model model) {
		boolean remark = evaluationInfoService.addEvaluationInfo(evaluationInfo);
		if(remark) {
			model.addAttribute("info", "学员评价记录添加成功!");
		}else {
			model.addAttribute("info", "学员评价记录添加失败");
		}
		return listEvaluationInfo(null,model);
	}
	
	@RequestMapping("listEvaluationInfo.action")
	public String listEvaluationInfo(EvaluationInfo evaluationInfo,Model model) {
		List<EvaluationInfo> list = evaluationInfoService.getEvaluationInfoList(evaluationInfo);
		
		// 根据学生id依次遍历查找学生对应的姓名属性，并将其设置到指定的位置
		for(int i=0;i<list.size();i++) {
			EvaluationInfo ei = list.get(i);
			if(ei.getStudentId()!=null) {
				StudentInfo si = studentInfoService.getStudentInfo(ei.getStudentId());
				ei.setStudentName(si.getStudentName());
			}
		}
		pack(); // 封装数据
		model.addAttribute("evaluationTitle_map", evaluationTitle_map);
		model.addAttribute("list", list);
		return "student/evaluationinfo/evaluationinfo_list";
	}
	
	@RequestMapping("updateEvaluationInfoUI.action")
	public String updateEvaluationInfoUI(Integer evaluationId,Model model) {
		// 根据id查找评价记录，转发数据回显数据
		EvaluationInfo evaluationInfo = evaluationInfoService.getEvaluationInfo(evaluationId);
		if(evaluationInfo!=null) {
			model.addAttribute("evaluationInfo", evaluationInfo);
		}
		pack(); // 封装数据
		model.addAttribute("evaluationTitle_map", evaluationTitle_map);
		return "student/evaluationinfo/evaluationinfo_update";
	}
	
	@RequestMapping("updateEvaluationInfo.action")
	public String updateEvaluationInfo(EvaluationInfo evaluationInfo,Model model) {
		boolean remark = evaluationInfoService.updateEvaluationInfo(evaluationInfo);
		if(remark) {
			model.addAttribute("info", "学员评价记录修改成功!");
		}else {
			model.addAttribute("info", "学员评价记录修改失败");
		}
		return listEvaluationInfo(null, model);
	}
	
	@RequestMapping("deleteEvaluationInfo.action")
	public String deleteEvaluationInfo(Integer evaluationId,Model model) {
		boolean remark = evaluationInfoService.deleteEvaluationInfo(evaluationId);
		if(remark) {
			model.addAttribute("info", "学员评价记录删除成功!");
		}else {
			model.addAttribute("info", "学员评价记录删除失败");
		}
		return listEvaluationInfo(null, model);
	}
	
}


