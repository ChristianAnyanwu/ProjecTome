package core;

import java.util.ArrayList;

import base.Base;
import command.CommandManager;
import input.InputManager;
import output.OutputManager;
import project.ProjectLoader;

public class ProjectManager {

	public static void main(String[] args) {
		ProjectManager pm = new ProjectManager();
		pm.run();

	}

	InputManager im;
	OutputManager om;
	CommandManager cm;
	ProjectLoader pl;

	Base base;

	private void run() {
		//main loop just no while for now
		ArrayList<String> cmds = im.getCommands();
	
		if (cmds.size() > 0) {

		}
	}

}
