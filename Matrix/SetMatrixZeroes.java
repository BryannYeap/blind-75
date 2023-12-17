class Solution {
    public void setZeroes(int[][] matrix) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) continue;

                rows.add(i);
                cols.add(j);
            }
        }

        for (Integer i : rows) {
            int[] row = matrix[i];
            for (int j = 0; j < row.length; j++) row[j] = 0;
        }

        for (Integer j : cols) {
            for (int i = 0; i < matrix.length; i++) {
                int[] row = matrix[i];
                row[j] = 0;
            }
        }
    }
}