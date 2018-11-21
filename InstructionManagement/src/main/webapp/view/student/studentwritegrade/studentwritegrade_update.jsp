<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
    	<li><a href="#">学员管理</a></li>
        <li>修改学生成绩</li>
    </ul>
</div>

<form action="${pageContext.request.contextPath }/student/studentwritegrade/updateStudentWriteGrade.action" method="post" class="form-horizontal">

    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">编号</label>
                <div class="col-sm-9">
                	<input type="text" name="writeGradeId" readonly="readonly" class="form-control input-sm" value="${studentWriteGrade.writeGradeId }"/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">学员</label>
                <div class="col-sm-9">
                	<select name="studentId" class="form-control input-sm">
                    	<c:forEach items="${studentList}" var="student">
                    		<option ${studentWriteGrade.studentId==student.studentId?'selected':'' } value="${student.studentId}">${student.studentName}</option>
                    	</c:forEach>
                    </select>
                </div>
            </div>
        </div>

    </div>
    	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">科目</label>
                <div class="col-sm-9">
                	<input type="text" name="writeGradeSubject" class="form-control input-sm" value="${studentWriteGrade.writeGradeSubject }"/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">成绩</label>
                <div class="col-sm-9">
                	<input type="text" name="writeGrade" class="form-control input-sm" value="${studentWriteGrade.writeGrade }"/>
                </div>
            </div>
        </div>

    </div>
    <div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">考试时间</label>
                <div class="col-sm-9">
               			<input type="text" name="writeGradeTime" 
               			onclick="WdatePicker()" readonly="readonly"	
               			value="<fmt:formatDate value="${studentWriteGrade.writeGradeTime }" pattern="yyyy-MM-dd" type="both"/>" readonly="readonly" 
               			class="form-control input-sm" /> </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">负责人</label>
                <div class="col-sm-9">
                	<select name="staffId" class="form-control input-sm">
                    	<c:forEach items="${staffList}" var="staff">
                    		<option ${studentWriteGrade.staffId==staff.staffId?'selected':'' } value="${staff.staffId}">${staff.staffName}</option>
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
                	<textarea class="form-control" name="writeGradeNote">${studentWriteGrade.writeGradeNote }</textarea>
                </div>
            </div>
        
        </div>

    </div>
 
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="保存"/>

              <a class="btn btn-warning" href="${pageContext.request.contextPath }/student/studentwritegrade/listStudentWriteGrade.action">返回上一级</a>
        </div>
    </div>
</form>

</body>
</html>