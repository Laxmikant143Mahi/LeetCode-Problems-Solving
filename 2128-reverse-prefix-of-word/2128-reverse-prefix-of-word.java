class Solution {
    public String reversePrefix(String word, char ch) {
        
        StringBuilder sb = new StringBuilder();

        int index=-1;
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<word.length(); i++){

            if(ch!=word.charAt(i)){
                stack.push(word.charAt(i));
            }else{
                stack.push(ch);
                index=i;
                break;
            }
        }
        if(index==-1){
            return word;
        }

        for(int i=0; i<=index; i++){
            sb.append(stack.pop());

        }
        for(int i=index+1; i<word.length(); i++){

            sb.append(word.charAt(i));
        }

        return sb.toString();
        
    }
}