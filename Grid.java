import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Grid {
    private char[][] grid;
    private Position position;

    public Grid(String filename) {
        // Read in grid
        List<String> lines = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        if (lines.size() > 0) {
            grid = new char[lines.size()][lines.get(0).length()];
            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                for (int j = 0; j < line.length(); j++) {
                    grid[i][j] = line.charAt(j);
                }
            }
        }

        // Move to start position
        this.position = this.FindStartPosition();
    }

    public void PrintGrid() {
        for (char[] row : grid) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }


    public void PrintDimensions() {
        if (grid != null && grid.length > 0) {
            int rows = grid.length;
            int columns = grid[0].length;
            System.out.println("Grid Dimensions: " + rows + " x " + columns + " (Rows x Columns)");
        } else {
            System.out.println("Looks like the grid's not properly set up, Bro.");
        }
    }


    public Position FindStartPosition() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 'S') {
                    return new Position(i, j); // Row, Column format
                }
            }
        }
        return new Position(-1, -1); // "S" wasn't found, so return something to indicate that.
    }


    public Position FindFinishPosition() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 'F') {
                    return new Position(i, j); // Row, Column format
                }
            }
        }
        return new Position(-1, -1); // "F" wasn't found, so return something to indicate that.
    }


    public MoveResult Move(char direction, int distance) {
        int moved = 0; // Tracks the distance actually moved
        int dx = 0, dy = 0;
    
        // Translate direction to grid movement
        switch (direction) {
            case 'U': dx = -1; break;
            case 'D': dx = 1; break;
            case 'L': dy = -1; break;
            case 'R': dy = 1; break;
        }
    
        for (int i = 0; i < distance; i++) {
            int nextX = position.x + dx;
            int nextY = position.y + dy;
    
            // Check if we're about to go out of bounds or hit a wall
            if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length || grid[nextX][nextY] != ' ' && grid[nextX][nextY] != 'F') {
                break;
            }
    
            // Move
            position.x = nextX;
            position.y = nextY;
            moved++;
    
            // Check if we've hit the finish
            if (grid[nextX][nextY] == 'F') {
                break;
            }
        }
    
        return new MoveResult(position, moved);
    }


    // Main to run a quick test
    public static void main(String[] args) {
        Grid myGrid = new Grid("grids/001-direct-10x10.grid");
        myGrid.PrintGrid();
        myGrid.PrintDimensions();
        System.out.println("Start Position: " + myGrid.FindStartPosition());
        System.out.println("Finish Position: " + myGrid.FindFinishPosition());
    }
}
