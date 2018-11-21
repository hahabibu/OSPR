<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
			<li>修改员工薪水</li>
		</ul>
	</div>

	<form
		action="${pageContext.request.contextPath }/finance/staffsalary/updateStaffSalary.action"
		class="form-horizontal">
		<div class="row">
			<div class="col-sm-3 col-sm-offset-4">
				<input type="submit" class="btn btn-success" value="修改" /> <a
					href="${pageContext.request.contextPath }/finance/staffsalary/listStaffSalary.action"
					class="btn btn-success">返回上一级</a>
			</div>
		</div>
		<h5 class="page-header alert-info"
			style="padding: 10px; margin: 0px; margin-bottom: 5px;">基本信息</h5>
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">员工薪水编号</label>
					<div class="col-sm-9">
						<input type="text" name="staffSalaryId"
							value="${staffSalary.staffSalaryId }" readonly="readonly"
							class="form-control input-sm" placeholder="员工薪水编号" />
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">领取人编号</label>
					<!-- 不是输入的 而是从数据库读取 ，选择的 -->
					<div class="col-sm-4">
						<select class="form-control input-sm" name="staffId">
							<option>请选择</option>
							<c:forEach items="${stafflist}" var="sta">
								<option value="${sta.staffId}"
									${sta.staffId==staffSalary.staffId?'selected':''}>${sta.staffName}</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-sm-4"></div>
				</div>
			</div>
		</div>
		<!--开始 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">财务人员编号</label>
					<div class="col-sm-4">
						<select class="form-control input-sm" name="staStaffId">
							<option>请选择</option>
							<c:forEach items="${stastafflist}" var="stasta">
								<option value="${stasta.staffId}"
									${stasta.staffId==staffSalary.staStaffId?'selected':''}>${stasta.staffName}</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">本月薪水</label>
					<div class="col-sm-5">
						<input type="text" name="staffSalaryTotal"
							value="${staffSalary.staffSalaryTotal }"
							class="form-control input-sm" placeholder="请输入缴费情况" />
					</div>
				</div>
			</div>
		</div>
		<!--结束 -->
		<!--开始 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">扣除</label>
					<div class="col-sm-9">
						<input type="text" name="staffSalaryDeduct"
							value="${staffSalary.staffSalaryDeduct }"
							class="form-control input-sm" placeholder="请输入缴费方式" />
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">领取日期</label>
					<div class="col-sm-9">
						<input type="text" name="staffSalaryTime"
							value="<fmt:formatDate value="${staffSalary.staffSalaryTime }" type="both"/>"
							onclick="WdatePicker()" readOnly="readOnly"
							class="form-control input-sm" placeholder="请选择缴费时间" />
					</div>
				</div>
			</div>
		</div>
		<!--结束 -->
		<!--开始 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">是否发放</label>
					<div class="col-sm-9">
						<input type="text" name="staffSalaryIsused"
							value="${staffSalary.staffSalaryIsused }"
							class="form-control input-sm" placeholder="请输入优惠金额" />
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">实际发放金额</label>
					<div class="col-sm-9">
						<input type="text" name="staffSalaryReal"
							value="${staffSalary.staffSalaryReal }"
							class="form-control input-sm" placeholder="请输入应缴金额" />
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
					<label class="col-sm-3 control-label">备注</label>
					<div class="col-sm-9">
						<textarea class="form-control" name="remark">${staffSalary.remark }</textarea>
					</div>
				</div>

			</div>

		</div>

		<div class="row">
			<div class="col-sm-3 col-sm-offset-4">
				<input type="submit" class="btn btn-success" value="修改" /> <a
					href="${pageContext.request.contextPath }/finance/staffsalary/listStaffSalary.action"
					class="btn btn-success">返回上一级</a>
			</div>
		</div>
	</form>

</body>
</html>
