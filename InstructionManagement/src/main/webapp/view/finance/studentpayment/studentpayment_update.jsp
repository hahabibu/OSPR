<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
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
    	<li><a href="#">财务管理</a></li>
        <li>学员缴费</li>
        <li>修改缴费信息</li>
    </ul>
</div>

<form action="${pageContext.request.contextPath }/finance/studentpayment/updateStudentPayment.action" class="form-horizontal">
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="修改"/>
            <a href="${pageContext.request.contextPath }/finance/studentpayment/listStudentPayment.action" class="btn btn-success">返回上一级</a>
        </div>
    </div>
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">缴费编号</label>
                <div class="col-sm-9">
                	<input type="text" name="paymentId" value="${StudentPayment.paymentId} " readOnly="readonly" class="form-control input-sm" placeholder="请输入编号"/>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">学员姓名</label>
                <div class="col-sm-4">
                	<select class="form-control input-sm" name="studentId">
						<option value="">请选择</option>
						<c:forEach items="${studentlist}" var="stu">
							<option value="${stu.studentId}" ${stu.studentId==studentPayment.studentId?'selected':''}>${stu.studentName}</option>
						</c:forEach>
					</select>
                </div>
            </div>
        </div>
    </div>
    	<!--开始 -->
    <div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">经办员工姓名</label>
                <div class="col-sm-4">
					<select class="form-control input-sm" name="staffId">
						<option value="">请选择</option>
						<c:forEach items="${stafflist}" var="sta">
							<option value="${sta.staffId}"   ${sta.staffId==studentPayment.staffId?'selected':''}   >${sta.staffName}</option>
						</c:forEach>
					</select>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">缴费情况</label>
                <div class="col-sm-5">
                	<input type="text" name="paymentSitutation" value="${StudentPayment.paymentSitutation}" class="form-control input-sm" />
                </div>
            </div>
        </div>
    </div>
   <!--结束 -->
       	<!--开始 -->
    	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">缴费方式</label>
                <div class="col-sm-9">
                	<input type="text" name="paymentMenthod" value="${StudentPayment.paymentMenthod}" class="form-control input-sm" />
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">缴费时间</label>
                <div class="col-sm-9">
                	<input type="text" name="paymentTime"   value="<fmt:formatDate value="${StudentPayment.paymentTime}" pattern="yyyy-MM-dd" type="both"/>"  onclick="WdatePicker()" readonly="readonly"  class="form-control input-sm" />
                </div>
            </div>
        </div>
    </div>
   <!--结束 -->
    <!--开始 -->
    	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">优惠金额</label>
                <div class="col-sm-9">
                	<input type="text" name="paymentDiscountAmount" value="${StudentPayment.paymentDiscountAmount}" class="form-control input-sm" />
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">应缴金额</label>
                <div class="col-sm-9">
                	<input type="text" name="paymentShouldAmount" value="${StudentPayment.paymentShouldAmount}" class="form-control input-sm" />
                </div>
            </div>
        </div>
    </div>
   <!--结束 -->
   <!--开始 -->
    	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">实缴金额</label>
                <div class="col-sm-9">
                	<input type="text" name="paymentRealAmount" value="${StudentPayment.paymentRealAmount}" class="form-control input-sm" />
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">欠款</label>
                <div class="col-sm-9">
                	<input type="text" name="paymentDebtAmount" value="${StudentPayment.paymentDebtAmount}" class="form-control input-sm" />
                </div>
            </div>
        </div>
    </div>
   <!--结束 -->

         
            
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">描述信息</h5>
    <div class="row">
    	<div class="col-sm-10">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">备注</label>
                <div class="col-sm-9">
                	<textarea class="form-control" name="paymentRemark">${StudentPayment.paymentRemark }</textarea>
                </div>
            </div>
        
        </div>

    </div>
 
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="修改"/>
            <a href="${pageContext.request.contextPath }/finance/studentpayment/listStudentPayment.action" class="btn btn-success">返回上一级</a>
        </div>
    </div>
</form>

</body>
</html>
