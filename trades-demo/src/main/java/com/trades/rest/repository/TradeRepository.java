/**
 * 
 */
package com.trades.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trades.rest.model.Trade;

/**
 * This class work as Repository class for Trade functionality .
 *
 *
 * @author Siddharth S
 * @version 1.0
 * @since 2021-04-08
 */

@Repository("tradeRepository")
public interface TradeRepository extends JpaRepository<Trade, Long> {
	public List<Trade> findByTradeId(String tradeId);

}
