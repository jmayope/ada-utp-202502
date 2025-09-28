import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void showMenu(List<String> menu) {
        System.out.println(String.join("\n", menu.stream().map((m) -> String.format("%d %s", menu.indexOf(m) + 1, m)).toList()));
    }

    public static void showCustomers(List<Customer> customers) {
        System.out.println(String.join("\n", customers.stream().map((m) -> m.toString()).toList()));
    }

    public static void showAccounts(LinkedList<Account> accounts) {
        System.out.println(String.join("\n", accounts.stream().map((m) -> m.toString()).toList()));
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        boolean sw = true;
        int option = 0;
        List<Customer> customers = new ArrayList<>();
        List<String> mainMenu = new ArrayList<>();
        mainMenu.add("Crear Cliente");
        mainMenu.add("Listar Clientes");
        mainMenu.add("Seleccionar Cliente");
        mainMenu.add("Salir");

        while (sw) {
            showMenu(mainMenu);
            System.out.println("Elija una opción:");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    // Creamos cliente
                    String full_name = "";
                    System.out.println("Opcion de Creación de Clientes");
                    System.out.println("Ingrese el Nombre Completo del Cliente:");
                    sc.nextLine();
                    full_name = sc.nextLine();
                    System.out.println("Creando Cliente...");
                    Customer customer = new Customer("CLI001", full_name );
                    System.out.println(String.format("Cliente creado satisfactoriamente: \n%s", customer.toString()));
                    customers.add(customer);
                    break;
                case 2:
                    // Listar Clientes
                    showCustomers(customers);
                    break;
                case 3:
                    // SELECCIONO CLIENTE
                    int indexCustomerSelected = 0;
                    showCustomers(customers);
                    System.out.println("Elija el número de cliente a consultar:");
                    indexCustomerSelected = sc.nextInt();
                    if (indexCustomerSelected <= customers.size()) {
                        Customer customerSelected = customers.get(indexCustomerSelected);
                        int optionCustomer = 0;
                        boolean swCustomer = true;
                        while (swCustomer) {
                            List<String> customerMenu = new ArrayList<>();
                            customerMenu.add("Crear Cuenta");
                            customerMenu.add("Seleccionar Cuenta");
                            customerMenu.add("Eliminar Cuenta");
                            System.out.println("Menu del Cliente\n");
                            showMenu(customerMenu);
                            System.out.println("Elija una opción:");
    
                            switch (optionCustomer) {
                                case 1:
                                    List<String> accountTypes = new ArrayList<>();
                                    accountTypes.add("Deposito");
                                    accountTypes.add("Ahorro");
                                    accountTypes.add("Corriente");
                                    int accountTypeSelected = 0;
                                    showMenu(accountTypes);
                                    System.out.println("Elija tipo de cuenta: ");
                                    accountTypeSelected = sc.nextInt();
                                    if (accountTypeSelected<=accountTypes.size()) {
                                        customerSelected.addAccount(accountTypes.get(indexCustomerSelected));
                                    }
                                    break;
                                case 2:
                                    
                                    break;
                                case 3:
                                    showAccounts(customerSelected.getAccounts());
                                    int indexAccountSelected = 0;
                                    System.out.println("Elije una cuenta: ");
                                    indexAccountSelected = sc.nextInt();
                                    if (indexAccountSelected <= customerSelected.getAccounts().size()) {
                                        Account accountSelected =  customerSelected.getAccounts().get(indexAccountSelected);
                                        customerSelected.deleteAccount(accountSelected.getNumberAccount());
                                    } else {
                                        System.out.println("No se encontro la cuenta a eliminar");
                                    }
                                    break;
                                default:
                                    break;
                            }
                        }

                    } else {
                        System.out.println("No existe ese Usuario");
                    }
                    break;
                default:
                    System.out.println("Saliendo del sistema");
                    sw = false;
                    break;
            }
        }

    }
}
