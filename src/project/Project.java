package project;

import java.util.ArrayList;
import java.util.HashMap;

public class Project {

	// Project Properties
	String name, shortName;
	String versionName, versionNumber;

	public enum ProjectTypes {
		LongTermRunnable, LongTermStorage, ShortTermRunnable, ShortTermStorage, DataAnalysis_OneOff, DataAnalysis_Repetitive, Unknown
	}

	ProjectTypes projectType;
	boolean parallelAllowed;

	ArrayList<ProjectNode> pNodes = new ArrayList<ProjectNode>();
	ArrayList<ProjectFile> files = new ArrayList<ProjectFile>();
	HashMap<String, String> variables = new HashMap<String, String>();
	ProjectProgress progress;

	public Project() {
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}

	public void setProjectType(ProjectTypes projectType) {
		this.projectType = projectType;
	}

	public void setParallelAllowed(boolean parallelAllowed) {
		this.parallelAllowed = parallelAllowed;
	}

	public String getName() {
		return name;
	}

	public String getShortName() {
		return shortName;
	}

	public String getVersionName() {
		return versionName;
	}

	public String getVersionNumber() {
		return versionNumber;
	}

	public ProjectTypes getProjectType() {
		return projectType;
	}

	public boolean isParallelAllowed() {
		return parallelAllowed;
	}

	public ArrayList<ProjectNode> getpNodes() {
		return pNodes;
	}

	public ArrayList<ProjectFile> getFiles() {
		return files;
	}

	public HashMap<String, String> getVariables() {
		return variables;
	}

	public ProjectProgress getProgress() {
		return progress;
	}

	public void addFile(ProjectFile file) {
		files.add(file);
	}
	
	public void addVariable(String key, String value){
		variables.put(key, value);
	}

}
