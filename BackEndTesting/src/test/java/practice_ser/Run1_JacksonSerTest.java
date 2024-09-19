package practice_ser;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.ObjectMapper;


@JsonPropertyOrder(
	value = { "createdBy",
			"projectName", 
			"teamSize",
			"status"}
)
@JsonIgnoreProperties(
		value = { "status"}
		)

class Project{  //POJO CLASS
	@JsonProperty(value= "project Name")
	private String projectName;
	@JsonProperty(value ="created By")
	
	private String createdBy;
	@JsonProperty(value="team Size")
	 int teamSize;
	private String status;
	public Project(String projectName, String createdBy, int teamSize, String status) {
		super();
		this.projectName = projectName;
		this.createdBy = createdBy;
		this.teamSize = teamSize;
		this.status = status;
	}
	public Project() {}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public int getTeamSize() {
		return teamSize;
	}
    public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
public class Run1_JacksonSerTest {
	public static void main(String[] args) throws IOException {
		Project pobj=new Project("abc24","gopika",15,"created");
		ObjectMapper objM=new ObjectMapper();
		objM.writeValue(new File("./project.json"), pobj);
		System.out.println("--------completed----------");
	}
	
}
