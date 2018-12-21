package projectMaster;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import project.Project;
import util.FileUtility;

public class ProjectLoader {

	static JSONObject root = new JSONObject();
	static JSONParser parser = new JSONParser();
	static FileUtility fl = new FileUtility();

	public Project loadProject(String fileLoc) {
		try {
		Project project = new Project();
		
		JSONObject root = getProjectAsJsonRoot(fileLoc);
		
		
		
		
		return project;
		
		} catch (Exception e) {
			// TODO: handle exception better
			return null;
		}
	}

	public JSONObject getProjectAsJsonRoot(String fileLoc) {
		String projectJson = fl.readFileAsString(fileLoc);
		try {
			return (JSONObject) parser.parse(projectJson);
		} catch (ParseException e) {
			// TODO handle error
			e.printStackTrace();
		}
		return null;
	}

}
