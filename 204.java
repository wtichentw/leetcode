class Solution {
    public int countPrimes(int n) {
        List<Integer> prime = new LinkedList<>();
        int ans = 0;
        
        for (int i = 2; i < n; i++) {
            if (isPrime(i, prime)) {
                ans++;
            }
        }
        
        return ans;
    }
    
    public boolean isPrime(int n, List<Integer> prime) {
        for (int p: prime) {
            if (n % p == 0) return false;
            if (p >= Math.sqrt(n)) break;
        }
            
        prime.add(n);
        return true;
    }
}