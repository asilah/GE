package test;



import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Calendar;
import java.util.Date;

import org.gestion.emp.entities.Employe;
import org.gestion.emp.metier.IEmployeMetier;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itextpdf.text.DocumentException;
import com.paulhitz.nga.payslips.BulletinDePaieGenPDF;

public class test {
	
	public static int getWorkingDaysBetweenTwoDates(Date startDate, Date endDate) {
	    Calendar startCal = Calendar.getInstance();
	    startCal.setTime(startDate);        

	    Calendar endCal = Calendar.getInstance();
	    endCal.setTime(endDate);

	    int workDays = 0;

	    //Return 0 if start and end are the same
	    if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
	        return 0;
	    }

	    if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
	        startCal.setTime(endDate);
	        endCal.setTime(startDate);
	    }

	    do {
	       //excluding start date
	        startCal.add(Calendar.DAY_OF_MONTH, 1);
	        if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
	            ++workDays;
	        }
	    } while (startCal.getTimeInMillis() < endCal.getTimeInMillis()); //excluding end date

	    return workDays;
	}

	public static void main(String[] args) throws MalformedURLException, IOException, DocumentException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		IEmployeMetier m = (IEmployeMetier) context.getBean("metier");
		Employe e = new Employe();
		e.setCodeEmp(1L);
		e=m.findEmloye(e);
		BulletinDePaieGenPDF pdf = new BulletinDePaieGenPDF(e);
		pdf.creerLeFichier("kk");
		

//Employe e = new Employe();
//e.setCodeEmp(1L);
//Date d = new Date(115,11,2);
//System.out.println(d);
//BulletinPaie p = m.getInfoSalaire(e,d,true);
//System.out.println(p);
//System.out.println(p.getNbJours());
//System.out.println(p.getHeureSup1());
//System.out.println(p.getHeureSup2());
//System.out.println(p.getHeureSup3());
//
//e.setCodeEmp(1L);
//BulletinPaie dr = m.getInfoSalaire(e,new Date(115,10,20),false);
//System.out.println(dr);
//		Departement d = new Departement();
//		d.setCodeDept(1L);
//		System.out.println("list des emp ne sont pas en conge");
//		List<Employe> emp = m.getEmployesByDepartement(false,d);
//		for (Employe e : emp) {
//			System.out.println(e.getCodeEmp());
//		}
//		d.setCodeDept(2L);
//		System.out.println("list de tout emp ");
//		emp = m.getEmployesByDepartement(true,d);
//		for (Employe e : emp) {
//			System.out.println(e.getCodeEmp());
//		}
//Employe e = new Employe();
//e.setCodeEmp(1L);
////m.addEmplye(e);
//m.debloquerEmploye(e);

	}

}
