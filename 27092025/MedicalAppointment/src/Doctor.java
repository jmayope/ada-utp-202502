public class Doctor {
    String id;
    String full_name;
    String specialty;
    public Doctor(String id, String full_name, String specialty) {
        this.id = id;
        this.full_name = full_name;
        this.specialty = specialty;
    }

    public String getId() {
        return id;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getSpecialty() {
        return specialty;
    }

    @Override
    public String toString() {
        return "Doctor [id=" + id + ", full_name=" + full_name + ", specialty=" + specialty + "]";
    }

    
    
}
