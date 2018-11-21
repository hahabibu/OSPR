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
			<li>课程表</li>
		</ul>
	</div>

	<form class="form-inline"
		action="${pageContext.request.contextPath }/classinfo/syllabusinfo/listSyllabusinfo.action">
		<div class="row alert alert-info" style="margin: 0px; padding: 3px;">
			<div class="form-group">
				<label class="" for="activename">课程表名称：</label> <input type="text"
					class="form-control" name="syllabusName" id="activename"
					placeholder="请输入">
			</div>
			<input type=submit class="btn btn-danger" value="查询" /> <a
				class="btn btn-success"
				href="${pageContext.request.contextPath }/view/classinfo/syllabusinfo/syllabusinfo_add.jsp">添加课程表信息</a>
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
				name="listDisciplineinfo" pagesize="10"
				requestURI="${pageContext.request.contextPath }/classinfo/syllabusinfo/listSyllabusinfo.action">
				<display:column property="syllabusId" title="编号"></display:column>
				<display:column property="syllabusName" title="学科名称"
					href="${pageContext.request.contextPath }/classinfo/syllabusinfo/getSyllabusinfo.action"
					paramId="syllabusId" paramProperty="syllabusId"></display:column>
				<display:column property="syllabusYi" title="周一"></display:column>
				<display:column property="syllabusEr" title="周二"></display:column>
				<display:column property="syllabusSan" title="周三"></display:column>
				<display:column property="syllabusSi" title="周四"></display:column>
				<display:column property="syllabusWu" title="周五"></display:column>
				<display:column property="syllabusLiu" title="周六"></display:column>
				<display:column property="syllabusQi" title="周日"></display:column>
				<display:column
					href="${pageContext.request.contextPath }/classinfo/syllabusinfo/getSyllabusinfo.action"
					paramId="syllabusId" paramProperty="syllabusId" value="修改"
					title="修改"></display:column>
				<display:column
					href="${pageContext.request.contextPath }/classinfo/syllabusinfo/deleteSyllabusinfo.action"
					paramId="syllabusId" paramProperty="syllabusId" value="删除"
					title="删除"></display:column>
			</display:table>
		</div>
	</form>
</body>
</html>
