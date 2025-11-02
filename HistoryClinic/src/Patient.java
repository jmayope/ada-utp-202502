public class Patient {
    String name;
    int history_clinic;
    
    public Patient(String name, int history_clinic) {
        this.name = name;
        this.history_clinic = history_clinic;
    }

    @Override
    public String toString() {
        return "Patient [name=" + name + ", history_clinic=" + history_clinic + "]";
    }

    
    
}
