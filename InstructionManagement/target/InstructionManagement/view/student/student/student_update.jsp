<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<%@include file="/view/public/commons.jspf"%>
</head>

<body onload="loadData()">
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px;">
			<li><a href="#">招生管理</a></li>
			<li>学员信息</li>
			<li>修改学员信息</li>
		</ul>
	</div>

	<form id="studentInfo" name="studentInfo" onsubmit="return doSubmit()"
		action="${pageContext.request.contextPath }/student/student/updateStudentInfo.action"
		method="post" class="form-horizontal">
		<div class="row">
			<div class="col-sm-3 col-sm-offset-4">
				<input type="submit" class="btn btn-success" value="修改" /> <a
					class="btn btn-warning"
					href="${pageContext.request.contextPath }/student/student/listStudentInfo.action">返回上一级</a>
			</div>
		</div>
		
		<!-- 此处设置隐藏属性，添加学员类型为“意向学员” -->
		<input type="hidden" name="studentType" value="正式学员">
		
		<h5 class="page-header alert-info"
			style="padding: 10px; margin: 0px; margin-bottom: 5px;">基本信息</h5>
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">编号</label>
					<div class="col-sm-9">
						<input type="text" name="studentId"
							value="${studentInfo.studentId }" class="form-control input-sm"
							readonly="readonly" placeholder="请输入编号" />
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">姓名</label>
					<div class="col-sm-9">
						<input type="text" name="studentName"
							value="${studentInfo.studentName }" class="form-control input-sm"
							placeholder="请输入姓名" />
					</div>
				</div>
			</div>
		</div>
		<!--开始 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">性别</label>
					<div class="col-sm-4">
						<select name="studentSex" class="form-control input-sm">
							<option ${studentInfo.studentSex=='保密'?'selected':'' }>保密</option>
							<option ${studentInfo.studentSex=='男'?'selected':'' }>男</option>
							<option ${studentInfo.studentSex=='女'?'selected':'' }>女</option>
						</select>
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">年龄</label>
					<div class="col-sm-5">
						<input type="text" name="studentAge"
							value="${studentInfo.studentAge }" class="form-control input-sm"
							placeholder="请输入年龄" />
					</div>
				</div>
			</div>
		</div>
		<!--结束 -->
		<!--开始 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">手机号码</label>
					<div class="col-sm-9">
						<input type="text" name="studentTellphone"
							value="${studentInfo.studentTellphone }"
							class=" form-control
							input-sm" placeholder="请输入手机号码" />
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">电子邮件</label>
					<div class="col-sm-9">
						<input type="email" name="studentEmail"
							value="${studentInfo.studentEmail }"
							class=" form-control
							input-sm" placeholder="请输入电子邮件" />
					</div>
				</div>
			</div>
		</div>
		<!--结束 -->
		<!--开始 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">身份证</label>
					<div class="col-sm-9">
						<input type="text" name="studentIdcard"
							value="${studentInfo.studentIdcard }"
							class=" form-control
							input-sm" placeholder="请输入身份证" />
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">家庭地址</label>
					<div class="col-sm-9">
						<input type="text" name="studentAddress"
							value="${studentInfo.studentAddress }"
							class=" form-control
							input-sm" placeholder="请输入家庭地址" />
					</div>
				</div>
			</div>
		</div>
		<!--结束 -->
		<!--开始 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">出生日期</label>
					<div class="col-sm-9">
						<input type="text" name="studentBirthday"
							class="form-control input-sm"
							value='<fmt:formatDate value="${studentInfo. studentBirthday}"/>'
							readonly="readonly" onclick="WdatePicker()" placeholder="请输入出生日期" />
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">所在院校</label>
					<div class="col-sm-9">
						<select id="province" name="province" onchange="getCity()">
							<!-- <option value="0">所在省份</option> -->
							<option value="${fn:split(studentInfo.studentSchool,'-')[0] }" selected>${fn:split(studentInfo.studentSchool,'-')[0] }</option>
						</select> <select id="city" name="city" onchange="getCollege()">
							<option value="0">所在城市</option>
							<option value="${fn:split(studentInfo.studentSchool,'-')[1] }" selected>${fn:split(studentInfo.studentSchool,'-')[1] }</option>
						</select> <select id="college" name="college">
							<option value="0">所在大学</option>
							<option value="${fn:split(studentInfo.studentSchool,'-')[2] }" selected>${fn:split(studentInfo.studentSchool,'-')[2] }</option>
						</select>
					</div>
				</div>
			</div>
		</div>
		<!--结束 -->
		<!--开始 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">QQ号码</label>
					<div class="col-sm-9">
						<input type="text" name="studentQq"
							value="${studentInfo.studentQq }" class="form-control input-sm"
							placeholder="请输入QQ号码" />
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">家长姓名</label>
					<div class="col-sm-9">
						<input type="text" name="studentParentsName"
							value="${studentInfo.studentParentsName }"
							class=" form-control
							input-sm" placeholder="请输入家长姓名" />
					</div>
				</div>
			</div>
		</div>
		<!--结束 -->
		<!--开始 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">省份</label>
					<div class="col-sm-9">
						<select id="studentPro" name="studentPro" onchange="getProCity()">
							<!-- <option value="0">所在省份</option> -->
							<option value="${studentInfo.studentPro}" selected>${studentInfo.studentPro}</option>
						</select>
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">家长电话</label>
					<div class="col-sm-9">
						<input type="text" name="studentParentsPhone"
							value="${studentInfo.studentParentsPhone}"
							class="form-control input-sm" placeholder="请输入家长电话" />
					</div>
				</div>
			</div>
		</div>
		<!--结束 -->
		<!--开始 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">城市</label>
					<div class="col-sm-9">
						<select id="studentProCity" name="studentProCity">
							<option value="0">所在城市</option>
							<option value="${studentInfo.studentProCity}" selected>${studentInfo.studentProCity}</option>
						</select>
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">意向状态</label>
					<div class="col-sm-6">
						<select name="studentState" class="form-control input-sm">
							<c:forEach var="studentState" items="${studentState_map }">
								<option value="${studentState.value}"
									${studentState.value==studentInfo.studentState?'selected':'' } >${studentState.key}</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>
		<!--结束 -->
		<h5 class="page-header alert-info"
			style="padding: 10px; margin: 0px; margin-bottom: 5px;">描述信息</h5>
		<div class="row">
			<div class="col-sm-10">
				<div class="form-group">
					<label class="col-sm-3 control-label">描述信息</label>
					<div class="col-sm-9">
						<textarea class="form-control" name="studentDesc">${studentInfo.studentDesc }</textarea>
					</div>
				</div>
			</div>

		</div>

		<div class="row">
			<div class="col-sm-3 col-sm-offset-4">
				<input type="submit" class="btn btn-success" value="修改" /> <a
					class="btn btn-warning"
					href="${pageContext.request.contextPath }/student/student/listStudentInfo.action">返回上一级</a>
			</div>
		</div>
	</form>

</body>
</html>
