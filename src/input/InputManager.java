package input;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class InputManager {
	
	UserInputManager uim = new UserInputManager();

	public ArrayList<String> getCommandInput() {
		String commandsRaw = "";

		uim.getUserInputString("Enter Commands:");
		
		System.out.println(commandsRaw);

		return null;
	}

}
