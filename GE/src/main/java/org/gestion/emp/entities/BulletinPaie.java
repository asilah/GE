package org.gestion.emp.entities;

import java.util.Calendar;
import java.util.Date;

public class BulletinPaie {

	private Employe employe;
	private Entreprise entreprise;
	private Date datePaie;
	private String mois;
	private int heureNormale;
	private int heureSup1;
	private int heureSup2;
	private int heureSup3;
	private int nbJours;
	private int anciennete;
	
	
	
	public BulletinPaie(Employe employe, Entreprise entreprise, Date datePaie, String mois, int heureNormale,
			int heureSup1, int heureSup2, int heureSup3, int nbJours, int anciennete) {
		super();
		this.employe = employe;
		this.entreprise = entreprise;
		this.datePaie = datePaie;
		this.mois = mois;
		this.heureNormale = heureNormale;
		this.heureSup1 = heureSup1;
		this.heureSup2 = heureSup2;
		this.heureSup3 = heureSup3;
		this.nbJours = nbJours;
		this.anciennete = anciennete;
	}
	
	public BulletinPaie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public Entreprise getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	public Date getDatePaie() {
		return datePaie;
	}
	public void setDatePaie(Date datePaie) {
		this.datePaie = datePaie;
	}
	public String getMois() {
		return mois;
	}
	public void setMois(String mois) {
		this.mois = mois;
	}
	public int getHeureNormale() {
		return heureNormale;
	}
	public void setHeureNormale(int heureNormale) {
		this.heureNormale = heureNormale;
	}
	public int getHeureSup1() {
		return heureSup1;
	}
	public void setHeureSup1(int heureSup1) {
		this.heureSup1 = heureSup1;
	}
	public int getHeureSup2() {
		return heureSup2;
	}
	public void setHeureSup2(int heureSup2) {
		this.heureSup2 = heureSup2;
	}
	public int getHeureSup3() {
		return heureSup3;
	}
	public void setHeureSup3(int heureSup3) {
		this.heureSup3 = heureSup3;
	}
	public int getNbJours() {
		return nbJours;
	}
	public void setNbJours(int nbJours) {
		this.nbJours = nbJours;
	}
	public int getAnciennete() {
		return anciennete;
	}
	public void setAnciennete(int anciennete) {
		this.anciennete = anciennete;
	}
	
	public static int getWorkingDaysBetweenTwoDates(Date startDate, Date endDate) {
	    Calendar startCal = Calendar.getInstance();
	    System.out.println(""+startDate+"    "+endDate);
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
	public int getNbJoursTravail(Date date, boolean normal){
		int i,k=0,d=date.getDate();
		if ( normal ){
			if ( date.getMonth() == 0 ) date = new Date(date.getYear()-1, 11, 1);
			else 	date = new Date(date.getYear(), date.getMonth()-1, 1);
			for ( i = 1; i < 8; i++) {
				date.setDate(i);
				if ( date.getDay()==0 ) break;
			}
			if ( i+28 > getJoursMois (date) ) return getJoursMois (date) -4;
			else return getJoursMois (date) -5;
		}
		else {
			for ( i = 1; i <= d; i++) {
				
				date.setDate(i);
				if ( date.getDay()==0 ) k++;
			}
			return d-k;
		}
	}
	
	public int getNbJoursTravail(Date date, Date date2){
		return getWorkingDaysBetweenTwoDates(date, date2);
	}
	

	public int getJoursMois(Date date){
		switch (date.getMonth()) {
		case 0:return 31; 
		case 1:if (date.getYear()%4==0)return 29; else return 28; 
		case 2:return 31; 
		case 3:return 30; 
		case 4:return 31; 
		case 5:return 30; 
		case 6:return 31; 
		case 7:return 31; 
		case 8:return 30; 
		case 9:return 31; 
		case 10:return 30; 
		case 11:return 31; 
		default:return 0;
		}
		
	}

	@Override
	public String toString() {
		return "BulletinPaie [employe=" + employe + ", entreprise=" + entreprise + ", datePaie=" + datePaie + ", mois="
				+ mois + ", heureNormale=" + heureNormale + ", heureSup1=" + heureSup1 + ", heureSup2=" + heureSup2
				+ ", heureSup3=" + heureSup3 + ", nbJours=" + nbJours + ", anciennete=" + anciennete + "]";
	}
	
	
	
}
