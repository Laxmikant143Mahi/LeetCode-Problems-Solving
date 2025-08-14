class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        
       String[] str1 = s1.split(" ");
       String[] str2 = s2.split(" ");

       HashMap<String,Integer> map = new HashMap<>();

       for(String element : str1){

         map.put(element, map.getOrDefault(element,0)+1);
       }

        for(String element : str2){

         map.put(element, map.getOrDefault(element,0)+1);
       }

       ArrayList<String> list = new ArrayList<>();

       for(Map.Entry<String,Integer> entry : map.entrySet()){

        if(entry.getValue()==1){

            list.add(entry.getKey());
        }
       }

       String ans[] = new String[list.size()];

       for(int i=0; i<list.size(); i++){

            ans[i] = list.get(i);
       }

       return ans;

    }
}