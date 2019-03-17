package coffeeshopapp;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Serve {
	

	public static LinkedList<Order> currentQueueOrder=new LinkedList<Order>();
	public static LinkedList<Order> currentCookOrder=new LinkedList<Order>();
	public static Queue<String> currentQueue=new LinkedList<>();
	static final Object lock=new Object();
	static String tookOrder=null;
	static String cookFinish=null;
	
	
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
	

}
