package com.guigu.instructional.finance.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guigu.instructional.finance.service.StaffSalaryService;
import com.guigu.instructional.finance.mapper.StaffSalaryMapper;
import com.guigu.instructional.po.StaffSalary;
import com.guigu.instructional.po.StaffSalaryExample;
import com.guigu.instructional.po.StaffSalaryExample.Criteria;

/**       
 * <p>project_name:GuiguManager</p>
 * <p>package_name:com.tmt.instructional.finance.service.impl.StaffSalaryServiceImpl</p>
 * <p>description：</p>
 * <p>@author：童梦涛<p>   
 * <p> date:2018年8月19日下午9:55:37 </p>
 * <p>comments：    </p>
 * <p>@version  jdk1.9</p>
 * 
 * <p>Copyright (c) 2018, 493352276@qq.com All Rights Reserved. </p>    
 */

@Service("staffSalaryServiceImpl")
@Transactional
public class StaffSalaryServiceImpl  implements StaffSalaryService{

	@Resource(name="staffSalaryMapper")
	private StaffSalaryMapper staffSalaryMapper;

	@Override
	public boolean addStaffSalary(StaffSalary staffSalary) {
		int i=staffSalaryMapper.insert(staffSalary);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateStaffSalary(StaffSalary staffSalary) {

		int i=staffSalaryMapper.updateByPrimaryKeySelective(staffSalary);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteStaffSalary(int staffSalaryId) {
		int i=staffSalaryMapper.deleteByPrimaryKey(staffSalaryId);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public List<StaffSalary> getStaffSalaryList(StaffSalary staffSalary) {
		
		StaffSalaryExample staffSalaryExample =new StaffSalaryExample();
		Criteria criteria=staffSalaryExample.createCriteria();
		if(staffSalary!=null) {
			if(staffSalary.getStaffSalaryId()!=null) {
				criteria.andStaffSalaryIdEqualTo(staffSalary.getStaffSalaryId());
			}
			if(staffSalary.getStaStaffId()!=null) {
				criteria.andStaStaffIdEqualTo(staffSalary.getStaStaffId());
			}
		}
		
		criteria.andStaffSalaryIdIsNotNull();
		return staffSalaryMapper.selectByExample(staffSalaryExample);
	}

	@Override
	public StaffSalary getStaffSalaryById(int staffSalaryId) {
		
		return staffSalaryMapper.selectByPrimaryKey(staffSalaryId);
	}
	


}


