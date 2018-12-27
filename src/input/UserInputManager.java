package input;

import javax.swing.JOptionPane;

public class UserInputManager {
	enum UserInputTypes {
		Text, ComputerDialog
	}

	UserInputTypes userInputType = UserInputTypes.ComputerDialog;
	// TODO implement userINputtypes into project manager file so that it is
	// saved

	public void setCurrentUserInputMethod(UserInputTypes uit) {
		userInputType = uit;
	}

	public String getUserInputString(String question) {
		switch (userInputType) {
		case ComputerDialog:
			return getUserInputStringFromDialog(question);
		// TODO implement userinput type string response for texting input
		default:
			break;
		}
		return "";
	}

	public Boolean getUserYesNo(String question) {
		switch (userInputType) {
		case ComputerDialog:
			return getUserYesNoFromDialog(question);
		// TODO implement userinput type yesno for texting input
		default:
			break;
		}
		return false;
	}

	private String getUserInputStringFromDialog(String question) {
		String response = JOptionPane.showInputDialog(null, question);
		if (response == null) {
			return "";
		}
		return response;
	}

	private Boolean getUserYesNoFromDialog(String question) {
		//TODO allow title to change
		int response = JOptionPane.showConfirmDialog(null, question,"title",0);

		if (response == 0) {
			return true;
		}
		return false;
	}
	
	//TODO put in yesnocancel option for user input
}
