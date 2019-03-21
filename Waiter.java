package controller;
import java.util.*;
import model.*;


public class Waiter implements Runnable {
	private String name;
	private volatile boolean exit;
	LinkedList<Order> curr;
	Serve serve;
	LogsSingleton logger = LogsSingleton.getInstance();
	
	public Waiter(String name, Serve serve) {
		this.name = name;
		this.exit=false;
		this.serve=serve;
		this.curr=new LinkedList<Order>();
		logger.logEntry(this.name+" Joined as Service Staff");
		Thread t=new Thread(this,this.name);
		t.start();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setExit(boolean exit) {
		this.exit = exit;
	}
	
	//Function for servicing current order and online order
	public void service(LinkedList<Order> queueOrder, String message)
	{
		int MilliSec;
		String currCust=null;
		try
		{
			synchronized(queueOrder)
			{
				Thread.sleep(ProcessClass.order_time);
		        this.curr =serve.getFirstOrder(queueOrder);
		        MilliSec=serve.getTotalMilliSec(this.curr)/1000;
		        currCust=this.curr.getFirst().getCustId();
		        //System.out.println("Current waiting queue:"+Serve.currentQueue);
		        logger.logEntry(message);
		        logger.logEntry("Current First Order:" +currCust);
		        logger.logEntry(Thread.currentThread().getName()+" Currently Taking Order from:" +currCust+".Total time:"+MilliSec+" min");
		       
		        //Getting the food ordered by the customer
		        logger.logEntry("Food ordered are:");
		        for(Order o:this.curr)
		        {
		        	logger.logEntry(serve.getNameByItemId(o.getItemId())+" "+o.getQuantity());
		        }
		        Serve.serveQueue.replace(currCust, "Waiting");
		        //Adding order to cooking queue
		        Serve.currentCookOrder.addAll(this.curr);
		        
		        //Removing order from current waiting queue once took order
		        queueOrder.removeAll(this.curr);
		        queueOrder.notifyAll();		        		    
		       	       
			}

		} 
	catch(Exception e) {}	
		
	}
		
	//Waiter Start Servicing
	public void serviceOrder()
	{
		if(Serve.onlineQueueOrder.isEmpty())
		{
			service(Serve.currentQueueOrder, "Processing current order");
		}
		else
		{
			service(Serve.onlineQueueOrder, "Processing online order");
		}
		
	}
	public LinkedList<Order> getCurr() {
		  return curr;
		 }

	public void run()
	{
      while(!exit)
      {
		serviceOrder();	
		
	  }
      
	}
}

