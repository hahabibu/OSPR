<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<!-- 引入相关的文件 -->
<%@include file="/view/public/commons.jspf"%>
</head>

<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px;">
			<li><a href="#">招生管理</a></li>
			<li>试听记录</li>
		</ul>
	</div>
	<form
		action="${pageContext.request.contextPath }/recruitstudent/auditioninfo/listAuditionInfo.action"
		method="post" class="form-inline">
		<div class="row alert alert-info" style="margin: 0px; padding: 3px;">

			<div class="form-group">
				<label class="" for="activename">学员姓名：</label> <input type="text"
					class="form-control" id="activename" name="studentName"
					placeholder="请输入学员姓名">
			</div>
			<div class="form-group">
				<label class="" for="activename">试听课程：</label> <input type="text"
					class="form-control" id="activename" name="auditionCourse"
					placeholder="请输入试听课程">
			</div>
			<input type="submit" class="btn btn-danger" value="查询" /> <a
				class="btn btn-success"
				href="${pageContext.request.contextPath }/recruitstudent/auditioninfo/addAuditionInfoUI.action">添加纪录</a>
		</div>
		<!-- 提示信息 -->
		<div align="center">
			<div class="alert alert-warning"
				style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
				<button type="button" class="close" data-dismiss="alert">
					<span aria-hidden="true">&times;</span>

				</button>
				<p align="center" style="color: red;">招生管理-${info}</p>
			</div>

		</div>

		<div class="row" style="padding: 15px; padding-top: 0px;">
			<display:table class="table  table-condensed table-striped"
				name="list" pagesize="10"
				requestURI="${pageContext.request.contextPath}/recruitstudent/auditioninfo/list.action }">
				<display:column property="auditionId" title="编号"></display:column>
				<display:column property="studentName" title="姓名"></display:column>
				<display:column property="auditionCourse" title="试听课程"></display:column>
				<display:column property="auditionTime"
					format="{0,date,yyyy年MM月dd日}" title="试听时间"></display:column>
				<display:column property="auditionAddr" title="试听地点"></display:column>

				<display:column
					href="${pageContext.request.contextPath }/recruitstudent/auditioninfo/updateAuditionInfoUI.action"
					paramId="auditionId" paramProperty="auditionId" value="修改" title="修改"></display:column>

				<display:column
					href="${pageContext.request.contextPath }/recruitstudent/auditioninfo/deleteAuditionInfo.action"
					paramId="auditionId" paramProperty="auditionId" title="删除" value="删除">
				</display:column>
			</display:table>
		</div>
	</form>
</body>
</html>
