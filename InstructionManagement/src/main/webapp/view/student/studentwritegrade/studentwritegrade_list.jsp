<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net/el" prefix="display"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<%@ include file="/view/public/commons.jspf"%>
</head>

<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px;">
			<li><a href="#">学员管理</a></li>
			<li>学生成绩</li>
		</ul>
	</div>
	<script type="text/javascript">
		function query(condition) {
			$("#keyword").attr("name", condition.value);
		}
	</script>
	<form class="form-inline"
		action="${pageContext.request.contextPath }/student/studentwritegrade/listStudentWriteGrade.action"
		method="post">
		<div class="row alert alert-info" style="margin: 0px; padding: 3px;">
			<div class="col-sm-3">
				<select class="form-control  input-sm" onchange="query(this)"
					name="condition">
					<option value="">请选择</option>
					<option value="studentName">学员姓名</option>
				</select>
			</div>
			<div class="col-sm-3">
				<input type="text" id="keyword" class="form-control input-sm" />
			</div>
			<input type="submit" class="btn btn-danger" value="查询" /> <input
				type="button" class="btn btn-success" value="添加"
				onClick="javascript:window.location='${pageContext.request.contextPath}/student/studentwritegrade/addStudentWriteGradeUI.action'" />
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

	</form>
	<div class="row" style="padding: 15px; padding-top: 0px;">
		<display:table class="table table-condensed table-striped" name="list"
			pagesize="10"
			requestURI="${pageContext.request.contextPath }/student/studentwritegrade/listCommunicateInfo.action">
			<display:column property="writeGradeId" title="编号"></display:column>
			<display:column property="studentName" title="学员姓名"></display:column>
			<display:column property="staffName" title="负责人"></display:column>
			<display:column property="writeGradeSubject" title="科目"></display:column>
			<display:column property="writeGrade" title="成绩"></display:column>
			<display:column
				href="${pageContext.request.contextPath }/student/studentwritegrade/updateStudentWriteGradeUI.action"
				paramId="writeGradeId" paramProperty="writeGradeId" value="修改"
				title="修改"></display:column>
			<display:column
				href="${pageContext.request.contextPath }/student/studentwritegrade/deleteStudentWriteGrade.action"
				paramId="writeGradeId" paramProperty="writeGradeId" value="删除"
				title="删除"></display:column>
		</display:table>
	</div>
</body>
</html>