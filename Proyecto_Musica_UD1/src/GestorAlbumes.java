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
}