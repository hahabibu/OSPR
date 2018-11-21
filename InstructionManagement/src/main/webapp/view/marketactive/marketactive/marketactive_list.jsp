<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<li>营销活动</li>
		</ul>
	</div>
	<script type="text/javascript">
		function query(condition) {
			// 通过改变下拉框传递相应的数据
			if(condition.value!=-1){
				$("#activeState").attr("value",condition.value);
			}
		}
	</script>
	<div class="row alert alert-info" style="margin: 0px; padding: 3px;">
		<form action="${pageContext.request.contextPath }/marketactive/marketactive/listMarketActive.action" method="post" class="form-inline">
			<div class="form-group">
				<label class="" for="activename">活动名称：</label> 
				<input type="text"
					class="form-control" id="activename" name="activeName" placeholder="请输入活动名称">
			</div>
			<div class="form-group">
				<label class="" for="activstate">活动状态：</label> 
				<input type="hidden" id="activeState" name="activeState" class="form-control input-sm" />
				<select
					class="form-control" name="condition" onchange="query(this)">
					<option value="-1">所有活动</option>
					<c:forEach var="activeState" items="${activeState_map }">
						<option value="${activeState.value }">${activeState.key }</option>
					</c:forEach>
				</select>
			</div>
			<input type="submit" class="btn btn-danger" value="查询" /> <a
				class="btn btn-success"
				href="${pageContext.request.contextPath }/marketactive/marketactive/addMarketActiveUI.action">添加活动</a>
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
			requestURI="${pageContext.request.contextPath}/marketactive/messageinfo/list.action }">
			<display:column property="activeId" title="编号"></display:column>
			<display:column property="activeName" title="活动名称"></display:column>
			<%-- <display:column property="staffId" title="负责人"></display:column> --%>
			<display:column property="staffName" title="负责人"></display:column>
			<display:column property="activeStart" title="开始时间" format="{0,date,yyyy年MM月dd日}"></display:column>
			<display:column property="activeEnd" title="结束时间" format="{0,date,yyyy年MM月dd日}"></display:column>
			<display:column property="activeState" title="活动状态"></display:column>
			<display:column
				href="${pageContext.request.contextPath}/marketactive/marketactive/updateMarketActiveUI.action"
				paramId="activeId" paramProperty="activeId" value="修改"
				title="修改"></display:column>
			<display:column
				href="${pageContext.request.contextPath}/marketactive/marketactive/deleteMarketActive.action"
				paramId="activeId" paramProperty="activeId" value="删除"
				title="删除"></display:column>
		</display:table>
	</div>

</body>
</html>
