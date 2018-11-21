<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>

</head>
<%@ include file="/view/public/commons.jspf" %>
<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">班级管理</a></li>
        <li>添加班级</li>
    </ul>
</div>

<form action="${pageContext.request.contextPath}/classinfo/classinfo/addClassinfo.action" method="post" class="form-horizontal">

    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">班级编号</label>
                <div class="col-sm-9">
                	<input type="text" name="classId" readonly="readonly" class="form-control input-sm" placeholder="请输入编号"/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">班级名称</label>
                <div class="col-sm-9">
                	<input type="text" name="className" class="form-control input-sm" placeholder="请输入班级名称"/>
                </div>
            </div>
        </div>

    </div>
    
    <div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">开班日期</label>
                <div class="col-sm-9">
               			<input type="text" name="classStartTime" readonly="readonly" onclick="WdatePicker()" class="form-control input-sm" placeholder="请输入开班日期"/>
                </div>
            </div>
        </div>
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">结束日期</label>
                <div class="col-sm-9">
               		 <input type="text" name="classEndTime" readonly="readonly" onclick="WdatePicker()" class="form-control input-sm" placeholder="请输入结束日期"/>
                </div>
            </div>
        
        </div>

    </div>
        <div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">班级人数</label>
                <div class="col-sm-9">
               			<input type="text" name="classNumber" class="form-control input-sm" placeholder="请输入班级人数"/>
                </div>
            </div>
        </div>
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">教师</label>
                <div class="col-sm-9">
               		 <select  class="form-control input-sm" name="staffId">
                     	<c:forEach items="${liStaffInfos }" var="data" >
                     		<option value="${data.staffId }">${data.staffName }</option>
                     	</c:forEach>
                     </select>
                </div>
            </div>

        </div>

    </div>
        <div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">学科</label>
                <div class="col-sm-9">
               	   <select name="disciplineId" class="form-control input-sm">
               	   		<option >请选择</option>
                     	<c:forEach items="${listDisci }" var="data">
                     		<option value="${data.disciplineId }">${data.disciplineName }</option>
                     	</c:forEach>
                     </select>
                </div>
            </div>
        </div>
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">课程表</label>
                <div class="col-sm-9">
               		 <select name="syllabusId" class="form-control input-sm">
                     	<option >请选择</option>
                     	<c:forEach items="${listSyl }" var="data">
                     		<option value="${data.syllabusId }">${data.syllabusName }</option>
                     	</c:forEach>
                     </select>
                </div>
            </div>

        </div>

    </div>
           <div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">教室</label>
                <div class="col-sm-9">
               	   <select name="classroomId" class="form-control input-sm">
                     	<option >请选择</option>
                     	<c:forEach items="${lisClar }" var="data">
                     		<option value="${data.classroomId }">${data.classroomName }</option>
                     	</c:forEach>
                     </select>
                </div>
            </div>
        </div>

    </div>
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">描述</h5>
    	<div class="row">
    	<div class="col-sm-10">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">描述</label>
                <div class="col-sm-9">
                	<textarea class="form-control"></textarea>
                </div>
            </div>
        
        </div>

    </div>
 
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="保存"/>

              <a class="btn btn-warning" href="classinfo_list.html">返回上一级</a>
        </div>
    </div>
</form>

</body>
</html>
