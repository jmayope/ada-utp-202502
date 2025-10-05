import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class App {


    public static void showMenu(List<String> menu) {
        System.out.println(String.join("\n", menu.stream().map((m) -> String.format("%d. %s", menu.indexOf(m) + 1, m)).toList()));
    }

    public static void showStudents(List<Student> students) {
        System.out.println(String.join("\n", students.stream().map((m) -> m.toString()).toList()));
    }

    public static void showRooms(List<Room> rooms) {
        System.out.println(String.join("\n", rooms.stream().map((m) -> m.toString()).toList()));
    }

    public static void showRoomTypes(List<Room> rooms) {
        List<String> types = new ArrayList<>();
        rooms.stream().forEach((r) -> {
            if (!types.contains(r.type)) {
                types.add(r.type);
            }
        });
        System.out.println(String.join("\n", types));
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        boolean sw = true;
        List<Student> students = new ArrayList<>();
        System.out.println("*****************************************");
        System.out.println("Administración de Estudiantes");
        System.out.println("*****************************************");
        while (sw) {
            List<String> menuStudents = new ArrayList<>();
            System.err.println("Menu de Aplicativo:\n");
            menuStudents.add("Agregar Estudiante");
            menuStudents.add("Listar Estudiantes");
            menuStudents.add("Buscar Estudiante");
            showMenu(menuStudents);
            System.out.println("Elije una opción:");
            int optionSelected = sc.nextInt();
            switch (optionSelected) {
                case 1:
                    // Agregar estudiante
                    System.out.println("Opción de Agregar estudiante");
                    System.out.println("Ingrese el Nombre Completo del Estudiante:");
                    sc.nextLine();
                    String full_name = sc.nextLine();
                    String code = String.format("CLI%03d", students.size() + 1);
                    Student newStdent = new Student(code, full_name);
                    students.add(newStdent);
                    System.out.println("Estudiante Agregado a la BD Local");
                    break;
                case 2:
                    showStudents(students);
                    break;
                case 3:
                    showStudents(students);
                    System.out.println("Ingrese Código a Buscar:");
                    sc.nextLine();
                    String codeToSearch = sc.nextLine();
                    System.out.println(codeToSearch);
                    System.out.println(students.toString());
                    Optional<Student> studentFound = Student.search(students, codeToSearch);
                    String result = "No encontrado";
                    if (!studentFound.isEmpty()) {
                        result = String.format("Estudiante Encontrado: %s", studentFound.get().toString());
                    }
                    System.out.println(result);
                    break;
                default:
                    sw = false;
                    System.out.println("Saliendo del Aplicativo");
                    break;
            }
        }
        System.out.println("*****************************************");
        System.out.println("Administración de Habitaciones:\n");
        System.out.println("*****************************************");

        sw = true;
        List<Room> rooms = new ArrayList<>();
        while (sw) {
            List<String> menuStudents = new ArrayList<>();
            System.err.println("Menu de Aplicativo:\n");
            menuStudents.add("Agregar habitación");
            menuStudents.add("Listar habitaciones");
            menuStudents.add("Buscar Habitación por Número y Tipo");
            showMenu(menuStudents);
            System.out.println("Elije una opción:");
            int optionSelected = sc.nextInt();
            String number = "";
            switch (optionSelected) {
                case 1:
                    // CREAR HABITACIONES
                    System.out.println("Ingrese número de Habitación a crear:");
                    sc.nextLine();
                    number = sc.nextLine();
                    System.out.println("Ingrese tipo de Habitación a crear:");
                    String type = sc.nextLine();
                    Room newRoom = new Room(number, type);
                    rooms.add(newRoom);
                    System.out.println("Habitación agregada");
                    break;
                case 2:
                    // Listar habitaciones
                    showRooms(rooms);
                    break;
                case 3:
                    // BUSCAR HABITACIÓN
                    System.out.println("Ingrese número de Habitación a buscar: ");
                    sc.nextLine();
                    number = sc.nextLine();
                    System.out.println("Tipos de Habitaciones existentes:");
                    showRoomTypes(rooms);
                    System.out.println("Ingresa tipo de habitación a buscar:");
                    sc.nextLine();
                    type = sc.nextLine();
                    Optional<Room> roomFound = Room.search(rooms, number, type);
                    String result = "No encontrado";
                    if (!roomFound.isEmpty()) {
                        result = String.format("Habitación Encontrada: %s", roomFound.get().toString());
                    }
                    System.out.println(result);
                    break;
                default:
                    sw = false;
                    System.out.println("Saliendo del Aplicativo");
                    break;
            }
        }
    }
}
