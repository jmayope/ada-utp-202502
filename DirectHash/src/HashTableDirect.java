import java.util.LinkedList;

public class HashTableDirect {
    // ListLinked<
    LinkedList<Employee>[] table;
    int id;
    int size;

    public HashTableDirect(int size) {
        // this.table = table;
        // this.id = id;
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public int hash(int id) {
        return id % size;
    }

    public void add(Employee employee) {
        table[hash(id)].stream().filter((e) -> e.id == employee.id).toList().removeAll(null);
        
        table[hash(id)].add(employee);

    }

    public Employee search(int id) {
        int index = hash(id);
        return table[index].stream().filter((e) -> e.id == id).findFirst().orElse(null);
    }

    public boolean delete(int id) {
        table[hash(id)].remove();
        return true;
    }

    public void printEmployees() {
        String[] employees = new String[table.length];
        int count = 0;
        for (LinkedList<Employee> linkedList : table) {
            employees[count] = linkedList.get(count).toString();
            count++;
        }
        System.out.println(String.join("\n", employees));
    }

}
