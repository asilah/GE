package test;

import java.util.Date;

import org.gestion.emp.entities.BulletinPaie;

public class mian {

	public static void main(String[] args) {
Date d = new Date(115,11,2);

System.out.println(d.getYear()+"    "+d.getMonth()+"    ");
System.out.println(d);
BulletinPaie b = new BulletinPaie();
System.out.println(b.getNbJoursTravail(new Date(115,10,20),false));
	
	}
	
	
	


}
