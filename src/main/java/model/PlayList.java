package model;

import java.util.ArrayList;
import java.util.List;

public class PlayList implements ComponentePlayList {

    private String nombre;
    private List<ComponentePlayList> hijos = new ArrayList<>();

    public PlayList(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int duracionTotal() {
        int total = 0;
        for (ComponentePlayList c : hijos) {
            total += c.duracionTotal();
        }
        return total;
    }

    @Override
    public void mostrar(String indent) {
        System.out.println(indent + "Playlist: " + nombre);
        for (ComponentePlayList c : hijos) {
            c.mostrar(indent + "  ");
        }
    }

    public void agregar(ComponentePlayList c) {
        hijos.add(c);
    }

    public void quitar(ComponentePlayList c) {
        hijos.remove(c);
    }


    public static String formatearDuracion(int segundos) {
        int horas = segundos / 3600;
        int min = (segundos % 3600) / 60;
        int seg = segundos % 60;
        return String.format("%02d:%02d:%02d", horas, min, seg);
    }
}