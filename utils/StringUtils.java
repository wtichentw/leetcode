// get number of palindromic substrings from str[left, right]
public int extendPalindrome(String str, int left, int right) {
    int ans = 0;
    
    while (left >= 0 && right < str.length() &&
           str.charAt(left) == str.charAt(right)) {
        ans   += 1;
        left  -= 1;
        right += 1;
    }
    
    return ans;
}