class Solution {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            for (int j = i; j < row.length; j++) {
                int temp = row[j];
                row[j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            for (int j = 0; j < row.length / 2; j++) {
                int temp = row[j];
                row[j] = row[row.length - j - 1];
                 row[row.length - j - 1] = temp;
            }
        }
    }
}