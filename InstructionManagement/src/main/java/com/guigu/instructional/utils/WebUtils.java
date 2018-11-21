package com.guigu.instructional.utils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.guigu.instructional.po.DataDictionary;

/**
 * 此处定义一些常量参数
 */

public class WebUtils {

	// 定义公有方法完成数据封装
	public static Map<String, Integer> pack(List<DataDictionary> list) {
		Map<String, Integer> map = new LinkedHashMap<>();
		// 将编号作为value值存储，将具体名称作为key值存储
		for (int i = 0; i < list.size(); i++) {
			DataDictionary dd = list.get(i);
			map.put(dd.getDataContent(), dd.getDataId());
		}
		return map;
	}

	// 活动状态
	public static final Map<String, Integer> activeState = new LinkedHashMap<>();

	public static Map<String, Integer> getActivestate() {
		activeState.put("准备阶段", 0);
		activeState.put("开始阶段", 1);
		activeState.put("进行阶段", 2);
		activeState.put("活动结束", 3);
		return activeState;
	}

	// 活动类型
	public static final Map<String, Integer> activeType = new LinkedHashMap<>();

	public static Map<String, Integer> getActivetype() {
		activeType.put("现场交流", 0);
		activeType.put("专题讲座", 1);
		activeType.put("学科导读", 2);
		activeType.put("会议形式", 3);
		return activeType;
	}

	// 反应
	public static final Map<String, Integer> activeRefectEstimate = new LinkedHashMap<>();

	public static Map<String, Integer> getActiverefectestimate() {
		activeRefectEstimate.put("特差", 0);
		activeRefectEstimate.put("一般", 1);
		activeRefectEstimate.put("好", 2);
		activeRefectEstimate.put("很好", 3);
		activeRefectEstimate.put("非常好", 4);
		return activeRefectEstimate;
	}

	// 学员意向状态
	public static final Map<String, Integer> studentState = new LinkedHashMap<>();

	public static Map<String, Integer> getStudentState() {
		studentState.put("无意向", 0);
		studentState.put("意向低", 1);
		studentState.put("意向中", 2);
		studentState.put("意向高", 3);
		return studentState;
	}

	// 评价主题
	public static final Map<String, Integer> evaluationTitle = new LinkedHashMap();

	public static Map<String, Integer> getEvaluationTitle() {
		evaluationTitle.put("日常考勤", 0);
		evaluationTitle.put("学风记录", 1);
		evaluationTitle.put("学习状态", 2);
		evaluationTitle.put("模拟面试", 3);
		return evaluationTitle;
	}
}
