class Solution {
    // [0 - 20]
    String[] ones = new String[] {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
                                  "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", 
                                  "Eighteen", "Nineteen"};
    String[] tens = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety", };
    String[] strs = new String[] {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        
        String ans = "";
        int idx = 0;    
        
        while (num > 0) {
            if (num % 1000 != 0)
                ans = helper(num % 1000) + strs[idx] + " " + ans;

            num /= 1000;
            idx++;
        }
        
        return ans.trim();
    }
    
    public String helper(int n) {
        if (n == 0) 
            return "";
        else if (n < 20)
            return ones[n] + " ";
        else if (n < 100)
            return tens[n / 10] + " " + helper(n % 10);
        else 
            return ones[n / 100] + " Hundred " + helper(n % 100);
    }
}