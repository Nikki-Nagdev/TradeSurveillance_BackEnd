package com.detection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.pojo.TradeList;

public class DetectionAlgo {
	
	double threshold = 100000;
	int seconds = 2;
	

	public boolean DetectionAl(List<TradeList> li)
	{
		for(int i = 0;i<li.size();i++)
		{
			if(li.get(i).getPrice() * li.get(i).getQuantity()>=threshold 
					&& li.get(i).isChecked == false && li.get(i).getCustomerId()!=200)
			{
				int inter[]=Interval(i,li); 
				if(inter[0]==inter[1]&&inter[1]==inter[2])
					continue;
				boolean frontRun=false;
				
				if(li.get(i).getSecurity()==1 || li.get(i).getSecurity()==4)
					frontRun= DetectESF(inter,li);
				else if(li.get(i).getSecurity() == 2)
					frontRun= DetectPut(inter, li);
				else
					frontRun= DetectCall(inter, li);
					
				if(frontRun)
				{
					System.out.print("Front Running scenario detected at index ");
					System.out.print(i);
					System.out.print("  ");
					System.out.println(li.get(i).toString());
				}
				
			}
		}
		return true;
	}
	public int[] Interval(int index,List<TradeList>li){
		int interval[]= {0,0,0};
		if(index == 0 || index == li.size()-1)
			return interval; 
		Calendar tempc = (Calendar)li.get(index).getTradeExecutionTime();
		Calendar befc = (Calendar)tempc.clone();
		befc.add(Calendar.SECOND, -10);
		Calendar afterc = (Calendar)tempc.clone();
		afterc.add(Calendar.SECOND,10);
		
		interval[1]=index;
		int i = index;
		
		while(befc.before(tempc))
		{
			i--;
			if(i ==0)
				break;
			befc.add(Calendar.SECOND, seconds);
		}
		interval[0]=i;
		i = index;
		while(afterc.after(tempc))
		{
			i++;
			if(i == li.size()-1)
				break;
			afterc.add(Calendar.SECOND, -seconds);
		}
		interval[2]=i;
		return interval;

	}

	
public boolean DetectESF(int interval[],List<TradeList>li) {
  int custIndex=interval[1];
  int startIndex=interval[0];
  int endIndex=interval[2];
  
  boolean alert=false;
   //If customer buys equities or futures
  if(li.get(custIndex).getOrderType())
  {
    int j=custIndex-1;
    
    while(startIndex<=j)
    {
       if(((li.get(j).getOrderType()==true)&&(li.get(j).getSecurity()==1||li.get(j).getSecurity()==4||li.get(j).getSecurity()==3))||(li.get(j).getOrderType()==false&&li.get(j).getSecurity()==2)&&li.get(j).getCustomerId()==200)
       {
         int i=custIndex+1;
         while(i<=endIndex)
         {
           if((!li.get(i).getOrderType()==li.get(j).getOrderType())&&(li.get(j).getSecurity()==li.get(i).getSecurity())&&li.get(i).getCustomerId()==200)
           {
             
             li.get(j).setChecked(true);
        	 li.get(i).setChecked(true);
             li.get(custIndex).setChecked(true);
             alert=true;
           }
           i=i+1;
         }
       }
      if(alert)
        return alert;
      j=j-1;
    } 
  }
   //If customer sells equities or futures
   else
   {
    int j=custIndex-1;
    
    while(startIndex<=j)
    {
       if(((li.get(j).getOrderType()==false)&&(li.get(j).getSecurity()==1||li.get(j).getSecurity()==4||li.get(j).getSecurity()==3))||(li.get(j).getOrderType()==true&&li.get(j).getSecurity()==2)&&li.get(j).getCustomerId()==200)
       {
         int i=custIndex+1;
         while(i<=endIndex)
         {
           if((!li.get(i).getOrderType()==li.get(j).getOrderType())&&(li.get(j).getSecurity()==li.get(i).getSecurity())&&li.get(i).getCustomerId()==200)
           {
             
             li.get(j).setChecked(true);
             li.get(i).setChecked(true);
             li.get(custIndex).setChecked(true);
             alert=true;
           }
           i=i+1;
         }
       }
      if(alert)
        return alert;
      j=j-1;
    } 
   } 
		return alert;
	}
	
public boolean DetectCall(int interval[],List<TradeList>li)
{
  int custIndex=interval[1];
  int startIndex=interval[0];
  int endIndex=interval[2];
  int p1=custIndex,p2=custIndex;
  boolean alert=false;
  //If customer buys call options
  if(li.get(custIndex).getOrderType())
  {
    int j=custIndex-1;
    
    while(startIndex<=j)
    {
       if((li.get(j).getOrderType()==true)&&(li.get(j).getSecurity()==3)&&li.get(j).getCustomerId()==200)
       {
         int i=custIndex+1;
         while(i<=endIndex)
         {
           if((!li.get(i).getOrderType()==li.get(j).getOrderType())&&(li.get(j).getSecurity()==li.get(i).getSecurity())&&li.get(i).getCustomerId()==200)
           {
        	   li.get(j).setChecked(true);
               li.get(i).setChecked(true);
               li.get(custIndex).setChecked(true);
             alert=true;
           }
           i=i+1;
         }
       }
      if(alert)
        return alert;
      j=j-1;
    }
  }
    
    //If firm sells call options
    else
    {
      int j=custIndex-1;
      
    while(startIndex<=j)
    {
       if((li.get(j).getOrderType()==false)&&(li.get(j).getSecurity()==3)&&li.get(j).getCustomerId()==200)
       {
         int i=custIndex+1;
         while(i<=endIndex)
         {
           if((!li.get(i).getOrderType()==li.get(j).getOrderType())&&(li.get(j).getSecurity()==li.get(i).getSecurity())&&li.get(i).getCustomerId()==200)
           {
             
        	   li.get(j).setChecked(true);
               li.get(i).setChecked(true);
               li.get(custIndex).setChecked(true);
             alert=true;
           }
           i=i+1;
         }
       }
      if(alert)
        return alert;
      j=j-1;
    }
  }
    return alert;
}
  
  
  public boolean DetectPut(int interval[],List<TradeList>li)
{
  int custIndex=interval[1];
  int startIndex=interval[0];
  int endIndex=interval[2];
  int p1=custIndex,p2=custIndex;
  boolean alert=false;
  if(li.get(custIndex).getOrderType())
  {
    int j=custIndex-1;
    
    while(startIndex<=j)
    {
       if((li.get(j).getOrderType()==true)&&(li.get(j).getSecurity()==2)&&li.get(j).getCustomerId()==200)
       {
         int i=custIndex+1;
         while(i<=endIndex)
         {
           if((!li.get(i).getOrderType()==li.get(j).getOrderType())&&(li.get(j).getSecurity()==li.get(i).getSecurity())&&li.get(i).getCustomerId()==200)
           {
             
        	   li.get(j).setChecked(true);
               li.get(i).setChecked(true);
               li.get(custIndex).setChecked(true);
             alert=true;
           }
           i=i+1;
         }
       }
      if(alert)
        return alert;
      j=j-1;
    }
  }
    else
    {
      int j=custIndex-1;
      
    while(startIndex<=j)
    {
       if((li.get(j).getOrderType()==false)&&(li.get(j).getSecurity()==2)&&li.get(j).getCustomerId()==200)
       {
         int i=custIndex+1;
         while(i<=endIndex)
         {
           if((!li.get(i).getOrderType()==li.get(j).getOrderType())&&(li.get(j).getSecurity()==li.get(i).getSecurity())&&li.get(i).getCustomerId()==200)
           {
             
        	   li.get(j).setChecked(true);
               li.get(i).setChecked(true);
               li.get(custIndex).setChecked(true);
             alert=true;
           }
           i=i+1;
         }
       }
      if(alert)
        return alert;
      j=j-1;
    }
  }
    return alert;
}
}
