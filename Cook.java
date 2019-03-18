package coffeeshopapp;



public class Cook implements Runnable {
	private String name;	
	private volatile boolean exit;
	Serve serve;
	
	public Cook(String name,Serve serve) {
		this.name = name;
		this.exit=false;
		this.serve=serve;
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

	public void run()
	{
		while(!exit)
		{
		serve.startCook();
		}
	}
}
