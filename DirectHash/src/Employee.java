public class Employee {
    int id;
    String name;
    String appointment;
    
    public Employee(int id, String name, String appointment) {
        this.id = id;
        this.name = name;
        this.appointment = appointment;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", appointment=" + appointment + "]";
    }
    
}
