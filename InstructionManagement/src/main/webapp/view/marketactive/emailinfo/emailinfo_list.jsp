<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
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
			<li><a href="#">营销管理</a></li>
			<li>邮件管理</li>
		</ul>
	</div>

	<script type="text/javascript">
		function query(condition) {
			// 通过改变下拉框传递相应的数据
			if(condition.value==1||condition.value==0){
				$("#emailState").attr("value",condition.value);
			}
			// 每次点击数据触发提交表单数据
			$("#emailform").submit();
		}
		
	</script>

	<div class="row alert alert-info" style="margin: 0px; padding: 3px;">
		<form id="emailform"
			action="${pageContext.request.contextPath }/marketactive/emailinfo/listEmailInfo.action"
			method="post" class="form-horizontal">
			<div class="col-sm-2">主题:</div>
			<div class="col-sm-3">
				<!-- 添加隐藏字段存放状态信息 -->
				<input type="hidden" id="emailState" name="emailState" class="form-control input-sm" />
				<select class="form-control  input-sm" onchange="query(this)"
					name="condition">
					<option value="">请选择</option>
					<option value="1">已发送</option>
					<option value="0">草稿箱</option>
				</select>
			</div>
			<div class="col-sm-3">
				<input type="text" name="emailTitle" class="form-control input-sm" />
			</div>
			<input type="submit" class="btn btn-danger" value="查询" /> <a
				class="btn btn-success"
				href="${pageContext.request.contextPath }/marketactive/emailinfo/addEmailInfoUI.action">发送邮件</a>
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
			<display:column property="emailId" title="编号"></display:column>
			<display:column property="emailTitle" title="主题"></display:column>
			<display:column property="staffName" title="发送人"></display:column>
<%-- 			<display:column property="staffId" title="发送人"></display:column> --%>
			<display:column property="emailTime" title="发送时间" format="{0,date,yyyy年MM月dd日}"></display:column>
			<display:column property="emailMan" title="接收人"></display:column>
			<display:column property="emailAddr" title="接收地址"></display:column>
			<display:column property="emailState" title="邮件状态"></display:column>
			<display:column
				href="${pageContext.request.contextPath}/marketactive/emailinfo/showEmailInfo.action"
				paramId="emailId" paramProperty="emailId" value="查看" title="查看"></display:column>
			<display:column
				href="${pageContext.request.contextPath}/marketactive/emailinfo/deleteEmailInfo.action"
				paramId="emailId" paramProperty="emailId" value="删除" title="删除"></display:column>
		</display:table>
	</div>
</body>
</html>
