package br.com.musical.proMusica.model;

import jakarta.persistence.*;

@Entity
@Table(name = "musicas")
public class Musica {

    @Id
    private Long id;

    @Column(unique = true)
    private String nomeDaMusica;

    @ManyToOne
    private Artista artistas;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNomeDaMusica() {
        return nomeDaMusica;
    }

    public void setNomeDaMusica(String nomeDaMusica) {
        this.nomeDaMusica = nomeDaMusica;
    }

    public Artista getArtistas() {
        return artistas;
    }

    public void setArtistas(Artista artistas) {
        this.artistas = artistas;
    }

    @Override
    public String toString() {
        return "Musica{" +
                "id=" + id +
                ", nomeDaMusica='" + nomeDaMusica + '\'' +
                ", artistas=" + artistas +
                '}';
    }
}
