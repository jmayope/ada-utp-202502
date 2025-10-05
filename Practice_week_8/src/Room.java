import java.util.List;
import java.util.Optional;

public class Room {
    String number;
    String type;
    
    public Room(String number, String type) {
        this.number = number;
        this.type = type;
    }
    
    @Override
    public String toString() {
        return "Room [code=" + number + ", type=" + type + "]";
    }

    public static Optional<Room> search(List<Room> rooms, String number, String type) {
        return rooms.stream().filter((s) -> s.number.toLowerCase().equals(number.toLowerCase()) && s.type.toLowerCase().equals(type.toLowerCase())).findFirst();
    }
    
    
}
