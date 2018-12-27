package projectMaster;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import log.Log;
import util.FileUtility;

public class MasterProjectLoader {
	static JSONObject root = new JSONObject();
	static FileUtility fl = new FileUtility();

	public static MasterProject getMasterProject(String projectMasterFileLocation, Log _log) {
		root = fl.getProjectAsJsonRoot(projectMasterFileLocation);

		// getting json value
		JSONArray projects = (JSONArray) root.get("Projects");

		ArrayList<ProjectListItem> projs = new ArrayList<ProjectListItem>();

		for (int i = 0; i < projects.size(); i++) {
			String name = ((JSONObject) projects.get(i)).get("Project-Name").toString().toLowerCase();
			String shortName = ((JSONObject) projects.get(i)).get("Project-Name-Short").toString().toLowerCase();
			String fileLoc = ((JSONObject) projects.get(i)).get("Project-File-Loc").toString().toLowerCase();
			ProjectListItem p = new ProjectListItem(name, shortName, fileLoc);
			projs.add(p);
		}

		return new MasterProject(projs, _log);
	}

}
