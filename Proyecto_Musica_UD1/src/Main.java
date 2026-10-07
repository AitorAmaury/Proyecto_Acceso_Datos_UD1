import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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
            System.out.println("7. Dar de baja un Artista");
            System.out.println("8. Dar de baja un Álbum");
            System.out.println("9. Dar de baja una Canción");
            System.out.println("10. Modificar un Artista");
            System.out.println("11. Modificar un Álbum");
            System.out.println("12. Modificar una Canción");
            System.out.println("13. Exportar Artistas a XML");
            System.out.println("14. Exportar Álbumes a XML");
            System.out.println("15. Exportar Canciones a XML");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");

            try {
                opcion = Integer.parseInt(br.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: introduce un número válido");
                continue;
            } catch (IOException e) {
                System.out.println("Error al leer la entrada: " + e.getMessage());
                continue;
            }

            switch (opcion) {
                case 1:
                    altaArtista(artistas);
                    GestorArtistas.guardarTodos(artistas);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case 2:
                    altaAlbum(albumes, artistas);
                    GestorAlbumes.guardarTodos(albumes);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case 3:
                    altaCancion(canciones, albumes);
                    GestorCanciones.guardarTodos(canciones);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case 4:
                    listarArtistas(artistas);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case 5:
                    listarAlbumes(albumes);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case 6:
                    listarCanciones(canciones);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case 7:
                    bajaArtista(artistas, albumes, canciones);
                    GestorArtistas.guardarTodos(artistas);
                    GestorAlbumes.guardarTodos(albumes);
                    GestorCanciones.guardarTodos(canciones);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case 8:
                    bajaAlbum(albumes, canciones);
                    GestorAlbumes.guardarTodos(albumes);
                    GestorCanciones.guardarTodos(canciones);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case 9:
                    bajaCancion(canciones);
                    GestorCanciones.guardarTodos(canciones);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case 10:
                    modificarArtista(artistas);
                    GestorArtistas.guardarTodos(artistas);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case 11:
                    modificarAlbum(albumes);
                    GestorAlbumes.guardarTodos(albumes);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case 12:
                    modificarCancion(canciones);
                    GestorCanciones.guardarTodos(canciones);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case 13:
                    GestorXML.exportarArtistasXML(artistas);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case 14:
                    GestorXML.exportarAlbumesXML(albumes);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case 15:
                    GestorXML.exportarCancionesXML(canciones);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                default:
                    System.out.println("Opción no válida");
            }

        } while (opcion != 0);
    }

    // ALTAS

    private static void altaArtista(List<Artista> artistas) {
        try {
            int id = artistas.size() + 1;
            System.out.print("Nombre: ");
            String nombre = br.readLine();
            System.out.print("Género musical: ");
            String genero = br.readLine();
            artistas.add(new Artista(id, nombre, genero));
            System.out.println("Artista añadido con éxito con ID: " + id);
        } catch (IOException e) {
            System.out.println("Error al leer datos: " + e.getMessage());
        }
    }

    private static void altaAlbum(List<Album> albumes, List<Artista> artistas) {
        try {
            if (artistas.isEmpty()) {
                System.out.println("No hay artistas registrados. Da de alta un artista primero.");
                return;
            }
            int id = albumes.size() + 1;
            System.out.print("Título del álbum: ");
            String titulo = br.readLine();
            System.out.print("Año de publicación: ");
            int anio = Integer.parseInt(br.readLine());

            listarArtistas(artistas);
            System.out.print("ID del Artista al que pertenece: ");
            int idArtista = Integer.parseInt(br.readLine());

            if (!GestorAlbumes.existeArtista(artistas, idArtista)) {
                System.out.println("Error: no existe ningún artista con ese ID. Álbum no creado.");
                return;
            }

            albumes.add(new Album(id, titulo, anio, idArtista));
            System.out.println("Álbum añadido con éxito con ID: " + id);
        } catch (IOException e) {
            System.out.println("Error al leer datos: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: El año y el ID del artista deben ser números enteros.");
        }
    }

    private static void altaCancion(List<Cancion> canciones, List<Album> albumes) {
        try {
            if (albumes.isEmpty()) {
                System.out.println("No hay álbumes registrados. Da de alta un álbum primero.");
                return;
            }
            int id = canciones.size() + 1;
            System.out.print("Título de la canción: ");
            String titulo = br.readLine();
            System.out.print("Duración (segundos): ");
            int duracion = Integer.parseInt(br.readLine());
            System.out.print("Género: ");
            String genero = br.readLine();

            listarAlbumes(albumes);
            System.out.print("ID del Álbum al que pertenece: ");
            int idAlbum = Integer.parseInt(br.readLine());

            if (!GestorCanciones.existeAlbum(albumes, idAlbum)) {
                System.out.println("Error: no existe ningún álbum con ese ID. Canción no creada.");
                return;
            }

            canciones.add(new Cancion(id, titulo, duracion, genero, idAlbum));
            System.out.println("Canción añadida con éxito con ID: " + id);
        } catch (IOException e) {
            System.out.println("Error al leer datos: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: La duración y el ID del álbum deben ser números enteros.");
        }
    }

    // LISTADOS

    private static void listarArtistas(List<Artista> artistas) {
        if (artistas.isEmpty()) {
            System.out.println("No hay artistas registrados.");
            return;
        }
        for (Artista a : artistas) {
            System.out.println("ID: " + a.getId() + " | Nombre: " + a.getNombre() + " | Género: " + a.getGenero());
        }
    }

    private static void listarAlbumes(List<Album> albumes) {
        if (albumes.isEmpty()) {
            System.out.println("No hay álbumes registrados.");
            return;
        }
        for (Album a : albumes) {
            System.out.println("ID: " + a.getId() + " | Título: " + a.getTitulo() + " | Año: " + a.getAnio() + " | idArtista: " + a.getIdArtista());
        }
    }

    private static void listarCanciones(List<Cancion> canciones) {
        if (canciones.isEmpty()) {
            System.out.println("No hay canciones registradas.");
            return;
        }
        for (Cancion c : canciones) {
            System.out.println("ID: " + c.getId() + " | Título: " + c.getTitulo() + " | Duración: " + c.getDuracion() + "s | Género: " + c.getGenero() + " | idAlbum: " + c.getIdAlbum());
        }
    }

    // BAJAS

    private static void bajaArtista(List<Artista> artistas, List<Album> albumes, List<Cancion> canciones) {
        try {
            listarArtistas(artistas);
            System.out.print("ID del artista a eliminar: ");
            int id = Integer.parseInt(br.readLine());
            GestorArtistas.bajaConCascada(artistas, albumes, canciones, id);
        } catch (IOException e) {
            System.out.println("Error al leer datos: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: el ID debe ser un número entero.");
        }
    }

    private static void bajaAlbum(List<Album> albumes, List<Cancion> canciones) {
        try {
            listarAlbumes(albumes);
            System.out.print("ID del álbum a eliminar: ");
            int id = Integer.parseInt(br.readLine());
            GestorAlbumes.bajaConCascada(albumes, canciones, id);
        } catch (IOException e) {
            System.out.println("Error al leer datos: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: el ID debe ser un número entero.");
        }
    }

    private static void bajaCancion(List<Cancion> canciones) {
        try {
            listarCanciones(canciones);
            System.out.print("ID de la canción a eliminar: ");
            int id = Integer.parseInt(br.readLine());
            GestorCanciones.baja(canciones, id);
        } catch (IOException e) {
            System.out.println("Error al leer datos: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: el ID debe ser un número entero.");
        }
    }

    // MODIFICACIONES

    private static void modificarArtista(List<Artista> artistas) {
        try {
            listarArtistas(artistas);
            System.out.print("ID del artista a modificar: ");
            int id = Integer.parseInt(br.readLine());
            System.out.print("Nuevo nombre: ");
            String nombre = br.readLine();
            System.out.print("Nuevo género: ");
            String genero = br.readLine();
            GestorArtistas.modificar(artistas, id, nombre, genero);
        } catch (IOException e) {
            System.out.println("Error al leer datos: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: el ID debe ser un número entero.");
        }
    }

    private static void modificarAlbum(List<Album> albumes) {
        try {
            listarAlbumes(albumes);
            System.out.print("ID del álbum a modificar: ");
            int id = Integer.parseInt(br.readLine());
            System.out.print("Nuevo título: ");
            String titulo = br.readLine();
            System.out.print("Nuevo año: ");
            int anio = Integer.parseInt(br.readLine());
            System.out.print("Nuevo ID de artista: ");
            int idArtista = Integer.parseInt(br.readLine());
            GestorAlbumes.modificar(albumes, id, titulo, anio, idArtista);
        } catch (IOException e) {
            System.out.println("Error al leer datos: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: el año y los IDs deben ser números enteros.");
        }
    }

    private static void modificarCancion(List<Cancion> canciones) {
        try {
            listarCanciones(canciones);
            System.out.print("ID de la canción a modificar: ");
            int id = Integer.parseInt(br.readLine());
            System.out.print("Nuevo título: ");
            String titulo = br.readLine();
            System.out.print("Nueva duración (segundos): ");
            int duracion = Integer.parseInt(br.readLine());
            System.out.print("Nuevo género: ");
            String genero = br.readLine();
            System.out.print("Nuevo ID de álbum: ");
            int idAlbum = Integer.parseInt(br.readLine());
            GestorCanciones.modificar(canciones, id, titulo, duracion, genero, idAlbum);
        } catch (IOException e) {
            System.out.println("Error al leer datos: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: la duración y el ID deben ser números enteros.");
        }
    }
}