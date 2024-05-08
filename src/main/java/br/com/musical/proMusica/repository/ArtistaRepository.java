package br.com.musical.proMusica.repository;

import br.com.musical.proMusica.model.Artista;
import br.com.musical.proMusica.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

    Optional<Artista> findByNomeDoArtistaContainingIgnoreCase(String nome);

    @Query("SELECT m FROM Artista a JOIN a.musicas m WHERE a.nomeDoArtista ILIKE %:nomeArtista%")
    List<Musica> getMusicasPerArtistas(String nomeArtista);

    @Override
    List<Artista> findAll();
}
