package project;

public class ProjectProgress {

	String percentComplete;
	Long numTasksTotal, numTasksCompleted, numTasksLeft;

	public ProjectProgress() {
	}

	public Long getNumTasksTotal() {
		return numTasksTotal;
	}

	public void setNumTasksTotal(Long numTasksTotal) {
		this.numTasksTotal = numTasksTotal;
	}

	public Long getNumTasksCompleted() {
		return numTasksCompleted;
	}

	public void setNumTasksCompleted(Long numTasksCompleted) {
		this.numTasksCompleted = numTasksCompleted;
	}

	public Long getNumTasksLeft() {
		return numTasksLeft;
	}

	public void setNumTasksLeft(Long numTasksLeft) {
		this.numTasksLeft = numTasksLeft;
	}

	public String getPercentComplete() {
		//TODO change percent complete when progress is made
		return percentComplete;
	}

	public void setPercentComplete(String percentComplete) {
		this.percentComplete = percentComplete;
	}
	
}
