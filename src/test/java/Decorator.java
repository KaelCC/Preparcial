import model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


public class Decorator {

    @Test
    void efectosNoDebenRomperReproduccion() {
        IReproductor base = new ReproductorBase();
        IReproductor conEfectos = new EqEfecto(new ReverbEfecto(base));

        Contenido c = new Cancion("1", "Test", 100, "x", "y");

        assertDoesNotThrow(() -> conEfectos.reproducir(c));
    }
}
