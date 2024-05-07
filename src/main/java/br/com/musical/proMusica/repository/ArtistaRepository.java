package br.com.musical.proMusica.repository;

import br.com.musical.proMusica.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

}
