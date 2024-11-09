class Solution {
    public List<Integer> majorityElement(int[] arr) {
        
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++)
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);

        
        ArrayList<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){

            if(entry.getValue()>arr.length/3)
                list.add(entry.getKey());
        }
        return list;
    }
}