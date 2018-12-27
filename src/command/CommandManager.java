package command;

import java.util.ArrayList;

import log.Log;

public class CommandManager {
	Log log;
	
	public CommandManager(Log _log) {
		log = _log;
	}

	public void processCommands(ArrayList<String> commands) {
		//TODO manage incoming commands
		for (int i = 0; i < commands.size(); i++) {
			log.log(this, "Recieved cmd: " + commands.get(i));
		}
	}
	
}
