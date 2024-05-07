package br.com.musical.proMusica.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "artistas")
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nomeDoArtista;
    @Enumerated(EnumType.STRING)
    private TipoArtista tipoArtista;
    @OneToMany(mappedBy = "artistas", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Musica> musicas;

    public Artista() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNomeDoArtista() {
        return nomeDoArtista;
    }

    public void setNomeDoArtista(String nomeDoArtista) {
        this.nomeDoArtista = nomeDoArtista;
    }

    public TipoArtista getTipoArtista() {
        return tipoArtista;
    }

    public void setTipoArtista(TipoArtista tipoArtista) {
        this.tipoArtista = tipoArtista;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        musicas.forEach(m -> m.setArtistas(this));
        this.musicas = musicas;
    }

    @Override
    public String toString() {
        return "Artista{" +
                "id=" + id +
                ", nomeDoArtista='" + nomeDoArtista + '\'' +
                ", tipoArtista=" + tipoArtista +
                ", musicas=" + musicas +
                '}';
    }
}
