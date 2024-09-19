package practice_ser;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;




public class Run2_DeSerTest {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		FileInputStream filein=new FileInputStream("./file.txt");
		ObjectInputStream objinput=new ObjectInputStream(filein);
		NFSCGame userobj1=(NFSCGame)objinput.readObject();
		
		
		System.out.println(userobj1.level);
		System.out.println(userobj1.score);
		System.out.println(userobj1.name);
		System.out.println(userobj1.life);
	}

}
