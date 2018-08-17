class Solution {
     public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        
        fill(image, sr, sc, image[sr][sc], newColor);
        
         return image;
    }
    
    private void fill(int[][] image, int sr, int sc, int targetColor, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) return;
        if (image[sr][sc] != targetColor) return;
        
        image[sr][sc] = newColor;
        
        fill(image, sr + 1, sc, targetColor, newColor);
        fill(image, sr - 1, sc, targetColor, newColor);
        fill(image, sr, sc + 1, targetColor, newColor);
        fill(image, sr, sc - 1, targetColor, newColor);
    } 
}