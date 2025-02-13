class Solution {
    public String removeDuplicates(String s) {
        
        Stack<Character> stack = new Stack<>();
        char[] str = s.toCharArray();

        for(char ch : str){

            if((stack.size()>=1) && stack.peek()==ch)
                stack.pop();
            else
                stack.push(ch);
        }

        StringBuilder sb = new StringBuilder();

        for(char ch : stack)
            sb.append(ch);

        return sb.toString();
    }
}