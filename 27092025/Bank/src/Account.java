import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;


public class Account {
    private String numberAccount;
    private String type;
    private double residue;
    private LinkedList<Movement> movements;

    public Account(String type) {
        this.type = type;
        this.numberAccount = generateNumberAccount(16);
        System.out.println(String.format("Agregando cuenta [Tipo %s - Nro Cuenta: %s] ", type, numberAccount));
        this.residue = 0;
        this.movements = new LinkedList<>();
    }

    public static String generateNumberAccount(int longitud) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(longitud);
        
        for (int i = 0; i < longitud; i++) {
            int digito = random.nextInt(10); // genera un número entre 0 y 9
            sb.append(digito);
        }
        
        return sb.toString();
    }

    public void operation(boolean operationType, double amount) {
        boolean operationSuccess = false;
        if (operationType) {
            residue += amount;
            operationSuccess = true;
        } else {
            if (residue>amount) {
                residue -= amount;
                operationSuccess = true;
            } else {
                System.out.println("Saldo insuficiente");
                operationSuccess = false;
            }
        }
        if (operationSuccess) {
            movements.add(new Movement(operationType ? "Deposito" : "Retiro", amount));
            System.out.println(String.format("%s satisfactorio", operationType ? "Deposito" : "Retiro"));
        }
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public double getResidue() {
        return residue;
    }

    public LinkedList<Movement> getMovements() {
        return movements;
    }

    @Override
    public String toString() {
        return "Account [numberAccount=" + numberAccount + ", type=" + type + ", residue=" + residue + ", movements="
                + movements.size() + " Movements]";
    }

    
    

    

    

    
}
