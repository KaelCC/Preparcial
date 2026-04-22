import model.ReproductorGlobal;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class Singleton {
    @Test
    public void comprobarSiSingletonEsValido (){
        ReproductorGlobal r1 = ReproductorGlobal.getInstancia();
        ReproductorGlobal r2 = ReproductorGlobal.getInstancia();

        assertSame(r1,r2);
    }


}
