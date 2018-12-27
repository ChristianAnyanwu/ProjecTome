package projectMaster;

import java.util.ArrayList;

import log.Log;
import project.Project;

public class MasterProject {
	Log log;
	ProjectLoader pl = new ProjectLoader();

	ArrayList<ProjectListItem> projects;

	public MasterProject(ArrayList<ProjectListItem> _projects, Log _log) {
		projects = _projects;
		log = _log;
	}

	public boolean projectNameExists(String projectName) {
		projectName = projectName.toLowerCase();
		for (ProjectListItem projectListItem : projects) {
			if (projectListItem.getName().equals(projectName)) {
				return true;
			}
			if (projectListItem.getShortName().equals(projectName)) {
				return true;
			}
		}
		return false;
	}

	public Project getProjectByName(String projectName) {
		if (projectNameExists(projectName)) {
			ProjectListItem pli = getProjectListItemByName(projectName);
			return pl.loadProject(pli.getFileLoc());
		}
		return null;
	}

	private ProjectListItem getProjectListItemByName(String projectName) {
		projectName = projectName.toLowerCase();
		for (ProjectListItem projectListItem : projects) {
			if (projectListItem.getName().equals(projectName)) {
				return projectListItem;
			}
			if (projectListItem.getShortName().equals(projectName)) {
				return projectListItem;
			}
		}
		return null;
	}
}
