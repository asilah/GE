package org.gestion.emp.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("JF")
public class JoursFeries extends gestion_presence implements Serializable{
	
}
