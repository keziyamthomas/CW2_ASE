package coffeeshopapp;

import java.util.LinkedList;
import java.util.Map;

public class Waiter implements Runnable {
	private String name;
	private LinkedList<Order> currentQueueOrder;
	
	
	
	public Waiter(String name, LinkedList<Order> currentQueueOrder) {
		this.name = name;
		this.currentQueueOrder = currentQueueOrder;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
		
	public LinkedList<Order> getCurrentQueueOrder() {
		return currentQueueOrder;
	}

	public void setCurrentQueueOrder(LinkedList<Order> currentQueueOrder) {
		this.currentQueueOrder = currentQueueOrder;
	}

	//This method returns the first order in the queue
	public LinkedList<Order> getFirstOrder(LinkedList<Order> currentOrder) {
		LinkedList<Order> currOrder= new LinkedList<Order>();
		try
		{
			String currCust=currentOrder.getFirst().getCustId();
			System.out.println("Current First Order:" +currCust);
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
		for(Map.Entry<String, Item> entry: ProcessClass.itemlist.entrySet()){
			if(itemId.equals(entry.getValue().getId())) {
				milliSec = entry.getValue().getCookTimeMS();
			}
		}
		return milliSec;
	}
	
	public int getTotalMilliSec(LinkedList<Order> orderlist) {
		int totalMilliSec=0;
		for(Order o: orderlist){
			totalMilliSec+=getMilliSecByItemId(o.getItemId())*o.getQuantity();
		}
		return totalMilliSec;
	}
	public String getNameByItemId(String itemId) {
		String name=null;
		for(Map.Entry<String, Item> entry: ProcessClass.itemlist.entrySet()){
			if(itemId.equals(entry.getValue().getId())) {
				name = entry.getValue().getItemName();
			}
		}
		return name;
	}
	public synchronized void serviceOrder(LinkedList<Order> queueOrder)
	{
		int MilliSec;
		String currCust;
		try
		{
			synchronized(queueOrder)
			{
		        LinkedList<Order>currOrder =getFirstOrder(queueOrder);
		        MilliSec=getTotalMilliSec(currOrder)/1000;
		        currCust=currOrder.getFirst().getCustId();
		        System.out.println(this.name+" Currently Servicing:" +currCust+".Total time:"+MilliSec+" min");
		        System.out.println("Food ordered are:");
		        for(Order o:currOrder)
		        {
		        	System.out.println(getNameByItemId(o.getItemId())+" "+o.getQuantity());
		        }
		        queueOrder.removeAll(currOrder);
				queueOrder.notifyAll();	
			}
			for(int i=MilliSec;i>=0;i=i-1)
			{
				try{Thread.sleep(1000);} catch(Exception e){}
				System.out.println(i+" "+this.name);
			}
			System.out.println(this.name+" Finished:" +currCust);
		} 
		catch(Exception e) {}
		
		if(!queueOrder.isEmpty())
		{
		serviceOrder(queueOrder);
		}
	}
	public void run()
	{
		if(!currentQueueOrder.isEmpty())
		{
		serviceOrder(currentQueueOrder);
		}
	}
}
