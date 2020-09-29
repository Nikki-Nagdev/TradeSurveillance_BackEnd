package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	@PostMapping("/trades/add")
	public ResponseEntity<Trade> saveTrade(@RequestBody Trade trade) {

		Trade added = dao.save(trade);
		
		System.out.println(trade);
		ResponseEntity<Trade> response = new ResponseEntity<Trade>(added, HttpStatus.CREATED);

		return response;
	}

	@GetMapping("/trades")
	public ResponseEntity<List<Trade>> findAllTrades() {

		List<Trade> trade = dao.findAll();
		ResponseEntity<List<Trade>> response = new ResponseEntity<List<Trade>>(trade, HttpStatus.FOUND);

		return response;
	}
	
	

}
