<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net/el" prefix="display" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
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
        <li>数据字典</li>
    </ul>
</div>

<div class="row alert alert-info"  style="margin:0px; padding:3px;" >
<form class="form-horizontal" action="${pageContext.request.contextPath }/system/datadictionary/listDataDictionary.action" method="post">
	<div class="col-sm-2">类型:</div>
    <div class="col-sm-3">
    	<select class="form-control  input-sm" name="dataType">
    	    <option value="-1">请选择</option>
    		<c:forEach var="type" items="${dataType_list }">
    			<option value="${type }">${type }</option>
    		</c:forEach>
        </select> 
     </div>
     <div class="col-sm-3">
    	<input type="text" name="dataContent" id="keyword" class="form-control input-sm"/>
    </div>
    <input type="submit"   class="btn btn-danger"     value="查询"/>
    <input type="button"   class="btn btn-success"   value="添加" onClick="javascript:window.location='${pageContext.request.contextPath}/view/system/datadictionary/datadictionary_add.jsp'"/>
</form>
</div>
<div class="row" style="padding:15px; padding-top:0px; ">
	<display:table class="table table-condensed table-striped" name="list" pagesize="10" requestURI="${pageContext.request.contextPath }/system/staffinfo/listStaffInfo.action">
		<display:column property="dataId" title="编号"></display:column>
		<display:column property="dataContent" title="名称" ></display:column>
		<display:column property="dataType" title="类型"></display:column>
		<display:column property="dataDesc" title="描述"></display:column>
		<display:column href="${pageContext.request.contextPath }/system/datadictionary/updateDataDictionaryUI.action" paramId="dataId" paramProperty="dataId"  value="修改" title="修改"></display:column>
		<display:column href="${pageContext.request.contextPath }/system/datadictionary/deleteDataDictionary.action" paramId="dataId" paramProperty="dataId" value="删除" title="删除"></display:column>	
	</display:table>
</div>

</body>
</html>