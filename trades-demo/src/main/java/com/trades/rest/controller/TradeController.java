/**
 * 
 */
package com.trades.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trades.rest.exception.TradeException;
import com.trades.rest.model.Trade;
import com.trades.rest.services.*;
import com.trades.rest.utils.TradeUtils;
import com.trades.rest.utils.TradeValidator;


/**
 * This class work as RestController for Trade functionality .
 *
 * @author Siddharth S
 * @version 1.0
 * @since 2021-04-08
 */

@RestController
public class TradeController {

	private static final Logger logger = LoggerFactory.getLogger(TradeController.class);

	@Autowired
	private TradeService tradeService;
	
	
		/**
	   * This is used as rest api saving/updating the trades .
	   * @param trade Unused.
	   * @return ResponseEntity.
	   * @exception TradeException On input error.
	   * @see TradeException
	   */

	@RequestMapping(value = "/trade", method = RequestMethod.POST)
	public ResponseEntity<Trade> saveTrade(@RequestBody Trade trade) throws TradeException {
		logger.info("Trade to save " + trade);

		List<Trade> tradeList = tradeService.findByTradeId(trade.getTradeId());
		Trade oldTrade = null;

		if (tradeList.size() > 0) {
			oldTrade = TradeUtils.getMaxVersion(tradeList);
		}
		//TradeValidator.validate(trade, tradeList);
		
		if (oldTrade != null && oldTrade.getVersion() == trade.getVersion()) {
			oldTrade.setBookId(trade.getBookId());
			oldTrade.setCounterPartyId(trade.getCounterPartyId());
			return new ResponseEntity<Trade>(tradeService.saveTrade(oldTrade), HttpStatus.OK);
		}

		return new ResponseEntity<Trade>(tradeService.saveTrade(trade), HttpStatus.CREATED);
	}

	
	  /**
	   * This is used as rest api for fetching all trades .
	   * @param  .
	   * @return ResponseEntity.
	   * @see TradeException
	   */
	@RequestMapping(value = "/trades", method = RequestMethod.GET)
	public ResponseEntity<List<Trade>> getAllTrade() {

		return new ResponseEntity<List<Trade>>(tradeService.getAllTrade(), HttpStatus.OK);

	}
	
	  /**
	   * This is used to update the version which are expired.
	   * @param  .
	   * @return ResponseEntity.
	   * @see TradeException
	   */
	@RequestMapping(value = "/invoketrades", method = RequestMethod.GET)
	public ResponseEntity<List<Trade>> invokeTrades() {
		List<Trade> trades = tradeService.getAllTrade();		
		for (Trade trade : trades) {
			if(TradeValidator.isNotValidMaturityDate(trade.getMaturityDate())) {
				trade.setExpired('Y');
			}
		}
		tradeService.updateAllTrade(trades);
		return new ResponseEntity<List<Trade>>(tradeService.getAllTrade(), HttpStatus.OK);

	}

}
