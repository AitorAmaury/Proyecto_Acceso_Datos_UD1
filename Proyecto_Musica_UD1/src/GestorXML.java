import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GestorXML {

    public static void exportarArtistasXML(List<Artista> lista) {
        XStream xstream = new XStream();

        // Permisos de seguridad requeridos por XStream
        xstream.addPermission(AnyTypePermission.ANY);
        xstream.alias("artista", Artista.class);
        xstream.alias("artistas", List.class);

        try (FileWriter writer = new FileWriter("artistas.xml")) {
            xstream.toXML(lista, writer);
            System.out.println("Fichero artistas.xml generado con éxito.");
        } catch (IOException e) {
            System.out.println("Error al generar el fichero XML: " + e.getMessage());
        }
    }
}