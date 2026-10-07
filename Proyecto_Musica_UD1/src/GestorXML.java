import com.thoughtworks.xstream.XStream;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GestorXML {

    public static void exportarArtistasXML(List<Artista> lista) {
        XStream xstream = new XStream();
        xstream.alias("artistas", List.class);
        xstream.alias("artista", Artista.class);

        try (FileWriter writer = new FileWriter("artistas.xml")) {
            xstream.toXML(lista, writer);
            System.out.println("Fichero artistas.xml generado con éxito.");
        } catch (IOException e) {
            System.out.println("Error al generar el fichero XML: " + e.getMessage());
        }
    }

    public static void exportarAlbumesXML(List<Album> lista) {
        XStream xstream = new XStream();
        xstream.alias("albumes", List.class);
        xstream.alias("album", Album.class);

        try (FileWriter writer = new FileWriter("albumes.xml")) {
            xstream.toXML(lista, writer);
            System.out.println("Fichero albumes.xml generado con éxito.");
        } catch (IOException e) {
            System.out.println("Error al generar el fichero XML: " + e.getMessage());
        }
    }

    public static void exportarCancionesXML(List<Cancion> lista) {
        XStream xstream = new XStream();
        xstream.alias("canciones", List.class);
        xstream.alias("cancion", Cancion.class);

        try (FileWriter writer = new FileWriter("canciones.xml")) {
            xstream.toXML(lista, writer);
            System.out.println("Fichero canciones.xml generado con éxito.");
        } catch (IOException e) {
            System.out.println("Error al generar el fichero XML: " + e.getMessage());
        }
    }
}