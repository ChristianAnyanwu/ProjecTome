package project;

public class ProjectFile {

	String name;

	public enum FileTypes {
		MainRunnable, DataStorage, CodeStorage, VariableStorage
	}

	FileTypes fileType;

	public enum Languages {
		Java, Python, Txt, CSV
	}

	Languages language;

	String fileLocation;

	// -------
	public ProjectFile() {
	}
	// -------------

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FileTypes getFileType() {
		return fileType;
	}

	public void setFileType(FileTypes fileType) {
		this.fileType = fileType;
	}

	public Languages getLanguage() {
		return language;
	}

	public void setLanguage(Languages language) {
		this.language = language;
	}

	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

}
