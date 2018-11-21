<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<script type="text/javascript">
	function saveData() {
		var info = window.confirm("您确认发送邮件?选择取消将保存至草稿箱");
		if (info) {
			$("#type").val("1");
			return true;
		} else {
			// window.location.href = "${pageContext.request.contextPath }/marketactive/emailinfo/addEmailInfo.action?type=0";
			$("#type").val("0");
			return true;
		}
	}

	function getTemplateContent() {
		$("select option:selected").each(function() {
			var value = $(this).val();
			// 根据获取的模板信息修改数据
			if (value != "0") {
				$("#emailContent").val(value);
			} else {
				// 先将数据清空随后设置默认值
				$("#emailContent").val("");
				$("#emailContent").attr('placeholder', "请输入邮件内容!");
			}
		});
	}
</script>

<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px;">
			<li><a href="#">营销管理</a></li>
			<li>邮件管理</li>
			<li>发送邮件</li>
		</ul>
	</div>

	<form
		action="${pageContext.request.contextPath }/marketactive/emailinfo/addEmailInfo.action"
		method="post" class="form-horizontal" onsubmit="return saveData()">
		<!-- 隐藏参数：邮件保存类型：已发送、草稿箱 -->
		<input type="hidden" id="type" name="type" />
		<!-- 隐藏参数：邮件编码id -->
		<input type="hidden" name="emailId" value="${emailInfo.emailId }"/>
		<!-- 隐藏参数：邮件发送状态 -->
		<input type="hidden" name="emailState" value="${emailInfo.emailState }"/>

		<h5 class="page-header alert-info"
			style="padding: 10px; margin: 0px; margin-bottom: 5px;">基本信息</h5>
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">模板</label>
					<div class="col-sm-9">
						<select class="form-control input-sm"
							onclick="getTemplateContent()">
							<option value="0">默认</option>
							<c:forEach var="templateInfo" items="${templateInfo_list }">
								<option value="${templateInfo.templateContent }" >${templateInfo.templateTitle }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">主题</label>
					<div class="col-sm-9">
						<input type="text" name="emailTitle" class="form-control input-sm"
							placeholder="请输入主题" value="${emailInfo.emailTitle }"/>
					</div>
				</div>
			</div>

		</div>
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">接收人</label>
					<div class="col-sm-9">
						<input type="text" name="emailMan" class="form-control input-sm"
							placeholder="请输入接收人" value="${emailInfo.emailMan }" />
					</div>
				</div>
			</div>

		</div>

		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">邮件地址</label>
					<div class="col-sm-9">
						<input type="email" name="emailAddr" class="form-control input-sm"
							placeholder="请输入邮件地址" value="${emailInfo.emailAddr }" />
					</div>
				</div>
			</div>
		</div>
		<h5 class="page-header alert-info"
			style="padding: 10px; margin: 0px; margin-bottom: 5px;">邮件内容信息</h5>
		<div class="row">
			<div class="col-sm-10">
				<div class="form-group">
					<label class="col-sm-3 control-label">邮件内容</label>
					<div class="col-sm-9">
						<textarea class="form-control" id="emailContent"
							name="emailContent" placeholder="请输入邮件内容!">${emailInfo.emailContent }</textarea>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-3 col-sm-offset-4">
				<input type="submit" class="btn btn-success" value="发送" /> <a
					class="btn btn-warning"
					href="${pageContext.request.contextPath }/marketactive/emailinfo/listEmailInfo.action">返回上一级</a>
			</div>
		</div>
	</form>
</body>
</html>
