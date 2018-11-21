<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
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
		</ul>
	</div>
	<form
		action="${pageContext.request.contextPath }/recruitstudent/trackrecord/listTrackRecordInfo.action"
		method="post" class="form-inline">
		<div class="row alert alert-info" style="margin: 0px; padding: 3px;">

			<div class="form-group">
				<label class="" for="activename">学员姓名：</label> <input type="text"
					class="form-control" id="activename" name="studentName"
					placeholder="请输入学员姓名">
			</div>
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
				href="${pageContext.request.contextPath }/recruitstudent/trackrecord/addTrackRecordInfoUI.action">添加纪录</a>

		</div>
		<%-- <div class="row" style="padding: 15px; padding-top: 0px;">
			<table class="table  table-condensed table-striped">
				<tr>
					<th>编号</th>
					<th>主题</th>
					<th>姓名</th>
					<th>内容</th>
					<th>意向状态</th>
					<th>联系时间</th>
					<th>下次联系时间</th>
					<th>操作</th>
				</tr>
				<c:forEach var="trackrecord" items="${list }">
					<tr>
						<td>${trackrecord.trackRecordId }</td>
						<td>${trackrecord.trackRecordTitle }</td>
						<td>${trackrecord.studentId }</td>
						<td>${trackrecord.trackRecordContent }</td>
						<td>${trackrecord. enrollment}</td>
						<td><fmt:formatDate value="${trackrecord.trackRecordTime }" pattern="yyyy年MM月dd日" /></td>
						<td><fmt:formatDate value="${trackrecord.nextRecordTime }" pattern="yyyy年MM月dd日" /></td>
						<td>
							<!-- 添加隐藏参数trackRecordId --> <input type="hidden"
							id="trackRecordId" name="trackRecordId"
							value="${trackrecord.trackRecordId }" /> <a class="btn btn-info btn-sm" 
							href="${pageContext.request.contextPath }/recruitstudent/trackrecord/updateTrackRecordInfoUI.action">修改</a>
							<a class="btn btn-danger btn-sm" href="javascript:deleteData('${trackrecord.trackRecordId }');" >删除</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div> --%>
		
		
		<div class="row" style="padding: 15px; padding-top: 0px;">
			<display:table class="table  table-condensed table-striped"
				name="list" pagesize="10"
				requestURI="${pageContext.request.contextPath}/recruitstudent/recruitstudent/list.action }">
				<display:column property="trackRecordId" title="编号"></display:column>
				<display:column property="trackRecordTitle" title="主题"></display:column>
				<display:column property="studentName" title="姓名"></display:column>
				<display:column property="trackRecordContent" title="内容"></display:column>
				<display:column property="trackRecordTime" format="{0,date,yyyy年MM月dd日}" title="联系时间"></display:column>
				<%-- <display:column property="enrollment" title="意向状态"></display:column> --%>
				<display:column property="enrollmentDescr" title="意向状态"></display:column>
				<display:column property="nextRecordTime" format="{0,date,yyyy年MM月dd日}" title="下次联系时间"></display:column>

				<display:column
					href="${pageContext.request.contextPath }/recruitstudent/trackrecord/updateTrackRecordInfoUI.action"
					paramId="trackRecordId" paramProperty="trackRecordId" value="修改" title="修改"></display:column>

				<display:column
					href="${pageContext.request.contextPath }/recruitstudent/trackrecord/deleteTrackRecordInfo.action"
					paramId="trackRecordId" paramProperty="trackRecordId" title="删除" value="删除">
				</display:column>
			</display:table>
		</div>
		
		
	</form>
	
	<script type="text/javascript">
		function deleteData(id) {
			var conf = confirm('是否删除该数据?');
			if (conf) {
				$("#trackRecordId").val(id);
				alert($("#trackRecordId").val());
				window.location.href="${pageContext.request.contextPath }/recruitstudent/trackrecord/deleteTrackRecordInfo.action ";
			}
		}
	</script>
</body>
</html>
