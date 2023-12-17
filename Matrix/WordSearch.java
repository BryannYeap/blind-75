class Solution {
    public boolean exist(char[][] board, String word) {
        boolean res = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    res |= dfsWord(board, i, j, word, 1, visited);
                    if (res) return true;
                }
            }
        }

        return false; 
    }

    private boolean dfsWord(char[][] board, final int a, final int b, String word, int findIndex, boolean[][] visited) {
        visited[a][b] = true;
        if (findIndex >= word.length()) return true;

        for (int i = a - 1; i <= a + 1; i++) {
            for (int j = b - 1; j <= b + 1; j++) {
                if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) {
                    continue;
                }

                if (visited[i][j]) continue;

                boolean res = false;
                if ((i == a-1 && j == b) || (i == a && j == b-1) || (i == a && j == b+1) || (i == a+1 && j == b)) {
                    if (word.charAt(findIndex) == board[i][j]) {
                        res |= dfsWord(board, i, j, word, findIndex + 1, visited);
                        if (res) return res;
                    }
                }
            }
        }

        visited[a][b] = false;
        return false;
    }
}