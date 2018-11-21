package com.guigu.instructional.marketactive.service;
/**       
 * 营销活动相关
 */

import java.util.List;

import com.guigu.instructional.po.MarketActive;

public interface MarketActiveService {

	// 添加活动内容
	public boolean addMarketActive(MarketActive marketActive);

	// 删除活动内容
	public boolean deleteMarketActive(Integer activeId);
	
	// 修改活动内容
	public boolean updateMarketActive(MarketActive marketActive);

	// 根据编号获取相应的活动内容
	public MarketActive getMarketActive(Integer activeId);

	// 获取所有的活动内容
	public List<MarketActive> getMarketActiveList(MarketActive marketActive);

}
