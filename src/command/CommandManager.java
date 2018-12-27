package command;

import java.util.ArrayList;

import core.ProjectManager;
import input.UserInputManager;
import log.Log;
import project.Project;

public class CommandManager {
	Log log;
	UserInputManager uim = new UserInputManager();

	public CommandManager(Log _log) {
		log = _log;
	}

	public void processCommands(ProjectManager pm, ArrayList<String> commands, Project currentProject) {
		boolean haveCurrentProject = currentProject != null;

		String responseToUser = "";

		// TODO manage incoming commands
		for (int i = 0; i < commands.size(); i++) {

			String cmdFull = commands.get(i);
			String cmd = commands.get(i).split("\\s")[0];
			String[] cmdSplit = commands.get(i).split("\\s");

			for (int j = 0; j < cmdSplit.length; j++) {
			}

			// check for core commands
			boolean isCore = checkCoreCommandNames(cmd);
			if (isCore) {// Run the core command
				log.log(this, "Recieved Core Cmd: " + cmdFull);
				String response = runCoreCommand(cmdSplit, pm, currentProject) + "\n";
				responseToUser += cmd + ": " + response;
				continue;
			}

			// check if there is a current project set
			if (haveCurrentProject) {
				boolean isCurrentProjectCmd = checkCurrentProjectCommandNames(cmd);
				if (isCurrentProjectCmd) {// Run the project command
					log.log(this, "Recieved Project Cmd: " + cmdFull);
					// TODO run the project command here
					responseToUser += cmd + ": Success\n";
					continue;
				}
			}

			// invalid command
			// TODO check other projects for valid commands that match this and
			// suggest a way to resolve
			log.logIssue(this, "Invalid command recieved: " + cmdFull);
			responseToUser += cmd + ": Failure- Invalid Command\n";

		}

		// TODO allow for some value the user can put to recieve responses
		// immediately and not when its all done
		// handling response to user
		log.log(this, "Sending User Response: " + responseToUser);
		String title = "Response to User";
		uim.messageUser(title, responseToUser);
	}

	private String runCoreCommand(String[] cmdSplit, ProjectManager pm, Project currentProject) {
		boolean successful = false;
		String cmd = cmdSplit[0];
		switch (cmd) {
		case "sp":// set project
			if (cmdSplit.length != 2) {// checking argument count

				return log.logIssue(this, "Cmd Failure- Incorrect Arg count (s.b. 2)");
			}
			String projectName = cmdSplit[1];

			if (currentProject != null) {// if there is a current project
				// TODO close the current project
			}
			boolean projectExists = pm.getMp().projectNameExists(projectName);
			if (projectExists) {
				pm.setProject(pm.getMp().getProjectByName(projectName));
				if (pm.getProject() != null) {
					successful = true;
					return log.logSuccess(this, "Success- Project \"" + projectName + "\" successfully loaded.");
				} else {
					return log.logErr(this, "Failure- Project setting failure, reason unknown");
				}
			} else {
				return log.logIssue(this, "Failure- \"" + projectName + "\" is an unknown project name");
			}
		case "cp":// close project
			break;
		case "gp":// get project variable, returns some value of the project
			break;
		case "quit":
			pm.setKeepRunning(false);
			successful = true;
			break;
		}

		if (successful) {
			return log.logSuccess(this, "Success- " + cmd);
		}
		// TODO log the issue with the user input
		return "Failed";
	}

	String[] coreCommandList = { "sp", "cp", "gp", "quit" };

	private boolean checkCoreCommandNames(String cmd) {
		cmd = cmd.toLowerCase();
		for (int i = 0; i < coreCommandList.length; i++) {
			if (cmd.equals(coreCommandList[i])) {
				return true;
			}
		}
		return false;
	}

	private boolean checkCurrentProjectCommandNames(String cmd) {
		// TODO check the current projects names list get them from the files
		// cmds lists
		return false;
	}

}
