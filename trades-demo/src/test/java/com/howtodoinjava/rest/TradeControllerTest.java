package com.howtodoinjava.rest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import com.trades.rest.SpringBootDemoApplication;
import com.trades.rest.model.Trade;
import com.trades.rest.services.TradeService;

import com.trades.rest.controller.TradeController;

@SpringBootTest(classes = SpringBootDemoApplication.class, 
webEnvironment = WebEnvironment.RANDOM_PORT)
public class TradeControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;
	
	@MockBean
	TradeController tradeController;
	
	@MockBean
	private TradeService tradeService ;
	
	@Test
	public void testGetAllTrade() {	
		 Trade t1 = new Trade ();
		 t1.setBookId("B1");
		 t1.setCounterPartyId("CP1");
		 t1.setCreatedDate("12/04/2021");
		 t1.setExpired('N');
		 t1.setMaturityDate("12/04/2021");
		 t1.setId(1);
		 List<Trade> tradeList = new ArrayList<Trade>();
		 tradeList.add(t1);
		 Mockito.when(
				 tradeService.getAllTrade()).thenReturn(tradeList);
		 assertTrue(tradeList.size()>0); 
				
	}
}
