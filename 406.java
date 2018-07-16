class Solution {
    class PeopleComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return a[0] == b[0]? a[1] - b[1]: -a[0] + b[0];
        }
    }
    
    public int[][] reconstructQueue(int[][] people) {
        // sorting 
        Arrays.sort(people, new PeopleComparator());
        
        List<int[]> res = new LinkedList<>();
        for(int[] cur : people){
            res.add(cur[1],cur);       
        }
        
        return res.toArray(new int[people.length][]);
    }
}