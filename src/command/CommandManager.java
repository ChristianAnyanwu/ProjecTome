package command;

import java.util.ArrayList;

import input.UserInputManager;
import log.Log;
import project.Project;

public class CommandManager {
	Log log;
	UserInputManager uim = new UserInputManager();

	public CommandManager(Log _log) {
		log = _log;
	}

	public void processCommands(ArrayList<String> commands, Project currentProject) {
		boolean haveCurrentProject = currentProject != null;

		String responseToUser = "";

		// TODO manage incoming commands
		for (int i = 0; i < commands.size(); i++) {

			String cmdFull = commands.get(i);
			String cmd = commands.get(i).split("\\s")[0];
			String[] cmdSplit = commands.get(i).split("\\s");

			// check for core commands
			boolean isCore = checkCoreCommandNames(cmd);
			if (isCore) {// Run the core command
				log.log(this, "Recieved Core Cmd: " + cmdFull);
				// TODO run the core command here
				responseToUser += cmd + ": Success\n";
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
		
		//TODO allow for some value the user can put to recieve responses immediately and not when its all done
		//handling response to user
		log.log(this, "Sending User Response: " + responseToUser);
		String title = "Response to User";
		uim.messageUser(title ,responseToUser);
	}

	private boolean checkCoreCommandNames(String string) {
		if (string.contains("a")) {
			return true;
		}
		return false;
	}

	private boolean checkCurrentProjectCommandNames(String string) {
		if (string.contains("b")) {
			return true;
		}
		return false;
	}

}
