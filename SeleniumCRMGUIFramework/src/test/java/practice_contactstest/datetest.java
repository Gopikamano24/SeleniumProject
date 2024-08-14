package practice_contactstest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class datetest {

	public static void main(String[] args) {
	
	   Date dobj= new Date();
	   SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");
	   String currentdate=sim.format(dobj);
	   System.out.println(currentdate);
	   
	   Calendar cal=sim.getCalendar();
	   cal.add(Calendar.DAY_OF_MONTH, 30);
	   String datereq=sim.format(cal.getTime());
	   System.out.println(datereq);
	   
	   
	}

}
