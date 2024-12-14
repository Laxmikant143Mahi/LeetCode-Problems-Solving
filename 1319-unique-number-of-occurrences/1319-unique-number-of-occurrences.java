class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        
        HashMap<Integer,Integer> map = new HashMap<>();

        int n = arr.length;

        for(int i=0; i<n; i++)
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        
        int a[] = new int[1001];
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(a[entry.getValue()] !=0){
                return false;
            }

            a[entry.getValue()] =1;
        }
        return true;
    }
}