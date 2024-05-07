package br.com.musical.proMusica;

import br.com.musical.proMusica.principal.Principal;
import br.com.musical.proMusica.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProMusicaApplication implements CommandLineRunner {
	@Autowired
	ArtistaRepository repositorio;

	public static void main(String[] args) {
		SpringApplication.run(ProMusicaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repositorio);
		principal.exibeMenu();
	}
}
