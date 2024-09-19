package practice_ser;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class NFSCGame implements Serializable{
	
	String name;
	int level;
	long score;
	int life;
	public NFSCGame(String name, int level, long score, int life) {
		super();
		this.name = name;
		this.level = level;
		this.score = score;
		this.life = life;
	}
	
	
}


public class Run1_ser {
	
	public static void main(String[] args) throws IOException {
		
		NFSCGame userobj=new NFSCGame("gopika",12,240,2);
		FileOutputStream fileout=new FileOutputStream("./file.txt");
		
		ObjectOutputStream objout=new ObjectOutputStream(fileout);
		objout.writeObject(userobj);
		System.out.println("----------------completed--------------");
	}

}
