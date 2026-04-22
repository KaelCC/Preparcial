package model;

public class ReverbEfecto extends EfectoDecorator {
    public ReverbEfecto(IReproductor envuelto) { super(envuelto); }
    @Override
    public void reproducir(Contenido c) {
        super.reproducir(c);
        System.out.println(" Reverb aplicado ");
    }
}