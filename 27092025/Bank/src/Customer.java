import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class Customer {
    private String code;
    private String full_name;
    private LinkedList<Account> accounts;

    public Customer(String code, String full_name) {
        this.code = code;
        this.full_name = full_name;
        this.accounts = new LinkedList<>();
    }

    public boolean addAccount(String type) {
        accounts.add(new Account(type));
        return true;
    }

    public boolean deleteAccount(String numberAccount) {
        accounts.removeIf((a) -> a.getNumberAccount() == numberAccount);
        return true;
    }

    public void showAccounts() {
        String[] result = new String[accounts.size()];
        for (int i = 0; i < accounts.size(); i++) {
            result[i] = String.format("%d. %s", i + 1, accounts.get(i).toString());
        }
        System.out.println(String.join("\n", result));
    }

    public String getCode() {
        return code;
    }

    public String getFull_name() {
        return full_name;
    }

    public LinkedList<Account> getAccounts() {
        return accounts;
    }

    @Override
    public String toString() {
        return "Customer [code=" + code + ", full_name=" + full_name + ", accounts=" + accounts + "]";
    }

    
    
    
    
}
