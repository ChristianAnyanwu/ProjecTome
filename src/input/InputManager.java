package input;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class InputManager {
	
	UserInputManager uim = new UserInputManager();

	public ArrayList<String> getCommandInput() {
		String commandsRaw = uim.getUserInputString("Enter Commands:");
		
		String[] commandsSplit = commandsRaw.split("[.;,]");
		ArrayList<String> commands = (ArrayList<String>) Arrays.asList(commandsSplit);
		
		return commands;
	}

}
