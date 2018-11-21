<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<!-- 引入相关的文件 -->
<%@ include file="/view/public/commons.jspf"%>
</head>

<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px;">
			<li><a href="#">学员管理</a></li>
			<li>学员评价</li>
		</ul>
	</div>
	<form
		action="${pageContext.request.contextPath }/student/evaluationinfo/listEvaluationInfo.action"
		method="post" class="form-inline">
		<div class="row alert alert-info" style="margin: 0px; padding: 3px;">

			<div class="form-group">
				<label class="" for="activename">主题：</label>
				<!-- <input type="text" class="form-control" id="activename" name="" placeholder="请输入主题"> -->
				<select name="evaluationTile">
					<option value="-1">所有内容</option>
					<c:forEach var="evaluationTitle" items="${ evaluationTitle_map}">
						<option value="${evaluationTitle.key }">${evaluationTitle.key }</option>
					</c:forEach>
				</select>
			</div>

			<input type="submit" class="btn btn-danger" value="查询" /> <a
				class="btn btn-success" href="${pageContext.request.contextPath }/student/evaluationinfo/addEvaluationInfoUI.action">添加评价</a>
		</div>
	
		<!-- 提示信息 -->
		<div align="center">
			<div class="alert alert-warning"
				style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
				<button type="button" class="close" data-dismiss="alert">
					<span aria-hidden="true">&times;</span>

				</button>
				<p align="center" style="color: red;">学员管理-${info}</p>
			</div>

		</div>
		
		<div class="row" style="padding: 15px; padding-top: 0px;">
			<display:table class="table  table-condensed table-striped"
				name="list" pagesize="10"
				requestURI="${pageContext.request.contextPath}/student/student/list.action }">
				<display:column property="evaluationId" title="编号"></display:column>
				<display:column property="studentName" title="姓名"></display:column>
				<display:column property="evaluationTile" title="主题"></display:column>
				<display:column property="evaluationContent" title="评价内容"></display:column>
				<display:column property="evaluationCourse" title="课程名称"></display:column>
				<display:column property="evaluationTeacher" title="教师"></display:column>

				<display:column
					href="${pageContext.request.contextPath }/student/evaluationinfo/updateEvaluationInfoUI.action"
					paramId="evaluationId" paramProperty="evaluationId" value="修改" title="修改"></display:column>

				<display:column
					href="${pageContext.request.contextPath }/student/evaluationinfo/deleteEvaluationInfo.action"
					paramId="evaluationId" paramProperty="evaluationId" title="删除" value="删除">
				</display:column>
			</display:table>
		</div>
	</form>
</body>
</html>
