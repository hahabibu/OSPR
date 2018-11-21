package com.guigu.instructional.marketactive.service;

import java.util.List;

import com.guigu.instructional.po.MessageInfo;

/**       
 * 短信管理相关  
 */

public interface MessageInfoService {

	// 添加短信内容
	public boolean addMessageInfo(MessageInfo messageInfo);
	
	// 删除短信内容
	public boolean deleteMessageInfo(Integer messageId1);
	
	// 根据编号获取相应的短信内容
	public MessageInfo getMessageInfo(Integer messageId1);
	
	// 获取所有的短信内容
	public List<MessageInfo> getMessageInfoList(MessageInfo messageInfo);
	
}


