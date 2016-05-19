package org.gestion.emp.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("R")
public class Retard extends gestion_presence implements Serializable{
	

}
