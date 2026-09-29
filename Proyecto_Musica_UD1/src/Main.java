import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
    public static void main(String[] args) {

        List<Artista> artistas = GestorArtistas.leerTodos();
        List<Cancion> canciones = GestorCanciones.leerTodos();
        List<Album> albumes = GestorAlbumes.leerTodos();

        int opcion = -1;

        do {
            System.out.println("\n=== GESTIÓN DE COLECCIÓN MUSICAL ===");
            System.out.println("1. Dar de alta un Artista");
            System.out.println("2. Dar de alta un Álbum");
            System.out.println("3. Dar de alta una Canción");
            System.out.println("4. Listar Artistas");
            System.out.println("5. Listar Álbumes");
            System.out.println("6. Listar Canciones");
            System.out.println("7. Exportar Artistas a XML");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");

            try {
                opcion = Integer.parseInt(br.readLine());
            } catch (NumberFormatException e){
                System.out.println("Error");
            } catch (IOException e){
                System.out.println("Error al leer la entrada: "+ e.getMessage());
                continue;
            }
            switch (opcion){
                case 1:
                    altaArtista(artistas);

                break;

                case 2:

            }
        }


    }
    private static void altaArtista(List<Artista> artistas) {
        try {
            // ID automático basado en la cantidad de elementos en memoria
            int id = artistas.size() + 1;

            System.out.print("Nombre: ");
            String nombre = br.readLine();
            System.out.print("Género musical: ");
            String genero = br.readLine();

            // Le pasamos el ID calculado al constructor
            artistas.add(new Artista(id, nombre, genero));
            System.out.println("Artista añadido con éxito con ID: " + id);
        } catch (IOException e) {
            System.out.println("Error al leer datos: " + e.getMessage());
        }
    }

    private static void altaAlbum(List<Album> albumes, List<Artista> artistas) {
        try {
            int id = albumes.size() + 1;

            System.out.print("Título del álbum: ");
            String titulo = br.readLine();
            System.out.print("Año de publicación: ");
            int anio = Integer.parseInt(br.readLine());

            // Pide el idArtista para asociarlo con la clase Artista
            System.out.print("ID del Artista al que pertenece: ");
            int idArtista = Integer.parseInt(br.readLine());

            albumes.add(new Album(id, titulo, anio, idArtista));
            System.out.println("Álbum añadido con éxito con ID: " + id);
        } catch (IOException e) {
            System.out.println("Error al leer datos: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: El año y el ID del artista deben ser números enteros.");
        }
    }

    private static void altaCancion(List<Cancion> canciones) {
        try {
            int id = canciones.size() + 1;

            System.out.print("Título de la canción: ");
            String titulo = br.readLine();
            System.out.print("Duración (segundos): ");
            int duracion = Integer.parseInt(br.readLine());
            System.out.print("Género: ");
            String genero = br.readLine();

            // Pide el idAlbum para asociarlo con la clase Album
            System.out.print("ID del Álbum al que pertenece: ");
            int idAlbum = Integer.parseInt(br.readLine());

            canciones.add(new Cancion(id, titulo, duracion, genero, idAlbum));
            System.out.println("Canción añadida con éxito con ID: " + id);
        } catch (IOException e) {
            System.out.println("Error al leer datos: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: La duración y el ID del álbum deben ser números enteros.");
        }
    }

    private static void listarArtistas(List<Artista> artistas){

    }

    private static void listarAlbumes(List<Album> albumes){

    }

    private static void listarCanciones(List<Cancion> canciones){

    }

}