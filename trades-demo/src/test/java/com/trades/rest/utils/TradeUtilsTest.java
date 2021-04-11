package com.trades.rest.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.trades.rest.model.Trade;

class TradeUtilsTest {

	@Test
	void testGetMaxVersion() {
		Trade t1 = new Trade();
		t1.setBookId("B1");
		t1.setCounterPartyId("CP1");
		t1.setCreatedDate("12/04/2021");
		t1.setExpired('N');
		t1.setMaturityDate("12/04/2021");
		t1.setId(1);
		t1.setVersion(1);

		Trade t2 = new Trade();
		t2.setBookId("B1");
		t2.setCounterPartyId("CP1");
		t2.setCreatedDate("12/04/2021");
		t2.setExpired('N');
		t2.setMaturityDate("12/04/2021");
		t2.setId(1);
		t2.setVersion(2);

		List<Trade> tradeList = new ArrayList<Trade>();
		tradeList.add(t1);
		tradeList.add(t2);

		assertEquals(2, TradeUtils.getMaxVersion(tradeList).getVersion());
	}

}
