package controller;

import java.util.*;
import model.*;
import observer_pattern.Observer;


public class Serve {

	public static LinkedList<Order> currentQueueOrder=new LinkedList<Order>();
	public static LinkedList<Order> currentCookOrder=new LinkedList<Order>();
	public static LinkedList<Order> onlineQueueOrder=new LinkedList<Order>();
	
	public static TreeMap<String,String> serveQueue=new TreeMap<String,String>();
	
	LogsSingleton logger = LogsSingleton.getInstance();
		
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
		totalMilliSec += ProcessClass.order_time;
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
	
	
}
