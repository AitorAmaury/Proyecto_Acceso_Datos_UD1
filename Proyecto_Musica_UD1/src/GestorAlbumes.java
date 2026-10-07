import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorAlbumes {

    public static List<Album> leerTodos() {
        List<Album> listaAlbumes = new ArrayList<>();
        File fichero = new File("albumes.dat");

        if (!fichero.exists()) {
            return listaAlbumes;
        }

        try (FileInputStream fileIn = new FileInputStream(fichero);
             ObjectInputStream objIn = new ObjectInputStream(fileIn)) {

            while (true) {
                try {
                    Album a = (Album) objIn.readObject();
                    listaAlbumes.add(a);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer álbumes: " + e.getMessage());
        }
        return listaAlbumes;
    }

    public static void guardarTodos(List<Album> lista) {
        File fichero = new File("albumes.dat");

        try (FileOutputStream fileOut = new FileOutputStream(fichero);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            for (Album a : lista) {
                objectOut.writeObject(a);
            }
            System.out.println("Álbumes guardados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar álbumes: " + e.getMessage());
        }
    }

    // Comprueba que el artista indicado existe antes de dar de alta un álbum
    public static boolean existeArtista(List<Artista> artistas, int idArtista) {
        for (Artista a : artistas) {
            if (a.getId() == idArtista) return true;
        }
        return false;
    }

    // Baja en cascada: borra el álbum y sus canciones
    public static void bajaConCascada(List<Album> albumes, List<Cancion> canciones, int id) {
        Album aEliminar = null;
        for (Album a : albumes) {
            if (a.getId() == id) {
                aEliminar = a;
                break;
            }
        }

        if (aEliminar == null) {
            System.out.println("No existe ningún álbum con ese ID.");
            return;
        }

        int borradas = canciones.size();
        canciones.removeIf(c -> c.getIdAlbum() == id);
        borradas = borradas - canciones.size();

        albumes.remove(aEliminar);
        System.out.println("Álbum eliminado junto con " + borradas + " canción/es asociada/s.");
    }

    public static void modificar(List<Album> lista, int id, String nuevoTitulo, int nuevoAnio, int nuevoIdArtista) {
        for (Album a : lista) {
            if (a.getId() == id) {
                a.setTitulo(nuevoTitulo);
                a.setAnio(nuevoAnio);
                a.setIdArtista(nuevoIdArtista);
                System.out.println("Álbum modificado correctamente.");
                return;
            }
        }
        System.out.println("No existe ningún álbum con ese ID.");
    }
}