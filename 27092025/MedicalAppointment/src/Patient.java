public class Patient {
    String id;
    String full_name;

    public Patient(String id, String full_name) {
        this.id = id;
        this.full_name = full_name;
    }

    public String getId() {
        return id;
    }
    public String getFull_name() {
        return full_name;
    }

    @Override
    public String toString() {
        return "Patient [id=" + id + ", full_name=" + full_name + "]";
    }
    
    
    
}