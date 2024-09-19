package practice_ser;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Run2_JacksonDeSerTest {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		ObjectMapper objM= new ObjectMapper();
		Project pobj=objM.readValue(new File("./project.json"), Project.class);
		

		System.out.println(pobj.getProjectName());
		System.out.println(pobj.getCreatedBy());
		System.out.println(pobj.getStatus());
		System.out.println(pobj.getTeamSize());
	}
}

