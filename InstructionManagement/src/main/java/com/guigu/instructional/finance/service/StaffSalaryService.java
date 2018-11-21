package com.guigu.instructional.finance.service;

import java.util.List;

import com.guigu.instructional.po.StaffSalary;

/**       
 * <p>project_name:GuiguManager</p>
 * <p>package_name:com.tmt.instructional.system.service.StaffSalaryService</p>
 * <p>description：</p>
 * <p>@author：童梦涛<p>   
 * <p> date:2018年8月19日下午9:45:44 </p>
 * <p>comments：    </p>
 * <p>@version  jdk1.9</p>
 * 
 * <p>Copyright (c) 2018, 493352276@qq.com All Rights Reserved. </p>    
 */

public interface StaffSalaryService {

	public boolean addStaffSalary(StaffSalary staffSalary);
	
	public boolean updateStaffSalary(StaffSalary staffSalary);
	
	public boolean deleteStaffSalary(int staffSalaryId);
	
	public List<StaffSalary> getStaffSalaryList(StaffSalary staffSalary );
	
	public StaffSalary getStaffSalaryById(int staffSalaryId);
}


