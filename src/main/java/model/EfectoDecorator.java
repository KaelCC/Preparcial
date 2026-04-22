package model;

public abstract class EfectoDecorator implements IReproductor {
    protected IReproductor envuelto;
    public EfectoDecorator(IReproductor envuelto) {
        this.envuelto = envuelto;
    }
    @Override
    public void reproducir(Contenido c) {
        envuelto.reproducir(c);
    }
}