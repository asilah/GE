package org.gestion.emp.metier;

import java.util.Date;
import java.util.List;

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

public interface IEmployeMetier {
	public Employe addEmplye(Employe e);
	public Employe update(Employe e);
	public Employe findEmloye(Employe e);
	public List<Employe> getAllAmployes();
	public List<Employe> findEmployes(String id);
	public List<Employe> getAllEmployes(boolean conge);
	public List<Employe> getEmployesByDepartement(boolean conge, Departement departement);
	
	public Absence addAbsence(Employe e, Absence a);
	public Retard addRetard(Employe e, Retard r);
	public HeursSuplementaire addHeursSuplementaire(Employe e, HeursSuplementaire hs);
	public JoursFeries addJoursFeries(Employe e, JoursFeries jf); 
	public Admin logIn(Admin a);

	public List<gestion_presence> getAbsence(Employe e, Date date);
	public List<gestion_presence> getRetard(Employe e, Date date);
	public List<gestion_presence> getHeureSuplementaire(Employe e, Date date);
	public List<gestion_presence> getJoursFeries(Employe e, Date date);
	
	public Admin addAdmin(Admin a);
	public Admin updateAdmin(Admin a);
	
	public Departement addDepartement(Departement d);
	public Departement updateDepartement(Departement d);
	public Departement findDepartement(Departement d);
	public List<Departement> findDepartements(String id);
	public List<Departement> getAllDepartements();
	
	public Entreprise addEntreprise(Entreprise e);
	public Entreprise updateEntreprise(Entreprise e);
	public Entreprise findEntreprise(Entreprise e);

	public BulletinPaie getInfoSalaire(Employe e, Date date, boolean normal);
	public void bloquerEmploye(Employe e);
	public void debloquerEmploye(Employe e);
	public long nbrAbsenceEmploye(Employe e);
	public long nbrRtardEmploye(Employe e);
	public long nbrHeuresTravailleEmploye(Employe e);
}
