import java.util.LinkedList;

public class HashTableDirect {
    // ListLinked<
    private LinkedList<Employee>[] table;
    private int size;

    @SuppressWarnings("unckecked")
    public HashTableDirect(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public int hash(int id) {
        return id % size;
    }

    public void add(Employee employee) {
        // table[hash(employee.id)].removeIf((e) -> e.id == employee.id);
        
        // table[hash(employee.id)].add(employee);
        System.out.println(hash(employee.id));
        int index=hash(employee.id);
        for(Employee e: table[index]){
            if(e.id == employee.id){
                table[index].remove(e);
                break;
            }
        }
        table[index].add(employee);


    }

    public Employee search(int id) {
        return table[hash(id)].stream().filter((e) -> e.id == id).findFirst().orElse(null);
    }

    public boolean delete(int id) {
        table[hash(id)].removeIf((e) -> e.id == id);
        return true;
    }

    public void printEmployees() {
        // String[] employees = new String[table.length];
        // int count = 0;
        // for (LinkedList<Employee> linkedList : table) {
        //     employees[count] = linkedList.toString();
        //     count++;
        // }
        // System.out.println(String.join("\n", employees));
        for(int i=0; i<size;i++){
            System.out.print("Indice" + i + ": ");
            for(Employee e: table[i]){
                System.out.print("["+ e + "]");
            }
            System.out.println();
        }

    }

}
