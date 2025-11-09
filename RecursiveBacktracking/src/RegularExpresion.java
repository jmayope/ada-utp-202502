import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpresion {
    public boolean isRegExp;
    public String value;
    public int size;
    
    public RegularExpresion(boolean isRegExp, String value, int size) {
        this.isRegExp = isRegExp;
        this.value = value;
        this.size = size;
    }

    public static void search(String text, List<RegularExpresion> regExp) {
        int n = text.length();
        
        // int quantityOcurrencies = 0;

        regExp.stream().forEach((r) -> {
            int m = r.value.length();
            for (int i = 0; i < n - m; i++) {
                if (r.isRegExp) {
                    Pattern pattern = Pattern.compile(r.value, Pattern.CASE_INSENSITIVE);
                    Matcher matcher = pattern.matcher(text.substring(i, i + r.size));
                    boolean matchFound = matcher.find();
                    if (matchFound) {
                        // quantityOcurrencies++;
                        System.out.println("Busqueda con Expresión Regular");
                        System.out.println("Patron encontrado en index: "+i);
                    }
                } else {
                    if (r.value.equals(text.substring(i, i + m))) {
                        // quantityOcurrencies++;
                        System.out.println("Busqueda con Cadena de Texto");
                        System.out.println("Patron encontrado en index: "+i);
                    }
                }
            }
        });

    }
    
}
