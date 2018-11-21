<%@ page pageEncoding="utf-8"%><!doctype html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
    	<li><a href="#">系统管理</a></li>
        <li>教师管理</li>
        <li>修改教师</li>
    </ul>
</div>

<form action="${pageContext.request.contextPath }/classinfo/teacher/updateStaffInfo.action" class="form-horizontal">
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="保存"/>
            <input  type="reset" class="btn  btn-danger" value="取消"/>
        </div>
    </div>
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">编号</label>
                <div class="col-sm-9">
                	<input type="text" value="${sta.staffId }" readonly="readonly" name="staffId" class="form-control input-sm" placeholder="请输入编号"/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">姓名</label>
                <div class="col-sm-9">
                	<input type="text" value="${sta.staffName }" name="staffName" class="form-control input-sm" placeholder="请输入姓名"/>
                </div>
            </div>
        </div>

    </div>
    <!-- 开始2 -->
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">年龄</label>
                <div class="col-sm-5">
                	<input type="text" value="${sta.staffAge }" name="staffAge" class="form-control input-sm" placeholder="请输入年龄"/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">性别</label>
                <div class="col-sm-4">
                		<select class="form-control input-sm"  name="staffSex">
                        	<option>保密</option>
                            <option selected>男</option>
                            <option>女</option>
                        </select>
                </div>
            </div>
        </div>
    </div>
    <!-- 结束2 -->
    <!-- 开始3 -->
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">籍贯</label>
                <div class="col-sm-6">
                	<input type="text" name="staffNativePlace"  value="${sta.staffNativePlace }" class="form-control input-sm" placeholder="请输入籍贯"/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">身份证</label>
                <div class="col-sm-9">
                <input type="text" name="staffIdcard" value="${sta.staffIdcard }" class="form-control input-sm" placeholder="请输入身份证号码"/>
                </div>
            </div>
        </div>
    </div>
    <!-- 结束3 -->
        <!-- 开始4 -->
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">出生日期</label>
                <div class="col-sm-9"> 
                	<input type="text" name="staffBirthday" onclick="WdatePicker()" value='<fmt:formatDate value="${sta.staffBirthday}"/>' class="form-control input-sm" placeholder="请输入出生日期"/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">办公电话</label>
                <div class="col-sm-9">
                <input type="text" name="staffOfficePhone" value="${sta.staffOfficePhone }" class="form-control input-sm" placeholder="请输入办公电话"/>
                </div>
            </div>
        </div>
    </div>
    <!-- 结束4 -->
    <!-- 开始4 -->
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">电子邮件</label>
                <div class="col-sm-9">
                	<input type="text" name="staffEmail" value="${sta.staffEmail }" class="form-control input-sm" placeholder="请输入电子邮件"/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">移动电话</label>
                <div class="col-sm-9">
                <input type="text" name="staffMobilePhone" value="${sta.staffMobilePhone }" class="form-control input-sm" placeholder="请输入移动电话"/>
                </div>
            </div>
        </div>
    </div>
    <!-- 结束4 -->    
    <!-- 开始5 -->
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">家庭住址</label>
                <div class="col-sm-9">
                	<input type="text" name="staffAddr" value="${sta.staffAddr }" class="form-control input-sm" placeholder="请输入家庭住址 "/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">QQ</label>
                <div class="col-sm-9">
                <input type="text" name="staffQq" value="${sta.staffQq }" class="form-control input-sm" placeholder="请输入QQ"/>
                </div>
            </div>
        </div>
    </div>
    <!-- 结束5 -->    
    <!-- 开始6 -->
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">入职时间</label>
                <div class="col-sm-9">
                	<input type="text" name="staffEntryTime" onclick="WdatePicker()" value='<fmt:formatDate value="${sta.staffEntryTime }"/>' class="form-control input-sm" placeholder="请输入入职时间 "/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">教育水平</label>
                <div class="col-sm-6">
                		<select class="form-control input-sm"  name="staffEducationLevel">
                        	<option ${sta.staffEducationLevel=='保密'?'selected':'' }>保密</option>
                            <option ${sta.staffEducationLevel=='博士'?'selected':'' }>博士</option>
                            <option ${sta.staffEducationLevel=='硕士'?'selected':'' }>硕士</option>
                            <option ${sta.staffEducationLevel=='本科'?'selected':'' }>本科</option>
                        </select>
                </div>
            </div>
        </div>
    </div>
    <!-- 结束6 -->   
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">备注信息</h5>
    	<div class="row">
    	<div class="col-sm-10">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">备注</label>
                <div class="col-sm-9">
                	<textarea class="form-control"  name="staffRemark"> ${sta.staffRemark} </textarea>
                </div>
            </div>
        
        </div>

    </div>
        <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">账号信息</h5>
    	<div class="row">
        	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">账号</label>
                <div class="col-sm-9">
                	<input type="text" name="staffNumber" value="${sta.staffNumber}" class="form-control input-sm" placeholder="请输入账号 "  />
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">密码</label>
                <div class="col-sm-9">
                <input type="password" name="staffPassword" value="${sta.staffPassword }" class="form-control input-sm"  placeholder="请输入密码"/>
                </div>
            </div>
        </div>
    </div>
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="保存"/>
            <input  type="reset" class="btn  btn-danger" value="取消"/>
        </div>
    </div>
</form>

</body>
</html>
