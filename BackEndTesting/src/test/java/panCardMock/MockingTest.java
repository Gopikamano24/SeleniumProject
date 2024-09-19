package panCardMock;

import org.mockito.Mockito;
import org.testng.Assert;

class PANCard {

	public  String isvalid(String pancard) {
		
        //its an business logic where its an proper schema which says valid or 
		//invalid according to the data which we pass which comes under the schema(condition)
		//but in mocking we have to pass the data which is considered as
		//dummy data while validating we have to use the same data only..
		
		//if(pancard.matches("[A-Z]{5}[0-9]{4}[A-Z]")==true) 
			
			//if we dont pass number in{} near condition it will take as one only..
			
		return pancard+" is valid";
	}
	
	//if anyone wants to use isvalid() we shd call below () which returns classobj
	//using that classobj we shd use isvalid()..
	
	public  static PANCard getMockObject() {
		
		PANCard mockobj	=Mockito.mock(PANCard.class);
		
		Mockito.when(mockobj.isvalid("CRZPG9994H")).thenReturn("Its an Valid PAN Card");
		Mockito.when(mockobj.isvalid("GKMPG9994H")).thenReturn("Its an Valid PAN Card");
		Mockito.when(mockobj.isvalid("ABCPG9994G")).thenReturn("Its an InValid PAN Card");
		//it says that if you are going to use businesslogic isvalid() u shd use the above
		//3 data only
		return mockobj;
		
	}
}
public class MockingTest{
	
	public static void main(String[] args) {
		PANCard obj=PANCard.getMockObject();
		System.out.println(obj.isvalid("ABCPG9994G"));
	}
	
	
}