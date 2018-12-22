package projectMaster;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import project.Project;
import project.ProjectFile;
import project.ProjectProgress;
import project.ProjectFile.FileTypes;
import project.ProjectFile.Languages;
import util.FileUtility;
import project.Project.ProjectTypes;

public class ProjectLoader {

	static JSONObject root = new JSONObject();
	static JSONParser parser = new JSONParser();
	static FileUtility fl = new FileUtility();

	public Project loadProject(String fileLoc) {
		try {
			Project project = new Project();
			JSONObject root = fl.getProjectAsJsonRoot(fileLoc);

			root = (JSONObject) root.get("Project-Manager");

			// if it cant get properties it might as well crash
			getProperties(project, root);
			// TODO find a better way to log error and inform user about poorly
			// formatted parts of project files

			try {
				getPNodes(project, root);
			} catch (Exception e) {
				System.err.println("Error reading project files: ");
				e.printStackTrace();
			}
			try {
				getFiles(project, root);
			} catch (Exception e) {
				System.err.println("Error reading project files: ");
				e.printStackTrace();
			}
			try {
				getVariables(project, root);
			} catch (Exception e) {
				System.err.println("Error reading project variables: ");
				e.printStackTrace();
			}
			try {
				getProgress(project, root);
			} catch (Exception e) {
				System.err.println("Error reading project progress: ");
				e.printStackTrace();
			}

			return project;

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception better
			return null;
		}
	}

	// TODO long term-make the read in of json with more safety checks for all
	// json terms below
	private void getProperties(Project project, JSONObject root) {
		JSONObject properties = (JSONObject) root.get("Properties");
		project.setName((String) properties.get("Project-Name"));
		project.setShortName((String) properties.get("Project-Name-Short"));
		project.setVersionName((String) properties.get("Version-Name"));
		project.setVersionNumber((String) properties.get("Version-Number"));

		project.setProjectType(ProjectTypes.valueOf(((String) properties.get("Project-Type"))));
		project.setParallelAllowed((boolean) properties.get("Allow-Parallel"));
	}

	private void getPNodes(Project project, JSONObject root2) {
		// TODO implement project nodes and how they work

	}

	private void getFiles(Project project, JSONObject root) {
		JSONArray files = (JSONArray) root.get("Files");
		for (int i = 0; i < files.size(); i++) {
			
			JSONObject subFile = (JSONObject) files.get(i);
			
			ProjectFile file = new ProjectFile();
			file.setName((String) subFile.get("File-Name"));
			file.setFileType(FileTypes.valueOf((String) subFile.get("File-Type")));
			file.setLanguage(Languages.valueOf((String) subFile.get("File-Language")));
			file.setFileLocation((String) subFile.get("File-Loc"));
			//TODO file commands
			
			project.addFile(file);
		}

	}

	private void getVariables(Project project, JSONObject root) {
		JSONArray variables = (JSONArray) root.get("Variables");
		for (int i = 0; i < variables.size(); i++) {
			JSONObject var = (JSONObject) variables.get(i);
			String key = (String) var.keySet().toArray()[0];
			project.addVariable(key, (String)var.get(var.keySet().toArray()[0]));
			
		}
	}

	private void getProgress(Project project, JSONObject root) {
		JSONObject progress = (JSONObject) root.get("Progress");
		
		ProjectProgress pp = new ProjectProgress();
		pp.setPercentComplete((String)progress.get("Percent-Complete"));
		pp.setNumTasksTotal((Long) progress.get("Num-Tasks-Total"));
		pp.setNumTasksCompleted((Long) progress.get("Num-Tasks-Completed"));
		pp.setNumTasksLeft((Long) progress.get("Num-Tasks-Left"));
	}

}
