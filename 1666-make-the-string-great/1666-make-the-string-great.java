class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        char[] str = s.toCharArray();


        // Checking whether stack top and curr character is equal
        for(char ch : str){
                
            if((stack.size()>=1) && (stack.peek()!=ch) && Character.toLowerCase(stack.peek())==Character.toLowerCase(ch))
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