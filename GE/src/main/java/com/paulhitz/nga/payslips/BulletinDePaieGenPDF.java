package com.paulhitz.nga.payslips;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;

import org.gestion.emp.dao.IEmployeDao;
import org.gestion.emp.entities.BulletinPaie;
import org.gestion.emp.entities.Departement;
import org.gestion.emp.entities.Employe;
import org.gestion.emp.entities.Entreprise;
import org.gestion.emp.metier.IEmployeMetier;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import model.BulletinPaieForm;

public class BulletinDePaieGenPDF {
	
	


	private final URL BACKGROUND_IMAGE = BulletinDePaieGenPDF.class
			.getResource("/resources/templates/bdp.jpg");
	private static Image payslipBackground;
	
	private static final String local="C:/Users/ilyass/Documents/workspace-sts-3.7.2.RELEASE/GE/src/main/webapp/resources/pdfs/";
	private String fichier_emplacement;
	private Document document;
	private PdfWriter writer;
	private PdfContentByte over;
	private BaseFont bf;
	private BulletinPaieForm donnees;
	public BulletinDePaieGenPDF() throws BadElementException, MalformedURLException,
			IOException {
		super();
		// TODO Auto-generated constructor stub
		BulletinPaie b = new BulletinPaie();
		Employe emp=new Employe();
		Departement d= new Departement(); d.setCodeDept(1L); emp.setDepartement(d);
		emp.setNom("Mohammed"); emp.setPrenom("Mandouri");  emp.setNumCnss("1162562"); emp.setCin("BJ176254");
		emp.setCodeEmp(1L); emp.setDateNaissance(new Date()); emp.setDateEntre(new Date());
		emp.setNbJoursTravail(24); emp.setSalBase(120);
		Entreprise es= new Entreprise();
		es.setNom("Tamsamani Gaz"); es.setAddress("Asfi kaamla dyalna hhh");
		es.setCodeEntrp(1L);
		b.setAnciennete(5);
		b.setDatePaie(new Date());
		b.setEmploye(emp);
		b.setEntreprise(es);
		b.setHeureNormale(180);
		b.setHeureSup1(10);
		b.setHeureSup2(10);
		b.setHeureSup3(10);
		b.setMois("Mars");
		b.setNbJours(24);
		donnees = new BulletinPaieForm(b);
		Image payslipBackground = Image.getInstance(BACKGROUND_IMAGE);
		payslipBackground.setAlignment(Image.UNDERLYING);
		payslipBackground.setAbsolutePosition(0, 0);
		payslipBackground.scaleAbsolute(595, 842); // A4 page size at 72 DPI
		this.document = new Document();
		try {
			this.writer = PdfWriter.getInstance(document, new FileOutputStream(local+
					"bulletin_"+donnees.getNom()+"_"+donnees.getPrenom()+".pdf"));
			setFichier_emplacement("/resources/pdfs/"+"bulletin_"+donnees.getNom()+"_"+donnees.getPrenom()+".pdf");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		document.addTitle("Fichier de Test");
		document.addKeywords("Fichier Test");
		document.addCreator("TOUFGA");
		document.addAuthor("TOUFGA");
		document.open();
		try {
			document.add(payslipBackground);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.over = writer.getDirectContent();
		try {
			this.bf = BaseFont.createFont("c:/windows/fonts/verdana.ttf",
					BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void putTruc(String truc, float x, float y, int size) {
		over = writer.getDirectContent();
		over.saveState();
		over.beginText();
		over.setFontAndSize(bf, size);
		over.setTextMatrix((float) x, (float) y);
		over.showText(""+truc);
		over.endText();
		over.restoreState();

	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public PdfWriter getWriter() {
		return writer;
	}

	public void setWriter(PdfWriter writer) {
		this.writer = writer;
	}

	public PdfContentByte getOver() {
		return over;
	}

	public void setOver(PdfContentByte over) {
		this.over = over;
	}

	public BaseFont getBf() {
		return bf;
	}

	public void setBf(BaseFont bf) {
		this.bf = bf;
	}
	
	public static String format(double x) {
		NumberFormat nf = NumberFormat.getInstance(); // get instance
		nf.setMaximumFractionDigits(2); // set decimal places
		String s = nf.format(x);
		return s;
	}
	
	public void creerLeFichier(String FileName) throws MalformedURLException,
			IOException, DocumentException {
		
		
		this.putTruc(""+donnees.getMois(), (float) 400.01 , (float) 738.01 , 10 );
		this.putTruc(""+donnees.getNumCNSEMP(), (float) 400.01 , (float) 669.01 , 10 );
		this.putTruc(""+donnees.getSte(), (float) 34.19, (float) 703, 10);
		this.putTruc(""+donnees.getMatr(), (float) 34.19, (float) 669, 10);
		this.putTruc(""+donnees.getDept(), (float) 84.19, (float) 669, 10);
		this.putTruc(""+donnees.getNom()+" "+donnees.getPrenom(), (float) 120.19, (float) 669, 10);
		this.putTruc(""+donnees.getNationalite(), (float) 320.19, (float) 669, 10);
		this.putTruc(""+donnees.getAdresse(), (float) 185.19, (float) 703, 10);
		this.putTruc(""+donnees.getNumCNSSSTE(), (float) 500.19, (float) 703, 10);
		this.putTruc(""+donnees.getBulletinNum(), (float) 500.19, (float) 738, 10);
		this.putTruc(""+donnees.getCIN(), (float) 490.19, (float) 669, 10);
		this.putTruc(""+donnees.DateToString(donnees.getNaissance()), (float) 34.19, (float) 635, 10);
		this.putTruc(""+donnees.DateToString(donnees.getEmbauche()), (float) 120.19, (float) 635, 10);
		this.putTruc(""+donnees.getQualifaction(), (float) 213.19, (float) 635, 10);
		this.putTruc(""+donnees.getSitFam(), (float) 320.19, (float) 635, 10);
		this.putTruc(""+donnees.getPaiement(), (float) 370.19, (float) 635, 10);
		this.putTruc(""+donnees.getCat(), (float) 455.19, (float) 635, 10);
		this.putTruc(""+donnees.getDépartement(), (float) 485.19, (float) 635, 10);
		/**********************************BASE*******************************/
		this.putTruc(""+donnees.getSN_Base(), (float) 213.19, (float) 588, 10);
		this.putTruc(""+donnees.getHS1_Base(), (float) 213.19, (float) 566, 10);
		this.putTruc(""+donnees.getHS2_Base(), (float) 213.19, (float) 544, 10);
		this.putTruc(""+donnees.getHS3_Base(), (float) 213.19, (float) 522, 10);
		this.putTruc(""+donnees.getAn_b(), (float) 213.19, (float) 505, 10);
		this.putTruc(""+donnees.getC_CNSS_Base(), (float) 213.19, (float) 488, 10);
		this.putTruc(""+donnees.getC_AMO_Base(), (float) 213.19, (float) 466, 10);
		this.putTruc(""+donnees.getGaine_Net_Base(), (float) 213.19, (float) 444, 10);
		/**********************************TAUX******************************/
		this.putTruc(""+donnees.getSN_Taux(), (float) 320.19, (float) 588, 10);
		this.putTruc(""+donnees.getHS1_Taux(), (float) 320.19, (float) 566, 10);
		this.putTruc(""+donnees.getHS2_Taux(), (float) 320.19, (float) 544, 10);
		this.putTruc(""+donnees.getHS3_Taux(), (float) 320.19, (float) 522, 10);
		this.putTruc(""+donnees.getAn_t(), (float) 320.19, (float) 505, 10);
		this.putTruc(""+donnees.getC_CNSS_Taux(), (float) 320.19, (float) 488, 10);
		this.putTruc(""+donnees.getC_AMO_Taux(), (float) 320.19, (float) 466, 10);
		this.putTruc(""+donnees.getGaine_Net_Taux(), (float) 320.19, (float) 444, 10);
		/**********************************GAIN******************************/
		this.putTruc(donnees.getSN_Gain(), (float) 400.01 , (float) 588.01 , 10 );
		this.putTruc(donnees.getHS1_Gain(), (float) 400.01 , (float) 566.01 , 10 );
		this.putTruc(donnees.getHS2_Gain(), (float) 400.01 , (float) 544.01 , 10 );
		this.putTruc(donnees.getHS3_Gain(), (float) 400.01 , (float) 522.01 , 10 );
		this.putTruc(donnees.getAn_t(), (float) 400.01 , (float) 505.01 , 10 );
		this.putTruc(donnees.getC_CNSS_Gain(), (float) 400.01 , (float) 488.01 , 10 );
		this.putTruc(donnees.getC_AMO_Gain(), (float) 400.01 , (float) 466.01 , 10 );
		this.putTruc(donnees.getGaine_Net_Gain(), (float) 400.01 , (float) 444.01 , 10 );
		/**********************************RETENUE******************************/
		this.putTruc(donnees.getSN_Retenue(), (float) 490.19, (float) 588, 10);
		this.putTruc(donnees.getHS1_Retenue(), (float) 490.19, (float) 566, 10);
		this.putTruc(donnees.getHS2_Retenue(), (float) 490.19, (float) 544, 10);
		this.putTruc(donnees.getHS3_Retenue(), (float) 490.19, (float) 522, 10);
		this.putTruc(donnees.getAn_r(), (float) 490.19, (float) 505, 10);
		this.putTruc(donnees.getC_CNSS_Retenue(), (float) 490.19, (float) 488, 10);
		this.putTruc(donnees.getC_AMO_Retenue(), (float) 490.19, (float) 466, 10);
		this.putTruc(donnees.getGaine_Net_Retenue(), (float) 490.19, (float) 444, 10);
		
		this.putTruc(""+donnees.getPour_Quittance(), (float) 213.19, (float) 310, 10);
		this.putTruc(""+donnees.DateToString(donnees.getDate_de_Paie()), (float) 400.01 , (float) 310.01 , 10 );
		this.putTruc(""+format(donnees.getNet_A_Payer()), (float) 490.19, (float) 310, 10);
		document.close();
		System.out.println("we are done !! .....");
	}
	
	public BulletinDePaieGenPDF(Employe emp) throws BadElementException, MalformedURLException, IOException{
		
		
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
			IEmployeMetier m = (IEmployeMetier) context.getBean("metier");
			BulletinPaie b=m.getInfoSalaire(emp, new Date(), true);
			
			donnees = new BulletinPaieForm(b);
			System.out.println(b.getEmploye().getAddress());
			Image payslipBackground = Image.getInstance(BACKGROUND_IMAGE);
			payslipBackground.setAlignment(Image.UNDERLYING);
			payslipBackground.setAbsolutePosition(0, 0);
			payslipBackground.scaleAbsolute(595, 842); // A4 page size at 72 DPI
			this.document = new Document();
			try {
				this.writer = PdfWriter.getInstance(document, new FileOutputStream(local+
						"bulletin_"+donnees.getNom()+"_"+donnees.getPrenom()+".pdf"));
				setFichier_emplacement("/resources/pdfs/"+"bulletin_"+donnees.getNom()+"_"+donnees.getPrenom()+".pdf");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			document.addTitle("Fichier de Test");
			document.addKeywords("Fichier Test");
			document.addCreator("Hannouni");
			document.addAuthor("Hannouni");
			document.open();
			try {
				document.add(payslipBackground);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.over = writer.getDirectContent();
			try {
				this.bf = BaseFont.createFont("c:/windows/fonts/Verdana.ttf",
						BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				this.creerLeFichier("kk");
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	
	
	
	public void creerLeFichier(String FileName, Employe e, Entreprise es){
		
//		donnees.setAdresse(adresse);
//		donnees.setAL_Base(aL_Base);
//		donnees.setAL_Gain(aL_Gain);
//		donnees.
		
	}

	public static void main(String[] args) throws MalformedURLException,
			IOException, DocumentException {
		BulletinDePaieGenPDF pdf = new BulletinDePaieGenPDF();
		pdf.creerLeFichier("kk");

	}

	public String getFichier_emplacement() {
		return fichier_emplacement;
	}

	public void setFichier_emplacement(String fichier_emplacement) {
		this.fichier_emplacement = fichier_emplacement;
	}

}
