package controllers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import models.Consulta;
import models.Funcionario;
import models.Medico;
import models.Paciente;
import models.StatusConsulta;
import models.Tipo;
import models.TipoConsulta;
import play.mvc.Controller;
import play.mvc.With;
@With(Seguranca.class)
public class Consultas extends Controller {
	
	public static void form() {		
		List<TipoConsulta> tipos = Arrays.asList(TipoConsulta.values());
		List<StatusConsulta> stac = Arrays.asList(StatusConsulta.values());
		render(stac, tipos);
	}
	
	public static void formPac() {		
		List<TipoConsulta> tipos = Arrays.asList(TipoConsulta.values());
		List<StatusConsulta> stac = Arrays.asList(StatusConsulta.values());
		render(stac, tipos);
	}
	
	public static void formMed() {		
		List<TipoConsulta> tipos = Arrays.asList(TipoConsulta.values());
		List<StatusConsulta> stac = Arrays.asList(StatusConsulta.values());
		render(stac, tipos);
	}
	
	public static void listar() {
		List <Consulta> consultas = Consulta.findAll();		
		render(consultas);
	}
	
	public static void listarMed() {
		List <Consulta> consultas = Consulta.findAll();				
		render(consultas);
	}
	
	public static void editar(Long id){
		Consulta consulta= Consulta.findById(id);
		List<TipoConsulta> tipos = Arrays.asList(TipoConsulta.values());
		List<StatusConsulta> stac = Arrays.asList(StatusConsulta.values());
		render("Consultas/form.html", consulta, tipos, stac);
	}
	
	public static void editarRequerimento(Long id){
		Consulta consulta= Consulta.findById(id);
		List<TipoConsulta> tipos = Arrays.asList(TipoConsulta.values());
		List<StatusConsulta> stac = Arrays.asList(StatusConsulta.values());
		render("Consultas/formMed.html", consulta, tipos, stac);
	}
	public static void salvar(Consulta consulta){
		consulta.save();
		listar();
	}
	
	public static void salvarP(Consulta consulta, List<String> pacienteIDs) {

		if(pacienteIDs == null || pacienteIDs.isEmpty()) {
			consulta.paciente = null;
		}else {
			String IDs = "(" + String.join(", ", pacienteIDs) + ")";		
			String query = "select p from Paciente p where p.id in " + IDs;
			Paciente pacientes = (Paciente) Paciente.find(query).fetch();
			consulta.paciente = pacientes;
		}
		consulta.save();
		flash.success("Consulta salva com sucesso!");
		Pacientes.pacHome();
	}
	
	public static void salvarMed(Consulta consulta, List<String> medicoIDs) {

		if(medicoIDs == null || medicoIDs.isEmpty()) {
			consulta.medico = null;
		}else {
			String IDs = "(" + String.join(", ", medicoIDs) + ")";		
			String query = "select m from Medico m where m.id in " + IDs;
			Medico medicos = (Medico) Medico.find(query).fetch();
			consulta.medico = medicos;
		}
		consulta.save();
		flash.success("Consulta salva com sucesso!");
		listarMed();
	}
	public static void excluir(Long id){
		Consulta consulta = Consulta.findById(id);
		consulta.delete();
		listar();
	}
	
	public static void excluirMed(Long id){
		Consulta consulta = Consulta.findById(id);
		consulta.delete();
		listarMed();
	}
	
	public static void detalhes(Long id) {
		Consulta consulta = Consulta.findById(id);
		render(consulta);
	}
	
	public static void buscar(String nome){
		List<Consulta> consulta = Consulta.find("nome like ?", "%" + nome + "%").fetch();
		render("Consultas/listar.html", consulta);
		
	}


}
