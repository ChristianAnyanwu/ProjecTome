package projectMaster;

public class ProjectListItem {
	private String name;
	private String shortName;
	private String fileLoc;
	
	public ProjectListItem(String name, String shortName, String fileLoc) {
		super();
		this.name = name;
		this.shortName = shortName;
		this.fileLoc = fileLoc;
	}
	
	public String getName() {
		return name;
	}
	public String getShortName() {
		return shortName;
	}
	public String getFileLoc() {
		return fileLoc;
	}
	
	
}
