package coffeeshopapp;



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
	
	public void run()
	{
		while(true)
		{
		serve.startCook();
		}
	}
}
