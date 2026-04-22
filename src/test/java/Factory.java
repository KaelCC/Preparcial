import model.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class Factory {
    @Test
    void deberiaCrearCancionCorrectamente() {
        ContenidoFactory factory = new CancionFactory();

        Contenido c = factory.crearContenido("1", "Test", 100, "Artista", "Album");

        assertNotNull(c);
        assertEquals("Test", c.getTitulo());
        assertEquals(100, c.getDuracionSeg());
    }


    @Test
    void deberiaCrearPodcastCorrectamente() {
        ContenidoFactory factory = new PodcastFactory();

        Contenido c = factory.crearContenido("2", "Podcast", 200, "Autor", "10");

        assertNotNull(c);
        assertEquals("Podcast", c.getTitulo());
    }
}
