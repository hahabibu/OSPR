<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="../../../css/bootstrap.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="../../../js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="../../../js/bootstrap.min.js"></script>
</head>
<%@ include file="/view/public/commons.jspf"%>
<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px;">
			<li><a href="#">班级管理</a></li>
			<li>教室名称</li>
		</ul>
	</div>
	<form class="form-inline"
		action="${pageContext.request.contextPath }/classinfo/classroominfo/listClassroomInfo.action">
		<div class="row alert alert-info" style="margin: 0px; padding: 3px;">

			<div class="form-group">
				<label class="" for="activename">教室名称：</label> <input type="text"
					class="form-control" name="classroomName" id="activename"
					placeholder="请输入教室名称">
			</div>

			<input type="submit" class="btn btn-danger" value="查询" /> <a
				class="btn btn-success"
				href="${pageContext.request.contextPath }/view/classinfo/classroominfo/classroominfo_add.jsp">添加教室</a>

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
				name="listClassroomInfo" pagesize="10"
				requestURI="${pageContext.request.contextPath }/classinfo/classroominfo/listClassroomInfo.action">
				<display:column property="classroomId" title="教室编号"></display:column>
				<display:column property="classroomName" title="教室名称"
					href="${pageContext.request.contextPath }/classinfo/classroominfo/getClassroomInfo.action"
					paramId="classroomId" paramProperty="classroomId"></display:column>
				<display:column property="classroomMax" title="容纳人数"></display:column>
				<display:column property="classroomInfo" title="设备信息"></display:column>
				<display:column property="classroomRemark" title="备注"></display:column>
				<display:column
					href="${pageContext.request.contextPath }/classinfo/classroominfo/getClassroomInfo.action"
					paramId="classroomId" paramProperty="classroomId" value="修改"
					title="修改"></display:column>
				<display:column
					href="${pageContext.request.contextPath }/classinfo/classroominfo/deleteClassroomInfo.action"
					paramId="classroomId" paramProperty="classroomId" value="删除"
					title="删除"></display:column>
			</display:table>
		</div>
	</form>
</body>
</html>
