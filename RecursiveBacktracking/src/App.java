import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        String a = "abc pienso que siempre sera como quiero abc digo lo que abc me encanta abcdario";
        List<RegularExpresion> regExps = new ArrayList<>();
        regExps.add(new RegularExpresion(false, "abc", 0));
        regExps.add(new RegularExpresion(true, "[{a-zA-Z}]{7}", 7));
        
        RegularExpresion.search(a, regExps);

    }
}
