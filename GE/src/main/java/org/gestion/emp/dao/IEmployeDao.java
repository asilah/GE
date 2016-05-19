package org.gestion.emp.dao;

import java.util.Date;
import java.util.List;

import org.gestion.emp.entities.Admin;
import org.gestion.emp.entities.BulletinPaie;
import org.gestion.emp.entities.Departement;
import org.gestion.emp.entities.Employe;
import org.gestion.emp.entities.Entreprise;
import org.gestion.emp.entities.gestion_presence;

public interface IEmployeDao {
	
	public Employe addEmplye(Employe e);
	public Employe update(Employe e);
	public Employe findEmloye(Employe e);
	public List<Employe> findEmployes(String id);
	public List<Employe> getAllEmployes(boolean conge);
	public List<Employe> getEmployesByDepartement(boolean conge, Departement departement);
	public void bloquerEmploye(Employe e);
	public void debloquerEmploye(Employe e);
	
	public gestion_presence addGestionPresence(gestion_presence gp, Employe e);
	public List<gestion_presence> getGestionPresence(Employe e,Date date, String type);
	
	public Admin logIn(Admin a);
	public Admin addAdmin(Admin a);
	public Admin updateAdmin(Admin a);
	
	public Entreprise addEntreprise(Entreprise e);
	public Entreprise updateEntreprise(Entreprise e);
	public Entreprise findEntreprise(Entreprise e);
	
	public Departement addDepartement(Departement d);
	public Departement updateDepartement(Departement d);
	public Departement findDepartement(Departement d);
	public List<Departement> findDepartements(String id);
	public List<Departement> getAllDepartements();
	
	public BulletinPaie getInfoSalaire(Employe e, Date date, boolean normal);
	public List<Employe> getAllEmployes();
	public long nbrAbsenceEmploye(Employe e);
	public long nbrRtardEmploye(Employe e);
	public long nbrHeuresTravailleEmploye(Employe e);

}
