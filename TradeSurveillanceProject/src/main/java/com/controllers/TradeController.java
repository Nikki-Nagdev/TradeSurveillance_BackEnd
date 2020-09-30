package com.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pojo.Trade;
import com.repository.TradeRepository;

@RestController
public class TradeController {
	@Autowired
	TradeRepository dao;
	
	private static final Logger logger = LoggerFactory.getLogger(TradeController.class);

	@PostMapping("/trades/add")
	public ResponseEntity<Trade> saveTrade(@RequestBody Trade trade) {

		Trade added = dao.save(trade);
		
		logger.info("trade added :" + trade);
		// System.out.println(trade);
		ResponseEntity<Trade> response = new ResponseEntity<Trade>(added, HttpStatus.CREATED);

		return response;
	}

	@GetMapping("/trades")
	public ResponseEntity<List<Trade>> findAllTrades() {

		List<Trade> trade = dao.findAll();
		
		if(!trade.isEmpty())
		{ResponseEntity<List<Trade>> response = new ResponseEntity<List<Trade>>(trade,HttpStatus.FOUND);
		logger.info("trades found are :" + response);
		return response;}
		else
		{ResponseEntity<List<Trade>> response = new ResponseEntity<List<Trade>>(trade,HttpStatus.NOT_FOUND);
		logger.info("trades found are :" + response);
		return response;
			
		}
	}
	
	
	


}
