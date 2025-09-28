import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void showMenu(List<String> menu) {
        System.out.println(String.join("\n", menu.stream().map((m) -> String.format("%d. %s", menu.indexOf(m) + 1, m)).toList()));
    }

    public static void showCustomers(List<Customer> customers) {
        System.out.println(String.join("\n", customers.stream().map((m) -> String.format("%d. %s", customers.indexOf(m) + 1, m.toString())).toList()));
    }

    public static void showAccounts(LinkedList<Account> accounts) {
        System.out.println(String.join("\n", accounts.stream().map((m) -> String.format("%d. %s", accounts.indexOf(m) + 1, m.toString())).toList()));
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
                    String code = String.format("CLI%03d", customers.size() + 1);
                    Customer customer = new Customer(code, full_name );
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
                    System.out.println("Lista de Clientes:\n");
                    showCustomers(customers);
                    System.out.println("Elija el número de cliente a consultar:");
                    indexCustomerSelected = sc.nextInt();
                    if (indexCustomerSelected <= customers.size()) {
                        Customer customerSelected = customers.get(indexCustomerSelected - 1);
                        int optionCustomer = 0;
                        boolean swCustomer = true;
                        while (swCustomer) {
                            List<String> customerMenu = new ArrayList<>();
                            customerMenu.add("Crear Cuenta");
                            customerMenu.add("Listar Cuentas");
                            customerMenu.add("Seleccionar Cuenta");
                            customerMenu.add("Eliminar Cuenta");
                            System.out.println("Menu del Cliente\n");
                            showMenu(customerMenu);
                            System.out.println("Elija una opción:");
                            optionCustomer = sc.nextInt();
                            int indexAccountSelected = 0;
                            Account accountSelected;
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
                                        System.out.println(accountTypes.get(accountTypeSelected - 1));
                                        customerSelected.addAccount(accountTypes.get(accountTypeSelected - 1));
                                    } else {
                                        System.out.println("No existe ese Tipo de Cuenta");
                                    }
                                    break;
                                case 2:
                                    // Listar cuentas
                                    System.out.println("Lista de cuentas");
                                    showAccounts(customerSelected.getAccounts());
                                    break;
                                case 3:
                                    // Seleccionar Cuenta y Realizar Operación
                                    showAccounts(customerSelected.getAccounts());
                                    indexAccountSelected = 0;
                                    System.out.println("Elije una cuenta: ");
                                    indexAccountSelected = sc.nextInt();
                                    if (indexAccountSelected <= customerSelected.getAccounts().size()) {
                                        accountSelected =  customerSelected.getAccounts().get(indexAccountSelected - 1);
                                        boolean swAccount = true;
                                        int optionAccountSelected = 0;
                                        while (swAccount) {
                                            List<String> accountMenu = new ArrayList<>();
                                            accountMenu.add("Ver Información de Cuenta");
                                            accountMenu.add("Realizar Deposito");
                                            accountMenu.add("Realizar Retiro");
                                            accountMenu.add("Volver al menu anterior");
                                            double amount = 0;
                                            switch (optionAccountSelected) {
                                                case 1:
                                                    // Ver información
                                                    System.out.println(accountSelected.toString());
                                                    break;
                                                case 2: 
                                                    // Realizar deposito
                                                    System.out.println("Ingrese cantidad a depositar: ");
                                                    amount = sc.nextDouble();
                                                    accountSelected.operation(true, amount);
                                                    break;
                                                case 3:
                                                    // Realizar retiro
                                                    System.out.println("Ingrese cantidad a retirar: ");
                                                    amount = sc.nextDouble();
                                                    accountSelected.operation(false, amount);
                                                    break;
                                                default:
                                                    System.out.println("Volviendo al menu anterior");
                                                    swAccount = false;
                                                    break;
                                            }
                                        }
                                    } else {
                                        System.out.println("No se encontro la cuenta a eliminar");
                                    }
                                    break;
                                case 4:
                                    // Eliminar Cuenta
                                    showAccounts(customerSelected.getAccounts());
                                    
                                    System.out.println("Elije una cuenta: ");
                                    indexAccountSelected = sc.nextInt();
                                    if (indexAccountSelected <= customerSelected.getAccounts().size()) {
                                        accountSelected = customerSelected.getAccounts().get(indexAccountSelected - 1);
                                        customerSelected.deleteAccount(accountSelected.getNumberAccount());
                                        System.out.println("Eliminando cuenta");
                                    } else {
                                        System.out.println("No se encontro la cuenta a eliminar");
                                    }
                                    break;
                                default:
                                    System.out.println("Saliendo al menú anterior");
                                    swCustomer = false;
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
