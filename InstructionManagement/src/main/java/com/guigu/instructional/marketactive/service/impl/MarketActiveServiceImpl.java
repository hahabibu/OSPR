package com.guigu.instructional.marketactive.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guigu.instructional.marketactive.mapper.MarketActiveMapper;
import com.guigu.instructional.marketactive.service.MarketActiveService;
import com.guigu.instructional.po.MarketActive;
import com.guigu.instructional.po.MarketActiveExample;
import com.guigu.instructional.po.MarketActiveExample.Criteria;

/**       
 * 营销活动相关    
 */
@Service("marketActiveServiceImpl")
@Transactional
public class MarketActiveServiceImpl implements MarketActiveService{

	@Resource(name="marketActiveMapper")
	private MarketActiveMapper marketActiveMapper;
	
	@Override
	public boolean addMarketActive(MarketActive marketActive) {
		int i = marketActiveMapper.insertSelective(marketActive);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteMarketActive(Integer activeId) {
		int i = marketActiveMapper.deleteByPrimaryKey(activeId);
		if(i>0) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean updateMarketActive(MarketActive marketActive) {
		int i = marketActiveMapper.updateByPrimaryKeySelective(marketActive);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public MarketActive getMarketActive(Integer activeId) {
		return marketActiveMapper.selectByPrimaryKey(activeId);
	}

	@Override
	public List<MarketActive> getMarketActiveList(MarketActive marketActive) {
		MarketActiveExample marketActiveExample = new MarketActiveExample();
		Criteria criteria = marketActiveExample.createCriteria();
		if(marketActive!=null) {
			if(marketActive.getActiveName()!=null) {
				if(!marketActive.getActiveName().equals("")) {
					criteria.andActiveNameLike("%"+marketActive.getActiveName()+"%");
				}
			}
			if(marketActive.getActiveState()!=null) {
				if(marketActive.getActiveState()!=-1) {
					criteria.andActiveStateEqualTo(marketActive.getActiveState());
				}
			}
		}
		return marketActiveMapper.selectByExample(marketActiveExample);
	}

}


