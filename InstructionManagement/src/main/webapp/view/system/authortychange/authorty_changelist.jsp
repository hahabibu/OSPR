<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<%@ include file="/view/public/commons.jspf" %>
</head>

<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">系统管理</a></li>
        <li>权限变更</li>
    </ul>
</div>
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >
<form class="form-horizontal">
	<div class="col-sm-2">角色名称:</div>
    <div class="col-sm-3">
    	<input type="text"  class="form-control input-sm"/>
    </div>
    <input type="button"   class="btn btn-danger"   value="查询"/>

    </form>
</div>
<div class="row" style="padding:15px; padding-top:0px; ">
	 <display:table class="table table-condensed table-striped" name="list" pagesize="10" requestURI="${pageContext.request.contextPath}/system/roleinfo/listRoleInfo.action">
		<display:column property="roleId" title="角色编号"></display:column>
		<display:column property="roleName" title="角色姓名"></display:column>
		<display:column property="roleDesc" title="角色描述" ></display:column>
		<display:column href="${pageContext.request.contextPath }/system/authortychange/AuthortyChangeUI.action" paramId="roleId" paramProperty="roleId" value="权限变更"  title="操作"></display:column>
		
	</display:table>
</div>

</body>
</html>
