/**
 * 
 */
package jobs;

import models.Consulta;
import models.Funcionario;
import models.Paciente;
import models.StatusConsulta;
import models.Tipo;
import models.TipoUsuario;
import play.jobs.Job;
import play.jobs.OnApplicationStart;


@OnApplicationStart
public class Inicializador extends Job{
		
	public void doJob() throws Exception {
//		if(Tipo.count() == 0) {
//			
//			Tipo tipo1 = new Tipo();
//			tipo1.nome = "Normal";
//			tipo1.save();
//			
//			Tipo tipo2 = new Tipo();
//			tipo2.nome = "Retorno";
//			tipo2.save();
//		}
		
		if(Funcionario.count()==0) {
			Funcionario func = new Funcionario();
			func.email="admin@admin.com";
			func.senha="admin";
			func.nome="José Druthstain";
			func.tipoUsuario = TipoUsuario.FUNCIONARIO;
			func.save();
		}
	}
}
