package com.guigu.instructional.system.service;

import java.util.List;

import com.guigu.instructional.po.RoleInfo;

/**       
 * <p>project_name:GuiguManager</p>
 * <p>package_name:com.tmt.instructional.system.service.RoleInfoService</p>
 * <p>description：</p>
 * <p>@author：童梦涛<p>   
 * <p> date:2018年8月16日上午10:33:14 </p>
 * <p>comments：    </p>
 * <p>@version  jdk1.9</p>
 * 
 * <p>Copyright (c) 2018, 493352276@qq.com All Rights Reserved. </p>    
 */

public interface RoleInfoService {

	public boolean addRoleInfo(RoleInfo roleInfo);
	
	public boolean updateRoleInfo(RoleInfo roleInfo);
	
	public List<RoleInfo> getRoleInfoList(RoleInfo roleInfo);
	
	public RoleInfo getRoleInfo(Integer roleId);
}


