import java.util.ArrayList;
import java.util.List;

public class CargarDatosEjemplo {
    public static void main(String[] args) {
        List<Artista> artistas = new ArrayList<>();
        artistas.add(new Artista(1, "Fito y Fitipaldis", "Rock"));
        artistas.add(new Artista(2, "Rosalía", "Flamenco Pop"));
        artistas.add(new Artista(3, "Bad Bunny", "Reggaetón"));

        List<Album> albumes = new ArrayList<>();
        albumes.add(new Album(1, "Antes de que cuente diez", 2002, 1));
        albumes.add(new Album(2, "Motomami", 2022, 2));
        albumes.add(new Album(3, "Un Verano Sin Ti", 2022, 3));

        List<Cancion> canciones = new ArrayList<>();
        canciones.add(new Cancion(1, "Soldadito marinero", 228, "Rock", 1));
        canciones.add(new Cancion(2, "Antes de que cuente diez", 195, "Rock", 1));
        canciones.add(new Cancion(3, "Saoko", 171, "Flamenco Pop", 2));
        canciones.add(new Cancion(4, "Bizcochito", 158, "Flamenco Pop", 2));
        canciones.add(new Cancion(5, "Tití Me Preguntó", 243, "Reggaetón", 3));

        GestorArtistas.guardarTodos(artistas);
        GestorAlbumes.guardarTodos(albumes);
        GestorCanciones.guardarTodos(canciones);

        GestorXML.exportarArtistasXML(artistas);
        GestorXML.exportarAlbumesXML(albumes);
        GestorXML.exportarCancionesXML(canciones);
    }
}
