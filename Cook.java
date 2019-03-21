package controller;

import java.util.LinkedList;

import model.*;


public class Cook implements Runnable {
	private String name;
	private int MilliSec;
	private int sec;
	private volatile boolean exit;
	LinkedList<Order> curr;
	Serve serve;
	LogsSingleton logger = LogsSingleton.getInstance();
	
	public Cook() {
		//Constructor
	}
	
	public Cook(String name,Serve serve) {
		this.name = name;
		this.exit=false;
		this.serve=serve;
		this.curr=new LinkedList<Order>();
		this.MilliSec = 0;
		logger.logEntry(this.name+" Joined for Cooking");
		Thread t=new Thread(this,this.name);
		t.start();
	}
	
	//Cook Start Cooking
		public void startCook()
		{
			String currCust;	

			try
			{
				synchronized(Serve.currentCookOrder)
				{
					Thread.sleep(ProcessClass.prep_time);
			        this.curr =serve.getFirstOrder(Serve.currentCookOrder);
			        MilliSec=serve.getTotalMilliSec(this.curr)/1000;
			        currCust=this.curr.getFirst().getCustId();
			        logger.logEntry(Thread.currentThread().getName()+" Currently Started Cooking for:" +currCust+".Total time:"+MilliSec+" min");
			        
			        //Remove order from cooking queue
			        Serve.currentCookOrder.removeAll(this.curr);       
			        Serve.currentCookOrder.notifyAll();	
			        Serve.serveQueue.replace(currCust, "Preparing");
			      
				}
				
				//Time taken for cooking according to the food ordered
				for(this.sec=this.MilliSec;this.sec>=1;this.sec=this.sec-1)
				{
					try{Thread.sleep(1000);} catch(Exception e){}
					logger.logEntry(this.sec+" "+Thread.currentThread().getName());
				}
				logger.logEntry(Thread.currentThread().getName()+" Finished Cooking for:" +currCust);
				Serve.serveQueue.replace(currCust, "Ready");
				Thread.sleep(1000);
				logger.logEntry(currCust+" Recieved Food Ordered");
				
				//Remove customer from cooking queue after finishing cooking
				Serve.serveQueue.replace(currCust, "Delivered");
				
				Thread.sleep(1000);
				Serve.serveQueue.replace(currCust, "Left the shop");
				
				Thread.sleep(2000);
				Serve.serveQueue.remove(currCust);
			
			} 
			catch(Exception e) {}
			}
		


	public String getName() {
		return name;
	}
	
	public LinkedList<Order> getCurr() {
		return curr;
	}
	public void setCurr(LinkedList<Order> curr) {
		this.curr = curr;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void setExit(boolean exit) {
		this.exit = exit;
	}

	public int getMilliSec() {
		return MilliSec;
	}

	public int getSec() {
		return sec;
	}
	public void run()
	{
		while(!exit)
		{
		   startCook();
		}
	}
}
