package controllers;

import java.util.Arrays;
import java.util.List;

import models.Funcionario;
import models.Paciente;
import models.Sexo;
import models.TipoUsuario;
import play.mvc.Controller;
import play.mvc.With;
@With(Seguranca.class)
public class Funcionarios extends Controller {
	
	public static void form(){
		TipoUsuario tipo = TipoUsuario.FUNCIONARIO;
		List<Sexo> sexo = Arrays.asList(Sexo.values());
		render(sexo);
	}
	public static void editar(Long id){
		Funcionario func= Funcionario.findById(id);
		render("Funcionarios/form.html", func);
	}
	public static void salvar(Funcionario func){
		if(validation.hasErrors()) {
			validation.keep();
			params.flash();
			form();
		}else {
			if(params.get("apagarImagem") != null) {
			func.foto.getFile().delete();
		}
		func.tipoUsuario= TipoUsuario.FUNCIONARIO;
		func.save();
		flash.success("Funcionário cadastrado");
		listar();
		}
	}
	public static void listar(){
		List<Funcionario> funcs=Funcionario.findAll();
		render(funcs);
	}
	public static void excluir(Long id){
		Funcionario func = Funcionario.findById(id);
		func.delete();
		flash.success("Funcionario removido");
		listar();
	}
	public static void buscar(String nome){
		List<Funcionario> funcs = Funcionario.find("nome like ?", "%" + nome + "%").fetch();
		render("Funcionarios/listar.html", funcs);
		
	}
	public static void mostrarImagemPerfil(Long id) {
		Funcionario func=Funcionario.findById(id);
		renderBinary(func.foto.get());
	}

}
