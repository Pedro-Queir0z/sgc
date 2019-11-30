package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.db.jpa.Model;

@Entity
public class Consulta extends Model{
	
	public String descricao;
	public String diagnostico;
	@Temporal(TemporalType.TIMESTAMP)
	public Date data;
	
	@ManyToOne
	@JoinColumn(name="medico_id")
	public Medico medico;
	
	@ManyToOne
	@JoinColumn(name="paciente_id")
	public Paciente paciente;
	
	@Enumerated(EnumType.STRING)
	public TipoConsulta tipo;
	
	@Enumerated(EnumType.STRING)
	public StatusConsulta stac;
	
}
