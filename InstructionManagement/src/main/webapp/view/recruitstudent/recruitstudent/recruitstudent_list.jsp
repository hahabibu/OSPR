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
<%@include file="/view/public/commons.jspf"%>
</head>
<script type="text/javascript">
	
</script>
<body>


	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px;">
			<li><a href="#">招生管理</a></li>
			<li>招生线索</li>
		</ul>
	</div>
	<form class="form-inline"
		action="${pageContext.request.contextPath }/recruitstudent/recruitstudent/listStudentInfo.action"
		method="post">
		<div class="row alert alert-info" style="margin: 0px; padding: 3px;">

			<div class="form-group">
				<label class="" for="activename">学员姓名：</label> <input type="text"
					class="form-control" id="activename" name="studentName"
					placeholder="请输入学员姓名">
			</div>

			<!-- 此处设置隐藏属性，添加学员类型为“意向学员” -->
			<input type="hidden" name="studentType" value="意向学员">

			<div class="form-group">
				<label class="" for="activename">学员意向：</label> <select
					name="studentState" class="form-control">
					<option value="-1">所有内容</option>
					<c:forEach var="studentState" items="${studentState_map }">
						<option value="${studentState.value }">${studentState.key }</option>
					</c:forEach>
				</select>
			</div>
			<input type="submit" class="btn btn-danger" value="查询" /> <a
				class="btn btn-success"
				href="${pageContext.request.contextPath }/recruitstudent/recruitstudent/addStudentInfoUI.action">添加学员</a>
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
				requestURI="${pageContext.request.contextPath}/recruitstudent/recruitstudent/list.action }">
				<display:column property="studentId" title="编号"></display:column>
				<display:column property="studentName" title="姓名"></display:column>
				<display:column property="studentSex" title="性别"></display:column>
				<display:column property="studentTellphone" title="手机号码"></display:column>
				<display:column property="studentEmail" title="电子邮件"></display:column>
				<display:column property="studentSchool" title="所在院校"></display:column>
				<display:column property="studentType" title="学员类型"></display:column>

				<display:column
					href="${pageContext.request.contextPath }/recruitstudent/recruitstudent/updateStudentInfoUI.action"
					paramId="studentId" paramProperty="studentId" value="修改" title="修改"></display:column>
				<display:column
					href="${pageContext.request.contextPath }/recruitstudent/recruitstudent/updateStudentType.action"
					paramId="studentId" paramProperty="studentId" title="领取学员"
					value="领取学员">
				</display:column>

				<display:column
					href="${pageContext.request.contextPath }/recruitstudent/recruitstudent/deleteStudentInfo.action"
					paramId="studentId" paramProperty="studentId" title="删除" value="删除">
				</display:column>
			</display:table>
		</div>
	</form>
</body>
</html>
