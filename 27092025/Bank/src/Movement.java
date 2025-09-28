import java.time.LocalDateTime;


public class Movement {
    protected String type;
    protected double amount;
    protected LocalDateTime date;

    public Movement(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.date = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Movement [type=" + type + ", amount=" + amount + ", date=" + date + "]";
    }

    
    
}
