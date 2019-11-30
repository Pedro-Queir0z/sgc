package controllers;

import java.util.Arrays;
import java.util.List;


import models.Consulta;
import models.Funcionario;
import models.Medico;
import models.Sexo;
import models.TipoUsuario;
import models.Usuario;
import play.mvc.Controller;
import play.mvc.With;

@With(Seguranca.class)
public class Medicos extends Controller{
	
	public static void form(){
		TipoUsuario tipo = TipoUsuario.MEDICO;
		List<Sexo> sexo = Arrays.asList(Sexo.values());
		render(sexo);
	}
	
	public static void medHome() {
		List <Consulta> consultas = Consulta.findAll();
		render(consultas);		
	}
	
	public static void editar(Long id){
		Medico medico= Medico.findById(id);
		List<Consulta> consulta= Consulta.findAll();
		List<Sexo> sexo = Arrays.asList(Sexo.values());
		render("Medicos/form.html", medico, consulta, sexo);
	}
	
	public static void detalhes(Long id){
		Medico medico= Medico.findById(id);
		List<Consulta> consulta= Consulta.findAll();
		render("Medicos/form.html", medico, consulta);
	}
	
	public static void salvar(Medico medico){
		if(validation.hasErrors()) {
			validation.keep();
			params.flash();
			form();
		}else {
			if(params.get("apagarImagem") != null) {
			medico.foto.getFile().delete();
		}
		medico.tipoUsuario= TipoUsuario.MEDICO;
		medico.save();
		flash.success("Médico cadastrado");
		listar();
		}
	}
	public static void listar(){
		List<Medico> medicos=Medico.findAll();
		render(medicos);
	}
	public static void excluir(Long id){
		Medico medico = Medico.findById(id);
		medico.delete();
		listar();
	}
	public static void buscar(String nome){
		List<Medico> medicos = Medico.find("nome like ?", "%" +nome+ "%").fetch();
		render("Medicos/listar.html", medicos);
		
	}
	
	public static void mostrarImagemPerfil(Long id) {
		Medico medico=Medico.findById(id);
		renderBinary(medico.foto.get());
	}

}
