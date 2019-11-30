package controllers;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import models.Consulta;
import models.Funcionario;
import models.Paciente;
import models.Sexo;
import models.TipoUsuario;
import models.Usuario;
import play.mvc.Controller;


public class Pacientes extends Controller {
	
	public static void pacHome() {
		render();
	}
	
	public static void form(){
		List<Sexo> sexo = Arrays.asList(Sexo.values());
		render(sexo);
	}
	
	public static void detalhes(Long id) {
		Paciente pac = Paciente.findById(Long.parseLong(session.get("usuario.id")));
		render(pac);
	}
	
	public static void editarPerfil(Long id) {
		Paciente paciente =Paciente.findById(id);
		List<Sexo> sexo = Arrays.asList(Sexo.values());
		render(paciente, sexo);
	}
	
	public static void editar(Long id){
		Paciente paciente =Paciente.findById(id);
		List<Consulta> consulta= Consulta.findAll();
		List<Sexo> sexo = Arrays.asList(Sexo.values());
		render("Pacientes/form.html", paciente, consulta, sexo);
	}
	// paciente edita perfil
	public static void salvarEdicao( Paciente paciente){
		Usuario usuario = Usuario.findById(Long.parseLong(session.get("usuario.id")));
		if(validation.hasErrors()) {
			validation.keep();
			params.flash();
			form();
			System.out.println("ahhh!");
		}else {
			if(params.get("apagarImagem") != null) {
			paciente.foto.getFile().delete();
		}
		paciente.tipoUsuario= TipoUsuario.PACIENTE;
		paciente.save();
		flash.success("Dados salvos com sucesso!");
		Pacientes.detalhes(usuario.id);						
		}
	}
	//area do admin
	public static void salvar( Paciente paciente){		
		if(validation.hasErrors()) {
			validation.keep();
			params.flash();
			form();
			System.out.println("ahhh!");
		}else {
			if(params.get("apagarImagem") != null) {
			paciente.foto.getFile().delete();
		}
		paciente.tipoUsuario= TipoUsuario.PACIENTE;
		paciente.save();		
		flash.success("Cadastrado efetuado com sucesso!");
		listar();
		}
	}
	
	public static void listar(){
		List<Paciente> pacientes=Paciente.findAll();
		render(pacientes);
	}
	public static void excluir(Long id){
		Paciente paciente = Paciente.findById(id);
		paciente.delete();
		listar();
	}
	public static void buscar(String nome){
		List<Paciente> pacientes = Paciente.find("nome like ?", "%" +nome+ "%").fetch();
		render("Pacientes/listar.html", pacientes);
		
	}
	public  static  void  mostrarImagemPerfil(Long  id) {
		Paciente paciente=Paciente.findById(id);
	    notFoundIfNull(paciente);
	    response.setContentTypeIfNotSet(paciente.foto.type());
	    renderBinary(paciente.foto.get());
	}
	
	public static void listarConsultasPaciente() {
		Paciente pac = Paciente.findById(Long.parseLong(session.get("usuario.id")));
		//List<Consulta> consultas=Consulta.find("paciente  = ?", pac).fetch();
		List<Consulta> consultas = Consulta.findAll();
		render(consultas);
	}
	public static void salvarConsulta(Consulta consulta) {
		Paciente pac = Paciente.findById(session.get("usuario.id"));
		consulta.paciente= (Paciente) pac;
		consulta.save();
		listarConsultasPaciente();
	}


}
