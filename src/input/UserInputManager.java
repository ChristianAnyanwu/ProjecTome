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

	public void messageUser(String message) {
		messageUser("", message);
	}

	public void messageUser(String title, String message) {
		// TODO how to handle whether user recieved response?
		switch (userInputType) {
		case ComputerDialog:
			messageUserWithDialog(title, message);
			break;
		// TODO implement texting response for messaging user
		default:
			break;
		}
	}

	private String getUserInputStringFromDialog(String question) {
		String response = JOptionPane.showInputDialog(null, question);
		if (response == null) {
			return "";
		}
		return response;
	}

	private Boolean getUserYesNoFromDialog(String question) {
		// TODO allow title to change
		int response = JOptionPane.showConfirmDialog(null, question, "title", 0);

		if (response == 0) {
			return true;
		}
		return false;
	}

	private void messageUserWithDialog(String title, String message) {
		JOptionPane.showMessageDialog(null, message, title, 1);
	}

	// TODO put in yesnocancel option for user input
}
