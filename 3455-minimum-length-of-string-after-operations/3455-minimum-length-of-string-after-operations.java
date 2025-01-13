class Solution {
    public int minimumLength(String s) {

        if(s.length()<=2)
            return s.length();
        HashMap<Character,Integer> map = new HashMap<>();

        int count=0;
        for(int i=0; i<s.length(); i++){

            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
            
        }
        
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            
            int value = entry.getValue();
                
                if(value%2==0)
                    count+=2;
                else 
                    count+=1;
            
        }

        return count;
    }
}