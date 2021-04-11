package com.trades.rest.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.trades.rest.exception.TradeException;
import com.trades.rest.model.Trade;

/**
 * This class is uded to validate input data.
 *
 * @author Siddharth S
 * @version 1.0
 * @since 2021-04-08
 */


public class TradeValidator {
	
	private static String DATE_FORMAT = "dd/MM/yyyy";
	
	/**
	 * This method is used to validate Trade.
	 * maturityDate can not be lesser than current date 
	 * current version can not be lower than to max version
	 * @param trade 
	 * * @param tradeList 
	 * @return boolean
	 */
	public static boolean validate(Trade trade,List<Trade> tradeList) throws TradeException{
		
		 if (isNotValidMaturityDate(trade.getMaturityDate())) {
			 throw new TradeException("maturity date can not be less than today date");
		 }
		 if (tradeList.size()> 0) {
		    if ( trade.getVersion() < TradeUtils.getMaxVersion(tradeList).getVersion() ) {
		    	 throw new TradeException("Trade lower version not allowed ");
		     }
		 }		 
		return true;
	}

	/**
	 * This method is used to validate maturityDate.
	 * maturityDate can not be lower than current date
	 * @param maturityDate 
	 * @return boolean
	 */
	public static boolean isNotValidMaturityDate(String maturityDate) {

		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		String todayDate = sdf.format(new Date());
		Date currentDate = null;
		try {
			currentDate = sdf.parse(todayDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return TradeUtils.parseDate(maturityDate).before(currentDate);

	}
}
