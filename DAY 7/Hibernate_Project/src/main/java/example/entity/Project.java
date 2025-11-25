package example.entity;

public class Project {
    private Integer projectId;
    private String title;
    private String mainTech;
    private int duration;
   
	public Project(Integer projectId, String title, String mainTech, int duration) {
		super();
		this.projectId = projectId;
		this.title = title;
		this.mainTech = mainTech;
		this.duration = duration;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMainTech() {
		return mainTech;
	}

	public void setMainTech(String mainTech) {
		this.mainTech = mainTech;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	
	
}
