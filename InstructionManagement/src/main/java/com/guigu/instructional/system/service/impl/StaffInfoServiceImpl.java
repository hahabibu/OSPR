package com.guigu.instructional.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guigu.instructional.po.StaffInfo;
import com.guigu.instructional.po.StaffInfoExample;
import com.guigu.instructional.po.StaffInfoExample.Criteria;
import com.guigu.instructional.system.mapper.StaffInfoMapper;
import com.guigu.instructional.system.service.StaffInfoService;

/**       
 * 员工管理实现类
 */
@Service("staffInfoServiceImpl")
@Transactional
public class StaffInfoServiceImpl implements StaffInfoService{
	
	@Resource(name="staffInfoMapper")
	private StaffInfoMapper staffInfoMapper;

	@Override
	public boolean addStaff(StaffInfo staffInfo) {
		int i = staffInfoMapper.insertSelective(staffInfo);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateStaff(StaffInfo staffInfo) {
		int i=staffInfoMapper.updateByPrimaryKeySelective(staffInfo);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteStaff(Integer staffId) {
		int i=staffInfoMapper.deleteByPrimaryKey(staffId);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public StaffInfo getStaffInfo(Integer staffId) {
		return staffInfoMapper.selectByPrimaryKey(staffId);
	}

	@Override
	public List<StaffInfo> getStaffInfoList(StaffInfo staffInfo) {
		StaffInfoExample staffInfoExample = new StaffInfoExample();
		// 创建员工查询的对象Criteria
		Criteria criteria = staffInfoExample.createCriteria();
		if(staffInfo!=null) {
			// 根据员工编号进行查询
			if(staffInfo.getStaffId()!=null) {
				criteria.andStaffIdEqualTo(staffInfo.getStaffId());
			}
			// 根据员工姓名查询
			if(staffInfo.getStaffName()!=null) {
				criteria.andStaffNameLike("%"+staffInfo.getStaffName()+"%");
			}
			// 根据员工手机号信息查询
			if(staffInfo.getStaffMobilePhone()!=null) {
				criteria.andStaffMobilePhoneEqualTo(staffInfo.getStaffMobilePhone());
			}
			// 根据员工的角色编号进行查找
			if(staffInfo.getRoleId()!=null) {
				criteria.andRoleIdEqualTo(staffInfo.getRoleId());
			}
			// 查询有效的员工信息:设定0为无效状态、1为有效状态
			criteria.andStaffStateEqualTo("1");
		}
		return staffInfoMapper.selectByExample(staffInfoExample);
	}

}


