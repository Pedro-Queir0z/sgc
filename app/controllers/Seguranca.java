/**
 * 
 */
package controllers;


import models.TipoUsuario;
import models.Usuario;
import play.mvc.Before;
import play.mvc.Controller;

public class Seguranca extends Controller{
	
	@Before
	static void checarUsuarioLogado() {
		// nenhum usuário logado
		if(session.get("usuario.id") == null) { 
			Application.index();	
	
		}
//		else { 
//			Usuario usuario = Usuario.findById(Long.parseLong(session.get("usuario.id")));
//			if(usuario.tipoUsuario.equals(TipoUsuario.PACIENTE)) //verificar se o usuário é um PACIENTE
//				Pacientes.pacHome();			
//			
//		}
	}

}
