<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
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
			<li>短信邮件模板</li>
		</ul>
	</div>
	<div class="row alert alert-info" style="margin: 0px; padding: 3px;">
		<form
			action="${pageContext.request.contextPath }/marketactive/templateinfo/listTemplateInfo.action"
			method="post" class="form-horizontal">
			<div class="col-sm-1">模板类型:</div>
			<div class="col-sm-3">
				<select class="form-control  input-sm" name="templateType">
					<option value="所有内容">所有内容</option>
					<option value="短信模板">短信模板</option>
					<option value="邮件模板">邮件模板</option>
				</select>
			</div>
			<div class="col-sm-1">&nbsp;</div>
			<div class="col-sm-1">标题:</div>
			<div class="col-sm-3">
				<input type="text" name="templateTitle"
					class="form-control input-sm" />
			</div>
			<input type="submit" class="btn btn-danger" value="查询" /> <a
				class="btn btn-success"
				href="${pageContext.request.contextPath }/view/marketactive/template/template_add.jsp">添加模板</a>
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
		<display:table class="table  table-condensed table-striped"
			name="list" pagesize="10"
			requestURI="${pageContext.request.contextPath}/marketactive/template/list.action }">
			<display:column property="templateId" title="编号"></display:column>
			<display:column property="templateTitle" title="标题"></display:column>
			<display:column property="templateContent" title="内容"></display:column>
			<display:column property="templateType" title="类别"></display:column>

			<display:column
				href="${pageContext.request.contextPath }/marketactive/templateinfo/updateTemplateInfoUI.action"
				paramId="templateId" paramProperty="templateId" value="修改"
				title="修改"></display:column>
			<display:column paramId="templateId" paramProperty="templateId"
				title="删除">
				<a href="javascript:deleteData('${templateId }')">删除</a>
			</display:column>
		</display:table>
	</div>

	<script type="text/javascript">
		function deleteData(templateId) {
			alert(templateId);
			var info = window.confirm("您确认删除这条数据吗?");

			if (info) {
				window.location.href = "${pageContext.request.contextPath }/marketactive/templateinfo/deleteTemplateInfo.action";
			}
		}
	</script>

</body>
</html>
