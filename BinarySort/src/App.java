import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class App {

    public static int binarySearchWithNTimes(int[] array, int toSearch, Integer... nTimes) {
        int times = (nTimes == null) ? 1 : nTimes[0];
        int left = 0;
        int count = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (array[middle] == toSearch) {
                count ++;
                if (count == times) {
                    return middle;
                }
            } else if (array[middle] < toSearch) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    public static Product binarySearcfOfProduct(List<Product> products, double priceToSearch) {

        int min = 0;
        int max = products.size() - 1;
        while (min <= max) {
            int middle = min + (max - min) / 2;
            if (products.get(middle).getPrice() == priceToSearch) {
                return products.get(middle);
            } else if (products.get(middle).getPrice() < priceToSearch) {
                min = middle + 1;
            } else {
                max = middle - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        int[] array = {1,2,3,3,3,3,1,1,1,4,4,5,6,6,6,4,4,2,2,2,3,7,7,8,8,8,9,9,9}; //{1,2,3,4,5,6,7,8,9};
        int toSearch = 6;
        int result = binarySearchWithNTimes(array, toSearch,3);

        System.out.println(result);
        String message = "No se encontro";
        if (result != -1) {
            message = "Se encontro en el array en el indice: " + result;
        }
        System.out.println(String.format("El Número %d, %s ", toSearch, message));

        List<Product> allProducts = Arrays.asList(
            new Product("Avena", 4, 120),
            new Product("Canela", 2, 200),
            new Product("Laurel", 6, 400),
            new Product("Comino", 8, 10),
        // );
        // List<Product> products = Arrays.asList(
            new Product("Pan", 2.5, 15), 
            new Product("Leche", 4.5, 30), 
            new Product("Harina", 15, 40),
            new Product("Croasant", 7, 70),
            new Product("Vainilla Psicocul", 9, 120)
            );

        List<Product> products = allProducts;
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Double.compare(p1.price, p2.price);
            }
        });

        double priceToSearch = 4.5;
        Product productFound = binarySearcfOfProduct(products, priceToSearch);

        System.out.println(products);
        message = "No se encontro el Producto";
        if (productFound != null) {
            message = "Se encontro el elemento: " + productFound.toString();
        }

        System.out.println(message);

        

        




    }
}
