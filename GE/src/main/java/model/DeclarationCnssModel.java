package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.gestion.emp.entities.BulletinPaie;
import org.gestion.emp.entities.Employe;



public class DeclarationCnssModel {
	
	private String numCnss;
	private String Ste;
	private String Cin;
	private String Nom;
	private String Prenom;
	private Date Naissance;
	private Date Embauche;
	private int nbJour;
	private int heureSupS1;
	private int heureSupS2;
	private int heureSupS3;
	private double salbase;
	private int perAn;
	private double an;
	private double salBrute;
	private double cotCnss;
	private double SalNet;
	private double  totAF;
	private double totRS;
	private double TotCV;
	public double getTotAF() {
		return totAF;
	}

	public void setTotAF(double totAF) {
		this.totAF = totAF;
	}

	public double getTotRS() {
		return totRS;
	}

	public void setTotRS(double totRS) {
		this.totRS = totRS;
	}

	public double getTotCV() {
		return TotCV;
	}

	public void setTotCV(double totCV) {
		TotCV = totCV;
	}

	public double getTotFP() {
		return totFP;
	}

	public void setTotFP(double totFP) {
		this.totFP = totFP;
	}

	public double getTotTOT() {
		return totTOT;
	}

	public void setTotTOT(double totTOT) {
		this.totTOT = totTOT;
	}

	private double totFP;
	private double totTOT;

	public DeclarationCnssModel() {
		super();
		// TODO Auto-generated constructor stub
		
		Ste = "MA SOCIETE";
		numCnss = "CNSS";
		Nom = "nom";
		Prenom = "prenom";
		Naissance = new Date();
		Embauche = new Date();
		Cin="BB101908";
		nbJour=0;
		heureSupS1=0;
		heureSupS2=0;
		heureSupS3=0;
		salbase=00.00;
		perAn=0;
		an=0.0;
		salBrute=0.00;
		cotCnss=0.0;
		SalNet =0.0;
		
	}
	
	public DeclarationCnssModel(BulletinPaie b) {
		super();
		// TODO Auto-generated constructor stub
		Employe e=b.getEmploye();
		Ste = b.getEntreprise().getNom();
		numCnss = e.getNumCnss();
		Nom = e.getNom();
		Prenom = e.getPrenom();
		Naissance =e.getDateNaissance();
		Embauche = e.getDateEntre();
		Cin=e.getCin();
		nbJour=b.getNbJours();
		heureSupS1=b.getHeureSup1();
		heureSupS2=b.getHeureSup2();
		heureSupS3=b.getHeureSup3();
		salbase=(b.getNbJours()+1.25*b.getHeureSup1()+1.5*b.getHeureSup2()+2*b.getHeureSup3())*e.getSalBase();
		perAn=b.getAnciennete();
		an=salbase*perAn/100;
		salBrute=salbase+an;
		cotCnss=salBrute*0.0448;
		SalNet =salBrute-cotCnss;
		totAF=0.0;
		 totRS=0.0;
		 TotCV=0.0;
		 totFP=0.0;
		 totTOT=0.0;
	}
	
	public DeclarationCnssModel Total(List<DeclarationCnssModel> l){
		DeclarationCnssModel t= new DeclarationCnssModel();
		for (DeclarationCnssModel e : l) {
			t.setAn(t.getAn()+e.getAn());
			t.setSalbase(t.getSalbase()+e.getSalbase());
			t.setSalBrute(t.getSalBrute()+e.getSalBrute());
			t.setCotCnss(t.getCotCnss()+e.getCotCnss());
			t.setSalNet(t.getSalNet()+e.getSalNet());
		}
		t.setTotAF(t.getSalBrute()*0.064);
		t.setTotRS(t.getSalBrute()*0.1346);
		t.setTotCV(t.getTotAF()+t.getTotRS());
		t.setTotFP(t.getSalBrute()*0.016);
		t.setTotTOT(t.getTotFP()+t.getTotCV());
		return t;	
	}
	public String getNumCnss() {
		return numCnss;
	}

	public void setNumCnss(String numCnss) {
		this.numCnss = numCnss;
	}

	public String getSte() {
		return Ste;
	}

	public void setSte(String ste) {
		Ste = ste;
	}

	public String getCin() {
		return Cin;
	}

	public void setCin(String cin) {
		Cin = cin;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public Date getNaissance() {
		return Naissance;
	}

	public void setNaissance(Date naissance) {
		Naissance = naissance;
	}

	public Date getEmbauche() {
		return Embauche;
	}

	public void setEmbauche(Date embauche) {
		Embauche = embauche;
	}

	public int getNbJour() {
		return nbJour;
	}

	public void setNbJour(int nbJour) {
		this.nbJour = nbJour;
	}

	public int getHeureSupS1() {
		return heureSupS1;
	}

	public void setHeureSupS1(int heureSupS1) {
		this.heureSupS1 = heureSupS1;
	}

	public int getHeureSupS2() {
		return heureSupS2;
	}

	public void setHeureSupS2(int heureSupS2) {
		this.heureSupS2 = heureSupS2;
	}

	public int getHeureSupS3() {
		return heureSupS3;
	}

	public void setHeureSupS3(int heureSupS3) {
		this.heureSupS3 = heureSupS3;
	}

	public double getSalbase() {
		return salbase;
	}

	public void setSalbase(double salbase) {
		this.salbase = salbase;
	}

	public int getPerAn() {
		return perAn;
	}

	public void setPerAn(int perAn) {
		this.perAn = perAn;
	}

	public double getAn() {
		return an;
	}

	public void setAn(double an) {
		this.an = an;
	}

	public double getSalBrute() {
		return salBrute;
	}

	public void setSalBrute(double salBrute) {
		this.salBrute = salBrute;
	}

	public double getCotCnss() {
		return cotCnss;
	}

	public void setCotCnss(double cotCnss) {
		this.cotCnss = cotCnss;
	}

	public double getSalNet() {
		return SalNet;
	}

	public void setSalNet(double salNet) {
		SalNet = salNet;
	}
	
	public List<DeclarationCnssModel> Demo(int taille){
		List<DeclarationCnssModel> a= new ArrayList<DeclarationCnssModel>();
		for(int i=0; i<=taille; i++)
		a.add(new DeclarationCnssModel());
		return a;
	}
	


}
