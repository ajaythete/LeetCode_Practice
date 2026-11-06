import java.util.Scanner;

public class RasikhBox {

    // Apply gravity: stones fall to the bottom of each column
    public static char[][] applyGravity(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        char[][] newGrid = new char[rows][cols];
        
        // Initialize grid with '.'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                newGrid[i][j] = '.';
            }
        }
        
        // Make stones fall down in each column
        for (int c = 0; c < cols; c++) {
            int stoneCount = 0;
            for (int r = 0; r < rows; r++) {
                if (grid[r][c] == '*') {
                    stoneCount++;
                }
            }
            // Place stones at the bottom rows of the column
            for (int r = rows - 1; r >= rows - stoneCount; r--) {
                newGrid[r][c] = '*';
            }
        }
        return newGrid;
    }

    // Rotate 90 degrees clockwise (right)
    public static char[][] rotateRight(char[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        char[][] rotated = new char[C][R];
        
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                rotated[c][R - 1 - r] = grid[r][c];
            }
        }
        return rotated;
    }

    // Rotate 90 degrees counter-clockwise (left)
    public static char[][] rotateLeft(char[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        char[][] rotated = new char[C][R];
        
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                rotated[C - 1 - c][r] = grid[r][c];
            }
        }
        return rotated;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = line.charAt(j);
            }
        }
        
        int k = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        // Apply initial gravity before rotations
        grid = applyGravity(grid);
        
        // Process each rotation instruction
        for (int i = 0; i < k; i++) {
            String instruction = scanner.nextLine().trim();
            if (instruction.equalsIgnoreCase("right")) {
                grid = rotateRight(grid);
            } else if (instruction.equalsIgnoreCase("left")) {
                grid = rotateLeft(grid);
            }
            // Apply gravity after each rotation
            grid = applyGravity(grid);
        }
        
        // Print final matrix configuration
        int finalRows = grid.length;
        int finalCols = grid[0].length;
        for (int i = 0; i < finalRows; i++) {
            for (int j = 0; j < finalCols; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        
        //scanner.close();
    }
}