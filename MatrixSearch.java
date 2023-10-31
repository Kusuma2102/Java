public class MatrixSearch {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Start from the top-right corner of the matrix
        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) {
                return true; // Target found
            } else if (matrix[row][col] < target) {
                row++; // Move down if the current value is less than the target
            } else {
                col--; // Move left if the current value is greater than the target
            }
        }

        return false; // Target not found
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 4, 7, 11 },
                { 2, 5, 8, 12 },
                { 3, 6, 9, 16 },
                { 10, 13, 14, 17 }
        };

        int target = 5;
        boolean found = searchMatrix(matrix, target);

        if (found) {
            System.out.println(target + " is in the matrix.");
        } else {
            System.out.println(target + " is not in the matrix.");
        }
    }
}
