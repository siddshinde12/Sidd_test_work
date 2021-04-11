/**
 * 
 */
package com.trades.rest.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.trades.rest.model.Trade;

/**
 * This class work as utils class for Trade functionality .It defines a number
 * of useful utility methods
 *
 * @author Siddharth S
 * @version 1.0
 * @since 2021-04-08
 */

public class TradeUtils {

	/**
	 * This method is used to find max version of trades.
	 * 
	 * @param trades 
	 * @return trade This returns trade with max version number .
	 */
	public static Trade getMaxVersion(List<Trade> trades) {

		return trades.stream().max(Comparator.comparing(Trade::getVersion)).get();

	}

	/**
	 * This method is used to find max version of trades.
	 * 
	 * @param trades 
	 * @return trade This returns trade with max version number .
	 */
	public static Date parseDate(String date) {

		Date formattedDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			formattedDate = sdf.parse(date);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return formattedDate;
	}


}
