class Solution {
    public boolean checkIfExist(int[] arr) {
       HashMap<Integer,Integer> map = new HashMap<>();

       for(int i=0; i<arr.length; i++)
            map.put(arr[i],i);

        for(int i=0; i<arr.length; i++)
        {
            if(map.containsKey(arr[i]+arr[i])){
                if(map.get(arr[i]+arr[i])!=i){
                    return true;
                }
            }
        }
        return false;
    }
}