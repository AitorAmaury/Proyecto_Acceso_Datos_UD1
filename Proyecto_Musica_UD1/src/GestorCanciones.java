import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorCanciones {

    public static List<Cancion> leerTodos() {
        List<Cancion> listaCanciones = new ArrayList<>();
        File fichero = new File("canciones.dat");

        if (!fichero.exists()) {
            return listaCanciones;
        }

        try (FileInputStream fileIn = new FileInputStream(fichero);
             ObjectInputStream objIn = new ObjectInputStream(fileIn)) {
            while (true) {
                try {
                    Cancion c = (Cancion) objIn.readObject();
                    listaCanciones.add(c);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer canciones: " + e.getMessage());
        }
        return listaCanciones;
    }

    public static void guardarTodos(List<Cancion> lista) {
        File fichero = new File("canciones.dat");

        try (FileOutputStream fileOut = new FileOutputStream(fichero);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            for (Cancion c : lista) {
                objectOut.writeObject(c);
            }
            System.out.println("Canciones guardadas.");
        } catch (IOException e) {
            System.out.println("Error al guardar canciones: " + e.getMessage());
        }
    }

    // Comprueba que el álbum indicado existe antes de dar de alta una canción
    public static boolean existeAlbum(List<Album> albumes, int idAlbum) {
        for (Album a : albumes) {
            if (a.getId() == idAlbum) return true;
        }
        return false;
    }

    public static void baja(List<Cancion> lista, int id) {
        Cancion cEliminar = null;
        for (Cancion c : lista) {
            if (c.getId() == id) {
                cEliminar = c;
                break;
            }
        }
        if (cEliminar != null) {
            lista.remove(cEliminar);
            System.out.println("Canción eliminada correctamente.");
        } else {
            System.out.println("No existe ninguna canción con ese ID.");
        }
    }

    public static void modificar(List<Cancion> lista, int id, String nuevoTitulo, int nuevaDuracion, String nuevoGenero, int nuevoIdAlbum) {
        for (Cancion c : lista) {
            if (c.getId() == id) {
                c.setTitulo(nuevoTitulo);
                c.setDuracion(nuevaDuracion);
                c.setGenero(nuevoGenero);
                c.setIdAlbum(nuevoIdAlbum);
                System.out.println("Canción modificada correctamente.");
                return;
            }
        }
        System.out.println("No existe ninguna canción con ese ID.");
    }
}