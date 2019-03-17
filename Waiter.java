package coffeeshopapp;


public class Waiter implements Runnable {
	private String name;
	Serve serve;
	
	
	public Waiter(String name, Serve serve) {
		this.name = name;
		this.serve=serve;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public void run()
	{
      while(true)
      {
		serve.serviceOrder();			
	  }
	}
}
