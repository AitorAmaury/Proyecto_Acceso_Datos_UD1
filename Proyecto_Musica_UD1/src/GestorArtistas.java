import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorArtistas {

    public static List<Artista> leerTodos() {
        List<Artista> listaArtistas = new ArrayList<Artista>();
        File fichero = new File("artistas.dat");

        if (!fichero.exists()) {
            return listaArtistas;
        }
        try {
            FileInputStream fileIn = new FileInputStream(fichero);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);

            while (true) {
                try {
                    Artista a = (Artista) objIn.readObject();
                    listaArtistas.add(a);
                } catch (EOFException eofe) {
                    break;
                }
            }
            objIn.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer artistas: " + e.getMessage());
        }
        return listaArtistas;

    }

    public static void guardarTodos(List<Artista> lista){


        File fichero = new File("artistas.dat");

        try {
            FileOutputStream fileOut = new FileOutputStream(fichero);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            for (Artista a : lista){
                objectOut.writeObject(a);
            }
            System.out.println("Artistas guardados.");
        }catch (IOException e){
            System.out.println("Error al guardar: "+e.getMessage());
        }

    }
}
