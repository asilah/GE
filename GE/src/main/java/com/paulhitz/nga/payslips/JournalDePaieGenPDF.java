package com.paulhitz.nga.payslips;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.gestion.emp.entities.BulletinPaie;
import org.gestion.emp.entities.Employe;
import org.gestion.emp.metier.IEmployeMetier;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import model.JournalPaieModel;

public class JournalDePaieGenPDF {

	private final URL BACKGROUND_IMAGE = JournalDePaieGenPDF.class
			.getResource("/resources/templates/jp.jpg");
	private static Image payslipBackground;

	private Document document;
	private PdfWriter writer;
	private PdfContentByte over;
	private BaseFont bf;
	private String fileLocation;
	private static final String local="C:/Users/TOUFGA/Documents/workspace-sts-3.7.1.RELEASE/odskz/src/main/webapp/resources/pdfs/";
//	public JournalDePaieGenPDF() throws BadElementException, MalformedURLException,
//			IOException {
//		super();
//		// TODO Auto-generated constructor stub
//
//		Image payslipBackground = Image.getInstance(BACKGROUND_IMAGE);
//		payslipBackground.setAlignment(Image.UNDERLYING);
//		payslipBackground.setAbsolutePosition(0, 0);
//		payslipBackground.scaleAbsolute(595, 842); // A4 page size at 72 DPI
//		this.document = new Document();
//		
//		try {
//			this.writer = PdfWriter.getInstance(document, new FileOutputStream(local+
//					"journal_De_Paie1.pdf"));
//			
//			this.setFileLocation("/resources/pdfs/journal_De_Paie1.pdf");
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (DocumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		document.addTitle("Fichier de Test");
//		document.addKeywords("Fichier Test");
//		document.addCreator("TOUFGA");
//		document.addAuthor("TOUFGA");
//		document.open();
//		try {
//			document.add(payslipBackground);
//		} catch (DocumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		this.over = writer.getDirectContent();
//		try {
//			this.bf = BaseFont.createFont("c:/windows/fonts/verdana.ttf",
//					BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
//		} catch (DocumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public void putTruc(String truc, float x, float y, int size) throws DocumentException, IOException {
		
		bf = BaseFont.createFont("c:/windows/fonts/verdana.ttf",
				BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		
		over = writer.getDirectContent();
		over.saveState();
		over.beginText();
		over.setFontAndSize(bf, size);
		over.setTextMatrix((float) x, (float) y);
		over.showText(truc);
		over.endText();
		over.restoreState();

	}
	
	public static String format(double x) {
		NumberFormat nf = NumberFormat.getInstance(); // get instance
		nf.setMaximumFractionDigits(2); // set decimal places
		String s = nf.format(x);
		return s;
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
	
	public void FirstElem(JournalPaieModel j, int k, int s) throws DocumentException, IOException{
		this.putTruc(j.getCnss(),(float) 25 ,(float) k, s);
		this.putTruc(j.getCin(),(float) 63 ,(float) k, s);
		this.putTruc(j.getNom(),(float) 100 ,(float) k, s);
		this.putTruc(""+j.getNbJourTravail(),(float) 203 ,(float) k, s);
		this.putTruc(format(j.getJourTravail()),(float) 218 ,(float) k, s);
		this.putTruc(""+j.getNbHeureSup(),(float) 255 ,(float) k, s);
		this.putTruc(format(j.getHeureSup()),(float) 275 ,(float) k, s);
		this.putTruc(format(j.getSalBase()),(float) 310 ,(float) k, s);
		this.putTruc(""+j.getPerAnciennete(),(float) 350,(float) k, s);
		this.putTruc(format(j.getAnciennete()),(float) 367 ,(float) k, s);
		this.putTruc(format(j.getSalBrute()),(float) 400 ,(float) k, s);
		this.putTruc(format( j.getCotCNSS()),(float) 440 ,(float) k, s);
		this.putTruc(format(j.getCoteAMO()),(float) 483 ,(float) k, s);
		this.putTruc(format(j.getSalNet()),(float) 520 ,(float) k, s);
		
	}
	
	public void TotaltElem(JournalPaieModel j, int k, int s) throws DocumentException, IOException{
		
		this.putTruc(format(j.getJourTravail()),(float) 203 ,(float) k, s);
		this.putTruc(format(j.getHeureSup()),(float) 255 ,(float) k, s);
		this.putTruc(format(j.getSalBase()),(float) 310 ,(float) k, s);
		this.putTruc(format(j.getAnciennete()),(float) 350 ,(float) k, s);
		this.putTruc(format(j.getSalBrute()),(float) 400 ,(float) k, s);
		this.putTruc(format( j.getCotCNSS()),(float) 440 ,(float) k, s);
		this.putTruc(format(j.getCoteAMO()),(float) 483 ,(float) k, s);
		this.putTruc(format(j.getSalNet()),(float) 520 ,(float) k, s);
		
	}
	
	public void PrintList(List<JournalPaieModel> l ) throws DocumentException, IOException{
		 int k=612;
		 int pas=20;
		 JournalPaieModel t=new JournalPaieModel().Total(l);
		for (JournalPaieModel e : l) {
			FirstElem(e, k, 6);
			k-=pas;
		}
		System.out.println(k);
		TotaltElem(t, 92, 6);
		
		
	}
	
	public void creerLeFichier(String FileName) throws MalformedURLException,
			IOException, DocumentException {
		this.putTruc("Ma societé", (float) 80.19, (float) 790, 25);
		this.putTruc("Février/2016", (float) 320.01 , (float) 730.01 , 20 );
		
		PrintList(new JournalPaieModel().Demo(25));
		
		document.close();
		System.out.println("we are done !! .....");
	}
	
	public String JournalDePaieGenPDFMethode(List<Employe> emp) throws BadElementException, MalformedURLException, IOException{
		
		
		// TODO Auto-generated constructor stub
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		IEmployeMetier m = (IEmployeMetier) context.getBean("metier");
		List<JournalPaieModel> js= new ArrayList<JournalPaieModel>();
		BulletinPaie b= m.getInfoSalaire(emp.get(0), new Date(), true);
		
		
		
		Image payslipBackground = Image.getInstance(BACKGROUND_IMAGE);
		payslipBackground.setAlignment(Image.UNDERLYING);
		payslipBackground.setAbsolutePosition(0, 0);
		payslipBackground.scaleAbsolute(595, 842); // A4 page size at 72 DPI
		
		this.document = new Document();
		try {
			this.writer = PdfWriter.getInstance(document, new FileOutputStream(local+
					"journal_De_Paie_OK.pdf"));
			
			this.setFileLocation("/resources/pdfs/journal_De_Paie_OK.pdf");
			
			
			
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

			
			this.putTruc(b.getEntreprise().getNom(), (float) 80.19, (float) 790, 25);
			this.putTruc("Février/2016", (float) 320.01 , (float) 730.01 , 20 );
			
			for (Employe e : emp) {
				 
				js.add(new JournalPaieModel(m.getInfoSalaire(e, new Date(), true)));
			}
			
			PrintList(js);
			
			document.close();
			System.out.println("we are done !! .....");
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (true) return fileLocation;
		return fileLocation;
		
//		//this.over = writer.getDirectContent();
//		try {
//			this.bf = BaseFont.createFont("c:/windows/fonts/verdana.ttf",
//					BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
//		} catch (DocumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	
	}

	

	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

}
