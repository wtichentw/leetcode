class Solution {
    public int findNthDigit(int n) {
        // 9    [1, 9]
        // 90   [10, 99]
        // 900  [100, 999]
        // 9000 [1000, 9999]
        
        int len = 1;
		long count = 9;
		int start = 1;

		while (n > len * count) {
			n -= len * count;
			len += 1;
			count *= 10;
			start *= 10;
		}

        int num = start + (n - 1) / len;
        int idx = (n - 1) % len;
        
		return (int) (Integer.toString(num).charAt(idx) - '0');
    }
}