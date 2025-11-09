import java.util.ArrayList;
import java.util.List;

public class Maze {
    public int size;
    public String[][] field;

    String wall = "| 1 |";
    String pass = "| 0 |";

    public Maze(int size) {
        this.size = size;
        this.field = new String[size][size];
        initMaze(size);
    }

    public void initMaze(int size) {
        for (int i = 0; i < size; i++) {
            int walls = 0;
            for (int j = 0; j < size; j++) {
                if (i + j == 0 || i + j == size*2) {
                    field[i][j] = pass;
                } else {
                    boolean possibleWall = (int)(Math.random() * (2)) == 1;
                    if (walls < (size/2)) {
                        if ((int)(Math.random() * (10)) < (size/2 + 3)) {
                            field[i][j] = possibleWall ? wall : pass;
                            walls++;
                        } else {
                            field[i][j] = pass;    
                        }
                    } else {
                        field[i][j] = pass;
                    }
                }
            }
        }
    }

    public void showMaze() {
        String content = "";
        for (int i = 0; i < field.length; i++) {
            String row = "";
            for (int j = 0; j < field[i].length; j++) {
                row += field[i][j]+"";
            }
            content += row + "\n";
        }
        System.out.println(content);
    }

    
    public boolean iterateMaze(int x, int y, boolean[][] visitado) {
        
        if (x < 0 || x >= size || y < 0 || y >= size || field[x][y].equals(wall) || visitado[x][y]) {
            return false;
        }

        visitado[x][y] = true;
        
        if (x == size - 1 && y == size - 1) {
            System.out.println("Encontre la ruta");
            return true;
        }

        if (iterateMaze(x + 1, y, visitado) || iterateMaze(x - 1, y, visitado) ||
            iterateMaze(x, y + 1, visitado) || iterateMaze(x, y - 1, visitado)) {
            return true;
        }
        return false;
    }

    
}