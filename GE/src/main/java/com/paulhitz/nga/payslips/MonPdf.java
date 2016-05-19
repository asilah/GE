package com.paulhitz.nga.payslips;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class MonPdf {

	private final URL BACKGROUND_IMAGE = MonPdf.class
			.getResource("/resources/templates/payslip_background.png");
	private static Image payslipBackground;

	private Document document;
	private PdfWriter writer;
	private PdfContentByte over;
	private BaseFont bf;

	public MonPdf() throws BadElementException, MalformedURLException,
			IOException {
		super();
		// TODO Auto-generated constructor stub

		Image payslipBackground = Image.getInstance(BACKGROUND_IMAGE);
		payslipBackground.setAlignment(Image.UNDERLYING);
		payslipBackground.setAbsolutePosition(0, 0);
		payslipBackground.scaleAbsolute(595, 842); // A4 page size at 72 DPI
		this.document = new Document();
		try {
			this.writer = PdfWriter.getInstance(document, new FileOutputStream(
					"test.pdf"));
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

	public void creerLeFichier(String FileName) throws MalformedURLException,
			IOException, DocumentException {
		this.putTruc("SOLD OUT", (float) 120.19, (float) 730, 10);
		this.putTruc("XXheheheheXXX", (float) 60.19, (float) 535.13, 10);
		this.putTruc("XXXXXhehehehXXXXXX", (float) 310.19, (float) 535.13, 10);
		document.close();
		System.out.println("we are done !! .....");
	}

	public static void main(String[] args) throws MalformedURLException,
			IOException, DocumentException {
		MonPdf pdf = new MonPdf();
		pdf.creerLeFichier("kk");

	}

}
