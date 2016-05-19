package com.paulhitz.nga.payslips;

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

import model.DeclarationCnssModel;
import model.JournalPaieModel;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class DeclarationMensCnssGenPdf {

	private final URL BACKGROUND_IMAGE = DeclarationMensCnssGenPdf.class
			.getResource("/resources/templates/dmcnss.jpg");
	private static Image payslipBackground;

	private Document document;
	private PdfWriter writer;
	private PdfContentByte over;
	private BaseFont bf;
	private String fileLocation;
	private static final String local="/Users/ismailtamsamani/Documents/workspace/employe/src/main/webapp/resources/pdfs/";
	public DeclarationMensCnssGenPdf() throws BadElementException, MalformedURLException,
			IOException {
		super();
		// TODO Auto-generated constructor stub

		Image payslipBackground = Image.getInstance(BACKGROUND_IMAGE);
		payslipBackground.setAlignment(Image.UNDERLYING);
		payslipBackground.setAbsolutePosition(0, 0);
		payslipBackground.scaleAbsolute(595, 842); // A4 page size at 72 DPI
		this.document = new Document();
		try {
			this.writer = PdfWriter.getInstance(document, new FileOutputStream(local+
					"cnssOK.pdf"));
			this.setFileLocation("/resources/pdfs/"+"déclaration_cnssOK.pdf");
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
			this.bf = BaseFont.createFont("/Library/Fonts/Microsoft/Verdana.ttf",
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
	public String DateToString(Date d){
		int y=d.getYear()+1900;
		return ""+d.getDate()+"/"+d.getMonth()+1+"/"+y;
	}
	public void FirstElem(DeclarationCnssModel j, int k, int s){
		this.putTruc(j.getNumCnss(),(float) 25 ,(float) k, s);
		this.putTruc(j.getCin(),(float) 67 ,(float) k, s);
		this.putTruc(j.getNom()+" "+j.getPrenom(),(float) 104 ,(float) k, s);
		this.putTruc(""+j.getNbJour(),(float) 305 ,(float) k, s);
		this.putTruc(""+j.getHeureSupS1(),(float) 320 ,(float) k, s);
		this.putTruc(""+j.getHeureSupS2(),(float) 337 ,(float) k, s);
		this.putTruc(""+j.getHeureSupS3(),(float) 355,(float) k, s);
		
		//this.putTruc(format(j.getJourTravail()),(float) 218 ,(float) k, s);
		this.putTruc(""+DateToString(j.getNaissance()),(float) 210 ,(float) k, s);
		this.putTruc(""+DateToString(j.getEmbauche()),(float) 255 ,(float) k, s);
		this.putTruc(format(j.getSalbase()),(float) 375 ,(float) k, s);
		this.putTruc(""+j.getPerAn(),(float) 410,(float) k, s);
		this.putTruc(format(j.getAn()),(float) 430 ,(float) k, s);
		this.putTruc(format(j.getSalBrute()),(float) 455 ,(float) k, s);
		this.putTruc(format( j.getCotCnss()),(float) 496 ,(float) k, s);
		this.putTruc(format(j.getSalNet()),(float) 525 ,(float) k, s);
		
	}
	
	public void TotaltElem(DeclarationCnssModel t ){
		int s=6;
		int k=190;
		int p=170;
		this.putTruc(format(t.getSalbase()),(float) 375 ,(float) k, s);
		this.putTruc(format(t.getAn()),(float) 410 ,(float) k, s);
		this.putTruc(format(t.getSalBrute()),(float) 455 ,(float) k, s);
		this.putTruc(format( t.getCotCnss()),(float) 496 ,(float) k, s);
		this.putTruc(format(t.getSalNet()),(float) 525 ,(float) k, s);
		this.putTruc(format(t.getTotAF()),(float) p ,(float) 166, s+3);
		this.putTruc(format(t.getTotRS()),(float) p ,(float) 144, s+3);
		this.putTruc(format(t.getTotCV()),(float) p ,(float) 124, s+3);
		this.putTruc(format(t.getTotFP()),(float) p ,(float) 105, s+3);
		this.putTruc(format(t.getTotTOT()),(float) p ,(float) 83, s+3);
	}
	
	public void PrintList(List<DeclarationCnssModel> l ){
		 int k=612;
		 int pas=20;
		 DeclarationCnssModel t=new DeclarationCnssModel().Total(l);
		for (DeclarationCnssModel e : l) {
			FirstElem(e, k, 6);
			k-=pas;
		}
		TotaltElem(t);
		
		
	}
	
	public String creerLeFichier() throws MalformedURLException,
			IOException, DocumentException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		IEmployeMetier m = (IEmployeMetier) context.getBean("metier");
		List<Employe> empl=m.getAllAmployes();
		List<DeclarationCnssModel> ds= new ArrayList<DeclarationCnssModel>();
		for (Employe e : empl) {
			BulletinPaie b=m.getInfoSalaire(e, new Date(), true);
			DeclarationCnssModel d= new DeclarationCnssModel(b);
			ds.add(d);
		}
		this.putTruc("Ma societé", (float) 80.19, (float) 790, 25);
		this.putTruc("Février/2016", (float) 320.01 , (float) 730.01 , 20 );
		//this.FirstElem(new JournalPaieModel(), 612 ,6);
		//this.FirstElem(new JournalPaieModel(), 592 ,6);
		PrintList(ds);
		//this.putTruc("XXheheheheXXX", (float) 60.19, (float) 535.13, 10);
		//this.putTruc("XXXXXhehehehXXXXXX", (float) 310.19, (float) 535.13, 10);
		document.close();
		System.out.println("we are done !! .....");
		return this.getFileLocation();
	}
//
//	public static void main(String[] args) throws MalformedURLException,
//			IOException, DocumentException {
//		DeclarationMensCnssGenPdf pdf = new DeclarationMensCnssGenPdf();
//		pdf.creerLeFichier();
//
//	}

	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

}
