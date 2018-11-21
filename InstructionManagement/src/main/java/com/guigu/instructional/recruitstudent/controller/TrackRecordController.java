package com.guigu.instructional.recruitstudent.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.instructional.po.DataDictionary;
import com.guigu.instructional.po.StudentInfo;
import com.guigu.instructional.po.TrackRecordInfo;
import com.guigu.instructional.recruitstudent.service.StudentInfoService;
import com.guigu.instructional.recruitstudent.service.TrackRecordService;
import com.guigu.instructional.system.service.DataDictionaryService;
import com.guigu.instructional.utils.WebUtils;

/**
 * 跟踪记录相关
 */

@Controller
@RequestMapping("/recruitstudent/trackrecord/")
public class TrackRecordController {

	@Resource(name = "trackRecordServiceImpl")
	private TrackRecordService trackRecordService;

	@Resource(name = "studentInfoServiceImpl")
	private StudentInfoService studentInfoService;
	
	@Resource(name = "dataDictionaryServiceImpl")
	private DataDictionaryService dataDictionaryService ;

	Map<String, Integer> studentState_map = new LinkedHashMap<>();
	
	public void pack() {
		// 根据需求查找数据并通过WebUtils进行封装
		DataDictionary dd = new DataDictionary();
		dd.setDataType("意向状态类型");
		List<DataDictionary>  studentState_list = dataDictionaryService.getDataDictionaryList(dd);
		studentState_map = WebUtils.pack(studentState_list);
	}

	// 添加跟踪记录前需要将所有意向学生信息传入
	@RequestMapping("addTrackRecordInfoUI.action")
	public String addTrackRecordInfoUI(TrackRecordInfo trackRecordInfo, Model model) {
		// 查找所有意向学生信息
		// 创建查找条件
		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setStudentType("意向学员");
		List<StudentInfo> student_list = studentInfoService.getStudentInfoList(studentInfo);
		model.addAttribute("student_list", student_list);
		return "recruitstudent/trackrecord/trackrecord_add";
	}

	// 添加跟踪记录
	@RequestMapping("addTrackRecordInfo.action")
	public String addTrackRecordInfo(TrackRecordInfo trackRecordInfo, Model model) {
		boolean remark = trackRecordService.addTrackRecordInfo(trackRecordInfo);
		if (remark) {
			model.addAttribute("info", "跟踪记录添加成功！");
		} else {
			model.addAttribute("info", "跟踪记录添加失败！");
		}
		return listTrackRecordInfo(null, model);
	}

	// 列出所有跟踪记录
	@RequestMapping("listTrackRecordInfo.action")
	public String listTrackRecordInfo(StudentInfo studentInfo, Model model) {
		List<TrackRecordInfo> list = trackRecordService.getTrackRecordInfoList(studentInfo);
		// 根据对应学员的意向设置相关属性
		for(int i=0;i<list.size();i++) {
			TrackRecordInfo tri = list.get(i);
			StudentInfo si = studentInfoService.getStudentInfo(tri.getStudentId());
			tri.setEnrollment(si.getStudentState());
			// 设置学员姓名
			tri.setStudentName(si.getStudentName());
			// 设置意向状态描述
			DataDictionary dd = dataDictionaryService.getDataDictionary(tri.getEnrollment());
			tri.setEnrollmentDescr(dd.getDataContent());
		}
		
		model.addAttribute("list", list);
		pack(); // 封装数据
		model.addAttribute("studentState_map", studentState_map);
		return "recruitstudent/trackrecord/trackrecord_list";
	}

	// 修改跟踪记录进行数据回显
	@RequestMapping("updateTrackRecordInfoUI.action")
	public String updateTrackRecordInfoUI(Integer trackRecordId, Model model) {
		TrackRecordInfo trackRecordInfo = trackRecordService.getTrackRecordInfo(trackRecordId);
		model.addAttribute("trackRecordInfo", trackRecordInfo);

		// 创建查找条件,查找所有意向学生信息
		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setStudentType("意向学员");
		List<StudentInfo> student_list = studentInfoService.getStudentInfoList(studentInfo);
		model.addAttribute("student_list", student_list);
		
		return "recruitstudent/trackrecord/trackrecord_update";
	}

	// 修改跟踪记录
	@RequestMapping("updateTrackRecordInfo.action")
	public String updateTrackRecordInfo(TrackRecordInfo trackRecordInfo, Model model) {
		boolean remark = trackRecordService.updateTrackRecordInfo(trackRecordInfo);
		if (remark) {
			model.addAttribute("info", "跟踪记录修改成功！");
		} else {
			model.addAttribute("info", "跟踪记录修改失败！");
		}
		return listTrackRecordInfo(null, model);
	}

	// 删除跟踪记录
	@RequestMapping("deleteTrackRecordInfo.action")
	public String deleteTrackRecordInfo(Integer trackRecordId, Model model) {
		System.out.println("shachuhcuhcuhcuch"+trackRecordId);
		boolean remark = trackRecordService.deleteTrackRecordInfo(trackRecordId);
		if (remark) {
			model.addAttribute("info", "跟踪记录删除成功！");
		} else {
			model.addAttribute("info", "跟踪记录修改失败！");
		}
		return listTrackRecordInfo(null, model);
	}


}
