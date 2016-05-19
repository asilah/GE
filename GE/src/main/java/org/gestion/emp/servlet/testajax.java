package org.gestion.emp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gestion.emp.entities.Departement;
import org.gestion.emp.metier.EmployeMetierImp;
import org.gestion.emp.metier.IEmployeMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet implementation class testajax
 */
public class testajax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testajax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
//		EmployeMetierImp metier = (EmployeMetierImp) ctx.getBean("metier");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		IEmployeMetier m = (IEmployeMetier) context.getBean("metier");
		// TODO Auto-generated method stub
		String a=request.getParameter("a");
		String b=request.getParameter("b");
		String c=request.getParameter("c");
		long d= Long.parseLong(request.getParameter("d"));
		Departement dept= new Departement();
		dept.setCodeDept(d);
		dept=m.findDepartement(dept);
		
		response.getWriter().print(a+" / "+b+" / "+c +" voici le d ="+d);
		response.getWriter().print(dept.getNom()+" : "+dept.getDescription());
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
