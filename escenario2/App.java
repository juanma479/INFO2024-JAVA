package escenario2;

import escenario2.dominio.Estudiante;
import escenario2.dominio.Institucion;
import java.util.Scanner;

public class App {
    private Institucion institucion; //Utilizo a la clase institución como atributo

    //Constructor
    public App() {
        institucion = new Institucion();
    }
    public static void main(String[] args) {
        App app = new App();
        app.correrPrograma();
    }

    //Método que corre el programa
    public void correrPrograma() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        //Bucle While con las opciones de menú
        do {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> institucion.registrarEstudiante();
                case 2 -> institucion.crearCurso();
                case 3 -> inscribirEstudianteEnCurso();
                case 4 -> institucion.mostrarInformacionEstudiantesYCursos();
                case 5 -> institucion.cargarExamen(scanner);
                case 6 -> institucion.cargarCalificacionExamen();
                case 7 -> institucion.mostrarInformacionEstudiante(scanner);
                case 8 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida. Por favor, intente nuevamente.");
            }
        } while (opcion != 8);

        scanner.close();
    }

    //Método con la plantilla de menú principal
    private void mostrarMenu() {
        System.out.println("\n=== Menú Principal ===");
        System.out.println("1. Registrar Estudiante");
        System.out.println("2. Crear Curso");
        System.out.println("3. Inscribir Estudiante en Curso");
        System.out.println("4. Mostrar Información de Estudiantes y Cursos");
        System.out.println("5. Cargar un Examen");
        System.out.println("6. Cargar una Calificación al Examen");
        System.out.println("7. Mostrar Información de un Estudiante");
        System.out.println("8. Salir");
    }

    
    // Método de app para inscripción
    private void inscribirEstudianteEnCurso() {
        Scanner sc = new Scanner(System.in);

        //Consulta por alumno registrado
        System.out.println("El estudiante está registrado? (si/no)");
        String respuesta = sc.nextLine().toLowerCase();

        //Casos
        // Positivo: Pide DNI y corre metodo de inscripción.
        // Negativo: Sugiere registrar estudiante primero para luego realizar la inscripción sin tener que pedir DNI
        switch (respuesta) {
            case "si" -> {
                System.out.println("Ingrese el DNI del estudiante:");
                Long dni = sc.nextLong();
                sc.nextLine();
                institucion.inscribirEstudiante(dni);
            }
            case "no" -> {
                System.out.println("Debe registrar al estudiante primero.");
                Estudiante nuevoEstudiante = institucion.registrarEstudiante();
                institucion.inscribirEstudiante(nuevoEstudiante.getDni());
            }
            default -> System.out.println("Respuesta no válida. Volviendo al menú principal.");
        }
    }


}
