class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int n = s.length();
        int i = 0, j = s.length() - 1;
        
        while (i < j) {
            while (i < n  && !isVowel(s.charAt(i))) i++;
            while (j >= 0 && !isVowel(s.charAt(j))) j--;
            
            if (i < j) {
                char tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        
        return new String(arr);
    }
    
    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
               c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}