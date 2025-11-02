import java.time.LocalDateTime;

public class Appointment {
    String id;
    Doctor doctor;
    Patient patient;
    LocalDateTime create_at;

    public Appointment(String id, Doctor doctor, Patient patient) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.create_at = LocalDateTime.now();
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public LocalDateTime getCreate_at() {
        return create_at;
    }

    @Override
    public String toString() {
        return String.format("Appointment [Doctor: %s - Specialty: %s - Patient: %s]", doctor.getFull_name(), doctor.getSpecialty(), patient.getFull_name());
    }

    

    
}
