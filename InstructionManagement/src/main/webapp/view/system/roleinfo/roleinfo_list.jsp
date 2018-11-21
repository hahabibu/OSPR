<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<%@ include file="/view/public/commons.jspf"%>
</head>

<body>
	<script type="text/javascript">
		function query(condition) {
			$("#keyword").attr("name", condition.value);
		}
	</script>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px;">
			<li><a href="#">系统管理</a></li>
			<li>角色管理</li>
		</ul>
	</div>
	<div class="row alert alert-info" style="margin: 0px; padding: 3px;">
		<form class="form-horizontal" action="${pageContext.request.contextPath}/system/roleinfo/listRoleInfo.action">
			<div class="col-sm-1">条件:</div>
			<div class="col-sm-3">
				<select class="form-control  input-sm" onchange="query(this)" name="condition">
		        	<option value="">请选择</option>
		        	<option value="roleId">角色编号</option>
		            <option value="roleName">角色名称</option>

	       		</select>
			</div>
			<div class="col-sm-3">
				<input type="text" class="form-control input-sm" id="keyword"/>
			</div>
			<input type="submit" class="btn btn-danger" value="查询" /> 
			<input type="button" class="btn btn-success" value="添加"
				onClick="javascript:window.location='${pageContext.request.contextPath}/view/system/roleinfo/roleinfo_add.jsp'" />
		</form>
	</div>

	<div align="center">
		<div class="alert alert-warning"
			style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
			<button type="button" class="close" data-dismiss="alert">
				<span aria-hidden="true">&times;</span>

			</button>
			<p align="center" style="color: red;">角色信息-${info}</p>
		</div>
	</div>

	<div class="row" style="padding: 15px; padding-top: 0px;">
		<table class="table  table-condensed table-striped">
		</table>
		<display:table class="table table-condensed table-striped" name="list"
			pagesize="10"
			requestURI="${pageContext.request.contextPath}/system/roleinfo/listRoleInfo.action">
			<display:column property="roleId" title="角色编号"></display:column>
			<display:column property="roleName" title="角色姓名"></display:column>
			<display:column property="roleDesc" title="角色描述"></display:column>
			<display:column
				href="${pageContext.request.contextPath }/system/roleinfo/updateRoleInfoUI.action"
				paramId="roleId" paramProperty="roleId" value="修改" title="修改"></display:column>
			<display:column
				href="${pageContext.request.contextPath }/system/roleinfo/deleteRoleInfo.action"
				paramId="roleId" paramProperty="roleId" value="删除" title="删除"></display:column>
		</display:table>

	</div>

</body>
</html>
