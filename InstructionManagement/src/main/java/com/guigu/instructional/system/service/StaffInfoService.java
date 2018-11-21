package com.guigu.instructional.system.service;

import java.util.List;

import com.guigu.instructional.po.StaffInfo;

/**       
 * 员工管理
 */

public interface StaffInfoService {
	
	// 添加员工信息
	public boolean addStaff(StaffInfo staffInfo);
	
	// 修改员工信息
	public boolean updateStaff(StaffInfo staffInfo);
	
	// 删除员工信息
	public boolean deleteStaff(Integer staffId);
	
	// 根据id获取员工信息
	public StaffInfo getStaffInfo(Integer staffId);
	
	// 获取员工信息列表
	public List<StaffInfo> getStaffInfoList(StaffInfo staffInfo);
	
}


