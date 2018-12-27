package log;

import java.util.LinkedList;
import java.util.List;


public class Log {
	public List<String> log = new LinkedList<String>();

	// TODO add logs and logerrs to all applicable locations
	
	//for any meanignful event
	public String log(Object obj, String logValue) {
		log.add("Log~ " + obj.getClass() + " ~ " + logValue.replaceAll("\n", "\t"));
		System.out.println("Log: " + logValue);
		return logValue;
	}
	
	//for code failing
	public String logErr(Object obj, String logValue) {
		log.add("Err~ " + obj.getClass() + " ~ " + logValue.replaceAll("\n", "\t"));
		System.out.println("Err: " + logValue);
		return logValue;
	}
	
	//for any user related problem
	public String logIssue(Object obj, String logValue) {
		log.add("Issue~ " + obj.getClass() + " ~ " + logValue.replaceAll("\n", "\t"));
		System.out.println("Issue: " + logValue);
		return logValue;
	}

	public List<String> getLog() {
		return log;
	}

	public String logSuccess(Object obj, String logValue) {
		log.add("Success~ " + obj.getClass() + " ~ " + logValue.replaceAll("\n", "\t"));
		System.out.println("Success: " + logValue);
		return logValue;
	}
}
