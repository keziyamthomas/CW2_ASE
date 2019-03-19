package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//Reference - https://medium.com/@p.osinaga/using-singleton-in-java-b1b78cf640ed

public class LogsSingleton {
	
	private static LogsSingleton logger = null;
	private PrintWriter pwriter;
	
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY hh:mm:ss");
	
	
	private LogsSingleton() {
		if(logger == null) {
			try {
				FileWriter fwriter = new FileWriter("Logs.txt");
				pwriter = new PrintWriter(fwriter,true);	
			}
			catch(Exception e) {
				
			}
		}
	}
	
	public static synchronized LogsSingleton getInstance() {
		if(logger == null)
			logger = new LogsSingleton();
		return logger; 
	}
	
	public void logEntry(String logmessage) {
		try {
			Calendar cal = Calendar.getInstance();
			pwriter.println(format.format(cal.getTime())+"  " + logmessage);
		}
		catch(Exception e) {
			
		}
	}

}
