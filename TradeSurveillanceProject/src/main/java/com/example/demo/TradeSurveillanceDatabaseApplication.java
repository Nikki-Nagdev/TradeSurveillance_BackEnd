package com.example.demo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.detection.DetectionAlgo;
import com.generator.GenerateTradeList;
import com.pojo.Trade;


@SpringBootApplication(scanBasePackages = "com")
@EntityScan(basePackages = "com")
@EnableJpaRepositories(basePackages = "com")
public class TradeSurveillanceDatabaseApplication {

	public static void main(String[] args) {
		List<Trade>li = new ArrayList<>();
		GenerateTradeList g = new GenerateTradeList();
		li = g.Generate();
		DetectionAlgo d = new DetectionAlgo();
		ArrayList<ArrayList<Trade>> arr = d.DetectionAl(li);
		for(int i = 0;i<arr.size();i++)
		{
			System.out.println("Front Running Scenario");
			System.out.println(i+1);
			for(int j = 0;j<arr.get(i).size();j++)
			{
				if(j == 0)
				{
					System.out.println("Firm Trade");
					System.out.println(arr.get(i).get(j).toString());
				}
				else if(j == 1)
				{
					System.out.println("Customer Trade");
					System.out.println(arr.get(i).get(j).toString());
				}
				else
				{
					System.out.println("Firm Trade");
					System.out.println(arr.get(i).get(j).toString());
			
				}
			}
		}
    
    }
}


