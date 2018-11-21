<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<!-- 引入相关文件 -->
<%@include file="/view/public/commons.jspf"%>
</head>

<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px;">
			<li><a href="#">招生管理</a></li>
			<li>跟踪记录</li>
			<li>修改记录</li>
		</ul>
	</div>

	<form
		action="${pageContext.request.contextPath }/recruitstudent/trackrecord/updateTrackRecordInfo.action"
		method="post" class="form-horizontal">

		<h5 class="page-header alert-info"
			style="padding: 10px; margin: 0px; margin-bottom: 5px;">基本信息</h5>
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">编号</label>
					<div class="col-sm-9">
						<input type="text" name="trackRecordId"
							value="${trackRecordInfo.trackRecordId }" readonly="readonly"
							class="form-control input-sm" placeholder="请输入编号" />
					</div>
				</div>

			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">主题</label>
					<div class="col-sm-9">
						<input type="text" name="trackRecordTitle"
							value="${trackRecordInfo.trackRecordTitle }"
							class="form-control input-sm" placeholder="请输入主题" />
					</div>
				</div>
			</div>

		</div>
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">联系学员</label>
					<div class="col-sm-9">
						<select name="studentId" class="form-control input-sm">
							<c:forEach var="student" items="${student_list }">
								<option value="${student.studentId }"
									${student.studentId== trackRecordInfo.studentId?'selected':'' }>${student.studentName }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">联系时间</label>
					<div class="col-sm-9">
						<input type="text" name="trackRecordTime" readonly="readonly"
							value='<fmt:formatDate value="${trackRecordInfo.trackRecordTime }"/>'
							onclick="WdatePicker()" class="form-control input-sm"
							placeholder="请输入联系时间" />
					</div>
				</div>

			</div>

		</div>
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">下次联系时间</label>
					<div class="col-sm-9">
						<input type="text" name="nextRecordTime" readonly="readonly"
							value='<fmt:formatDate value="${trackRecordInfo.nextRecordTime }"/>'
							onclick="WdatePicker()" class="form-control input-sm"
							placeholder="请输入下次联系时间" />
					</div>
				</div>

			</div>

		</div>
		<h5 class="page-header alert-info"
			style="padding: 10px; margin: 0px; margin-bottom: 5px;">具体内容</h5>
		<div class="row">
			<div class="col-sm-10">
				<div class="form-group">
					<label class="col-sm-3 control-label">具体内容</label>
					<div class="col-sm-9">
						<textarea class="form-control" name="trackRecordContent">${trackRecordInfo.trackRecordContent }</textarea>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-3 col-sm-offset-4">
				<input type="submit" class="btn btn-success" value="保存" /> <a
					class="btn btn-warning"
					href="${pageContext.request.contextPath }/recruitstudent/trackrecord/listTrackRecordInfo.action">返回上一级</a>
			</div>
		</div>
	</form>
</body>
</html>
