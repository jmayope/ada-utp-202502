public class Backpack {

    
    public static int solvedBackpack(int[] values, int[] weights, int n, int capacity) {
    
        if (n == 0 || capacity == 0) {
            return 0;
        }

    
        if (weights[n - 1] > capacity) {
            return solvedBackpack(values, weights, n - 1, capacity);
        } else {
            int including = solvedBackpack(values, weights, n - 1, capacity);
    
            int withoutIncluding = values[n - 1] + solvedBackpack(values, weights, n - 1, capacity - weights[n - 1]);
            
            return Math.max(including, withoutIncluding);
        }
    }
}
