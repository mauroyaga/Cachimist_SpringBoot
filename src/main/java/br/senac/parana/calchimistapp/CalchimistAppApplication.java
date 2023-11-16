package br.senac.parana.calchimistapp;

import br.senac.parana.calchimistapp.controlador.UsuarioControlador;
import br.senac.parana.calchimistapp.telas.UsuarioTela;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication          //Define a classe de entrada da aplicação.
public class CalchimistAppApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CalchimistAppApplication.class, args);

//		// Obtenha uma instância de UsuarioControlador do contexto Spring
//		UsuarioControlador usuarioControlador = context.getBean(UsuarioControlador.class);
//
//		// Crie uma instância de UsuarioTela e injete o UsuarioControlador
//		UsuarioTela usuarioTela = new UsuarioTela(usuarioControlador);
//
//		// Execute a interface do usuário
//		UsuarioTela.executar();
	}
}
