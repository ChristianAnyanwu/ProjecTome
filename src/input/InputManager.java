package input;

import java.util.ArrayList;

import log.Log;

public class InputManager {
	Log log;
	
	
	UserInputManager uim = new UserInputManager();
	//TODO have command split criteria set in project manager 
	String commandSplitCriteria = "[.;,]";

	public InputManager(Log _log) {
		log = _log;
	}

	public ArrayList<String> getCommandInput() {
		String commandsRaw = uim.getUserInputString("Enter Commands:");
		String[] commandsSplit = commandsRaw.split(commandSplitCriteria);
		
		ArrayList<String> commands = new ArrayList<String>();
		
		for (int i = 0; i < commandsSplit.length; i++) {
			commands.add(commandsSplit[i].trim());
		}
				
		return commands;
	}

}
