package project;

import java.util.ArrayList;
import java.util.HashMap;

public class Project {
	
	//Project Properties
	String name, shortName;
	String versionName, versionNumber;
	enum ProjectTypes {
		LongTermRunnable, LongTermStorage, ShortTermRunnable, ShortTermStorage, DataAnalysis_OneOff, DataAnalysis_Repetitive
	}
	ProjectTypes projectType;
	boolean parallelAllowed;
	
	ArrayList<ProjectNode> pNodes = new ArrayList<ProjectNode>();
	ArrayList<ProjectFile> files = new ArrayList<ProjectFile>();
	HashMap<String, String> variables = new HashMap<String,String>();
	
	
	
}
