<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>

</head>
<%@ include file="/view/public/commons.jspf"%>
<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px;">
			<li><a href="#">班级管理</a></li>
			<li>班级信息</li>
		</ul>
	</div>
	<form class="form-inline"
		action="${pageContext.request.contextPath }/classinfo/classinfo/listClassInfo.action">
		<div class="row alert alert-info" style="margin: 0px; padding: 3px;">

			<div class="form-group">
				<label class="" for="activename">班级名称：</label> <input type="text"
					class="form-control" id="activename" name="className"
					placeholder="请输入班级名称">
			</div>

			<input type="submit" class="btn btn-danger" value="查询" /> <a
				class="btn btn-success"
				href="${pageContext.request.contextPath }/classinfo/classinfo/SelectStaff.action">添加班级</a>

		</div>

		<!-- 提示信息 -->
		<div align="center">
			<div class="alert alert-warning"
				style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
				<button type="button" class="close" data-dismiss="alert">
					<span aria-hidden="true">&times;</span>

				</button>
				<p align="center" style="color: red;">班级管理-${info}</p>
			</div>
		</div>

		<div class="row" style="padding: 15px; padding-top: 0px" align="right">
			<table class="table table-condensed table-striped"></table>
			<display:table class="table table-condensed table-striped"
				name="listClassinfo" pagesize="10"
				requestURI="${pageContext.request.contextPath }/classinfo/classinfo/listClassInfo.action">
				<display:column property="classId" title="编号"></display:column>
				<display:column property="className" title="班级名称"
					href="${pageContext.request.contextPath }/classinfo/classinfo/listStudentInfo.action"
					paramId="classId" paramProperty="classId"></display:column>
				<display:column property="classNumber" title="班级人数"></display:column>
				<display:column property="classStartTime" title="开始时间"
					format="{0,date,yyyy年MM月dd日}"></display:column>
				<display:column property="classEndTime" title="结束时间"
					format="{0,date,yyyy年MM月dd日}"></display:column>
				<display:column
					href="${pageContext.request.contextPath }/classinfo/classinfo/getClassInfo.action"
					paramId="classId" paramProperty="classId" value="修改" title="修改"></display:column>
				<display:column
					href="${pageContext.request.contextPath }/classinfo/classinfo/deleteClassInfo.action"
					paramId="classId" paramProperty="classId" value="删除" title="删除"></display:column>
			</display:table>
		</div>
	</form>
</body>
</html>
