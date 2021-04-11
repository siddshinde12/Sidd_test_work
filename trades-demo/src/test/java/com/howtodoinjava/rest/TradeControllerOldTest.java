package com.howtodoinjava.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;



import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.trades.rest.controller.TradeController;
import com.trades.rest.model.Trade;
import com.trades.rest.services.TradeService;



@ExtendWith(MockitoExtension.class)
@WebMvcTest(value = TradeController.class)
public class TradeControllerOldTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TradeService tradeService ;
	

	public void getAllTradeTest() throws Exception{
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
	 
	 RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/trade").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
	 	
	}


}
