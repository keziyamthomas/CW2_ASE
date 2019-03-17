package coffeeshopapp;

import java.util.LinkedList;


public class Cook implements Runnable {
	private String name;
	
	Serve serve;
	
	public Cook(String name, Serve serve) {
		this.name = name;
		this.serve=serve;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
		
	public synchronized void startCook()
	{
		int MilliSec;
		String currCust;
		
//		try
//		{
//			synchronized(Serve.lock)
//			{
//				if(Serve.tookOrder==null)
//				{
//					try{Serve.lock.wait();} catch(Exception e) {}
//				}
//		        LinkedList<Order>currOrder =serve.getFirstOrder(queueOrder);
//		        MilliSec=serve.getTotalMilliSec(currOrder)/1000;
//		        currCust=currOrder.getFirst().getCustId();
//		        System.out.println(this.name+" Currently Cooking for:" +currCust+".Total time:"+MilliSec+" min");
//		        
//		        queueOrder.removeAll(currOrder);
//		        Serve.currentQueue.remove(currOrder.get(0).getCustId());
//		        System.out.println(Serve.currentQueue);
//		        Serve.lock.notifyAll();	
//		        Serve.tookOrder=null;
//			}
//			for(int i=MilliSec;i>=0;i=i-1)
//			{
//				try{Thread.sleep(1000);} catch(Exception e){}
//				System.out.println(i+" "+this.name);
//			}
//			System.out.println(this.name+" Finished Cooking for:" +currCust);
//		
//		} 
//		catch(Exception e) {}
		try
		{
			synchronized(Serve.currentCookOrder)
			{
				
		        LinkedList<Order>currOrder =serve.getFirstOrder(Serve.currentCookOrder);
		        MilliSec=serve.getTotalMilliSec(currOrder)/1000;
		        currCust=currOrder.getFirst().getCustId();
		        System.out.println(this.name+" Currently Started Cooking for:" +currCust+".Total time:"+MilliSec+" min");
		        
		        Serve.currentCookOrder.removeAll(currOrder);
		        
		        Serve.currentCookOrder.notifyAll();	
		      
			}
			for(int i=MilliSec;i>=0;i=i-1)
			{
				try{Thread.sleep(1000);} catch(Exception e){}
				System.out.println(i+" "+this.name);
			}
			System.out.println(this.name+" Finished Cooking for:" +currCust);
			Thread.sleep(1000);
			System.out.println(currCust+" Recieved Food Ordered");
		
		} 
		catch(Exception e) {}
		}
		
	
	public void run()
	{
		while(true)
		{
		startCook();
		}
	}
}
