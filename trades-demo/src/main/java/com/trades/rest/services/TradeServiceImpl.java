/**
 * 
 */
package com.trades.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trades.rest.model.Trade;
import com.trades.rest.repository.TradeRepository;

/**
 * This class work as Service class for Trade functionality .
 *it provides the functionality for saving/fetching trades
 *
 * @author Siddharth S
 * @version 1.0
 * @since 2021-04-08
 */

@Service("tradeService")
public class TradeServiceImpl implements TradeService {

	@Autowired
	private TradeRepository tradeRepository;

	@Override
	public List<Trade> getAllTrade() {
		return tradeRepository.findAll();
	}
	
	@Override
	public Trade saveTrade(Trade trade) {
     	return tradeRepository.save(trade);
	}

	@Override
	public List<Trade> findByTradeId(String tradeId) {
		return tradeRepository.findByTradeId(tradeId);		
	}
	
	@Override
	public List<Trade> updateAllTrade(List<Trade> trades) {
     	return tradeRepository.saveAll(trades);
	}

}
