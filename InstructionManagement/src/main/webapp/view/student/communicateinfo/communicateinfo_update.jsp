<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<%@ include file="/view/public/commons.jspf" %>
</head>

<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">学员管理</a></li>
        <li>修改沟通记录</li>
    </ul>
</div>

<form action="${pageContext.request.contextPath }/student/communicateinfo/updateCommunicateInfo.action"  method="post" class="form-horizontal">

    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">编号</label>
                <div class="col-sm-9">
                	<input type="text" name="communicationId" readonly="readonly" class="form-control input-sm" value="${communicationInfo.communicationId }"/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">学员</label>
                <div class="col-sm-9">
                	<select name="studentId" class="form-control input-sm">	
	                	<c:forEach items="${studentList}" var="student">
	                    		<option ${communicationInfo.studentId==student.studentId?'selected':'' } value="${student.studentId}">${student.studentName}</option>
	                    </c:forEach>
                    </select>
                </div>
            </div>
        </div>

    </div>
    
    <div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">沟通时间</label>
                <div class="col-sm-9">
               			<input type="text" name="communicationTime" 
               			onclick="WdatePicker()" readonly="readonly"	
               			value="<fmt:formatDate value="${communicationInfo.communicationTime }" pattern="yyyy-MM-dd" type="both"/>" readonly="readonly" 
               			class="form-control input-sm" />
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">负责人</label>
                <div class="col-sm-9">
                	<select name="staffId" class="form-control input-sm">
                    	<c:forEach items="${staffList}" var="staff">
                    		<option ${communicationInfo.staffId==staff.staffId?'selected':'' } value="${staff.staffId}">${staff.staffName}</option>
                    	</c:forEach>
                    </select>
                </div>
            </div>
        </div>


    </div>


 
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">沟通内容</h5>
    	<div class="row">
    	<div class="col-sm-10">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">沟通内容</label>
                <div class="col-sm-9">
                	<textarea class="form-control" name="communicationContent">${communicationInfo.communicationContent }</textarea>
                </div>
            </div>
        
        </div>

    </div>
 
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="保存"/>

              <a class="btn btn-warning" href="${pageContext.request.contextPath }/student/communicateinfo/listCommunicateInfo.action">返回上一级</a>
        </div>
    </div>
</form>

</body>
</html>