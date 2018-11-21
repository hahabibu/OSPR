<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<%@ include file="/view/public/commons.jspf" %>
</head>

<body>

<form action="${pageContext.request.contextPath}/system/authorty/updateAuthortyInfo.action"  class="form-horizontal">

    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
		
		<!-- 每次修改数据的时候会相应修改当前等级，因此此处需要设置隐藏参数回传权限等级 -->
		<input type="hidden" name="authortyClass" value="${authortyInfo.authortyClass }"/>
	
    	<div class="col-xs-5">
        	<div class="form-group">
            	<label class="col-xs-3 control-label">权限编号</label>
                <div class="col-xs-9">
                	<input type="text" name="authortyId" value="${authortyInfo.authortyId }"  readonly="readonly" class="form-control input-sm" placeholder="请输入权限编号"/>
                </div>
            </div>
        
        </div>
        <div class="col-xs-5">
            <div class="form-group">
            	<label class="col-xs-3 control-label">权限名称</label>
                <div class="col-xs-9">
                	<input type="text" name="authortyName" value="${authortyInfo.authortyName }" class="form-control input-sm" placeholder="请输入权限名称"/>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
    	<div class="col-xs-5">
        	<div class="form-group">
            	<label class="col-xs-3 control-label">上级权限</label>
                <div class="col-xs-9">
                    <select class="form-control input-sm" name="authortyPid">
						<option value="-1" >最高级</option>
						<c:forEach items="${pai_list}" var="pai">
							<option value="${pai.authortyId}" ${pai.authortyId==authortyInfo.authortyPid?'selected':'' }>${pai.authortyName}</option>
						</c:forEach>
					</select> 
                </div>
            </div>
        
        </div>
        <div class="col-xs-5">
            <div class="form-group">
            	<label class="col-xs-3 control-label">权限URL</label>
                <div class="col-xs-9">
                	<input type="text" name="authortyUrl" value="${authortyInfo.authortyUrl }" class="form-control input-sm" placeholder="请输入权限URL"/>
                </div>
            </div>
        </div>
    </div>
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">备注信息</h5>
    	<div class="row">
    	<div class="col-xs-10">
        	<div class="form-group">
            	<label class="col-xs-3 control-label">备注</label>
                <div class="col-xs-9">
                	<textarea class="form-control" name="authortyDesc">${authortyInfo.authortyDesc}</textarea>
                </div>
            </div>
        
        </div>

    </div>
 	<div class="row">
    	<div class="col-xs-3 col-xs-offset-3">
        	<input  type="submit" class="btn btn-success" value="保存权限信息"/>
        </div>
        <div class="col-xs-3 col-xs-offset-3">
        	<a class="btn btn-default" href="${pageContext.request.contextPath}/system/authorty/listAuthortyInfo.action">返回上一级</a>
        </div>
    </div>

</form>

</body>
</html>
