package log;

import java.util.LinkedList;
import java.util.List;


public class Log {
	public List<String> log = new LinkedList<String>();

	// TODO add logs and logerrs to all applicable locations
	
	//for any meanignful event
	public void log(Object obj, String logValue) {
		log.add("Log~ " + obj.getClass() + " ~ " + logValue.replaceAll("\n", "\t"));
		System.out.println("Log: " + logValue);
	}
	
	//for code failing
	public void logErr(Object obj, String logValue) {
		log.add("Err~ " + obj.getClass() + " ~ " + logValue.replaceAll("\n", "\t"));
		System.out.println("Err: " + logValue);
	}
	
	//for any user related problem
	public void logIssue(Object obj, String logValue) {
		log.add("Issue~ " + obj.getClass() + " ~ " + logValue.replaceAll("\n", "\t"));
		System.out.println("Issue: " + logValue);
	}

	public List<String> getLog() {
		return log;
	}
}
