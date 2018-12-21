package projectMaster;

import java.util.ArrayList;

import project.Project;

public class MasterProject {

	ProjectLoader pl = new ProjectLoader();

	ArrayList<ProjectListItem> projects;

	public MasterProject(ArrayList<ProjectListItem> _projects) {
		projects = _projects;
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

	private Project getProjectByName(String projectName) {
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
