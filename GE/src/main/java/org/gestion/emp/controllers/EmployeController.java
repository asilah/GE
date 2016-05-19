package org.gestion.emp.controllers;


import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.gestion.emp.entities.Absence;
import org.gestion.emp.entities.Admin;
import org.gestion.emp.entities.Departement;
import org.gestion.emp.entities.Employe;
import org.gestion.emp.entities.Entreprise;
import org.gestion.emp.entities.HeursSuplementaire;
import org.gestion.emp.entities.Retard;
import org.gestion.emp.metier.IEmployeMetier;
import org.gestion.emp.models.AdminForm;
import org.gestion.emp.models.DepartementForm;
import org.gestion.emp.models.EmployeForm;
import org.gestion.emp.models.EntrepriseForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.DocumentException;
import com.paulhitz.nga.payslips.BulletinDePaieGenPDF;
import com.paulhitz.nga.payslips.DeclarationMensCnssGenPdf;

@Controller
public class EmployeController {
	@Autowired
	private IEmployeMetier metier;

	
	@RequestMapping(value="/index")
	public String index(Model model, HttpServletRequest request, HttpSession session){
		if (logedin(session)){
			return "home";
		}
		model.addAttribute("AdminForm",new AdminForm());
		return "connexion"; 
		
	}
	
	@RequestMapping(value="/login")
	public String login(Model model,AdminForm af, HttpServletRequest request, HttpSession session){
		if (logedin(session)){
			return "home";
		}
		Admin a = new Admin();
		a.setLogin(af.getLogin());
		a.setMotpass(af.getMotpass());
		try {
			a=metier.logIn(a);
			af.setAdmin(a);
			model.addAttribute("AdminForm",af);
			session.setAttribute("Admin", a);
			return "home";
		} catch (Exception e) {
			af.setException(e.getMessage());
			model.addAttribute("AdminForm",af);
			return "connexion"; 
		}
	}
	
//	ajout -----------------------------------------------------------------
	
	@RequestMapping(value="/ajoutEmp")
	public String ajoutEmp(Model model,EmployeForm ef, HttpServletRequest request, HttpSession session){
		if (logedin(session)){
			model.addAttribute("EmpForm",new EmployeForm());
			try {
				if (session.getAttribute("page").equals("ajoutEmp") && ef.getSubmit().equals("Ajouter") ){
					
					ef.setSubmit(null);
					ef.setEmployeSup(1L);
					Employe e = new Employe();		
					e.affect(ef);
					
					e=metier.addEmplye(e);
					
					session.setAttribute("page", "home");
					model.addAttribute("msg","oktest");
					return "home";
				}
			} catch (Exception e) {
				List<Departement> listDept = metier.getAllDepartements();
				model.addAttribute("listDept", listDept);
				return "ajoutEmploye";
			}
			List<Departement> listDept = metier.getAllDepartements();
			model.addAttribute("listDept", listDept);
			return "ajoutEmploye";
		}else {
			model.addAttribute("AdminForm",new AdminForm());
			return "connexion"; 
		}
	}
	
	@RequestMapping(value="/ajoutDept")
	public String ajoutDept(Model model,DepartementForm df, HttpServletRequest request, HttpSession session){
		if (logedin(session)){
			model.addAttribute("DeptForm",new DepartementForm());
			try {
				if (session.getAttribute("page").equals("ajoutDept") && df.getSubmit().equals("Ajouter") ){
					df.setSubmit(null);
					Departement d = new Departement();		
//					d.affect(df);
					d.setDescription(df.getDescription());
					d.setNom(df.getNom());
					d.setVille(df.getVille());
					d=metier.addDepartement(d);
					session.setAttribute("page", "home");
					model.addAttribute("msg","ok");
					return "home";
				}
			} catch (Exception e) {
				List<Employe> listEmp = metier.getAllAmployes();
				model.addAttribute("listEmp", listEmp);
				return "ajoutDepartement";
			}
			List<Employe> listEmp = metier.getAllAmployes();
			model.addAttribute("listEmp", listEmp);
			return "ajoutDepartement";
		}else {
			model.addAttribute("AdminForm",new AdminForm());
			return "connexion"; 
		}
	}
	
	@RequestMapping(value="/ajoutAdmin")
	public String ajoutAdmin(Model model,AdminForm af, HttpServletRequest request, HttpSession session){
		if (logedin(session)){
			model.addAttribute("AdminForm",new AdminForm());
			
			try {
				if (session.getAttribute("page").equals("ajoutAdmin") && af.getSubmit().equals("Ajouter")  ){
					af.setSubmit(null);
					Admin a = new Admin();	
					
					a.affect(af);
					a=metier.addAdmin(a);
					
					session.setAttribute("page", "home");
					model.addAttribute("msg","ok");
					return "home";
				}
			} catch (Exception e) {
				model.addAttribute("AdminForm",new AdminForm());
				return "ajoutAdmin";
			}
			
			
			
			
			model.addAttribute("AdminForm",new AdminForm());
			return "ajoutAdmin";
		}else {
			model.addAttribute("AdminForm",new AdminForm());
			return "connexion"; 
		}
	}

//	List ----------------------------------------------------------------------------------------
	
	@RequestMapping(value="/listEmp")
	public String listEmp(Model model,EmployeForm ef, HttpServletRequest request, HttpSession session){
		if (logedin(session)){
			
			List<Employe> listEmp = metier.getAllEmployes(true);
			model.addAttribute("EmpForm", new EmployeForm());
			model.addAttribute("listEmp", listEmp);
			return "listEmploye";
		}
		model.addAttribute("AdminForm",new AdminForm());
		return "connexion"; 
		
	}
	
	@RequestMapping(value="/listDept")
	public String listDept(Model model,DepartementForm df, HttpServletRequest request, HttpSession session){
		if (logedin(session)){
			model.addAttribute("DeptForm",new EmployeForm());
			
			List<Departement> depts=metier.getAllDepartements();
			model.addAttribute("depts", depts);
			return "listDepartement";
		}
		model.addAttribute("AdminForm",new AdminForm());
		return "connexion"; 
		
	}
	
//	affiche-----------------------------------------------------------------------
	
	@RequestMapping(value="/AfficheDept")
	public String AfficheDept(Model model,DepartementForm df, HttpServletRequest request, HttpSession session){
		if (logedin(session)){
			Departement d = new Departement();
			d.setCodeDept(df.getCodeDept());
			d = metier.findDepartement(d);
			
			List<Employe> listEmp = metier.getEmployesByDepartement(true, d);
			model.addAttribute("EmpForm", new EmployeForm());
			model.addAttribute("listEmp", listEmp);
			model.addAttribute("dept",d);
			return "afficheDepartement";
		}
		model.addAttribute("AdminForm",new AdminForm());
		return "connexion"; 
		
	}
	
	////////////////
	@RequestMapping(value="/AfficheEmp")
	public String AfficheEmp(Model model,EmployeForm ef, HttpServletRequest request, HttpSession session){
		if (logedin(session)){
			
			
			//List<Employe> listEmp = metier.getEmployesByDepartement(true, d);
			//model.addAttribute("listEmp", listEmp);
			Employe e= new Employe();
			e.setCodeEmp(ef.getCodeEmp());
			e=metier.findEmloye(e);
			long abs=metier.nbrAbsenceEmploye(e);
			long rt=metier.nbrRtardEmploye(e);
			long hr=metier.nbrHeuresTravailleEmploye(e);
			model.addAttribute("emp", e);
			model.addAttribute("abs", abs);
			model.addAttribute("rt", rt);
			model.addAttribute("hr", hr);
			model.addAttribute("EmpForm", new EmployeForm());
			return "afficheEmploye";
		}
		model.addAttribute("AdminForm",new AdminForm());
		return "connexion"; 
		
	}
	
//	gestion absence--------------------------------------------------------------------------------------
	
	@RequestMapping(value="/validationAbsence")
	public String validationAbsence(Model model, HttpServletRequest request, HttpSession session){
		String jf = request.getParameter("jf");
		String req = request.getParameter("req");
		//req.substring(0, req.length()-1);
		System.out.println("heeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeereeeeeeeeeeeeeeeeeeeeeeeeeeee");
		StringTokenizer st = new StringTokenizer(req, "/");
		String gestion;
		Absence a = new Absence();
		Retard r = new Retard();
		HeursSuplementaire h = new HeursSuplementaire();
		Employe e = new Employe();
		Long codeEmp;
		int hs1=0,hs2=0,hs3=0,hd,hf;
		while (st.hasMoreTokens()){
			gestion=st.nextToken();
			String[] attrs = gestion.split("-");
			codeEmp=Long.parseLong(attrs[0]);
			hd=Integer.parseInt(attrs[2]);
			hf=Integer.parseInt(attrs[3]);
			if (attrs[1].equals("A")){
				a = new Absence();
				e.setCodeEmp(codeEmp);
				a.setEmploye(e);
				a.setDateGestion(new Date());
				a.setEtat(attrs[5]);
				a.setRaison(attrs[4]);
				System.out.println("ajout d une absence");
				metier.addAbsence(e, a);
				
			}
			else if (attrs[1].equals("R")){
				r = new Retard();
				e.setCodeEmp(codeEmp);
				r.setEmploye(e);
				r.setDateGestion(new Date());
				r.setHeureDebut(new Time(hd, 0, 0));
				r.setHeureFin(new Time(hf, 0, 0));
				r.setHeureRetard(Integer.parseInt(attrs[3])-Integer.parseInt(attrs[2]));
				r.setEtat(attrs[5]);
				r.setRaison(attrs[4]);
				System.out.println("ajout d une retard");
				metier.addRetard(e, r);
				
				
			}else if (attrs[1].equals("S")){
				h = new HeursSuplementaire();
				e.setCodeEmp(codeEmp);
				h.setEmploye(e);
				h.setDateGestion(new Date());
				h.setHeureDebut(new Time(hd, 0, 0));
				h.setHeureFin(new Time(hf, 0, 0));
				
				if (hd>=9 && hd<21 && hf>=9 && hf<21){
					hs1= hf-hd;
				}else if (hd>=9 && hd<21 && hf>=21){
					hs1=21-hd;
					hs2=hf-21;
				}else if (hf>=9 && hf<21 && hd<9){
					hs1=hf-9;
					hs2=9-hd;
				}else if ((hd>=21 && hf>=21) || (hd<9 && hf<9)){
					hs2=hf-hd;
				}else if (hd<9 && hf>=21){
					hs1=12;
					hs2=(hf-21)+(9-hd);
				}
				if (jf.equals("t")){
					hs3=hs2;
					hs2=hs1;
					hs1=0;
				}
				h.setHeureSup1(hs1);
				h.setHeureSup2(hs2);
				h.setHeureSup3(hs3);
				h.setEtat(attrs[5]);
				h.setRaison(attrs[4]);
				System.out.println("ajout d une heure sup");
				metier.addHeursSuplementaire(e, h);
			}
			
			
			//System.out.println("code :"+attrs[0]+" ars :"+attrs[1]+" hd :"+attrs[2]+" hf :"+attrs[3]+" raison :"+attrs[4]+" etat :"+attrs[5]);
		}
		
		return ""; 
	}
	
	@RequestMapping(value="/gestionAbsence")
	public String gestionAbsence(Model model, DepartementForm df, HttpServletRequest request, HttpSession session){
		if (logedin(session)){
			model.addAttribute("DeptForm",new DepartementForm());
			try {
				if (session.getAttribute("page").equals("gestionAbsence") && df.getSubmit().equals("valider") ){
					df.setSubmit(null);
					session.setAttribute("page", "home");
					model.addAttribute("msg","ok");
					return "home";
				}
			} catch (Exception e) {
				List<Employe> listEmp = metier.getAllAmployes();
				List<Departement> listDept = metier.getAllDepartements();
				model.addAttribute("listDept", listDept);
				model.addAttribute("listEmp", listEmp);
				System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh1");
				return "gestionAbsence";
			}
			List<Employe> listEmp = metier.getAllAmployes();
			List<Departement> listDept = metier.getAllDepartements();
			model.addAttribute("listDept", listDept);
			model.addAttribute("listEmp", listEmp);
			System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh1");
			return "gestionAbsence";
		}else {
			model.addAttribute("AdminForm",new AdminForm());
			return "connexion"; 
		}
	}
	
//	update-------------------------------------------------------------------------------
	
	@RequestMapping(value="/updateEmp")
	public String updateEmp(Model model,EmployeForm ef, HttpServletRequest request, HttpSession session){
		if (logedin(session)){
			model.addAttribute("EmpForm",new EmployeForm());
			try {
				if (session.getAttribute("page").equals("updateEmp") && ef.getSubmit().equals("Modifier") ){
					
					ef.setSubmit(null);
					Employe e = new Employe();
					
					e.affect(ef);
					e.setCodeEmp(ef.getCodeEmp());
					
					metier.update(e);
					
					session.setAttribute("page", "home");
					model.addAttribute("msg","ok");
					return "home";
				}
			} catch (Exception e) {
				List<Departement> listDept = metier.getAllDepartements();
				model.addAttribute("listDept", listDept);
				Employe emp = new Employe();
				emp.setCodeEmp(ef.getCodeEmp());
				emp = metier.findEmloye(emp);
				model.addAttribute("emp", emp);
				return "updateEmploye";
			}
			List<Departement> listDept = metier.getAllDepartements();
			model.addAttribute("listDept", listDept);
			Employe emp = new Employe();
			emp.setCodeEmp(ef.getCodeEmp());
			emp = metier.findEmloye(emp);
			model.addAttribute("emp", emp);
			return "updateEmploye";
//			List<Employe> listEmp = metier.getAllAmployes();
//			List<Departement> listDept = metier.getAllDepartements();
//			model.addAttribute("listDept", listDept);
//			model.addAttribute("listEmp", listEmp);
//			return "updateEmploye";
		}else {
			model.addAttribute("AdminForm",new AdminForm());
			return "connexion"; 
		}
	}

	@RequestMapping(value="/updateDept")
	public String updateDept(Model model,DepartementForm df, HttpServletRequest request, HttpSession session){
		if (logedin(session)){
			model.addAttribute("DeptForm",new EmployeForm());
			try {
				if (session.getAttribute("page").equals("updateDept") && df.getSubmit().equals("Modifier") ){
					df.setSubmit(null);
					Departement d = new Departement();
					d.affect(df);
					d.setCodeDept(df.getCodeDept());
					metier.updateDepartement(d);
					session.setAttribute("page", "home");
					model.addAttribute("msg","ok");
					return "home";
				}
			} catch (Exception e) {
				Departement d = new Departement();
				d.setCodeDept(df.getCodeDept());
				d = metier.findDepartement(d);
				List<Employe> listEmp = metier.getAllAmployes();
				model.addAttribute("listEmp", listEmp);
				model.addAttribute("dept",d);
				return "updateDepartement";
			}
			Departement d = new Departement();
			d.setCodeDept(df.getCodeDept());
			d = metier.findDepartement(d);
			List<Employe> listEmp = metier.getAllAmployes();
			model.addAttribute("listEmp", listEmp);
			model.addAttribute("dept",d);
			return "updateDepartement";
		}else {
			model.addAttribute("AdminForm",new AdminForm());
			return "connexion"; 
		}
	}
		
	@RequestMapping(value="/updateEntr")
	public String updateEntr(Model model,EntrepriseForm ef, HttpServletRequest request, HttpSession session){
		if (logedin(session)){
			model.addAttribute("EntrForm",new EntrepriseForm());
			try {
				if (session.getAttribute("page").equals("updateEntr") && ef.getSubmit().equals("Modifier") ){
					ef.setSubmit(null);
					Entreprise entr = new Entreprise();
					entr.affect(ef);

					metier.updateEntreprise(entr);
					session.setAttribute("page", "home");
					model.addAttribute("msg","ok");
					return "home";
				}
			} catch (Exception e) {
				Entreprise entr = new Entreprise();
				entr.setCodeEntrp(1L);
				entr = metier.findEntreprise(entr);
				model.addAttribute("EntrForm", new EntrepriseForm());
				model.addAttribute("Entr",entr);
				return "updateEntreprise";
			}
			Entreprise entr = new Entreprise();
			entr.setCodeEntrp(1L);
			entr = metier.findEntreprise(entr);
			model.addAttribute("EntrForm", new EntrepriseForm());
			model.addAttribute("Entr",entr);
			return "updateEntreprise";
		}else {
			model.addAttribute("AdminForm",new AdminForm());
			return "connexion"; 
		}
	}
	
	@RequestMapping(value="/updateAdmin")
	public String updateAdmin(Model model){
		model.addAttribute("AdminForm",new AdminForm());
		List<Employe> listEmp = metier.getAllAmployes();
		List<Departement> listDept = metier.getAllDepartements();
		model.addAttribute("listDept", listDept);
		model.addAttribute("listEmp", listEmp);
		return "updateAdmin"; 
	}

	
	
//	logout--------------------------------------------------------------------
	
	@RequestMapping(value="/logout")
	public String logout(Model model,AdminForm af, HttpServletRequest request, HttpSession session){
		model.addAttribute("AdminForm",af);
		session.setAttribute("Admin", null);
		return "connexion";	
	}
	
	boolean logedin(HttpSession session){
		try {
			if (!session.getAttribute("Admin").equals(null)) return true;
		} catch (Exception e) {
			return false;
		}
		 return false;
	}
	@RequestMapping(value="/pdfs")
	public String pdfs(Model model, HttpServletRequest request, HttpSession session){
		if (logedin(session)){
			System.out.println("kk");
			/***********************************************************************************/
				List<Employe> lis=metier.getAllAmployes();
				List<BulletinDePaieGenPDF> pdfs= new ArrayList<BulletinDePaieGenPDF>();
				
				for (Employe emp : lis) {
					
					BulletinDePaieGenPDF pdf;
					try {
						pdf = new BulletinDePaieGenPDF(emp);
						pdfs.add(pdf);
					} catch (BadElementException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.println(emp.getNom());
				}
			model.addAttribute("pdfs",pdfs);
			//return "pdf";
			System.out.println("fiche de paie est générée avec succes ...");
			/***********************************************************************************/
		/*	try {
				String jpdf= new JournalDePaieGenPDF().JournalDePaieGenPDFMethode(metier.getAllAmployes());
				
				ArrayList<String> j=new ArrayList<String>();
				j.add(jpdf);
				model.addAttribute("jpdf", j);
				return "pdf";
			} catch (BadElementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "pdf";
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "pdf";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
				return "pdf";
			} */
			
			/******************************************************************************/
			
			
			DeclarationMensCnssGenPdf pdf;
			try {
				pdf = new DeclarationMensCnssGenPdf();
				try {
					String s= pdf.creerLeFichier();
					List<String> lisDec= new ArrayList<String>();
					lisDec.add(s);
					model.addAttribute("lisDec",lisDec);
				} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (BadElementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return "pdf";
			
		}
		model.addAttribute("AdminForm",new AdminForm());
		return "connexion"; 
		
	}
	
	
	
	
	
	
	
	
	@RequestMapping(value="/DeptSel")
	public String DeptSel(Model model,EmployeForm ef, HttpServletRequest request, HttpSession session){
		String req = request.getParameter("req");
		Departement d = new Departement();
		d.setDescription("eeeeeeeeee");
		d.setNom("safi");
		d.setVille("virrr");
		model.addAttribute("dept",d);
		return "updateDepartement";
		
	}
	
	
	
	@RequestMapping(value="/test")
	public String test(){
		
		
		return "test";
	}
	
	





	
	
	
	
}
