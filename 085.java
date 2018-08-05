class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;  
        int n = matrix[0].length;
        int[] heights = new int[n]; // using a array to reduce counting step of 1
        int max = 0;
        for(char[] row: matrix){
          for(int i = 0; i < n; i++){
            if(row[i] == '1'){
              heights[i] += 1;
            } else {
              heights[i] = 0;
            }
          }

          max = Math.max(max, maxArea(heights)); // go a sub problem of Histogram
        }
        return max;
    }
    
    public int maxArea(int[] heights){
        Stack<Integer> stack = new Stack();
        int max = 0;
        for(int i = 0; i <= heights.length; i++){
            int h = (i == heights.length) ? 0 : heights[i];
            while(!stack.isEmpty() && heights[stack.peek()] > h){
            int index = stack.pop();
            int leftBound = -1;
            if(!stack.isEmpty()){
               leftBound =  stack.peek();
            }
            max = Math.max(max, heights[index] * (i - leftBound - 1));
          }
          stack.push(i);
        }
        return max;
    }
}