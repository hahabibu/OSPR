package com.guigu.instructional.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guigu.instructional.po.RoleInfo;
import com.guigu.instructional.po.RoleInfoExample;
import com.guigu.instructional.po.RoleInfoExample.Criteria;
import com.guigu.instructional.system.mapper.RoleInfoMapper;
import com.guigu.instructional.system.service.RoleInfoService;

/**       
 * <p>project_name:GuiguManager</p>
 * <p>package_name:com.tmt.instructional.system.service.impl.RoleInfoServiceImpl</p>
 * <p>description：</p>
 * <p>@author：童梦涛<p>   
 * <p> date:2018年8月16日上午10:34:51 </p>
 * <p>comments：    </p>
 * <p>@version  jdk1.9</p>
 * 
 * <p>Copyright (c) 2018, 493352276@qq.com All Rights Reserved. </p>    
 */

@Service("roleInfoServiceImpl")
@Transactional
public class RoleInfoServiceImpl implements RoleInfoService{
	
	@Resource(name="roleInfoMapper")
	private RoleInfoMapper roleInfoMapper;
	
	@Override
	public boolean addRoleInfo(RoleInfo roleInfo) {
		
		int i=roleInfoMapper.insertSelective(roleInfo);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateRoleInfo(RoleInfo roleInfo) {
		
		int i=roleInfoMapper.updateByPrimaryKeySelective(roleInfo);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public List<RoleInfo> getRoleInfoList(RoleInfo roleInfo) {
		RoleInfoExample roleInfoExample=new RoleInfoExample();
		Criteria criteria =roleInfoExample.createCriteria();
		
		if(roleInfo!=null) {
			if(roleInfo.getRoleId()!=null) {
				criteria.andRoleIdEqualTo(roleInfo.getRoleId());
			}
			if(roleInfo.getRoleName()!=null){
				criteria.andRoleNameLike("%"+roleInfo.getRoleName()+"%");
			}
			
		}
		
		criteria.andRoleStateEqualTo("1");
		return roleInfoMapper.selectByExample(roleInfoExample);
	}

	@Override
	public RoleInfo getRoleInfo(Integer roleId) {
		
		return roleInfoMapper.selectByPrimaryKey(roleId);
	}

}


