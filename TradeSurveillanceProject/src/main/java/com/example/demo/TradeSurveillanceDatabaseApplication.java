package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.detection.DetectionAlgo;
import com.generator.GenerateTradeList;
import com.pojo.TradeList;

@SpringBootApplication(scanBasePackages = "com")
@EntityScan(basePackages = "com")
@EnableJpaRepositories(basePackages = "com")
public class TradeSurveillanceDatabaseApplication {

	public static void main(String[] args) {
		List<TradeList>li = new ArrayList<>();
		GenerateTradeList g = new GenerateTradeList();
		li = g.Generate();
		DetectionAlgo d = new DetectionAlgo();
		System.out.println(d.DetectionAl(li));
    
    }
}


