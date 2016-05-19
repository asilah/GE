package org.gestion.emp.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder.Case;

import org.gestion.emp.entities.Admin;
import org.gestion.emp.entities.BulletinPaie;
import org.gestion.emp.entities.Departement;
import org.gestion.emp.entities.Employe;
import org.gestion.emp.entities.Entreprise;
import org.gestion.emp.entities.gestion_presence;

public class EmployeDaoImp implements IEmployeDao{
	
	@PersistenceContext
	private EntityManager em;
	/*----------EMPLOYE--------------*/
	@Override
	public Employe addEmplye(Employe e) {
		Entreprise entr = em.find(Entreprise.class, 1L);
		if (e.getSalBase()< entr.getSmig()) e.setSalBase(entr.getSmig());
		if(e.getDepartement()!=null)
			{
		Departement d = em.find(Departement.class, e.getDepartement().getCodeDept());
		e.setDepartement(d);
			}
		e.setDateEntre(new Date());
		e.setActive(true);
		
		em.persist(e);
		
		return e;
	}

	@Override
	public Employe update(Employe e) {
		
		Employe emp = em.find(Employe.class, e.getCodeEmp());
		emp.affect(e);
		em.persist(emp);
		System.out.println("test");
		return null;
	}

	@Override
	public Employe findEmloye(Employe e) {
		Employe emp = em.find(Employe.class, e.getCodeEmp());
		return emp;
	}

	@Override
	public List<Employe> findEmployes(String id) {
		Query req = em.createQuery("select e from Employe e where e.cin like :x or e.numCnss like :x or e.nom like :x");
		req.setParameter("x", "%"+id+"%");
		return req.getResultList();
		
	}
	
	@Override
	public List<Employe> getEmployesByDepartement(boolean conge, Departement d) {
		Query req;
		if (conge){
			req = em.createQuery("select e from Employe e where e.active=true and e.departement.codeDept=?");
			req.setParameter(1, d.getCodeDept());
		}
		else  {
			req = em.createQuery("select e from Employe e where e.conge=false and e.active=true and e.departement.codeDept=?");
			req.setParameter(1, d.getCodeDept());
		}
		return req.getResultList();
	}
	
	@Override
	public List<Employe> getAllEmployes(boolean conge) {
		Query req;
		if (conge){
			req = em.createQuery("select e from Employe e where e.active=true");
		}
		else  req = em.createQuery("select e from Employe e where e.conge=false and e.active=true");
		return req.getResultList();
	}
	
	@Override
	public List<Employe> getAllEmployes() {
		Query req = em.createQuery("select e from Employe e where e.active=true");
		return req.getResultList();
	}
	
	@Override
	public void bloquerEmploye(Employe e) {
		e=em.find(Employe.class, e.getCodeEmp());
		e.setActive(false);
	}
	
	@Override
	public void debloquerEmploye(Employe e) {
		Entreprise ent = em.find(Entreprise.class, 1L);
		e=em.find(Employe.class, e.getCodeEmp());
		e.setActive(true);
		e.setDateEntre(new Date());
		e.setSalBase(ent.getSmig());
	}
	
	/*-----------GESTION_PRESENCE----------------*/
	
	@Override
	public gestion_presence addGestionPresence(gestion_presence gp, Employe e) {
		Employe emp = em.find(Employe.class, e.getCodeEmp());
		gp.setEmploye(emp);
		em.persist(gp);
		return gp;
	}

	@Override
	public List<gestion_presence> getGestionPresence(Employe e, Date date, String type) {
		
		String s = date.getYear()+1900+"-"+(date.getMonth()+1)+"%";
		Query req = em.createNativeQuery("select * from gestion_presence  where TYPE = ? and dateGestion like ? and codeEmploye = ? ORDER BY dateGestion DESC",gestion_presence.class);
		req.setParameter(1, type);
		req.setParameter(2, s);
		req.setParameter(3, e.getCodeEmp());
		return req.getResultList();
		
	}
	
	/*----------ADMIN--------------*/
	
	@Override
	public Admin addAdmin(Admin a) {
		em.persist(a);
		return a;
	}

	@Override
	public Admin updateAdmin(Admin a) {
		Admin admin = em.find(Admin.class, a.getCodeAdmin());
		admin.affect(a);;
		return null;
	}
	
	@Override
	public Admin logIn(Admin a) {
		Query req = em.createQuery("select a from Admin a where a.login = :x");
		req.setParameter("x", a.getLogin());
		Admin admin = new Admin();
		try {
			admin = (Admin)req.getSingleResult();
		} catch (Exception e) {
			throw new RuntimeException("employe introuvable");
		}
		
		
		if (!a.getMotpass().equals(admin.getMotpass())){
			throw new RuntimeException("mp invalide");
		}
		else return admin;
	}
	
	/*----------DEPARTEMENT--------------*/
	
	@Override
	public Departement addDepartement(Departement d) {
		if(d.getChefDept()!=null){
		Employe e = em.find(Employe.class, d.getChefDept().getCodeEmp());
		d.setChefDept(e);}
		em.persist(d);
		return d;
	}

	@Override
	public Departement updateDepartement(Departement d) {
		Departement dept = em.find(Departement.class, d.getCodeDept());
		dept.affect(d);
		em.persist(dept);
		return null;
	}
	
	@Override
	public Departement findDepartement(Departement d) {
		Departement dept = em.find(Departement.class, d.getCodeDept());
		
		return dept;
	}

	@Override
	public List<Departement> findDepartements(String id) {
		Query req = em.createQuery("select d from Departement d where d.nom like :x");
		req.setParameter("x", "%"+id+"%");
		return req.getResultList();
	}

	@Override
	public List<Departement> getAllDepartements() {
		Query req = em.createQuery("select d from Departement d");
		List<Departement> d = req.getResultList();
		return d;
	}
	
	
	/*----------ENTREPRISE--------------*/
	
	@Override
	public Entreprise addEntreprise(Entreprise e) {
		em.persist(e);
		return e;
	}

	@Override
	public Entreprise updateEntreprise(Entreprise e) {
		Entreprise entp = em.find(Entreprise.class, e.getCodeEntrp());
		entp.affect(e);
		return e;
	}
	
	@Override
	public Entreprise findEntreprise(Entreprise e){
		Entreprise entr = em.find(Entreprise.class, 1L);
		return entr;
	}

	/*----------BULLETIN_PAIE--------------*/

	@Override
	public BulletinPaie getInfoSalaire(Employe e, Date date, boolean normal) {
		Query req;	String d;	int y,m;
		
		Entreprise entrp = em.find(Entreprise.class, 1L);
		e = em.find(Employe.class, e.getCodeEmp());
		
		e.setSalBase(Math.max(e.getSalBase(), entrp.getSmig()));
		
		if (!normal) e.setActive(false);
		BulletinPaie bp = new BulletinPaie();
		
		bp.setEmploye(e);
		bp.setEntreprise(entrp);
		
		if ( date.getMonth() == 0 ){	y = (date.getYear()-1)+1900; m = 12;	}
		else {	y = date.getYear()+1900; m = date.getMonth();	}
		d = y+"-"+m;
		String sd =d;
		d = y+"-"+m+"%";
		
		//jours et heures 
		if (normal){
			bp.setMois(sd);
			req = em.createNativeQuery("select count(*) from gestion_presence  where TYPE = ? and codeEmploye = ? and dateGestion like ?");
			req.setParameter(1, "A");
			req.setParameter(2, e.getCodeEmp());
			req.setParameter(3, d);
			bp.setNbJours(bp.getNbJoursTravail(date, new Date())-Integer.parseInt(""+req.getSingleResult()));
			System.out.println(bp.getNbJours());
			bp.setHeureNormale(bp.getNbJours()*8);
			e.setNbJoursTravail(e.getNbJoursTravail()+bp.getNbJours());
			
		}else {
			bp.setMois(date.getYear()+1900+"-"+date.getMonth()+1);
			req = em.createNativeQuery("select count(*) from gestion_presence  where TYPE = ? and codeEmploye = ? and dateGestion <= ? and dateGestion >= ?");
			req.setParameter(1, "A");
			req.setParameter(2, e.getCodeEmp());
			req.setParameter(3, date);
			req.setParameter(4, new Date(date.getYear(),date.getMonth(),1));
			bp.setNbJours(bp.getNbJoursTravail(date, new Date())-Integer.parseInt(""+req.getSingleResult()));
			bp.setHeureNormale(bp.getNbJours()*8);
			e.setNbJoursTravail(e.getNbJoursTravail()+bp.getNbJours());
		}
		
		
		
		//heureSup1
		if (normal){
			req = em.createNativeQuery("select sum(heureSup1) from gestion_presence  where codeEmploye = ? and dateGestion like ?");
			req.setParameter(1, e.getCodeEmp());
			req.setParameter(2, d);
		}else{
			req = em.createNativeQuery("select sum(heureSup1) from gestion_presence  where codeEmploye = ? and dateGestion <= ? and dateGestion >= ? ");
			req.setParameter(1, e.getCodeEmp());
			req.setParameter(2, date);
			req.setParameter(3, new Date(date.getYear(),date.getMonth(),1));
		}
		try {
			bp.setHeureSup1(Integer.parseInt(""+req.getSingleResult()));
		} catch (Exception e2) {
			bp.setHeureSup1(0);
		}
		
		//heureSup2
		if (normal){
			req = em.createNativeQuery("select sum(heureSup2) from gestion_presence  where codeEmploye = ? and dateGestion like ?");
			req.setParameter(1, e.getCodeEmp());
			req.setParameter(2, d);
		}else{
			req = em.createNativeQuery("select sum(heureSup2) from gestion_presence  where codeEmploye = ? and dateGestion <= ? and dateGestion >= ? ");
			req.setParameter(1, e.getCodeEmp());
			req.setParameter(2, date);
			req.setParameter(3, new Date(date.getYear(),date.getMonth(),1));
		}
		try {
			bp.setHeureSup2(Integer.parseInt(""+req.getSingleResult()));
		} catch (Exception e2) {
			bp.setHeureSup2(0);
		}
		
		//heureSup3
		if (normal){
			req = em.createNativeQuery("select sum(heureSup3) from gestion_presence  where codeEmploye = ? and dateGestion like ?");
			req.setParameter(1, e.getCodeEmp());
			req.setParameter(2, d);
		}else{
			req = em.createNativeQuery("select sum(heureSup3) from gestion_presence  where codeEmploye = ? and dateGestion <= ? and dateGestion >= ? ");
			req.setParameter(1, e.getCodeEmp());
			req.setParameter(2, date);
			req.setParameter(3, new Date(date.getYear(),date.getMonth(),1));
		}
		try {
			bp.setHeureSup3(Integer.parseInt(""+req.getSingleResult()));
		} catch (Exception e2) {
			bp.setHeureSup3(0);
		}
		
		//anciennete
		Date entr = e.getDateEntre();
		int a = (entr.getMonth()+1) >= m ? y-(entr.getYear()+1900):y-(entr.getYear()+1900)-1;
		if (a<2) bp.setAnciennete(0);
		else if (a>=2 && a<5) bp.setAnciennete(5);
		else if (a>=5 && a<12) bp.setAnciennete(10);
		else if (a>=12 && a<20) bp.setAnciennete(15);
		else if (a>=20 && a<25) bp.setAnciennete(20);
		else if (a>=25) bp.setAnciennete(25);
		
		bp.setDatePaie(date);
		em.persist(e);
		
		return bp;
	}

	@Override
	public long nbrAbsenceEmploye(Employe e) {
		Query req = em.createNativeQuery("select count(*) from gestion_presence  where TYPE = ? and codeEmploye = ? ");
		req.setParameter(1, "A");
		req.setParameter(2, e.getCodeEmp());
		
		return Long.parseLong(""+req.getSingleResult());
	}

	@Override
	public long nbrRtardEmploye(Employe e) {
		Query req = em.createNativeQuery("select count(*) from gestion_presence  where TYPE = ? and codeEmploye = ? ");
		req.setParameter(1, "R");
		req.setParameter(2, e.getCodeEmp());
		
		return  Long.parseLong(""+req.getSingleResult());
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
	@Override
	public long nbrHeuresTravailleEmploye(Employe e) {
		// TODO Auto-generated method stub
//		SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
		Entreprise entrp = em.find(Entreprise.class, 1L);
//		String inputString1 = myFormat.format(e.getDateEntre());
//		String inputString2 =  myFormat.format(new Date());
		long jours=0;
		Query req = em.createNativeQuery("select count(*) from gestion_presence  where TYPE = ? and codeEmploye = ? ");
		req.setParameter(1, "HS");
		req.setParameter(2, e.getCodeEmp());
		long hs=Long.parseLong(""+ req.getSingleResult());
		//		    Date date1 = myFormat.parse(inputString1);
		//		    Date date2 = myFormat.parse(inputString2);
		//		    long diff = date2.getTime() - date1.getTime();
				    //System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
				    jours+=getWorkingDaysBetweenTwoDates(e.getDateEntre(), new Date())*entrp.getHeureNormale();
				    jours-=nbrAbsenceEmploye(e)*entrp.getHeureNormale();
				    jours+=hs;
				    System.out.println("Days 1 : "+getWorkingDaysBetweenTwoDates(e.getDateEntre(), new Date()));
	    e.setNbJoursTravail((int ) ((double)Math.max(0,jours)/entrp.getHeureNormale()));
	    update(e);
		return Math.max(0,jours);
	}








	

}
