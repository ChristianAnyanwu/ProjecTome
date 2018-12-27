package log;

import java.util.LinkedList;
import java.util.List;


public class Log {
	public List<String> log = new LinkedList<String>();

	// TODO add logs and logerrs to all applicable locations
	public void log(Object obj, String logValue) {
		log.add("Log: " + obj.getClass() + " : " + logValue);
		System.out.println("Log: " + logValue);
	}

	public void logErr(Object obj, String logValue) {
		log.add("Err: " + obj.getClass() + " : " + logValue);
		System.out.println("Err: " + logValue);
	}

	public List<String> getLog() {
		return log;
	}
}
