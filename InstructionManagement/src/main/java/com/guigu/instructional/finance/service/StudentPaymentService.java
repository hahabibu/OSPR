package com.guigu.instructional.finance.service;


import java.util.List;

import com.guigu.instructional.po.StudentPayment;

/**       
 * <p>project_name:GuiguManager</p>
 * <p>package_name:com.tmt.instructional.system.service.StudentPaymentService</p>
 * <p>description：</p>
 * <p>@author：童梦涛<p>   
 * <p> date:2018年8月18日上午11:17:52 </p>
 * <p>comments：    </p>
 * <p>@version  jdk1.9</p>
 * 
 * <p>Copyright (c) 2018, 493352276@qq.com All Rights Reserved. </p>    
 */

public interface StudentPaymentService {

	public boolean addStudentPayment(StudentPayment studentPayment);
	
	public boolean updateStudentPayment(StudentPayment studentPayment);
	
	public boolean deleteStudentPayment(int paymentId);
	
	public List<StudentPayment> getStudentPaymentList(StudentPayment studentPayment);
	
	public StudentPayment getStudentPaymentByPaymentId(int paymentId);
}


