package org.gestion.emp.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("HS")
public class HeursSuplementaire extends gestion_presence implements Serializable{

}
