package com.guigu.instructional.marketactive.service;

import java.util.List;

import com.guigu.instructional.po.EmailInfo;

/**
 * 邮件管理相关
 */

public interface EmailInfoService {

	// 添加邮件内容
	public boolean addEmailInfo(EmailInfo emailInfo);

	// 删除邮件内容
	public boolean deleteEmailInfo(Integer emailId);
	
	// 修改邮件信息
	public boolean updateEmailInfo(EmailInfo emailInfo);

	// 根据编号获取相应的邮件内容
	public EmailInfo getEmailInfo(Integer emailId);

	// 获取所有的邮件内容
	public List<EmailInfo> getEmailInfoList(EmailInfo emailInfo);

}
