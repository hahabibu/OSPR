<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<!-- 引入相关的js、css文件 -->
<%@include file="/view/public/commons.jspf"%>
</head>

<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px;">
			<li><a href="#">营销管理</a></li>
			<li>短信管理</li>
		</ul>
	</div>
	<div class="row alert alert-info" style="margin: 0px; padding: 3px;">
		<form
			action="${pageContext.request.contextPath }/marketactive/messageinfo/listMessageInfo.action"
			method="post" class="form-horizontal">
			<div class="col-sm-2">电话号码:</div>
			<div class="col-sm-3">
				<input type="text" class="form-control input-sm" name="messagePhone" />
			</div>
			<input type="submit" class="btn btn-danger" value="查询" /> <a
				class="btn btn-success"
				href="${pageContext.request.contextPath }/marketactive/messageinfo/addMessageInfoUI.action">发送短信</a>
		</form>
	</div>

	<!-- 提示信息 -->
	<div align="center">
		<div class="alert alert-warning"
			style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
			<button type="button" class="close" data-dismiss="alert">
				<span aria-hidden="true">&times;</span>

			</button>
			<p align="center" style="color: red;">营销管理-${info}</p>
		</div>
	</div>

	<div class="row" style="padding: 15px; padding-top: 0px;">
		<table class="tabletable-condensedtable-striped">
		</table>
		<display:table class="table  table-condensed table-striped"
			name="list" pagesize="10"
			requestURI="${pageContext.request.contextPath}/marketactive/messageinfo/list.action }">
			<display:column property="messageId1" title="编号"></display:column>
			<%-- <display:column property="staffId" title="发送人"></display:column> --%>
			<display:column property="staffName" title="发送人"></display:column>
			<display:column property="messageContent" title="短信内容"></display:column>
			<display:column property="messageTime" title="发送时间" format="{0,date,yyyy年MM月dd日}"></display:column>
			<display:column property="messageMan" title="接收人"></display:column>
			<display:column property="messagePhone" title="接收号码"></display:column>
			<display:column
				href="${pageContext.request.contextPath}/marketactive/messageinfo/showMessageInfo.action"
				paramId="messageId1" paramProperty="messageId1" value="查看"
				title="查看"></display:column>
			<display:column
				href="${pageContext.request.contextPath}/marketactive/messageinfo/deleteMessageInfo.action"
				paramId="messageId1" paramProperty="messageId1" value="删除"
				title="删除"></display:column>
		</display:table>
	</div>

</body>
</html>
