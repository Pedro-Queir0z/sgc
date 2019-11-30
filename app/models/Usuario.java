package models;

import javax.persistence.Entity;

import play.data.validation.Email;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Blob;
import play.db.jpa.Model;
@Entity
public class Usuario extends Model {
	@Required(message="Área obrigatória")
	public String nome;
	
	@Required(message="Área obrigatória")
	public String sobrenome;
	
	@Required(message="Área obrigatória")
	@Email
	public String email;
	
	@Required(message="Área obrigatória")
	public String cpf;
	
	@Required(message="Área obrigatória")
	@MinSize(value = 3)
	public String senha;
	
	@Required(message="Área obrigatória")
	public String sexo;
	
	public TipoUsuario tipoUsuario;

}
