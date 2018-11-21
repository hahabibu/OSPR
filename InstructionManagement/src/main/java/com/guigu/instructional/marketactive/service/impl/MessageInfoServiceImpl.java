package com.guigu.instructional.marketactive.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guigu.instructional.marketactive.mapper.MessageInfoMapper;
import com.guigu.instructional.marketactive.service.MessageInfoService;
import com.guigu.instructional.po.MessageInfo;
import com.guigu.instructional.po.MessageInfoExample;
import com.guigu.instructional.po.MessageInfoExample.Criteria;

/**       
 * 短信管理相关
 */

@Service("messageInfoServiceImpl")
@Transactional()
public class MessageInfoServiceImpl implements MessageInfoService{
	
	@Resource(name="messageInfoMapper")
	private MessageInfoMapper messageInfoMapper;

	@Override
	public boolean addMessageInfo(MessageInfo messageInfo) {
		int i=messageInfoMapper.insertSelective(messageInfo);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteMessageInfo(Integer messageId1) {
		int i=messageInfoMapper.deleteByPrimaryKey(messageId1);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public MessageInfo getMessageInfo(Integer messageId1) {
		return messageInfoMapper.selectByPrimaryKey(messageId1);
	}

	@Override
	public List<MessageInfo> getMessageInfoList(MessageInfo messageInfo) {
		// 封装数据
		MessageInfoExample messageInfoExample = new MessageInfoExample();
		Criteria criteria = messageInfoExample.createCriteria();
		if(messageInfo!=null) {
			if(messageInfo.getMessagePhone()!=null) {
				criteria.andMessagePhoneLike("%"+messageInfo.getMessagePhone()+"%");
			}
			if(messageInfo.getMessageState()!=null) {
				criteria.andMessageStateEqualTo(messageInfo.getMessageState());
			}
		}
		return messageInfoMapper.selectByExample(messageInfoExample);
	}
	
}


