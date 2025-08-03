class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        
        ArrayList<String> list = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();

        String str1[] = s1.split(" ");
        String str2[] = s2.split(" ");

        for(String str : str1){

            map.put(str, map.getOrDefault(str,0)+1);
        }

        for(String str : str2){

            map.put(str,map.getOrDefault(str,0)+1);
        }

        for(Map.Entry<String,Integer> entry : map.entrySet()){

            if(entry.getValue()==1){
                list.add(entry.getKey());
            }
        }


       return list.toArray(new String[0]);
    }
}