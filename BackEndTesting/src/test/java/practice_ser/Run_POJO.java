
package practice_ser;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
	

	 class project1 {

	   private String username;

	   private String projecttatus;

	   private int teamSize;

	   private  List<String> teamMember;

	   private ProjectManager projectManager;


	    public project1(String username, String projecttatus, int teamSize, List<String> teamMember,
			ProjectManager projectManager) {
		super();
		this.username = username;
		this.projecttatus = projecttatus;
		this.teamSize = teamSize;
		this.teamMember = teamMember;
		this.projectManager = projectManager;
	}
		public void setUsername(String username) {
	        this.username = username;
	    }
	    public String getUsername() {
	        return username;
	    }
	    
	    public void setProjecttatus(String projecttatus) {
	        this.projecttatus = projecttatus;
	    }
	    public String getProjecttatus() {
	        return projecttatus;
	    }
	    
	    public void setTeamSize(int teamSize) {
	        this.teamSize = teamSize;
	    }
	    public int getTeamSize() {
	        return teamSize;
	    }
	    
	    public void setTeamMember(List<String> teamMember) {
	        this.teamMember = teamMember;
	    }
	    public List<String> getTeamMember() {
	        return teamMember;
	    }
	    
	    public void setProjectManager(ProjectManager projectManager) {
	        this.projectManager = projectManager;
	    }
	    public ProjectManager getProjectManager() {
	        return projectManager;
	    }
	    
	}
	
	 class ProjectManager {

	   String name;
	   String area;
	   String empid;
       String dist;

	    public ProjectManager(String name, String area, String empid, String dist) {
		super();
		this.name = name;
		this.area = area;
		this.empid = empid;
		this.dist = dist;
	}
		
	    
		public String getArea() {
			return area;
		}


		public void setArea(String area) {
			this.area = area;
		}


		public String getDist() {
			return dist;
		}


		public void setDist(String dist) {
			this.dist = dist;
		}


		public void setName(String name) {
	        this.name = name;
	    }
	    public String getName() {
	        return name;
	    }
	    
	    public void setEmpid(String empid) {
	        this.empid = empid;
	    }
	    public String getEmpid() {
	        return empid;
	    }
	    
	}
	 public class Run_POJO {
		 public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
			List<String> lst=new ArrayList<String>();
			lst.add("john");
			lst.add("david");
			lst.add("stev");
			
			ProjectManager pM=new ProjectManager("sagar","salem", "tp05","nadoor");
			
			project1 projectobj = new project1("gopika", "created", 10, lst, pM);
			ObjectMapper obj=new ObjectMapper();
			
			obj.writeValue(new File("./project1.json"), projectobj);
		}
}