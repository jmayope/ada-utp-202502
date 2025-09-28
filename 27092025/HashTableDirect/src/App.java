
public class App {
    public static void main(String[] args) throws Exception {
        HashTableDirect employees = new HashTableDirect(10);

        employees.add(new Employee(101, "Juan", "Jefe de TI"));
        employees.add(new Employee(202, "Carlos", "Jefe de TI"));
        employees.add(new Employee(303, "Manuel", "Jefe de TI"));
        employees.add(new Employee(404, "Diego", "Jefe de TI"));
        employees.add(new Employee(505, "Jorge", "Jefe de TI"));

        Employee employeeFound = employees.search(201);

        String result = "No Encontrado";
        if (employeeFound != null) {
            result = employeeFound.toString();
        }

        employees.printEmployees();

        System.out.println(result);

        Employee newEmployee = new Employee(501, "Carmelo", "Chief of TI");

        employees.add(newEmployee);
        employees.printEmployees();
        employees.delete(501);
        System.out.println(String.format("Eliminando empleado con ID:%d", 501));

        employees.printEmployees();

    }
}
