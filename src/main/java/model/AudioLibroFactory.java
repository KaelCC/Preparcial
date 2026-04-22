package model;

public class AudioLibroFactory extends ContenidoFactory {
    @Override
    public Contenido crearContenido(String id, String titulo, int duracionSeg,
                                    String autor, String narrador) {
        return new Audiolibro(id, titulo, duracionSeg, autor, narrador);
    }
}