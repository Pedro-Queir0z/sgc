package controllers;

import java.util.List;

import models.Tipo;
import play.mvc.Controller;

public class Tipos extends Controller{
	
	public static void listar() {
		List<Tipo> tipos = Tipo.findAll();
		render(tipos);
	}
	
	public static void detalhes(Long id) {
		Tipo tipo = Tipo.findById(id);
		render(tipo);		
	}


}
