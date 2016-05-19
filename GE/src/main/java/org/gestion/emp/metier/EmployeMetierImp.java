package org.gestion.emp.metier;

import java.util.Date;
import java.util.List;

import org.gestion.emp.dao.IEmployeDao;
import org.gestion.emp.entities.Absence;
import org.gestion.emp.entities.Admin;
import org.gestion.emp.entities.BulletinPaie;
import org.gestion.emp.entities.Departement;
import org.gestion.emp.entities.Employe;
import org.gestion.emp.entities.Entreprise;
import org.gestion.emp.entities.HeursSuplementaire;
import org.gestion.emp.entities.JoursFeries;
import org.gestion.emp.entities.Retard;
import org.gestion.emp.entities.gestion_presence;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public class EmployeMetierImp implements IEmployeMetier{
	private IEmployeDao dao;

	public void setDao(IEmployeDao dao) {
		this.dao = dao;
	}

	@Override
	public Employe addEmplye(Employe e) {
		dao.addEmplye(e);
		return e;
	}

	@Override
	public Employe update(Employe e) {
		return dao.update(e);
	}

	@Override
	public Employe findEmloye(Employe e) {
		return dao.findEmloye(e);
	}

	@Override
	public List<Employe> getAllEmployes(boolean conge) {
		return dao.getAllEmployes(conge);
	}

	@Override
	public List<Employe> findEmployes(String id) {
		
		return dao.findEmployes(id);
	}
	
	@Override
	public List<Employe> getEmployesByDepartement(boolean conge, Departement departement) {
		return dao.getEmployesByDepartement(conge, departement);
	}
	
	@Override
	public Absence addAbsence(Employe e, Absence a) {
		dao.addGestionPresence(a, e);
		return a;
	}

	@Override
	public Retard addRetard(Employe e, Retard r) {
		dao.addGestionPresence(r, e);
		return r;
	}

	@Override
	public HeursSuplementaire addHeursSuplementaire(Employe e, HeursSuplementaire hs) {
		dao.addGestionPresence(hs, e);
		return hs;
	}

	@Override
	public JoursFeries addJoursFeries(Employe e, JoursFeries jf) {
		dao.addGestionPresence(jf, e);
		return jf;
	}
	
	@Override
	public Admin addAdmin(Admin a) {
		return dao.addAdmin(a);
	}

	@Override
	public Admin updateAdmin(Admin a) {
		return dao.updateAdmin(a);
	}

	@Override
	public Departement addDepartement(Departement d) {
		dao.addDepartement(d);
		return null;
	}

	@Override
	public Departement updateDepartement(Departement d) {
		dao.updateDepartement(d);
		return null;
	}

	@Override
	public List<gestion_presence> getAbsence(Employe e, Date date) {
		return dao.getGestionPresence(e, date, "A");
	}

	@Override
	public List<gestion_presence> getRetard(Employe e, Date date) {
		return dao.getGestionPresence(e, date, "R");
	}

	@Override
	public List<gestion_presence> getHeureSuplementaire(Employe e, Date date) {
		return dao.getGestionPresence(e, date, "HS");
	}

	@Override
	public List<gestion_presence> getJoursFeries(Employe e, Date date) {
		return dao.getGestionPresence(e, date, "JF");
	}

	@Override
	public Admin logIn(Admin a) {
		return dao.logIn(a);
		
	}

	@Override
	public BulletinPaie getInfoSalaire(Employe e, Date date, boolean normal) {
		
		return dao.getInfoSalaire(e, date, normal);
	}

	@Override
	public void bloquerEmploye(Employe e) {
		dao.bloquerEmploye(e);		
	}

	@Override
	public void debloquerEmploye(Employe e) {
		dao.debloquerEmploye(e);		
	}

	@Override
	public List<Employe> getAllAmployes() {
		return dao.getAllEmployes();
	}

	@Override
	public Departement findDepartement(Departement d) {
		return dao.findDepartement(d);
	}

	@Override
	public List<Departement> findDepartements(String id) {
		return dao.findDepartements(id);
	}

	@Override
	public List<Departement> getAllDepartements() {
		return dao.getAllDepartements();
	}

	@Override
	public Entreprise addEntreprise(Entreprise e) {
		return dao.addEntreprise(e);
	}

	@Override
	public Entreprise updateEntreprise(Entreprise e) {
		return dao.updateEntreprise(e);
	}
	
	@Override
	public Entreprise findEntreprise(Entreprise e){
		return dao.findEntreprise(e);
	}

	@Override
	public long nbrAbsenceEmploye(Employe e) {
		
		return dao.nbrAbsenceEmploye(e);
	}

	@Override
	public long nbrRtardEmploye(Employe e) {
		
		return dao.nbrRtardEmploye(e);
	}

	@Override
	public long nbrHeuresTravailleEmploye(Employe e) {
		
		return dao.nbrHeuresTravailleEmploye(e);
	}
	
	
}
