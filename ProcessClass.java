package coffeeshopapp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


public class ProcessClass {
	public HashMap<String,Item> itemlist = new HashMap<String,Item>();
	public HashMap<String,Report> reportlist = new HashMap<String,Report>();
	public LinkedList<Order> orderlist = new LinkedList<Order>();
    public LinkedList<Order> currentQueueOrder = new LinkedList<Order>();
	
	public Waiter waiter1=new Waiter("Waiter Sam",currentQueueOrder);
    public Waiter waiter2=new Waiter("Waiter John",currentQueueOrder);
    
    public Thread t1=new Thread(waiter1);
    public Thread t2=new Thread(waiter2);
	
	//This method will return the LinkedList of Orders
	public LinkedList<Order> getOrderList(){
		return orderlist;
	}
	 
	//This method will return HashMap of Report
	public HashMap<String,Report> getReportList(){
		return reportlist;
	}
	
	//This method will return HashMap of Items
	public HashMap<String,Item> getItemList(){
		return itemlist;
	}
	
	/* The readItems() method will read the items from Items.csv and add them to the hashmap ItemList */
	public void readItems(){
		Scanner scan;
		String itemfile = "Items.csv";
		File file =new File(itemfile);
		String text;
		try {
			scan = new Scanner(file);
			while(scan.hasNextLine()) {
				text = scan.nextLine();
				try {
					//splitting each line using , as delimiter
					String[] parts = text.split(",");
					String name = parts[0];
					String desc = parts[1];
					double price = Double.parseDouble(parts[2]);
					String category = parts[3];
					String id = parts[4];
					int milliSec = Integer.parseInt(parts[5]);
					try {
						String pattern = "BIT|HOT|SHK|CCD\\d{3}";
						Pattern pat = Pattern.compile(pattern);
						Matcher m = pat.matcher(id);
						if(!m.find()){
							throw new PatternException("Incorrect Id: " + id +" in Items.csv. The item Id should have the following pattern:<BIT/HOT/SHK/CCD><3-digit number> eg:BIT123, HOT123, SHK123, CCD123");
						}
						Item item = new Item(name,desc,price,category,id,millisec);
						itemlist.put(id, item);
					}
					catch(PatternException pe) {
						JOptionPane.showMessageDialog(null, pe.getMessage());
					}
					Report rpt = new Report(id,name,0,0.0);
					reportlist.put(id,rpt);
					}
					//catches exception in parsing string to integers
					catch(NumberFormatException e) {
						e.printStackTrace();
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
					finally {
						continue;
					}
				}
			scan.close();
		}
		catch(FileNotFoundException fnf) {
			fnf.printStackTrace();
		}
		catch(NumberFormatException e) {
			e.printStackTrace();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//Method to read items from Order.csv and insert them to LinkedList
	
	public void readOrder(){
		Scanner scan;
		String orderfile = "Orders.csv";
		File file =new File(orderfile);
		String text;
		try {
			scan = new Scanner(file);
			while(scan.hasNextLine()) {
				text=scan.nextLine();
				try {
					//splitting each line of the file to store in different variables
					String[] parts = text.split(",");
					String time = parts[0];
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY hh:mm");
					Date date = format.parse(time);
					Timestamp ts = new Timestamp(date.getTime());
					String id = parts[1];
					String itemid = parts[2];
					int quantity = Integer.parseInt(parts[3]);
					double amount = Double.parseDouble(parts[4]);
					try {
					Order order = new Order(ts,id,itemid,quantity,amount);
					orderlist.add(order);
					currentQueueOrder.add(order);
					}
					catch(PatternException pe) {
					   JOptionPane.showMessageDialog(null, pe.getMessage());
					}
				}
				catch(NumberFormatException e) {
					e.printStackTrace();
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
				finally {
					continue;
				}
			}
			scan.close();
		}
		catch(FileNotFoundException fnf) {
			fnf.printStackTrace();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//This method appends new orders with existing orders
	public void addOrder(LinkedList<Order> list) {
		orderlist.addAll(list);
		currentQueueOrder.addAll(list);
		for (Order o:orderlist)
		{
		System.out.println(o.getAmount());
		}
		System.out.println(list);
		
		
	}
	
	public void startService()
	{
		if(!t1.isAlive())
		{
		
	    try{t1.start();}catch(IllegalThreadStateException e) {Thread t1=new Thread(waiter1);t1.start();}
		}
		if(!t2.isAlive())
		{	
			
		try{t2.start();}catch(IllegalThreadStateException e) {Thread t2=new Thread(waiter2);t2.start();}
		}
    
	}
		
	
	//Reference-http://resources.mpi-inf.mpg.de/d5/teaching/ss05/is05/javadoc/java/util/HashMap.Entry.html
	// Get the list of items in a particular Category
	public List<String> getItemsByCategory(String category) {
		List<String> items = new ArrayList<String>();
		for(Map.Entry<String, Item> entry: itemlist.entrySet()) {
			if(category.equals(entry.getValue().getCategory())) {
				items.add(entry.getValue().getItemName());
			}
		}
		return items;
	}
	
	//Get the unit price of an item based on the name
	public double getUnitPriceByItemName(String itemName) {
		double unitPrice=0.0;
		for(Map.Entry<String, Item> entry: itemlist.entrySet()){
			if(itemName.equals(entry.getValue().getItemName())) {
				unitPrice = entry.getValue().getPrice();
			}
		}
		return unitPrice;
	}
	
	//This method generates the order Id based on the last Order in the list
	public String generateOrderId() {
		String orderId;
		int n = Integer.parseInt(orderlist.getLast().getCustId().substring(4));
		int newId = n + 1;
		String f_newId = String.format("%03d", newId);
		orderId = "CUST" + f_newId;
		return orderId;
	}
	
	//This method returns the Item Id from Item name
	public String getItemIdByItemName(String name) {
		String id=null;
		for(Map.Entry<String, Item> entry: itemlist.entrySet()){
			if(name.equals(entry.getValue().getItemName())) {
				id = entry.getValue().getId();
			}
		}
		return id;
		
	}
	
	//This method populates the ReportList for generating final report 
	public void populateReportList() {
		for(Order o: orderlist) {
			for(Map.Entry<String, Report> r: reportlist.entrySet()) {
				if(o.getItemId().equals(r.getKey())) {
					String id = r.getValue().getId();
					String name = r.getValue().getItemName();
					int quantity = r.getValue().getQuantity()+o.getQuantity();
					double total = r.getValue().getTotal() + o.getAmount();
					r.setValue(new Report(id,name,quantity,total));
				}
			}
		}
		
	}
	//This method generates the final report
	public String generateReport() {
		double amount=0.0;
		String report="";
		report += "Id     ItemName       Quantity   Total\r\n";
		report += "\r\n";
		for(Map.Entry<String, Report> r: reportlist.entrySet()) {
			report += String.format("%-7s",r.getValue().getId());
			report += String.format("%-20s",r.getValue().getItemName());
			report += String.format("%-7s",r.getValue().getQuantity());
			report += String.format("%-7s", r.getValue().getTotal());
			report += "\r\n";
			amount=amount+r.getValue().getTotal();
		}
		report += "\r\n";
		report+="\t\t\tGrossTotal: "+amount;
		report+="\r\n\t\t\tTotalDiscountToday: "+Discount.totalDiscount;
		report+="\r\n\t\t\tNetTotal: "+(amount-Discount.totalDiscount);
		return report;
	}
	
	//This method generates the report and writes them to a file
	public void WriteToFile() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("Report.txt"));
			String report = generateReport();
			writer.write(report);
			writer.close();
		}
		catch(FileNotFoundException fnf){
			JOptionPane.showMessageDialog(null,"The file to write the report is not found");
		}
		catch(IOException io) {
			io.printStackTrace();
		}
		
	}

}
