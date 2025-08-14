class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ls = new ArrayList<>();
        int i = 0;
        int j = 0;
        int h = matrix.length;
        int l = matrix[0].length;
        int state = 0;

        int maxH = h;
        int maxL = l;
        int max = maxH * maxL;

        while (ls.size() <  max) {
          ls.add(matrix[i][j]);
          if (state == 0) {
            j++;
            if (j >= l) {
              j--;
              i++;
              state = 1;
            }
          } else if (state == 1) {
            i++;
            if (i >= h) {
              i--;
              j--;
              state = 2;
            }
          } else if (state == 2) {
            j--;
            if (j < maxL - l) {
              j++;
              h--;
              i--;
              state = 3;
            }
          } else {
            i--;
            if (i < maxH - h) {
              i++;
              l--;
              j++;
              state = 0;
            }
          }
        }

        return ls;
    }
}