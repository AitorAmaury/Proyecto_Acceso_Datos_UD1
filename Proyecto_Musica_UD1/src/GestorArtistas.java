import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorArtistas {

    public static List<Artista> leerTodos() {
        List<Artista> listaArtistas = new ArrayList<>();
        File fichero = new File("artistas.dat");

        if (!fichero.exists()) {
            return listaArtistas;
        }

        try (FileInputStream fileIn = new FileInputStream(fichero);
             ObjectInputStream objIn = new ObjectInputStream(fileIn)) {

            while (true) {
                try {
                    Artista a = (Artista) objIn.readObject();
                    listaArtistas.add(a);
                } catch (EOFException eofe) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer artistas: " + e.getMessage());
        }
        return listaArtistas;
    }

    public static void guardarTodos(List<Artista> lista) {
        File fichero = new File("artistas.dat");

        try (FileOutputStream fileOut = new FileOutputStream(fichero);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            for (Artista a : lista) {
                objectOut.writeObject(a);
            }
            System.out.println("Artistas guardados.");
        } catch (IOException e) {
            System.out.println("Error al guardar artistas: " + e.getMessage());
        }
    }

    // Baja en cascada: borra el artista, sus álbumes y las canciones de esos álbumes
    public static void bajaConCascada(List<Artista> artistas, List<Album> albumes, List<Cancion> canciones, int id) {
        Artista aEliminar = null;
        for (Artista a : artistas) {
            if (a.getId() == id) {
                aEliminar = a;
                break;
            }
        }

        if (aEliminar == null) {
            System.out.println("No existe ningún artista con ese ID.");
            return;
        }

        // Buscar álbumes de ese artista
        List<Album> albumesAEliminar = new ArrayList<>();
        for (Album al : albumes) {
            if (al.getIdArtista() == id) {
                albumesAEliminar.add(al);
            }
        }

        // Por cada álbum, borrar también sus canciones
        for (Album al : albumesAEliminar) {
            canciones.removeIf(c -> c.getIdAlbum() == al.getId());
        }

        albumes.removeAll(albumesAEliminar);
        artistas.remove(aEliminar);

        System.out.println("Artista eliminado junto con " + albumesAEliminar.size() + " álbum(es) y sus canciones asociadas.");
    }

    public static void modificar(List<Artista> lista, int id, String nuevoNombre, String nuevoGenero) {
        for (Artista a : lista) {
            if (a.getId() == id) {
                a.setNombre(nuevoNombre);
                a.setGenero(nuevoGenero);
                System.out.println("Artista modificado correctamente.");
                return;
            }
        }
        System.out.println("No existe ningún artista con ese ID.");
    }
}