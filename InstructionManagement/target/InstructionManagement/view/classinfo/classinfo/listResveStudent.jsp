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

<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px;">
			<li><a href="#">班级管理</a></li>
			<li><a href="#">班级信息</a></li>
			<li>学员信息</li>
		</ul>
	</div>
	<form
		action="${pageContext.request.contextPath }/student/student/listStudentInfo.action"
		method="post" class="form-inline">
		<div class="row alert alert-info" style="margin: 0px; padding: 3px;">

			<div class="form-group">
				<label class="" for="activename">学员姓名：</label> <input type="text"
					class="form-control" id="activename" name="studentName"
					placeholder="请输入学员姓名">
			</div>

			<!-- 此处设置隐藏属性，添加学员类型为“正式学员” -->
			<input type="hidden" name="studentType" value="正式学员">
			<!-- 此处设置隐藏属性，添加班级id为当前的班级id -->
			<input type="hidden" name="classId" value="${classId }"> <input
				type="submit" class="btn btn-danger" value="查询" />
		</div>
	</form>


	<form action="${pageContext.request.contextPath }/classinfo/classinfo/addStudent.action"
		method="post" >
		<!-- 此处设置隐藏属性，添加班级id为当前的班级id -->
		<input type="hidden" name="classId" value="${classId }">
		<input type="hidden" id="studentId" name="studentId" >
		<div>
			<table class="table  table-condensed table-striped">
				<tr>
					<th>编号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>手机号码</th>
					<th>电子邮件</th>
					<th>所在院校</th>
					<th>学员类型</th>
					<th>操作</th>
				</tr>
				<c:forEach var="student" items="${list }">
					<tr>
						<td>${student.studentId }</td>
						<td>${student.studentName }</td>
						<td>${student.studentSex }</td>
						<td>${student.studentTellphone }</td>
						<td>${student.studentEmail }</td>
						<td>${student.studentSchool }</td>
						<td>${student.studentType }</td>
						<td><input type="submit" onclick="insertData(${student.studentId });" value="加入班级" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</form>
	<script type="text/javascript">
		function insertData(studentId) {
			$("#studentId").attr("value",studentId);
			alert('正在将该学生加入您的班级......');
		}
	</script>
</body>
</html>
	<%-- <div class="row" style="padding: 15px; padding-top: 0px;">
			<display:table class="table  table-condensed table-striped"
				name="list" pagesize="10"
				requestURI="${pageContext.request.contextPath}/classinfo/classinfo/list.action }">
				<display:column property="studentId" title="编号"></display:column>
				<display:column property="studentName" title="姓名"></display:column>
				<display:column property="studentSex" title="性别"></display:column>
				<display:column property="studentTellphone" title="手机号码"></display:column>
				<display:column property="studentEmail" title="电子邮件"></display:column>
				<display:column property="studentSchool" title="所在院校"></display:column>
				<display:column property="studentType" title="学员类型"></display:column>

				<display:column
					href="${pageContext.request.contextPath }/classinfo/classinfo/addStudent.action"
					paramId="studentId" paramProperty="studentId" value="加入班级" title="加入班级"></display:column>
				
			</display:table>
		</div> --%>
<!-- 使用table实现数据提交 -->
