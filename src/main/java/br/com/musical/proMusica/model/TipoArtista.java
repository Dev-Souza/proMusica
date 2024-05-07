package br.com.musical.proMusica.model;

public enum TipoArtista {
    SOLO("solo"),
    DUETO("dueto"),
    BANDA("banda");

    private String tipoArtista;

    TipoArtista(String tipoArtista){
        this.tipoArtista = tipoArtista;
    }


}
