package br.com.musical.proMusica.repository;

import br.com.musical.proMusica.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

    Optional<Artista> findByNomeDoArtistaContainingIgnoreCase(String nome);

    @Override
    List<Artista> findAll();
}
