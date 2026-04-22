package Main;

import model.*;

public class Main {

    public static void main(String[] args) {

        // ===== SINGLETON =====
        ReproductorGlobal sistema = ReproductorGlobal.getInstancia();

        Usuario ana = new Usuario(
                "USR01",
                "Ana",
                Usuario.TipoSuscripcion.PREMIUM
        );

        Usuario luis = new Usuario(
                "USR02",
                "Luis",
                Usuario.TipoSuscripcion.FREE
        );

        sistema.iniciarSesion(ana);

        // ===== FACTORY METHOD =====
        ContenidoFactory fabricaCanciones = new CancionFactory();
        ContenidoFactory fabricaPodcast = new PodcastFactory();
        ContenidoFactory fabricaAudioLibro = new AudioLibroFactory();

        Contenido track1 = fabricaCanciones.crearContenido(
                "S01",
                "Skyfall",
                240,
                "Adele",
                "Skyfall"
        );

        Contenido track2 = fabricaCanciones.crearContenido(
                "S02",
                "Bohemian Rhapsody",
                355,
                "Queen",
                "A Night at the Opera"
        );

        // 🔥 AQUÍ ESTABA EL ERROR → cambiado "Episodio 10" por "10"
        Contenido episodio = fabricaPodcast.crearContenido(
                "P10",
                "Café con Tech",
                1500,
                "TechTalk",
                "10"
        );

        Contenido libro = fabricaAudioLibro.crearContenido(
                "L01",
                "El Principito",
                5400,
                "Antoine de Saint-Exupéry",
                "Narrador X"
        );

        // ===== COMPOSITE =====
        PlayList listaMusica = new PlayList("🎵 Música Favorita");
        listaMusica.agregar(new ElementoContenido(track1));
        listaMusica.agregar(new ElementoContenido(track2));

        PlayList listaEducativa = new PlayList("📚 Contenido Educativo");
        listaEducativa.agregar(new ElementoContenido(episodio));
        listaEducativa.agregar(new ElementoContenido(libro));

        PlayList listaGeneral = new PlayList("🔥 Mi Colección");
        listaGeneral.agregar(listaMusica);
        listaGeneral.agregar(listaEducativa);

        System.out.println("\n=== Explorando playlists ===");
        listaGeneral.mostrar("");

        int duracion = listaGeneral.duracionTotal();
        System.out.println("\n⏱ Tiempo total acumulado: "
                + PlayList.formatearDuracion(duracion));

        // ===== DECORATOR + PROXY =====
        IReproductor reproductorAna = crearReproductor(ana, true, true, false);
        IReproductor reproductorLuis = crearReproductor(luis, true, false, true);

        System.out.println("\n>>> Ana reproduce un audiolibro (acceso completo)");
        reproductorAna.reproducir(libro);

        System.out.println("\n>>> Luis intenta reproducir audiolibro (restricción activa)");
        reproductorLuis.reproducir(libro);

        System.out.println("\n>>> Luis reproduce música con efectos");
        reproductorLuis.reproducir(track1);
    }

    static IReproductor crearReproductor(
            Usuario usuario,
            boolean eq,
            boolean eco,
            boolean efecto3D
    ) {
        IReproductor base = new ReproductorBase();

        if (eq) base = new EqEfecto(base);
        if (eco) base = new ReverbEfecto(base);
        if (efecto3D) base = new Efecto8D(base);

        return new ProxyReproductor(base, usuario);
    }
}