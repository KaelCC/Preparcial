package model;

public abstract class ContenidoFactory {
    public abstract Contenido crearContenido(String id, String titulo,
                                             int duracionSeg, String extra1, String
                                                     extra2);
}