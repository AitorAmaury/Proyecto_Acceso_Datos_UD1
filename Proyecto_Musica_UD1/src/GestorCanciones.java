import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorCanciones {
    public static List<Cancion> leerTodos() {
        List<Cancion> listaCanciones = new ArrayList<Cancion>();

        File fichero = new File("canciones.dat");

        if (!fichero.exists()) {
            return listaCanciones;
        }

        try (FileInputStream fileIn = new FileInputStream(fichero); ObjectInputStream objIn = new ObjectInputStream(fileIn)) {
            while (true) {
                try {
                    Cancion c = (Cancion) objIn.readObject();
                    listaCanciones.add(c);
                } catch (EOFException e) {
                    break;
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer canciones: "+ e.getMessage());
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
            System.out.println("Canciones guardadas");

        } catch (IOException e) {
            System.out.println("Error al guardar canciones");
        }
    }
}