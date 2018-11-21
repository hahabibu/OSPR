<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<%@ include file="/view/public/commons.jspf"%>
</head>

<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px;">
			<li><a href="#">财务管理</a></li>
			<li>员工薪水</li>
		</ul>
	</div>

	<script type="text/javascript">
		function query(condition) {
			$("#keyword").attr("name", condition.value);
		}
	</script>

	<div class="row alert alert-info" style="margin: 0px; padding: 3px;">
		<form class="form-inline"
			action="${pageContext.request.contextPath}/finance/staffsalary/listStaffSalary.action"
			method="post">
			<div class="col-sm-1">条件:</div>
			<div class="col-sm-3">
				<select class="form-control  input-sm" onchange="query(this)"
					name="condition">
					<option value="">请选择</option>
					<option value="staffSalaryId">账单编号</option>
					<option value="staffId">领取人编号</option>
					<option value="staStaffId">财务人员编号</option>
					<option value="staffName">领取人姓名</option>
					<option value="staStaffName">财务人员姓名</option>
				</select>
			</div>
			<div class="col-sm-3">
				<input type="text" id="keyword" class="form-control input-sm"
					autocomplete="off" />
			</div>

			<input type="submit" class="btn btn-danger" value="查询" /> 
			<a href="${pageContext.request.contextPath }/finance/staffsalary/addStaffSalaryUI.action" class="btn btn-success">添加</a>

		</form>
	</div>
	
	<!-- 提示信息 -->
	<div align="center">
		<div class="alert alert-warning"
			style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
			<button type="button" class="close" data-dismiss="alert">
				<span aria-hidden="true">&times;</span>

			</button>
			<p align="center" style="color: red;">财务管理-${info}</p>
		</div>
	</div>

	<div class="row" style="padding: 15px; padding-top: 0px;">
		<display:table class="table table-condensed table-striped" name="list"
			pagesize="10"
			requestURI="${pageContext.request.contextPath}/finance/staffsalary/listStaffSalary.action">
			<display:column property="staffSalaryId" title="员工薪水编号"></display:column>
			<display:column property="staffName" title="领取人"></display:column>
			<display:column property="staStaffName" title="财务人员"></display:column>
			<display:column property="staffSalaryTotal" title="本月薪水"></display:column>
			<display:column property="staffSalaryDeduct" title="扣除"></display:column>
			<display:column property="staffSalaryReal" title="实际发放金额"
				format="{0,date,yyyy年MM月dd日}"></display:column>
			<display:column property="staffSalaryIsused" title="是否发放"></display:column>
			<display:column property="staffSalaryTime" title="领取日期"
				format="{0,date,yyyy年MM月dd日}"></display:column>
			<display:column property="remark" title="备注"></display:column>
			<display:column
				href="${pageContext.request.contextPath }/finance/staffsalary/updateStaffSalaryUI.action"
				paramId="staffSalaryId" paramProperty="staffSalaryId" value="修改"
				title="修改"></display:column>
			<display:column
				href="${pageContext.request.contextPath }/finance/staffsalary/deleteStaffSalary.action"
				paramId="staffSalary" paramProperty="staffSalaryId" value="删除"
				title="删除"></display:column>
		</display:table>
	</div>

</body>
</html>
