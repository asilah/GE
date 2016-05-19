package org.gestion.emp.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
@Entity
@DiscriminatorValue("A")
public class Absence extends gestion_presence implements Serializable{
	

}
