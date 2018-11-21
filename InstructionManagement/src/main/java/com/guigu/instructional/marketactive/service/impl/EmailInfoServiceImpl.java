package com.guigu.instructional.marketactive.service.impl;
/**       
 * 邮件管理相关
 */

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guigu.instructional.marketactive.mapper.EmailInfoMapper;
import com.guigu.instructional.marketactive.service.EmailInfoService;
import com.guigu.instructional.po.EmailInfo;
import com.guigu.instructional.po.EmailInfoExample;
import com.guigu.instructional.po.EmailInfoExample.Criteria;

@Service("emailInfoServiceImpl")
@Transactional
public class EmailInfoServiceImpl implements EmailInfoService {
	
	@Resource(name="emailInfoMapper")
	private EmailInfoMapper emailInfoMapper;

	@Override
	public boolean addEmailInfo(EmailInfo emailInfo) {
		int i=emailInfoMapper.insertSelective(emailInfo);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteEmailInfo(Integer emailId) {
		int i=emailInfoMapper.deleteByPrimaryKey(emailId);
		if(i>0) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean updateEmailInfo(EmailInfo emailInfo) {
		int i=emailInfoMapper.updateByPrimaryKeySelective(emailInfo);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public EmailInfo getEmailInfo(Integer emailId) {
		return emailInfoMapper.selectByPrimaryKey(emailId);
	}

	@Override
	public List<EmailInfo> getEmailInfoList(EmailInfo emailInfo) {
		EmailInfoExample emailInfoExample = new EmailInfoExample();
		Criteria criteria = emailInfoExample.createCriteria();
		if(emailInfo!=null) {
			// 根据邮件主题进行查找
			if(emailInfo.getEmailTitle()!=null&&!emailInfo.getEmailTitle().equals("")) {
				criteria.andEmailTitleLike("%"+emailInfo.getEmailTitle()+"%");
			}
			// 根据邮件发送状态进行查找
			if(emailInfo.getEmailState()!=null&&!emailInfo.getEmailState().equals("")) {
				criteria.andEmailStateEqualTo(emailInfo.getEmailState());
			}
		}
		return emailInfoMapper.selectByExample(emailInfoExample);
	}

}


