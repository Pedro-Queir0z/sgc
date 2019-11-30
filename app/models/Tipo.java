package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

//@Entity
public class Tipo extends Model {
	public String nome;

	
//	@OneToMany(mappedBy="tipo")
//	public List<Consulta> consultas;
}
