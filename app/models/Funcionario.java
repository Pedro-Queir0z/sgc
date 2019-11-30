package models;

import javax.persistence.Entity;

import play.data.validation.Required;
import play.db.jpa.Blob;
import play.db.jpa.Model;

@Entity
public class Funcionario extends Usuario {
	
	public Blob foto;
	public int codFunc;
	
}
