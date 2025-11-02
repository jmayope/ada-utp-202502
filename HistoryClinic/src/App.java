import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class App {

    public static Optional<Patient> searchSequencial(List<Patient> patients, int key) {
        return patients.stream().filter((p) -> p.history_clinic == key).findFirst();
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Juancito", 1));
        patients.add(new Patient("Maria", 2));
        patients.add(new Patient("Paco", 3));
        patients.add(new Patient("Francisco", 4));
        patients.add(new Patient("Zoila", 5));
        patients.add(new Patient("Camila", 6));
        patients.add(new Patient("Romaria", 7));

        System.out.println("Ingrese el número de Historia Clínica: ");
        int key = sc.nextInt();

        Optional<Patient> patiendFound = searchSequencial(patients, key);
        String result = "Paciente No encontrado.";
        if (!patiendFound.isEmpty()) {
            result = String.format("Paciente encontrado: %s.", patiendFound.get().toString());
        }
        System.out.println(result);
        sc.close();


    }
}
