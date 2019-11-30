package controllers;


import java.util.List;

import models.Consulta;
import models.Funcionario;
import models.Medico;
import models.Paciente;
import models.TipoUsuario;
import models.Usuario;
import play.mvc.Controller;


public class Logins extends Controller{
	
	public static void form(){
		render();
	}
	public static void home() {
		List <Consulta> consultas = Consulta.findAll();
		render(consultas);
	}
	public static void senha() {
		render();
	}
	public static void logout(){
		session.clear();
		System.out.println("Logout");
		Application.index();
	}
	
	
//	public static void autentica(String email, String senha, String tipo){
//		if(email.equals("admin@admin") && senha.equals("admin")){
//			session.put("email", email);
//			session.put("tipo",tipo);
//			System.out.println(tipo);
//			flash.success("Bem vindo ao SGC");
//			render("Logins/home.html");
//		}
		
		//else {
		//	flash.error("Email ou senha invalidos");
		//	render("Logins/form.html");
		//}
//	}
	
	public static void autentica(String email, String senha, String tipo) {
		Usuario usuario = Usuario.find("email = ?1 and senha = ?2 ", email, senha).first();
		
		if(usuario == null) {
			flash.error("Email ou senha invalidos");
			form();
		}
		
		session.put("usuario.id", usuario.id);
		session.put("nomeUsuario", usuario.nome);
		flash.success("Bem vindo " + session.get("nomeUsuario"));
		if(usuario.tipoUsuario.equals(TipoUsuario.FUNCIONARIO)) {
				home();		
		}else if(usuario.tipoUsuario.equals(TipoUsuario.PACIENTE)) {
			Pacientes.pacHome();
		}else if(usuario.tipoUsuario.equals(TipoUsuario.MEDICO)) {			
			Medicos.medHome();
		}
	}
		
	
	

}
