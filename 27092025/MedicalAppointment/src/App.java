import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void showMenu(List<String> menu) {
        System.out.println(String.join("\n", menu.stream().map((m) -> String.format("%d. %s", menu.indexOf(m) + 1, m)).toList()));
    }
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Scanner customers = new Scanner(System.in);

        boolean sw = true;
        List<String> mainMenu = new ArrayList<>();
        mainMenu.add("Listar Doctores");
        mainMenu.add("Listar Pacientes");
        mainMenu.add("Seleccionar Doctor");
        mainMenu.add("Seleccionar Paciente");
        mainMenu.add("Salir");
        while (sw) {

             
            
            String.format("CLI%03d", customers);
            
            

        }


    }
}
