package model;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Random;

import org.gestion.emp.entities.BulletinPaie;
import org.gestion.emp.entities.Employe;
import org.gestion.emp.entities.Entreprise;

public class BulletinPaieForm {
	
	public String DateToString(Date d){
		int y=d.getYear()+1900;
		int m=d.getMonth()+1;
		return ""+d.getDate()+"/"+m+"/"+y;
	}
	
	public Date getBulletinDate() {
		return bulletinDate;
	}

	public void setBulletinDate(Date bulletinDate) {
		this.bulletinDate = bulletinDate;
	}

	public long getBulletinNum() {
		return bulletinNum;
	}

	public void setBulletinNum(long bulletinNum) {
		this.bulletinNum = bulletinNum;
	}

	public String getSte() {
		return ste;
	}

	public void setSte(String ste) {
		this.ste = ste;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNumCNSSSTE() {
		return numCNSSSTE;
	}

	public void setNumCNSSSTE(String numCNSSSTE) {
		this.numCNSSSTE = numCNSSSTE;
	}

	public long getMatr() {
		return Matr;
	}

	public void setMatr(long matr) {
		Matr = matr;
	}

	public long getDept() {
		return Dept;
	}

	public void setDept(long dept) {
		Dept = dept;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNationalite() {
		return Nationalite;
	}

	public void setNationalite(String nationalite) {
		Nationalite = nationalite;
	}

	public String getNumCNSEMP() {
		return numCNSEMP;
	}

	public void setNumCNSEMP(String numCNSEMP) {
		this.numCNSEMP = numCNSEMP;
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

	public String getQualifaction() {
		return Qualifaction;
	}

	public void setQualifaction(String qualifaction) {
		Qualifaction = qualifaction;
	}

	public String getSitFam() {
		return SitFam;
	}

	public void setSitFam(String sitFam) {
		SitFam = sitFam;
	}

	public String getPaiement() {
		return Paiement;
	}

	public void setPaiement(String paiement) {
		Paiement = paiement;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public String getDépartement() {
		return département;
	}

	public void setDépartement(String département) {
		this.département = département;
	}

	public String getSN_Base() {
		return SN_Base;
	}

	public void setSN_Base(String sN_Base) {
		SN_Base = sN_Base;
	}

	public String getSN_Taux() {
		return SN_Taux;
	}

	public void setSN_Taux(String sN_Taux) {
		SN_Taux = sN_Taux;
	}

	public String getSN_Gain() {
		return SN_Gain;
	}

	public void setSN_Gain(String sN_Gain) {
		SN_Gain = sN_Gain;
	}

	public String getSN_Retenue() {
		return SN_Retenue;
	}

	public void setSN_Retenue(String sN_Retenue) {
		SN_Retenue = sN_Retenue;
	}

	public String getHS1_Base() {
		return HS1_Base;
	}

	public void setHS1_Base(String hS1_Base) {
		HS1_Base = hS1_Base;
	}

	public String getHS1_Taux() {
		return HS1_Taux;
	}

	public void setHS1_Taux(String hS1_Taux) {
		HS1_Taux = hS1_Taux;
	}

	public String getHS1_Gain() {
		return HS1_Gain;
	}

	public void setHS1_Gain(String hS1_Gain) {
		HS1_Gain = hS1_Gain;
	}

	public String getHS1_Retenue() {
		return HS1_Retenue;
	}

	public void setHS1_Retenue(String hS1_Retenue) {
		HS1_Retenue = hS1_Retenue;
	}

	public String getHS2_Base() {
		return HS2_Base;
	}

	public void setHS2_Base(String hS2_Base) {
		HS2_Base = hS2_Base;
	}

	public String getHS2_Taux() {
		return HS2_Taux;
	}

	public void setHS2_Taux(String hS2_Taux) {
		HS2_Taux = hS2_Taux;
	}

	public String getHS2_Gain() {
		return HS2_Gain;
	}

	public void setHS2_Gain(String hS2_Gain) {
		HS2_Gain = hS2_Gain;
	}

	public String getHS2_Retenue() {
		return HS2_Retenue;
	}

	public void setHS2_Retenue(String hS2_Retenue) {
		HS2_Retenue = hS2_Retenue;
	}

	public String getHS3_Base() {
		return HS3_Base;
	}

	public void setHS3_Base(String hS3_Base) {
		HS3_Base = hS3_Base;
	}

	public String getHS3_Taux() {
		return HS3_Taux;
	}

	public void setHS3_Taux(String hS3_Taux) {
		HS3_Taux = hS3_Taux;
	}

	public String getHS3_Gain() {
		return HS3_Gain;
	}

	public void setHS3_Gain(String hS3_Gain) {
		HS3_Gain = hS3_Gain;
	}

	public String getHS3_Retenue() {
		return HS3_Retenue;
	}

	public void setHS3_Retenue(String hS3_Retenue) {
		HS3_Retenue = hS3_Retenue;
	}

	public String getAL_Base() {
		return AL_Base;
	}

	public void setAL_Base(String aL_Base) {
		AL_Base = aL_Base;
	}

	public String getAL_Taux() {
		return AL_Taux;
	}

	public void setAL_Taux(String aL_Taux) {
		AL_Taux = aL_Taux;
	}

	public String getAL_Gain() {
		return AL_Gain;
	}

	public void setAL_Gain(String aL_Gain) {
		AL_Gain = aL_Gain;
	}

	public String getAL_Retenue() {
		return AL_Retenue;
	}

	public void setAL_Retenue(String aL_Retenue) {
		AL_Retenue = aL_Retenue;
	}

	public String getC_CNSS_Base() {
		return C_CNSS_Base;
	}

	public void setC_CNSS_Base(String c_CNSS_Base) {
		C_CNSS_Base = c_CNSS_Base;
	}

	public String getC_CNSS_Taux() {
		return C_CNSS_Taux;
	}

	public void setC_CNSS_Taux(String c_CNSS_Taux) {
		C_CNSS_Taux = c_CNSS_Taux;
	}

	public String getC_CNSS_Gain() {
		return C_CNSS_Gain;
	}

	public void setC_CNSS_Gain(String c_CNSS_Gain) {
		C_CNSS_Gain = c_CNSS_Gain;
	}

	public String getC_CNSS_Retenue() {
		return C_CNSS_Retenue;
	}

	public void setC_CNSS_Retenue(String c_CNSS_Retenue) {
		C_CNSS_Retenue = c_CNSS_Retenue;
	}

	public String getGaine_Net_Base() {
		return Gaine_Net_Base;
	}

	public void setGaine_Net_Base(String gaine_Net_Base) {
		Gaine_Net_Base = gaine_Net_Base;
	}

	public String getGaine_Net_Taux() {
		return Gaine_Net_Taux;
	}

	public void setGaine_Net_Taux(String gaine_Net_Taux) {
		Gaine_Net_Taux = gaine_Net_Taux;
	}

	public String getGaine_Net_Gain() {
		return Gaine_Net_Gain;
	}

	public void setGaine_Net_Gain(String gaine_Net_Gain) {
		Gaine_Net_Gain = gaine_Net_Gain;
	}

	public String getGaine_Net_Retenue() {
		return Gaine_Net_Retenue;
	}

	public void setGaine_Net_Retenue(String gaine_Net_Retenue) {
		Gaine_Net_Retenue = gaine_Net_Retenue;
	}

	public String getSignature() {
		return Signature;
	}

	public void setSignature(String signature) {
		Signature = signature;
	}

	public String getPour_Quittance() {
		return Pour_Quittance;
	}

	public void setPour_Quittance(String pour_Quittance) {
		Pour_Quittance = pour_Quittance;
	}

	public Date getDate_de_Paie() {
		return date_de_Paie;
	}

	public void setDate_de_Paie(Date date_de_Paie) {
		this.date_de_Paie = date_de_Paie;
	}

	public double getNet_A_Payer() {
		return Net_A_Payer;
	}

	public void setNet_A_Payer(double net_A_Payer) {
		Net_A_Payer = net_A_Payer;
	}

	
	public String getMois() {
		return mois;
	}

	public void setMois(String mois) {
		this.mois = mois;
	}


	private String mois;
	private Date bulletinDate;
	private long bulletinNum;
	private String ste;
	private String adresse;
	private String numCNSSSTE;
	private long Matr;
	private long Dept;
	private String nom;
	private String prenom;
	private String Nationalite;
	private String CIN;
	private String numCNSEMP;
	private Date Naissance;
	private Date Embauche;
	private String Qualifaction;
	private String SitFam;
	private String Paiement;
	private String cat;
	private String département;
	private String SN_Base;
	private String SN_Taux;
	private String SN_Gain;
	private String SN_Retenue;
	private String HS1_Base;
	private String HS1_Taux;
	private String HS1_Gain;
	private String HS1_Retenue;
	private String HS2_Base;
	private String HS2_Taux;
	private String HS2_Gain;
	private String HS2_Retenue;
	private String HS3_Base;
	private String HS3_Taux;
	private String HS3_Gain;
	private String HS3_Retenue;
	private String AL_Base;
	private String AL_Taux;
	private String AL_Gain;
	private String AL_Retenue;
	private String C_CNSS_Base;
	private String C_CNSS_Taux;
	private String C_CNSS_Gain;
	private String C_CNSS_Retenue;
	private String C_AMO_Base;
	private String C_AMO_Taux;
	private String C_AMO_Gain;
	private String C_AMO_Retenue;
	private String Gaine_Net_Base;
	private String Gaine_Net_Taux;
	private String Gaine_Net_Gain;
	private String Gaine_Net_Retenue;
	private String Signature;
	private String Pour_Quittance;
	private Date date_de_Paie;
	private double Net_A_Payer;
	private String paiement;
	private String an_b;
	private String an_t;
	private String an_g;
	private String an_r;
	
	public String getC_AMO_Base() {
		return C_AMO_Base;
	}

	public void setC_AMO_Base(String c_AMO_Base) {
		C_AMO_Base = c_AMO_Base;
	}

	public String getC_AMO_Taux() {
		return C_AMO_Taux;
	}

	public void setC_AMO_Taux(String c_AMO_Taux) {
		C_AMO_Taux = c_AMO_Taux;
	}

	public String getC_AMO_Gain() {
		return C_AMO_Gain;
	}

	public void setC_AMO_Gain(String c_AMO_Gain) {
		C_AMO_Gain = c_AMO_Gain;
	}

	public String getC_AMO_Retenue() {
		return C_AMO_Retenue;
	}

	public void setC_AMO_Retenue(String c_AMO_Retenue) {
		C_AMO_Retenue = c_AMO_Retenue;
	}

	public String getAn_b() {
		return an_b;
	}

	public void setAn_b(String an_b) {
		this.an_b = an_b;
	}

	public String getAn_t() {
		return an_t;
	}

	public void setAn_t(String an_t) {
		this.an_t = an_t;
	}

	public String getAn_g() {
		return an_g;
	}

	public void setAn_g(String an_g) {
		this.an_g = an_g;
	}

	public String getAn_r() {
		return an_r;
	}

	public void setAn_r(String an_r) {
		this.an_r = an_r;
	}

	public BulletinPaieForm() {
		super();
		// TODO Auto-generated constructor stub
		
		
		bulletinDate = new Date();
		bulletinNum = 1L;
		ste = "MA SOCIETE";
		adresse = "adresse de test";
		numCNSSSTE = "CNSSSTE";
		Matr = 1L;
		Dept = 1L;
		nom = "nom";
		prenom = "prenom";
		Nationalite = "Marocaine";
		numCNSEMP = "CNSSEMP";
		Naissance = new Date();
		Embauche = new Date();
		Qualifaction = "Qualification";
		SitFam = "Celib";
		Paiement = "espèce";
		cat = "X";
		CIN="BB101908";
		département = "Informatique";
		SN_Base = "AAAA";
		SN_Taux = "AAAA";
		SN_Gain = "AAAA";
		SN_Retenue = "AAAA";
		HS1_Base = "AAAA";
		HS1_Taux = "AAAA";
		HS1_Gain = "AAAA";
		HS1_Retenue = "AAAA";
		HS2_Base = "AAAA";
		HS2_Taux = "AAAA";
		HS2_Gain = "AAAA";
		HS2_Retenue = "AAAA";
		HS3_Base = "AAAA";
		HS3_Taux = "AAAA";
		HS3_Gain = "AAAA";
		HS3_Retenue = "AAAA";
		AL_Base = "AAAA";
		AL_Taux = "AAAA";
		AL_Gain = "AAAA";
		AL_Retenue = "AAAA";
		C_CNSS_Base = "AAAA";
		C_CNSS_Taux = "AAAA";
		C_CNSS_Gain = "AAAA";
		C_CNSS_Retenue = "AAAA";
		Gaine_Net_Base = "AAAA";
		Gaine_Net_Taux = "AAAA";
		Gaine_Net_Gain = "AAAA";
		Gaine_Net_Retenue = "AAAA";
		Signature = "AAAA";
		Pour_Quittance = "AAAA";
		date_de_Paie = new Date();
		Net_A_Payer = 9092.02;
		paiement="espèce";
		

	}
	
	public static String format(double x) {
		NumberFormat nf = NumberFormat.getInstance(); // get instance
		nf.setMaximumFractionDigits(2); // set decimal places
		String s = nf.format(x);
		return s;
	}
	
	public BulletinPaieForm( BulletinPaie b) {
		super();
		
		double salh=b.getEmploye().getSalBase()/8;
		System.out.println();
		this.mois=b.getMois();
		this.ste=b.getEntreprise().getNom();
		this.date_de_Paie=b.getDatePaie();
		this.adresse=b.getEntreprise().getAddress();
		//this.bulletinNum=(long)date_de_Paie.getHours()*10000+date_de_Paie.getMinutes()*100+date_de_Paie.getSeconds();
		this.bulletinNum=1L;
		//this.numCNSSSTE= b.getEntreprise().getCodeEntrp().toString();
		this.numCNSSSTE="11111111";
		this.Matr= (long) b.getEmploye().getCodeEmp();
		this.Dept=b.getEmploye().getDepartement().getCodeDept();
		this.nom=b.getEmploye().getNom();
		this.prenom=b.getEmploye().getPrenom();
		this.département = b.getEmploye().getDepartement().getNom();
		this.numCNSEMP= b.getEmploye().getNumCnss();
		this.CIN=b.getEmploye().getCin();
		this.Naissance=b.getEmploye().getDateNaissance();
		this.Embauche=b.getEmploye().getDateEntre();
		this.Nationalite = "Marocaine";
		this.Qualifaction=b.getEmploye().getResponsabilite();
		this.SitFam=b.getEmploye().getSituationFamiliale();
		this.SN_Base= ""+b.getEmploye().getSalBase();
		this.SN_Gain= ""+b.getEmploye().getSalBase()*b.getEmploye().getNbJoursTravail();
		double saln=b.getEmploye().getSalBase()*b.getEmploye().getNbJoursTravail();
		this.SN_Taux =""+b.getEmploye().getNbJoursTravail();
		this.SN_Retenue=""+0.0;
		this.HS1_Base= ""+format(salh);
		this.HS2_Base= ""+format(salh);
		this.HS3_Base= ""+format(salh);
		this.HS1_Gain= ""+format(salh*1.25*b.getHeureSup1());
		this.HS2_Gain= ""+format(salh*1.5*b.getHeureSup2());
		this.HS3_Gain= ""+format(salh*2*b.getHeureSup3());
		this.HS1_Retenue=""+0.0;
		this.HS2_Retenue=""+0.0;
		this.HS3_Retenue=""+0.0;
		this.HS1_Taux =""+b.getHeureSup1();
		this.HS2_Taux =""+b.getHeureSup2();
		this.HS3_Taux =""+b.getHeureSup3();
		System.out.println(HS1_Taux);
		System.out.println(HS2_Taux);
		System.out.println(HS3_Taux);
		double s1=saln+salh*1.25*b.getHeureSup1()+salh*1.5*b.getHeureSup2()+salh*2*b.getHeureSup3();
		double anc=s1*b.getAnciennete()/100;
		double amo=(anc+s1)*0.02;
		double cnss=(anc+s1)*0.0448;
		this.C_CNSS_Base=""+format(anc+s1);
		this.C_CNSS_Gain=""+0.0;
		this.C_CNSS_Retenue=""+format(cnss);
		this.C_CNSS_Taux=""+4.48+"%";
		this.C_AMO_Base=""+format(anc+s1);
		this.C_AMO_Gain=""+0.0;
		this.C_AMO_Retenue=""+format(amo);
		this.C_AMO_Taux=""+2+"%";
		this.an_b=""+format(s1);
		this.an_t=""+b.getAnciennete()+"%";
		this.an_g=""+format(anc);
		this.an_r=""+format(0.0);
		this.Gaine_Net_Base="";
		this.Gaine_Net_Taux="";
		this.Gaine_Net_Gain=""+format(s1+anc);
		this.Gaine_Net_Retenue=""+format(cnss+amo);
		double net=(double)s1+anc-amo-cnss;
		this.Net_A_Payer= net;
		
	}

	public String getCIN() {
		return CIN;
	}

	public void setCIN(String cIN) {
		CIN = cIN;
	}
	

}
