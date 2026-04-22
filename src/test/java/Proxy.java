import model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Proxy {

    @Test
    void usuarioPremiumDebeReproducirTodo() {
        Usuario premium = new Usuario("1", "Ana", Usuario.TipoSuscripcion.PREMIUM);

        IReproductor r = new ProxyReproductor(
                new ReproductorBase(), premium
        );

        Contenido libro = new Audiolibro("1", "Libro", 1000, "Autor", "Narrador");

        assertDoesNotThrow(() -> r.reproducir(libro));
    }

    @Test
    void usuarioFreeNoDebeReproducirAudiolibro() {
        Usuario free = new Usuario("2", "Luis", Usuario.TipoSuscripcion.FREE);

        IReproductor r = new ProxyReproductor(
                new ReproductorBase(), free
        );

        Contenido libro = new Audiolibro("1", "Libro", 1000, "Autor", "Narrador");


        assertDoesNotThrow(() -> r.reproducir(libro));
    }
}