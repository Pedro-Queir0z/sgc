package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import controllers.Seguranca;
import play.data.validation.Required;
import play.db.jpa.Blob;
import play.db.jpa.Model;
import play.mvc.With;

@Entity
public class Medico extends Usuario{
	
	public String tipo;
	@Required(message="Área obrigatória")
	public Blob foto;
	public int codMed;
	
	public Medico() {
		tipoUsuario = TipoUsuario.MEDICO;
	}
	
	@OneToMany(mappedBy="medico")
	public List<Consulta> consultas;
}
