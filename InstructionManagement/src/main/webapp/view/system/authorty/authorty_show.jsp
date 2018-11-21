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

	<form action="" class="form-horizontal">
		<div class="row">
			<div class="col-xs-9 ">
				<a type="button" class="btn btn-success"
					href="${pageContext.request.contextPath}/system/authorty/updateAuthortyInfoUI.action">添加权限信息</a>
			</div>
		</div>

	</form>

<%-- 	<%
		Cookie[] cookie = request.getCookies();

		String user = new String();

		if (cookie != null) {

			for (int i = 0; i < cookie.length; i++) {

				Cookie myCookie = cookie[i];

				if (myCookie.getName().equals("user")) {

					user = myCookie.getValue();

				}

			}

		}

		out.println("user = " + user);
	%> --%>
	
	<!-- 提示信息 -->
	<div align="center">
		<div class="alert alert-warning"
			style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
			<button type="button" class="close" data-dismiss="alert">
				<span aria-hidden="true">&times;</span>

			</button>
			<p align="center" style="color: red;">系统管理-${info}</p>
		</div>
	</div>

	<div>
		<display:table id="table" class="table table-condensed table-striped"
			name="list" pagesize="10"
			requestURI="${pageContext.request.contextPath}/system/authorty/listAuthortyInfo.action">
			<display:column property="authortyId" title="权限编号"></display:column>
			<display:column property="authortyName" title="权限名称"></display:column>
			<display:column property="authortyPid" title="上级权限编号"></display:column>
			<display:column property="authortyPName" title="上级权限名称"></display:column>
			<display:column property="authortyDesc" title="权限描述"></display:column>
			<display:column property="authortyUrl" title="权限url"></display:column>
			
			<display:column
				href="${pageContext.request.contextPath }/system/authorty/addAuthortyInfoUI.action"
				paramId="authortyId" paramProperty="authortyId" value="添加子级权限"
				title="添加子级权限"></display:column>
			
			<display:column
				href="${pageContext.request.contextPath }/system/authorty/updateAuthortyInfoUI.action"
				paramId="authortyId" paramProperty="authortyId" value="修改"
				title="修改"></display:column>
				
			<display:column
				href="${pageContext.request.contextPath }/system/authorty/deleteAuthortyInfo.action"
				paramId="authortyId" paramProperty="authortyId" value="删除"
				title="删除"></display:column>
		</display:table>
	</div>

</body>
</html>
