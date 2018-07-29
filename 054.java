class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();
        
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int top = 0, down = m - 1, left = 0, right = n - 1;
        int i = 0, j = 0;

        // TODO
        while (top <= down && left <= right) {
            // right
            for (j = left; j <= right; j++) ans.add(matrix[top][j]);
            top++;
                
            if (left > right || top > down) break;
            
            // down
            for (i = top; i <= down; i++) ans.add(matrix[i][right]);
            right--;
            
            if (left > right || top > down) break;

            // left
            for (j = right; j >= left; j--) ans.add(matrix[down][j]);
            down--;
            
            if (left > right || top > down) break;

            // up
            for (i = down; i >= top; i--) ans.add(matrix[i][left]);
            left++;
            
            if (left > right || top > down) break;
        }

        return ans;
    }
}