class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> q = new LinkedList<>();
        int m = matrix.length, n = matrix[0].length;
        int[] dx = new int[] {0,  0, 1, -1};
        int[] dy = new int[] {1, -1, 0,  0};
        
        // pre
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                // start BFS from every 0 point
                if (matrix[i][j] == 0)
                    q.offer(new int[] {i, j});
                
                // set to max and wait for BFS
                else
                    matrix[i][j] = Integer.MAX_VALUE;
            }
        }

        // BFS
        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];
                
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    
                    if (nx < 0 || ny < 0 || nx >= m || ny >= n ||
                        matrix[nx][ny] <= matrix[x][y] + 1) 
                        continue;
                    
                    matrix[nx][ny] = matrix[x][y] + 1;
                    q.offer(new int[] {nx, ny});
                }
            }
        }
        
        return matrix;
    }
}