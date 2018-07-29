class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        
        for (char c: moves.toCharArray()) {
            if (c == 'L') x--;
            if (c == 'R') x++;
            if (c == 'D') y--;
            if (c == 'U') y++;
        }

        return x == 0 && y == 0;
    }
}