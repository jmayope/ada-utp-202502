public class Employee {
    private String id;
    private String full_name;
    

    

    public Employee(String id, String full_name) {
        this.id = id;
        this.full_name = full_name;
    }

    @Override
    public String toString() {
        return String.format("Empleado [ID=%s - Nombre Completo=%s]", id, full_name);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

}   
