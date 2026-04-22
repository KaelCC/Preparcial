package model;

public class Podcast extends Contenido {
    private String presentador;
    private int numeroEpisodio;
    public Podcast(String id, String titulo, int duracionSeg, String presentador, int ep)
    {
        super(id, titulo, duracionSeg);
        this.presentador = presentador;
        this.numeroEpisodio = ep;
    }
    @Override
    public void reproducir() {
        System.out.println(" model.Podcast:" + titulo + " de " + numeroEpisodio);
    }
}
