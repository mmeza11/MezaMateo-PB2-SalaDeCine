package com.morga.saladecine.interfaz;

import java.util.Scanner;
import com.morga.saladecine.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static SalaCine sala;
    private static Pelicula[] peliculas = new Pelicula[100];

    public static void main(String[] args) {
        inicializarSistema();
        mostrarMenuPrincipal();
    }

    private static void inicializarSistema() {
        System.out.println("🎬 BIENVENIDOS AL SISTEMA DE GESTIÓN DE CINEMA 🎬");
        sala = new SalaCine();

        // Agregamos algunas butacas por defecto (A1, A2, B1, B2)
        sala.agregarButaca("A1");
        sala.agregarButaca("A2");
        sala.agregarButaca("B1");
        sala.agregarButaca("B2");

        // Cargar películas por defecto
        cargarPeliculasDefault();

        System.out.println("\n✅ Sistema inicializado correctamente!");
        System.out.println("📽️  " + peliculas.length + " películas cargadas en el sistema.\n");
    }

    private static void cargarPeliculasDefault() {
        peliculas[0] = new PeliculaAccion("Misión Imposible", 150, 13);
        peliculas[1] = new PeliculaAccion("John Wick 4", 169, 16);
        peliculas[2] = new PeliculaAccion("Top Gun: Maverick", 130, 13);
        peliculas[3] = new PeliculaComedia("La Máscara", 120, 7);
        peliculas[4] = new PeliculaComedia("Shrek", 90, 0);
        peliculas[5] = new PeliculaDrama("Forrest Gump", 142, 13);
        peliculas[6] = new PeliculaDrama("El Padrino", 175, 16);
        peliculas[7] = new PeliculaTerror("El Conjuro", 112, 18);
        peliculas[8] = new PeliculaTerror("Scream", 111, 18);
        peliculas[9] = new PeliculaInfantil("Frozen", 102, 0);
    }

    private static void mostrarMenuPrincipal() {
        int opcion;

        do {
            System.out.println("=".repeat(50));
            System.out.println("🎭 MENU PRINCIPAL - GESTIÓN DE SALA DE CINE 🎭");
            System.out.println("=".repeat(50));
            System.out.println("1. 🎬 Gestionar películas");
            System.out.println("2. 🎫 Vender boleto");
            System.out.println("3. 🔓 Liberar asiento");
            System.out.println("4. 👀 Ver detalle de butacas");
            System.out.println("5. 📋 Ver información de película actual");
            System.out.println("6. 🎪 Reiniciar sala (liberar todos los asientos)");
            System.out.println("0. 🚪 Salir del sistema");
            System.out.println("=".repeat(50));
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> gestionarPeliculas();
                case 2 -> venderBoleto();
                case 3 -> liberarAsiento();
                case 4 -> mostrarButacasDetalle();
                case 5 -> mostrarInfoPelicula();
                case 6 -> reiniciarSala();
                case 0 -> System.out.println("¡Gracias por usar nuestro sistema de cinema! 🍿");
                default -> System.out.println("❌ Opción inválida. Intente de nuevo.");
            }

            if (opcion != 0) {
                System.out.println("\nPresione Enter para continuar...");
                scanner.nextLine();
                scanner.nextLine();
            }

        } while (opcion != 0);
    }

    private static void mostrarButacasDetalle() {
        System.out.println(sala.mostrarButacasDetalle());
    }

    private static void gestionarPeliculas() {
        System.out.println("\n🎬 CATÁLOGO DE PELÍCULAS DISPONIBLES");
        for (int i = 0; i < 10; i++) {
            if (peliculas[i] != null)
                System.out.printf("%2d. %s (%d años+)\n", i + 1, peliculas[i].getTitulo(), peliculas[i].getEdadMinima());
        }

        System.out.print("Seleccione una película (1-10): ");
        int opcion = scanner.nextInt();

        if (opcion >= 1 && opcion <= 10 && peliculas[opcion - 1] != null) {
            sala.cambiarPelicula(peliculas[opcion - 1]);
            System.out.println("Pelicula cambiada a: " + peliculas[opcion - 1].getTitulo());
        } else {
            System.out.println("❌ Opción inválida.");
        }
    }

    private static void venderBoleto() {
        if (sala.getPeliculaActual() == null) {
            System.out.println("❌ No hay película en cartelera. Primero seleccione una película.");
            return;
        }

        System.out.println("\n🎫 VENTA DE BOLETOS");
        System.out.println("Película actual: " + sala.getPeliculaActual().getTitulo());
        System.out.println("Edad mínima requerida: " + sala.getPeliculaActual().getEdadMinima() + " años");

        mostrarButacasDetalle();

        System.out.print("Ingrese el nombre del comprador: ");
        scanner.nextLine();
        String nombreComprador = scanner.nextLine();

        System.out.print("Ingrese el lugar del asiento (ejemplo A1): ");
        String lugar = scanner.next();
        System.out.print("Ingrese la edad del cliente: ");
        int edad = scanner.nextInt();

        try {
            sala.venderBoleto(lugar, edad, nombreComprador);
            System.out.println("🎉 ¡Boleto vendido exitosamente!");
        } catch (Exception e) {
            System.out.println("❌ No se pudo vender el boleto. Revise los datos.");
        }
    }

    private static void liberarAsiento() {
        System.out.println("\n🔓 LIBERAR ASIENTO");
        mostrarButacasDetalle();

        System.out.print("Ingrese el lugar del asiento a liberar (ejemplo A1): ");
        String lugar = scanner.next();

        try {
            sala.liberarAsiento(lugar);
            System.out.println("🎉 ¡Asiento liberado exitosamente!");
        } catch (Exception e) {
            System.out.println("❌ No se pudo liberar el asiento.");
        }
    }

    private static void mostrarInfoPelicula() {
        if (sala.getPeliculaActual() != null) {
            System.out.println("\n📋 INFORMACIÓN DE LA PELÍCULA ACTUAL");
            sala.getPeliculaActual().mostrarSinopsis();
        } else {
            System.out.println("❌ No hay película en cartelera actualmente.");
        }
    }

    private static void reiniciarSala() {
        System.out.print("⚠️  ¿Está seguro que desea liberar todos los asientos? (s/n): ");
        scanner.nextLine();
        String confirmacion = scanner.nextLine();

        if (confirmacion.equalsIgnoreCase("s") || confirmacion.equalsIgnoreCase("si")) {
            sala.reiniciarSala();
            System.out.println("🎭 Todos los asientos fueron liberados.");
        } else {
            System.out.println("❌ Operación cancelada.");
        }
    }
}
