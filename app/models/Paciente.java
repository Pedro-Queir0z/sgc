package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import play.data.validation.Required;
import play.db.jpa.Blob;
import play.db.jpa.Model;

@Entity
public class Paciente extends Usuario{
	
	public Blob foto;
	
	public int numSus;
	
	
	@ManyToMany(mappedBy="paciente")
	public List<Consulta> consultas;
}
