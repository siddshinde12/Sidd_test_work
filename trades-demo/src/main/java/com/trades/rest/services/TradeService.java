/**
 * 
 */
package com.trades.rest.services;

import java.util.List;

import com.trades.rest.model.Trade;

/**
 * @author Siddharth
 *
 */
public interface TradeService {
	
	public List<Trade> getAllTrade();
	public Trade saveTrade(Trade todo);
	public List<Trade> findByTradeId(String tradeId);
	public List<Trade> updateAllTrade(List<Trade> trades);

}
