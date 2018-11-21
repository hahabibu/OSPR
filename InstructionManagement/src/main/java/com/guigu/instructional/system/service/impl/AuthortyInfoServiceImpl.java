package com.guigu.instructional.system.service.impl;
/**       
 * <p>project_name:GuiguManager</p>
 * <p>package_name:com.tmt.instructional.system.service.impl.AuthortyInfoServiceImpl</p>
 * <p>description：</p>
 * <p>@author：童梦涛<p>   
 * <p> date:2018年8月17日上午10:59:46 </p>
 * <p>comments：    </p>
 * <p>@version  jdk1.9</p>
 * 
 * <p>Copyright (c) 2018, 493352276@qq.com All Rights Reserved. </p>    
 */

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guigu.instructional.po.AuthortyInfo;
import com.guigu.instructional.po.AuthortyInfoExample;
import com.guigu.instructional.po.AuthortyInfoExample.Criteria;
import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.system.mapper.AuthortyInfoMapper;
import com.guigu.instructional.system.service.AuthortyInfoService;

@Service("authortyInfoServiceImpl")
@Transactional
public class AuthortyInfoServiceImpl implements AuthortyInfoService{

	@Resource(name="authortyInfoMapper")
	private AuthortyInfoMapper authortyInfoMapper;
	
	@Override
	public boolean addAuthortyInfo(AuthortyInfo anthortyInfo) {
		int i=authortyInfoMapper.insertSelective(anthortyInfo);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateAuthortyInfo(AuthortyInfo anthortyInfo) {
		int i=authortyInfoMapper.updateByPrimaryKey(anthortyInfo);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteAuthortyInfo(int authortyId) {
		int i=authortyInfoMapper.deleteByPrimaryKey(authortyId);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public List<AuthortyInfo> getAuthotryInfoList(AuthortyInfo anthortyInfo) {
		AuthortyInfoExample authortyInfoExample=new AuthortyInfoExample();
		
		Criteria criteria=authortyInfoExample.createCriteria();
		if(anthortyInfo!=null) {
			if(anthortyInfo.getAuthortyId()!=null) {
				criteria.andAuthortyIdEqualTo(anthortyInfo.getAuthortyId());
			}if(anthortyInfo.getAuthortyName()!=null) {
				criteria.andAuthortyNameLike("%"+anthortyInfo.getAuthortyName()+"%");   
			}
			// 根据权限等级进行查找(-1是无效的内容，其作为根目录的父级编号)
			if(anthortyInfo.getAuthortyClass()!=null) {
				if(anthortyInfo.getAuthortyClass()!=-1) {
					criteria.andAuthortyClassEqualTo(anthortyInfo.getAuthortyClass());
				}
			}
		}
		
		criteria.andAuthortyIdIsNotNull();
		return authortyInfoMapper.selectByExample(authortyInfoExample);
	}

	@Override
	public AuthortyInfo getAuthortyInfo(int authortyId) {
		
		return authortyInfoMapper.selectByPrimaryKey(authortyId);
	}

	//根据权限id  得到对应的角色id --
	@Override
	public StaffInfo getStaffInfoByAuthorty(int authortyId) {
		
		return null;
	}

}


