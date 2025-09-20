import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class App {

    // Tablas HASH
    // HASHSET -> Buscar si un elemento existe en una lista; utilizando tablas set
    // -- Tenemos una lista de numeros y queremos verificar rapidamente si un número dado esta en la lista.
    // 
    // QUeremos contar cuantas veces aparece cada palabra 

    public static int[] generateArrayNumber() {
        int size = 50;
        int result[] = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = (int)(Math.random() * 100);
        }
        return result;
    }

    public static void printArray(int[] numbers) {
        String[] text = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            text[i] = numbers[i]+"";
        }
        System.out.println(String.join(",", text));
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // HashSet
        // int[] numbers = generateArrayNumber();
        // System.out.println(String.format("Tu lista es:"));
        // printArray(numbers);
 
        // System.out.println("Ingrese el número a buscar: ");
        // int numberSearch = sc.nextInt();

        // HashSet<Integer> allNumbers = new HashSet<>();

        // for (Integer num : numbers) {
        //     allNumbers.add(num);
        // }

        // System.out.println(String.format("El numero %d %s en la lista.", numberSearch, allNumbers.contains(numberSearch) ? "Existe" : "No Existe"));

        // HashMap

        String text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

        String[] words = text.split(" ");

        HashMap<String, Integer> frequency = new HashMap<>();

        for (String string : words) {
            frequency.put(string, frequency.getOrDefault(string, 0) + 1);
        }

        for (String key : frequency.keySet()) {
            System.out.println(String.format("%s : %s", key, frequency.get(key).toString()));
        }
        
        // 
        System.out.println("---------------------------- LIST ----------------------");

        List<Employee> staffs = new ArrayList<>();

        staffs.add(new Employee("EMP001", "Juan Ramos"));
        staffs.add(new Employee("EMP002", "Joe Doe"));
        staffs.add(new Employee("EMP003", "Liza Right"));
        staffs.add(new Employee("EMP004", "Joe Doe"));
        staffs.add(new Employee("EMP005", "Luke Mackrty"));
        String idSearch = "EMP003";
        Optional<Employee> optionalStaffFound = staffs.stream().filter((e) -> e.getId() == idSearch).findFirst();

        
        String result = "No existe";
        if (optionalStaffFound.isPresent()) {
            Employee staffFound = optionalStaffFound.get();
            result = staffFound.toString();
        }

        String message = String.format("El empleado con ID %s - %s", idSearch, result);
        System.out.println(message);

        System.out.println("----------------------- HASH MAP ----------------------");

        HashMap<Integer, Employee> employees = new HashMap<>();
        
        employees.put(1, new Employee("EMP001", "Juan Ramos"));
        employees.put(2, new Employee("EMP002", "Joe Doe"));
        employees.put(3, new Employee("EMP003", "Liza Right"));
        employees.put(4, new Employee("EMP004", "Joe Doe"));
        employees.put(5, new Employee("EMP005", "Luke Mackrty"));

        int searchID = 4;
        
        System.out.println(String.format("El Empleadpo con ID = %s - %s", searchID, employees.get(searchID) == null ? "No existe" : employees.get(searchID).toString()));
        

        System.out.println("------------------------- HASHMAP y HASHSET -------------------- ");

        int[] arrayNumbers = generateArrayNumber();
        printArray(arrayNumbers);
        System.out.println("Ingresa en numero objetivo: ");
        int objetiveNumber = sc.nextInt();
        HashMap<String, String> numbersToSum = new HashMap<>();
        for (int i = 0; i < arrayNumbers.length; i++) {
            for (int j = 1; j < arrayNumbers.length; j++) {
                if (arrayNumbers[i] + arrayNumbers[j] == objetiveNumber) {
                    numbersToSum.put(String.format("%s + %s", arrayNumbers[i] , arrayNumbers[j]), String.format("%s", (arrayNumbers[i] + arrayNumbers[j])));
                }
            }
        }

        for (String key : numbersToSum.keySet()) {
            System.out.println(String.format("%s = %s", key, numbersToSum.get(key)));
        }



    }
}
