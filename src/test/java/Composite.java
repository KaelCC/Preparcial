import model.Cancion;
import model.ElementoContenido;
import model.PlayList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Composite {
    @Test
    void deberiaSumarDuraciones() {
        PlayList lista = new PlayList("Test");

        lista.agregar(new ElementoContenido(
                new Cancion("1", "A", 100, "x", "y")
        ));

        lista.agregar(new ElementoContenido(
                new Cancion("2", "B", 200, "x", "y")
        ));

        assertEquals(300, lista.duracionTotal());
    }
 @Test
 void deberiaSoportarPlaylistsAnidadas() {
     PlayList padre = new PlayList("Padre");
     PlayList hijo = new PlayList("Hijo");

     hijo.agregar(new ElementoContenido(
             new Cancion("1", "A", 150, "x", "y")
     ));

     padre.agregar(hijo);

     assertEquals(150, padre.duracionTotal());
 }


    @Test
    void listaVaciaDebeSerCero() {
        PlayList lista = new PlayList("Vacía");

        assertEquals(0, lista.duracionTotal());
    }
}
