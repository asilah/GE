package org.gestion.emp.servlet;

import java.io.IOException;
import java.sql.Time;
import java.util.Date;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gestion.emp.entities.Absence;
import org.gestion.emp.entities.Employe;
import org.gestion.emp.entities.HeursSuplementaire;
import org.gestion.emp.entities.Retard;
import org.gestion.emp.metier.IEmployeMetier;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Servlet implementation class validationAbsence
 */
public class validationAbsence extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public validationAbsence() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		IEmployeMetier metier = (IEmployeMetier) context.getBean("metier");
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
