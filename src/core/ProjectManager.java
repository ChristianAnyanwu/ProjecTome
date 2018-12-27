package core;

import java.util.ArrayList;

import base.Base;
import command.CommandManager;
import input.InputManager;
import output.OutputManager;
import project.Project;
import projectMaster.MasterProject;
import projectMaster.MasterProjectLoader;

public class ProjectManager {

	public static void main(String[] args) {
		ProjectManager pm = new ProjectManager();
		pm.run();

	}

	static InputManager im;
	static OutputManager om;
	static CommandManager cm;
	static MasterProject mp;

	static Base base;
	
	Project project;

	String ProjectMasterFileLocation = "C:/Users/Christian/Desktop/Projects/ProjectManager/MasterProject.json";
	
	
	
	private void run() {
		
		StartProjectSubSystem();
		StartInputSubSystem();
		project = mp.getProjectByName("Test");
		
		coreCommandLoop();
		
		//main loop just no while for now
		/*ArrayList<String> cmds = im.getCommands();
	
		if (cmds.size() > 0) {

		}*/
		
		
	}

	private void coreCommandLoop() {
		// TODO Auto-generated method stub
		ArrayList<String> commands = im.getCommandInput();
		cm.processCommands(commands);
	}

	private void StartProjectSubSystem() {
		mp = MasterProjectLoader.getMasterProject(ProjectMasterFileLocation);
		
	}
	
	private void StartInputSubSystem() {
		im = new InputManager();
	}

}
