package com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pojo.Trade;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Integer>{
	 
 public List<Trade> findByIsChecked(Boolean a);

}
