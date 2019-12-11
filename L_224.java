class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        int result = 0; 
        int sign = 1;  

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {

                num = 10 * num + (int) (ch - '0');

            } else if (ch == '+') {
                result += sign * num;

                sign = 1;
                num = 0;

            } else if (ch == '-') {

                result += sign * num;
                sign = -1;
                num = 0;

            } else if (ch == '(') {

                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;

            } else if (ch == ')') {

              
                result += sign * num;

                result *= stack.pop();

        
                result += stack.pop();
                num = 0;
            }
        }
        return result + (sign * num);
    }
}