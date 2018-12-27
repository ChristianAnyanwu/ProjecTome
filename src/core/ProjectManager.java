package core;

import java.util.ArrayList;
import java.util.List;

import base.Base;
import command.CommandManager;
import input.InputManager;
import log.Log;
import output.OutputManager;
import project.Project;
import projectMaster.MasterProject;
import projectMaster.MasterProjectLoader;

public class ProjectManager {

	public static void main(String[] args) {
		System.out.println("------Starting Processes------");
		ProjectManager pm = new ProjectManager();
		pm.run();

		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			public void run() {
				System.out.println("------Closing Processes------");
				List<String> log = pm.log.getLog();
				for (String string : log) {
					System.out.println(string);
				}
			}
		}, "Shutdown-thread"));
	}

	public InputManager im;
	public OutputManager om;
	public CommandManager cm;
	public MasterProject mp;

	// TODO implement system to have new log file created on close
	Log log = new Log();

	static Base base;

	public Project project;

	String ProjectMasterFileLocation = "C:/Users/Christian/Desktop/Projects/ProjectManager/MasterProject.json";

	boolean keepRunning = true;
	
	private void run() {

		StartProjectSubSystem();
		StartInputSubSystem();
		StartCommandSubSystem();

		while (keepRunning) {
			coreCommandLoop();
		}

		// main loop just no while for now
		/*
		 * ArrayList<String> cmds = im.getCommands();
		 * 
		 * if (cmds.size() > 0) {
		 * 
		 * }
		 */

	}

	private void coreCommandLoop() {
		// TODO Auto-generated method stub
		ArrayList<String> commands = im.getCommandInput();
		cm.processCommands(this, commands, project);
	}

	private void StartProjectSubSystem() {
		mp = MasterProjectLoader.getMasterProject(ProjectMasterFileLocation, log);
	}

	private void StartInputSubSystem() {
		im = new InputManager(log);
	}

	private void StartCommandSubSystem() {
		cm = new CommandManager(log);
	}

	// -----------------Setters and Getters
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public InputManager getIm() {
		return im;
	}

	public OutputManager getOm() {
		return om;
	}

	public CommandManager getCm() {
		return cm;
	}

	public MasterProject getMp() {
		return mp;
	}

	public Log getLog() {
		return log;
	}

	public boolean isKeepRunning() {
		return keepRunning;
	}

	public void setKeepRunning(boolean keepRunning) {
		this.keepRunning = keepRunning;
	}

}
