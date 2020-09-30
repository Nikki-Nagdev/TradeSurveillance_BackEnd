package com.generator;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Arrays; 
import java.util.Random;

import com.pojo.MarketList;
import com.pojo.TradeList;

public class GenerateTradeList {


	public List<TradeList> Generate()
	{
		MarketList ML=new MarketList();
		double init[] = {115,20,20,120};
		ML.setPrice(init);

		int random;
		int [] cid={1,2,3,200};
		int [] sec={1,2,3,4};
		boolean [] type={true,false};
		int fbr=0; 
		int []fr={1000,1000,1000};


		int arr[] = {100,150,200,250,300,350,400,450,500,550,600,650,700,750,800,850,900,950,1000};  
		int freq[] = {1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,4};  
		int n = arr.length;

		// securityId,security,securityName,currentMarketPrice
		Random rand = new Random();
		random = rand.nextInt(5)+1;
		int a=random;
		//random = 6;
		int [] frindex=new int[random];
		int frpointer=0; 
		for(int i = 0;i<random;i++)
			frindex[i]=rand.nextInt(292);
		
		Arrays.sort(frindex);

		List<TradeList>li = new ArrayList<>();
		Calendar c = Calendar.getInstance();
		for(int i = 0;i<300;i++)
		{
			TradeList t = new TradeList(); 
			t.getTradeExecutionTime().setTime(c.getTime());
			li.add(t);
			//li.set(i,t);   /// CHeck if required
			c.add(Calendar.SECOND, 2);
		}
		int count = 0;
		for(int i=0;i<300;i++)
		{	

			List<TradeList>frl=new ArrayList<>();
			frl.add(new TradeList());
			frl.add(new TradeList());
			frl.add(new TradeList());
			if(frpointer<a&&i==frindex[frpointer])
			{

				frl = getScenario();
				
				fr[0]=i;
				fr[1]=rand.nextInt(5)+i; 
				fr[2]=rand.nextInt(5)+fr[1];
				// The split number for the final firm trade in the fr scenario
				fbr=rand.nextInt(4)+1; 
				//code for front running scenario  

				if(frpointer+1<a &&frindex[frpointer+1]<fr[2]) 
					frindex[frpointer+1]=fr[2]+1+fbr;
				else
					frpointer++;

				//firm trade
				li.get(fr[0]).setCustomerId(frl.get(0).getCustomerId());
				li.get(fr[0]).setSecurity(frl.get(0).getSecurity());
				li.get(fr[0]).setOrderType(frl.get(0).getOrderType());
				li.get(fr[0]).setQuantity(frl.get(0).getQuantity());
				li.get(fr[0]).setPrice(ML.getPrice()[li.get(fr[0]).getSecurity()-1]);
				PriceFluctuation(ML, li.get(fr[0]).getOrderType(), li.get(fr[0]).getQuantity(), li.get(fr[0]).getSecurity());

				li.get(fr[1]).setCustomerId(frl.get(1).getCustomerId());
				li.get(fr[1]).setSecurity(frl.get(1).getSecurity());
				li.get(fr[1]).setOrderType(frl.get(1).getOrderType());
				li.get(fr[1]).setQuantity(frl.get(1).getQuantity());
				li.get(fr[1]).setPrice(ML.getPrice()[li.get(fr[1]).getSecurity()-1]);
				PriceFluctuation(ML, li.get(fr[1]).getOrderType(), li.get(fr[1]).getQuantity(), li.get(fr[1]).getSecurity());

					for(int k=0;k<fbr;k++)
					{

						li.get(fr[2]+k).setCustomerId(frl.get(2).getCustomerId());
						li.get(fr[2]+k).setSecurity(frl.get(2).getSecurity());
						li.get(fr[2]+k).setOrderType(frl.get(2).getOrderType());
						li.get(fr[2]+k).setQuantity(frl.get(2).getQuantity()/fbr);
						li.get(fr[2]+k).setPrice(ML.getPrice()[li.get(i).getSecurity()-1]);
						PriceFluctuation(ML, li.get(fr[2]+k).getOrderType(), li.get(fr[2]+k).getQuantity(), li.get(fr[2]+k).getSecurity());

					}
				

			}

			if(i==fr[0])
			{
				System.out.println(count);
				count++;
				System.out.println("Firm Trade");
				System.out.println(li.get(i).toString());
				continue;

			}
			if(i==fr[1])
			{   
				System.out.println(count);
				count++;
				System.out.println("Customer Trade");
				System.out.println(li.get(i).toString());
				continue;
			}
			if(i==fr[2])
			{
					
				for(int k=0;k<fbr;k++)
				{

					System.out.println(count);
					count++;
					System.out.println("Broken up trades");
					System.out.println(li.get(i).toString());
					i++;
				}
			
			
				continue;

			}
			//random customer id
			random = rand.nextInt(4);
			li.get(i).setCustomerId(cid[random]); //0 - 3
			//random security

			//random type
			random = rand.nextInt(2);
			li.get(i).setOrderType(type[random]);
			// isChecked taken care of by constructor
			//random quantity distribution ?
			li.get(i).setQuantity( myRand(arr, freq, n));
			random = rand.nextInt(4); //0-3
			li.get(i).setSecurity(random+1);
			//price based on quantity
			li.get(i).setPrice(ML.getPrice()[random]);
			PriceFluctuation(ML, li.get(i).getOrderType(), li.get(i).getQuantity(), li.get(i).getSecurity());
		    System.out.println(count);
			count++;
			System.out.println(li.get(i).toString());
		}
		return li;
	}


	static int findCeil(int arr[], int r, int l, int h)  
	{  
		int mid;  
		while (l < h)  
		{  
			mid = l + ((h - l) >> 1); // Same as mid = (l+h)/2  
			if(r > arr[mid])  
				l = mid + 1; 
			else
				h = mid;  
		}  
		return (arr[l] >= r) ? l : -1;  
	}  

	static int myRand(int arr[], int freq[], int n)  
	{  
		// Create and fill prefix array  
		int prefix[] = new int[n], i;  
		prefix[0] = freq[0];  
		for (i = 1; i < n; ++i)  
			prefix[i] = prefix[i - 1] + freq[i];  

		// prefix[n-1] is sum of all frequencies. 
		// Generate a random number with  
		// value from 1 to this sum  
		int r = ((int)(Math.random()*(323567)) % prefix[n - 1]) + 1;  

		// Find index of ceiling of r in prefix arrat  
		int indexc = findCeil(prefix, r, 0, n - 1);  
		return arr[indexc];  
	}  
	public List<TradeList> getScenario()
	{
		Random rand = new Random();
		List<TradeList>sc = new ArrayList<>();
		sc.add(new TradeList());
		sc.add(new TradeList());
		sc.add(new TradeList());

		int num=rand.nextInt(3)+1;
		sc.get(0).setCustomerId(200);
		sc.get(1).setCustomerId(num);
		sc.get(2).setCustomerId(200);

		int quant=rand.nextInt(300)+400;
		sc.get(0).setQuantity(quant); 
		quant=rand.nextInt(100)+900;
		sc.get(1).setQuantity(quant); 
		quant=rand.nextInt(300)+400;
		sc.get(2).setQuantity(quant);  

		num=rand.nextInt(2)+1;
		switch(num)
		{
		case 1:
			int [] sec=new int[2];
			sec[0]=1;
			sec[1]=4;
			int num1=rand.nextInt(2);
			int num2=rand.nextInt(4)+1;
			sc.get(0).setSecurity(num2);
			sc.get(1).setSecurity(sec[num1]);
			sc.get(2).setSecurity(num2);
			boolean f = rand.nextBoolean();

			if(f)
			{
				sc.get(1).setOrderType(true);
			} 
			else
			{
				sc.get(1).setOrderType(false);
			}

			if(num2==2)
				sc.get(0).setOrderType(!sc.get(1).getOrderType());
			else
				sc.get(0).setOrderType(sc.get(1).getOrderType());

			sc.get(2).setOrderType(!sc.get(0).getOrderType());   
			return sc;

		case 2:
			int [] sec1=new int[2];
			sec1[0]=2;
			sec1[1]=3;
			num1=rand.nextInt(2);
			sc.get(0).setSecurity(sec1[num1]);
			sc.get(1).setSecurity(sec1[num1]);
			sc.get(2).setSecurity(sec1[num1]);
			f =rand.nextBoolean();
			if(f)
			{
				sc.get(1).setOrderType(true);
				sc.get(0).setOrderType(true);
				sc.get(2).setOrderType(false);
			} 
			else
			{
				sc.get(1).setOrderType(false);
				sc.get(0).setOrderType(false);
				sc.get(2).setOrderType(true);
			}

			return sc;      
		}
		return sc;
	}
	public void PriceFluctuation(MarketList ml,boolean orderType, int quantity, int security) {

		int type = (orderType)?1:-1;

		if(security == 1||security ==4)
		{
			ml.getPrice()[0] += 0.001 * quantity*type;
			ml.getPrice()[1] -= 0.0005 * quantity*type;
			ml.getPrice()[2] += 0.0005 * quantity* type;
			ml.getPrice()[3] += 0.001 * quantity* type;
		}
		else if(security == 2)
			ml.getPrice()[1]-=0.001*quantity*type;
		else
			ml.getPrice()[2]+=0.001*quantity*type;


	}

}


