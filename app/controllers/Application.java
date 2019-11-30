package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }
    public static void listar() {
        render();
    }
    public static void cadastrar() {
        render();
    }
    public static void info() {
    	render();
    }
    public static void form() {
    	List<Sexo> sexo = Arrays.asList(Sexo.values());
		render(sexo);
    }
    
    public static void salvar(Paciente paciente){
		if(validation.hasErrors()) {
			validation.keep();
			params.flash();
			System.out.println("ahhh!");
			form();
			
		}else {
			if(params.get("apagarImagem") != null) {
			paciente.foto.getFile().delete();
		}
		paciente.tipoUsuario = TipoUsuario.PACIENTE;
		paciente.save();
		session.put("usuario.id", paciente.id);
		session.put("nomeUsuario", paciente.nome);
		flash.success("Cadastrado efetuado com sucesso!");
		Pacientes.pacHome();
		}
	}

}