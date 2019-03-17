package coffeeshopapp;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Serve {

	public static LinkedList<Order> currentQueueOrder=new LinkedList<Order>();
	public static LinkedList<Order> currentCookOrder=new LinkedList<Order>();
	
	public static Queue<String> currentQueue=new LinkedList<>();
	public static Queue<String> currentCookingQueue=new LinkedList<>();
	
	//Get first order in the queue
	public LinkedList<Order> getFirstOrder(LinkedList<Order> currentOrder) {
		LinkedList<Order> currOrder= new LinkedList<Order>();
		try
		{
			String currCust=currentOrder.getFirst().getCustId();
					
			for(Order o:currentOrder)
			{
				if(o.getCustId().equals(currCust))
				{
					
				currOrder.add(o);
				}
				else
				{
					break;
				}
			}
		}
		catch(Exception e) {}
		return currOrder;
		
	}
	
	//Get the millisecond cooking time of an item based on the name
	public int getMilliSecByItemId(String itemId) {
		int milliSec=0;
		try
		{
		for(Map.Entry<String, Item> entry: ProcessClass.itemlist.entrySet()){
			if(itemId.equals(entry.getValue().getId())) {
				milliSec = entry.getValue().getCookTimeMS();
			}
		}}
		catch(Exception e) {}
		return milliSec;
	}
	
	//Get total milliseconds of an order
	public int getTotalMilliSec(LinkedList<Order> orderlist) {
		int totalMilliSec=0;
		for(Order o: orderlist){
			totalMilliSec+=getMilliSecByItemId(o.getItemId())*o.getQuantity();
		}
		return totalMilliSec;
	}
	
	//Get Food Name by Item Id
	public String getNameByItemId(String itemId) {
		String name=null;
		for(Map.Entry<String, Item> entry: ProcessClass.itemlist.entrySet()){
			if(itemId.equals(entry.getValue().getId())) {
				name = entry.getValue().getItemName();
			}
		}
		return name;
	}
	
	//Cook Start Cooking
	public void startCook()
	{
		int MilliSec;
		String currCust;	

		try
		{
			synchronized(Serve.currentCookOrder)
			{
				
		        LinkedList<Order>currOrder =getFirstOrder(Serve.currentCookOrder);
		        MilliSec=getTotalMilliSec(currOrder)/1000;
		        currCust=currOrder.getFirst().getCustId();
		        System.out.println(Thread.currentThread().getName()+" Currently Started Cooking for:" +currCust+".Total time:"+MilliSec+" min");
		        
		        //Remove order from cooking queue
		        Serve.currentCookOrder.removeAll(currOrder);       
		        Serve.currentCookOrder.notifyAll();	
		      
			}
			
			//Time taken for cooking according to the food ordered
			for(int i=MilliSec;i>=0;i=i-1)
			{
				try{Thread.sleep(1000);} catch(Exception e){}
				System.out.println(i+" "+Thread.currentThread().getName());
			}
			System.out.println(Thread.currentThread().getName()+" Finished Cooking for:" +currCust);
			Thread.sleep(1000);
			System.out.println(currCust+" Recieved Food Ordered");
			
			//Remove customer from cooking queue after finishing cooking
			Serve.currentCookingQueue.remove();
			System.out.println("Cooking to be finished for:"+Serve.currentCookingQueue);
		
		} 
		catch(Exception e) {}
		}
	
	//Waiter Start Servicing
	public void serviceOrder()
	{
		int MilliSec;
		String currCust=null;
		
		try
		{
			synchronized(Serve.currentQueueOrder)
			{
				Thread.sleep(1000);	
		        LinkedList<Order>currOrder =getFirstOrder(Serve.currentQueueOrder);
		        MilliSec=getTotalMilliSec(currOrder)/1000;
		        currCust=currOrder.getFirst().getCustId();
		        System.out.println("Current waiting queue:"+Serve.currentQueue);
		        System.out.println("Current First Order:" +currCust);
		        System.out.println(Thread.currentThread().getName()+" Currently Taking Order from:" +currCust+".Total time:"+MilliSec+" min");
		       
		        //Getting the food ordered by the customer
		        System.out.println("Food ordered are:");
		        for(Order o:currOrder)
		        {
		        	System.out.println(getNameByItemId(o.getItemId())+" "+o.getQuantity());
		        }
		        
		        //Adding order to cooking queue
		        Serve.currentCookOrder.addAll(currOrder);
		        Serve.currentCookingQueue.add(currCust);
		        System.out.println("Cooking to be finished for:"+Serve.currentCookingQueue);
		        
		        //Removing order from current waiting queue once took order
		        Serve.currentQueueOrder.removeAll(currOrder);
		        Serve.currentQueue.remove(currOrder.get(0).getCustId());
		        Serve.currentQueueOrder.notifyAll();		        		    
		        Thread.sleep(1000);		       
			}

		} 
	catch(Exception e) {}	
		
	}
	

}
