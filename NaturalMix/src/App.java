public class App {
    public static void mergeSort(int[] array, int begin, int end) {
        int middle;
        if (begin < end) {
            middle = (begin + (end - begin)) / 2;
            mergeSort(array, begin, end);
            mergeSort(array, middle + 1, end);
            merge(array, begin, middle, end);
        }
    }

    public static void merge(int[] array, int begin, int middle, int end) {
        int[] output = new int[end - begin + 1];
        int i =  begin, j = middle + 1, k = 0;

        while (i < middle && j <= end) {
            if (array[i] < array[j]) {
                output[k] = array[i];
                k++;
                i++;
            } else {
                output[k] = array[j];
                k++;
                j++;
            }
        }

        while (i <= middle) {
            output[k] = array[i];
            k++;
            i++;
        }

        while (j <= end) {
            output[k] = array[j];
            k++;
            j++;
        }

        for (i = begin; i < end; i++) {
            array[i] = output[i - begin];
        }

    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.println(i);
        }
    }
    public static void main(String[] args) throws Exception {
        int[] array = {34,56,33,4,221,4,5,6};

        System.out.println("Array original");
        
        printArray(array);

        mergeSort(array, 0, array.length - 1);

        System.out.println("\nArray ordenado");

        printArray(array);
    }
}
