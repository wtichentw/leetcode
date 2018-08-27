class Solution {
    class Cell {
        int x;
        int y;
        int h;
        
        Cell (int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
    
    class CellComparator implements Comparator<Cell> {
        @Override
        public int compare (Cell c1, Cell c2) {
            if(c1.h > c2.h)
                return 1;
            else if(c1.h == c2.h){
                return 0;
            }
            else {
                return -1;
            }
        }
    }
    
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) return 0;
        
        int m = heightMap.length, n = heightMap[0].length, ans = 0;
        int[][] visited = new int[m][n];
        int[] dx = {0,  0, 1, -1};
        int[] dy = {1, -1, 0,  0};
        
        PriorityQueue<Cell> pq = new PriorityQueue<>(1, new CellComparator());
        
        // Insert surround point
        for (int i = 0; i < m; i++) {
            visited[i][0] = 1;
            visited[i][n - 1] = 1;
            pq.offer( new Cell(i, 0, heightMap[i][0]) );
            pq.offer( new Cell(i, n - 1, heightMap[i][n -1]) );
        }
        for (int i = 0; i < n; i++) {
            visited[0][i] = 1;
            visited[m -1][i] = 1;
            pq.offer( new Cell(0, i, heightMap[0][i]) );
            pq.offer( new Cell(m - 1, i, heightMap[m - 1][i]) );
        }
        
        while (!pq.isEmpty()) {
            Cell curr = pq.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                
                if (0 <= nx && nx < m && 0 <= ny && ny < n && visited[nx][ny] == 0) {
                    int nh = heightMap[nx][ny];
                    
                    visited[nx][ny] = 1;
                    pq.offer( new Cell(nx, ny, Math.max(curr.h, nh)) );
                    ans += Math.max(0, curr.h - nh);
                }
                
            }
        }
        
        return ans;
    }
}