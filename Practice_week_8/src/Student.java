import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Student {
    String code;
    String full_name;

    public Student(String code, String full_name) {
        this.code = code;
        this.full_name = full_name;
        System.out.println("Estudiante creado");
    }

    public static Optional<Student> search(List<Student> students, String code) {
        return students.stream().filter((s) -> s.code.toLowerCase().equals(code.toLowerCase())).findFirst();
    }
    
    @Override
    public String toString() {
        return "Student [code=" + code + ", full_name=" + full_name + "]";
    }

    public String getCode() {
        return code;
    }

    public String getFull_name() {
        return full_name;
    }

    
}
