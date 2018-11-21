<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<!-- 引入相关的js、css文件 -->
<%@include file="/view/public/commons.jspf" %>
</head>

<script type="text/javascript">
	function getTemplateContent() {
		$("select option:selected").each(function(){
			var value = $(this).val();
			// 根据获取的模板信息修改数据
			if(value!="0"){
				$("#messageContent").val(value);
			}else{
				// 先将数据清空随后设置默认值
				$("#messageContent").val("");
				$("#messageContent").attr('placeholder',"请输入短信内容!");
			}
		});
	}
</script>

<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">营销管理</a></li>
        <li>短信管理</li>
        <li>发送信息</li>
    </ul>
</div>

<form action="${pageContext.request.contextPath }/marketactive/messageinfo/addMessageInfo.action" method="post" class="form-horizontal">

    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">模板</label>
                <div class="col-sm-9">
                	<select id="template" class="form-control input-sm" onclick="getTemplateContent()">
                		<option value="0">默认</option>
                		<c:forEach var="templateInfo" items="${templateInfo_list }">
                			<option value="${templateInfo.templateContent }">${templateInfo.templateTitle }</option>
                		</c:forEach>
                    </select>
                </div>
            </div>
        </div>
    </div>
    
    	<div class="row">
                <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">接收人</label>
                <div class="col-sm-9">
                	<input type="text" name="messageMan" class="form-control input-sm" placeholder="请输入接收人"/>
                </div>
            </div>
        </div>
        
        </div>
    
    	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">电话号码</label>
                <div class="col-sm-9">
                	<input type="text" name="messagePhone" class="form-control input-sm"  placeholder="请输入电话号码"/>
                </div>
            </div>
        
        </div>


    </div>
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">短信内容信息</h5>
    	<div class="row">
    	<div class="col-sm-10">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">短信内容</label>
                <div class="col-sm-9">
                	<textarea class="form-control" id="messageContent" name="messageContent" placeholder="请输入短信内容!"></textarea>
                </div>
            </div>
        </div>

    </div>
 
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="发送"/>

              <a class="btn btn-warning" href="${pageContext.request.contextPath }/marketactive/messageinfo/listMessageInfo.action">返回上一级</a>
        </div>
    </div>
</form>

</body>
</html>
