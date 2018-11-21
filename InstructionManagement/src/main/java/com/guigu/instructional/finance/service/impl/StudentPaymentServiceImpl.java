package com.guigu.instructional.finance.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guigu.instructional.finance.service.StudentPaymentService;
import com.guigu.instructional.finance.mapper.StudentPaymentMapper;
import com.guigu.instructional.po.StudentPayment;
import com.guigu.instructional.po.StudentPaymentExample;
import com.guigu.instructional.po.StudentPaymentExample.Criteria;

/**       
 * <p>project_name:GuiguManager</p>
 * <p>package_name:com.tmt.instructional.finance.service.impl.StudentPaymentServiceImpl</p>
 * <p>description：</p>
 * <p>@author：童梦涛<p>   
 * <p> date:2018年8月18日上午11:18:04 </p>
 * <p>comments：    </p>
 * <p>@version  jdk1.9</p>
 * 
 * <p>Copyright (c) 2018, 493352276@qq.com All Rights Reserved. </p>    
 */
@Service("studentPaymentServiceImpl")
@Transactional
public class StudentPaymentServiceImpl implements StudentPaymentService {

	@Resource(name="studentPaymentMapper")
	private StudentPaymentMapper studentPaymentMapper;
	
	@Override
	public boolean addStudentPayment(StudentPayment studentPayment) {
		int i=studentPaymentMapper.insertSelective(studentPayment);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateStudentPayment(StudentPayment studentPayment) {
		int i=studentPaymentMapper.updateByPrimaryKey(studentPayment);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteStudentPayment(int paymentId) {
		int i=studentPaymentMapper.deleteByPrimaryKey(paymentId);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public List<StudentPayment> getStudentPaymentList(StudentPayment studentPayment) {
		StudentPaymentExample studentPaymentExample =new StudentPaymentExample();
		Criteria criteria=studentPaymentExample.createCriteria();
		if(studentPayment!=null) {
			if(studentPayment.getPaymentId()!=null) {
				criteria.andPaymentIdEqualTo(studentPayment.getPaymentId());
			}
		}
		
		criteria.andPaymentIdIsNotNull();
		return studentPaymentMapper.selectByExample(studentPaymentExample);
	}

	@Override
	public StudentPayment getStudentPaymentByPaymentId(int paymentId) {
		
		return studentPaymentMapper.selectByPrimaryKey(paymentId);
	}

}


