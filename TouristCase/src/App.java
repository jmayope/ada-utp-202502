import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // TURISTA
        System.out.println("Problema del Turista");
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad del laberinto: ");
        int size = sc.nextInt();
        Maze maze = new Maze(size);
        sc.close();
        maze.showMaze();
        
        boolean[][] visitado = new boolean[maze.size][maze.size];
        
        if (maze.iterateMaze(0, 0, visitado)) {
            System.out.println("El turista ha encontrado una ruta!");
        } else {
            System.out.println("No se encontró una ruta.");
        }

        // MOCHILA
        System.out.println("Problema de la Mochila");
        int[] valuesOfObjects = {60, 100, 120};
        int[] weightsOfObjects = {10, 20, 30};
        int backpackCapacity = 50;
        
        int n = valuesOfObjects.length;
        int result = Backpack.solvedBackpack(valuesOfObjects, weightsOfObjects, n, backpackCapacity);
        
        System.out.println(String.format("El valor máximo que se puede obtener es: %s", result));

    }
}
