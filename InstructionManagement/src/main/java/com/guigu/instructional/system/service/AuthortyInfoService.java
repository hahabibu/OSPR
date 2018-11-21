package com.guigu.instructional.system.service;

import java.util.List;

import com.guigu.instructional.po.AuthortyInfo;
import com.guigu.instructional.po.StaffInfo;

/**       
 * <p>project_name:GuiguManager</p>
 * <p>package_name:com.tmt.instructional.system.service.AnthortyInfoService</p>
 * <p>description：</p>
 * <p>@author：童梦涛<p>   
 * <p> date:2018年8月17日上午10:37:49 </p>
 * <p>comments：    </p>
 * <p>@version  jdk1.9</p>
 * 
 * <p>Copyright (c) 2018, 493352276@qq.com All Rights Reserved. </p>    
 */

public interface AuthortyInfoService {

	public boolean addAuthortyInfo(AuthortyInfo authortyInfo);
	
	public boolean updateAuthortyInfo(AuthortyInfo authortyInfo);
	
	public boolean deleteAuthortyInfo(int authortyId);
	
	public List<AuthortyInfo> getAuthotryInfoList(AuthortyInfo authortyInfo);
	
	public AuthortyInfo getAuthortyInfo(int authortyId);
	
	public StaffInfo getStaffInfoByAuthorty(int authortyId);
}


