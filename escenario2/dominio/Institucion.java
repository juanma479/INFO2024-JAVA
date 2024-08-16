package escenario2.dominio;

import escenario2.enumeration.*;
import java.time.*;
import java.util.*;

public class Institucion {
    private Map<String, Curso> cursos;
    private List<Estudiante> estudiantes;

    // Constructor
    public Institucion() {
        this.cursos = new TreeMap<>();
        this.estudiantes = new ArrayList<>();
    }

    // Getters y Setters
    public Map<String, Curso> getCursos() {
        return cursos;
    }

    public void setCursos(Map<String, Curso> cursos) {
        this.cursos = cursos;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    // Método registrarEstudiante
    public Estudiante registrarEstudiante() {
        Scanner sc = new Scanner(System.in);

        // Nombre
        System.out.println("Ingrese el nombre del estudiante: ");
        String nombreEstudiante = sc.nextLine();

        // DNI
        System.out.println("Ingrese el dni del estudiante: ");
        Long dni = sc.nextLong();
        sc.nextLine();

        // Fecha de nacimiento
        System.out.println("Ingrese el año de nacimiento del estudiante: ");
        int anoDeNacimiento = sc.nextInt();
        System.out.println("Ingrese el mes de nacimiento del estudiante: ");
        int mesDeNacimiento = sc.nextInt();
        System.out.println("Ingrese el día de nacimiento del estudiante: ");
        int diaDeNacimiento = sc.nextInt();
        sc.nextLine();

        LocalDate fechaDeNacimiento = LocalDate.of(anoDeNacimiento, mesDeNacimiento, diaDeNacimiento);

        // Inicialización de la lista vacía de cursos
        List<Curso> cursos = new ArrayList<>();

        // Creación del objeto Estudiante utilizando el constructor
        Estudiante estudianteNuevo = new Estudiante(nombreEstudiante, fechaDeNacimiento, dni, cursos);

        // Aquí añade el estudiante a la lista en la clase Institución
        estudiantes.add(estudianteNuevo);

        return estudianteNuevo;
    }

    // Método para crear un curso
    public Curso crearCurso() {
        Scanner sc = new Scanner(System.in);

        // Solicitar nombre del curso
        System.out.println("Ingrese el nombre del curso: ");
        String nombreCurso = sc.nextLine();

        // Verificar si el curso ya existe
        if (cursos.containsKey(nombreCurso)) {
            System.out.println("El curso con ese nombre ya existe. Intente con otro nombre.");
            return null;
        }

        // Solicitar cantidad de horas de cursado
        System.out.println("Ingrese la cantidad de horas de cursado: ");
        int cantidadHoras = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

        // Solicitar nivel de complejidad
        System.out.println("Seleccione el nivel de complejidad (1: Baja, 2: Media, 3: Alta): ");
        int nivelComplejidad = sc.nextInt();
        sc.nextLine(); // Limpiar buffer
        ComplejidadEnum complejidad;

        switch (nivelComplejidad) {
            case 1 -> complejidad = ComplejidadEnum.BAJA;
            case 2 -> complejidad = ComplejidadEnum.MEDIA;
            case 3 -> complejidad = ComplejidadEnum.ALTA;
            default -> {
                System.out.println("Nivel de complejidad no válido. Se asignará por defecto 'Media'.");
                complejidad = ComplejidadEnum.MEDIA;
            }
        }

        // Solicitar tipo de curso
        System.out.println("Seleccione el tipo de curso (1: Teórico, 2: Práctico): ");
        int tipoCurso = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

        // Crear curso según tipo
        Curso nuevoCurso;

        // Generar un UUID para el curso
        UUID idCurso = UUID.randomUUID();

        switch (tipoCurso) {
            case 1 -> {
                // Curso Teórico
                System.out
                        .println("Seleccione la modalidad del curso (1: Presencial, 2: Semipresencial, 3: Virtual): ");
                int modalidadSeleccionada = sc.nextInt();
                sc.nextLine(); // Limpiar buffer
                ModalidadEnum modalidad;
                switch (modalidadSeleccionada) {
                    case 1 -> modalidad = ModalidadEnum.PRESENCIAL;
                    case 2 -> modalidad = ModalidadEnum.SEMIPRESENCIAL;
                    case 3 -> modalidad = ModalidadEnum.VIRTUAL;
                    default -> {
                        System.out.println("Modalidad no válida. Se asignará por defecto 'Presencial'.");
                        modalidad = ModalidadEnum.PRESENCIAL;
                    }
                } // Crear nuevo curso teórico
                nuevoCurso = new CursoTeorico(idCurso, nombreCurso, cantidadHoras, complejidad, new TreeMap<>(),
                        new ArrayList<>(), modalidad);
            }
            case 2 -> {
                // Curso Práctico
                List<Recurso> recursos = new ArrayList<>();
                System.out.println("Ingrese la cantidad de recursos necesarios: ");
                int cantidadRecursos = sc.nextInt();
                sc.nextLine();
                // Ciclo for para cargar recursos
                for (int i = 0; i < cantidadRecursos; i++) {
                    System.out.println("Ingrese el nombre del recurso " + (i + 1) + ": ");
                    String nombreRecurso = sc.nextLine();

                    System.out.println("Ingrese la descripción del recurso " + (i + 1) + ": ");
                    String descripcionRecurso = sc.nextLine();

                    // Crear id de recurso
                    UUID idRecurso = UUID.randomUUID();
                    recursos.add(new Recurso(idRecurso, nombreRecurso, descripcionRecurso));
                } // Crear nuevo curso práctico
                nuevoCurso = new CursoPractico(idCurso, nombreCurso, cantidadHoras, complejidad, new TreeMap<>(),
                        new ArrayList<>(), recursos);
            }
            default -> {
                System.out.println("Tipo de curso no válido. Operación cancelada.");
                return null;
            }
        }

        // Agregar el nuevo curso al mapa de cursos
        cursos.put(nombreCurso, nuevoCurso);
        System.out.println("Curso creado exitosamente.");
        return nuevoCurso;
    }

    public void inscribirEstudiante(Long dni) {
        Scanner sc = new Scanner(System.in);

        // Solicitar nombre del curso
        System.out.println("Ingrese el nombre del curso:");
        String nombreCurso = sc.nextLine();

        // Buscar el curso en el mapa
        Curso curso = cursos.get(nombreCurso);

        if (curso == null) {
            System.out.println("El curso " + nombreCurso + " no existe.");
            return; // Salimos del método si no se encuentra el curso
        }

        // Buscar al estudiante en la lista
        Estudiante estudiante = null;
        for (Estudiante e : estudiantes) {
            if (Objects.equals(e.getDni(), dni)) {
                estudiante = e;
                break;
            }
        }

        if (estudiante == null) {
            System.out.println("No se encontró un estudiante con el DNI: " + dni);
            return; // Salimos del método si no se encuentra el estudiante
        }

        // Agregar el curso a la lista de cursos del estudiante
        if (!estudiante.getCursos().contains(curso)) {
            estudiante.getCursos().add(curso);
        }

        // Agregar el estudiante a la lista de estudiantes del curso
        if (!curso.getEstudiantes().containsKey(dni)) {
            curso.getEstudiantes().put(dni, estudiante);
        }

        System.out.println(
                "El estudiante " + estudiante.getNombre() + " ha sido inscrito en el curso " + nombreCurso + ".");

    }

    // Método para mostrar la información de estudiantes y cursos
    public void mostrarInformacionEstudiantesYCursos() {
        for (Estudiante estudiante : estudiantes) {
            // Separación entre estudiantes
            System.out.println("--------------------------------------");

            // Mostrar información del estudiante
            System.out.println("Nombre: " + estudiante.getNombre());
            System.out.println("DNI: " + estudiante.getDni());

            // Calcular y mostrar la edad del estudiante
            LocalDate hoy = LocalDate.now();
            Period edad = Period.between(estudiante.getFechaNac(), hoy);
            System.out.println("Edad: " + edad.getYears() + " años");

            // Mostrar los cursos en los que está inscrito
            System.out.print("Cursos Inscritos: ");
            List<Curso> cursosInscritos = estudiante.getCursos();
            if (cursosInscritos.isEmpty()) {
                System.out.print("No está inscrito en ningún curso.");
            } else {
                for (int i = 0; i < cursosInscritos.size(); i++) {
                    System.out.print(cursosInscritos.get(i).getNombre());
                    if (i < cursosInscritos.size() - 1) {
                        System.out.print(", ");
                    }
                }
            }
            System.out.println();

            // Separación entre estudiantes
            System.out.println("--------------------------------------");
        }
    }

    public void cargarExamen(Scanner scanner) {
        // Solicitar el nombre del curso
        System.out.println("Ingrese el nombre del curso: ");
        String nombreCurso = scanner.nextLine();

        // Buscar el curso en el TreeMap
        Curso curso = cursos.get(nombreCurso);

        if (curso == null) {
            System.out.println("El curso " + nombreCurso + " no existe.");
            return;
        }

        // Solicitar el DNI del estudiante
        System.out.println("Ingrese el DNI del estudiante: ");
        Long dni = scanner.nextLong();
        scanner.nextLine(); // Limpiar el buffer

        // Buscar al estudiante en la lista
        Estudiante estudiante = null;
        for (Estudiante e : estudiantes) {
            if (Objects.equals(e.getDni(), dni)) {
                estudiante = e;
                break;
            }
        }

        if (estudiante == null || !curso.getEstudiantes().containsKey(dni)) {
            System.out.println("El estudiante con DNI " + dni + " no está inscrito en el curso " + nombreCurso + ".");
            return;
        }

        // Crear el objeto Examen sin calificación
        Examen examen = new Examen(curso, estudiante);

        // Agregar el examen a la lista de exámenes del curso
        curso.getExamenes().add(examen);

        System.out.println("Examen creado correctamente.");
    }

    public void cargarCalificacionExamen() {
        Scanner scanner = new Scanner(System.in);

        // Solicitar el nombre del curso
        System.out.println("Ingrese el nombre del curso: ");
        String nombreCurso = scanner.nextLine();

        // Buscar el curso en el TreeMap
        Curso curso = cursos.get(nombreCurso);

        if (curso == null) {
            System.out.println("El curso " + nombreCurso + " no existe.");
            return;
        }

        // Solicitar el DNI del estudiante
        System.out.println("Ingrese el DNI del estudiante: ");
        Long dni = scanner.nextLong();
        scanner.nextLine(); // Limpiar el buffer

        // Buscar al estudiante en la lista
        Estudiante estudiante = null;
        for (Estudiante e : estudiantes) {
            if (Objects.equals(e.getDni(), dni)) {
                estudiante = e;
                break;
            }
        }

        if (estudiante == null || !curso.getEstudiantes().containsKey(dni)) {
            System.out.println("El estudiante con DNI " + dni + " no está inscrito en el curso " + nombreCurso + ".");
            return;
        }

        // Buscar el examen correspondiente
        Examen examen = null;
        for (Examen e : curso.getExamenes()) {
            if (e.getEstudiante().equals(estudiante)) {
                examen = e;
                break;
            }
        }

        if (examen == null) {
            System.out.println("No hay examen registrado para el estudiante en el curso " + nombreCurso + ".");
            return;
        }

        // Solicitar la nota, descripción y fecha del examen
        System.out.println("Ingrese la nota del examen: ");
        double nota = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer

        System.out.println("Ingrese la descripción del examen: ");
        String descripcion = scanner.nextLine();

        System.out.println("Ingrese la fecha y hora del examen (YYYY-MM-DD HH:MM): ");
        String fechaHora = scanner.nextLine();
        LocalDateTime fechaExamen = LocalDateTime.parse(fechaHora.replace(" ", "T"));

        // Asignar los valores al examen
        examen.setCalificacion(nota);
        examen.setDescripcion(descripcion);
        examen.setFechaExamen(fechaExamen);

        System.out.println("Calificación cargada correctamente.");
    }

    public void mostrarInformacionEstudiante(Scanner scanner) {
        System.out.println("Ingrese el DNI del estudiante: ");
        Long dni = scanner.nextLong();
        scanner.nextLine(); // Limpiar el buffer

        // Buscar al estudiante por DNI
        Estudiante estudiante = null;
        for (Estudiante e : estudiantes) {
            if (Objects.equals(e.getDni(), dni)) {
                estudiante = e;
                break;
            }
        }

        if (estudiante == null) {
            System.out.println("Estudiante con DNI " + dni + " no encontrado.");
            return;
        }

        // Mostrar información del estudiante
        System.out.println("Nombre: " + estudiante.getNombre());
        System.out.println("DNI: " + estudiante.getDni());
        System.out.println("Edad: " + Period.between(estudiante.getFechaNac(), LocalDate.now()).getYears());

        // Mostrar cursos en los que está inscrito
        System.out.println("Cursos inscritos:");
        for (Curso curso : estudiante.getCursos()) {
            System.out.println("- " + curso.getNombre());

            // Buscar el examen en la lista de exámenes del curso
            Examen examenEncontrado = null;
            for (Examen examen : curso.getExamenes()) {
                if (Objects.equals(examen.getEstudiante().getDni(), dni)) {
                    examenEncontrado = examen;
                    break;
                }
            }

            if (examenEncontrado != null) {
                System.out.println("  Nota: " + examenEncontrado.getCalificacion());
                System.out.println("  Descripción: " + examenEncontrado.getDescripcion());
                System.out.println("  Fecha: " + examenEncontrado.getFechaExamen());
            } else {
                System.out.println("  No hay examen registrado para este curso.");
            }
        }
    }

}
