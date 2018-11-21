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
	<script type="text/javascript">
		function query(condition) {
			$("#keyword").attr("name", condition.value);
		}
	</script>

	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px;">
			<li><a href="#">系统管理</a></li>
			<li>教师管理</li>
		</ul>
	</div>
	<div class="row alert alert-info" style="margin: 0px; padding: 3px;">
		<form class="form-inline"
			action="${pageContext.request.contextPath }/classinfo/teacher/listStaffInfo.action ">

			<div class="col-sm-3">
				<select class="form-control  input-sm" onchange="query(this)"
					name="condition">
					<option value="">请选择</option>
					<option value="staffId">编号</option>
					<option value="staffName">姓名</option>
					<option value="staffMobilePhone">移动电话</option>
				</select>
			</div>

			<div class="col-sm-3">
				<input type="text" id="keyword" class="form-control input-sm" />
			</div>

			<input type="submit" class="btn btn-danger" value="查询" /> <a
				class="btn btn-success"
				href="${pageContext.request.contextPath }/view/classinfo/teacher/teacher_add.jsp">添加</a>
		</form>
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
			name="staffInfos" pagesize="10"
			requestURI="${pageContext.request.contextPath }/classinfo/teacher/listStaffInfo.action">
			<display:column property="staffId" title="教师编号"></display:column>
			<display:column property="staffName" title="教师姓名"
				href="${pageContext.request.contextPath }/classinfo/teacher/getStaffInfo.action"
				paramId="staffId" paramProperty="staffId"></display:column>
			<display:column property="staffSex" title="教师性别"></display:column>
			<display:column property="staffAge" title="教师年龄"></display:column>
			<display:column property="staffOfficePhone" title="电话号码"></display:column>
			<display:column property="staffQq" title="QQ"></display:column>
			<display:column property="staffEntryTime" title="入职时间"
				format="{0,date,yyyy年MM月dd日}"></display:column>
			<display:column
				href="${pageContext.request.contextPath }/classinfo/teacher/getStaffInfo.action"
				paramId="staffId" paramProperty="staffId" value="修改" title="修改"></display:column>
			<display:column
				href="${pageContext.request.contextPath }/classinfo/teacher/deleteStaffInfo.action"
				paramId="staffId" paramProperty="staffId" value="删除" title="删除"></display:column>
		</display:table>
	</div>
</body>
</html>
