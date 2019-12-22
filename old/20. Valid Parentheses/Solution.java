import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        char[] str = s.toCharArray();
        Stack stack = new Stack();
        for (int i = 0; i < str.length; i++) {
            if (stack.isEmpty()) {
                stack.push(str[i]);
            } else {
                if ((char) stack.peek() == '(') {
                    if (str[i] == ')') {
                        stack.pop();
                    } else if (str[i] == ']' || str[i] == '}') {
                        return false;
                    } else {
                        stack.push(str[i]);
                    }
                } else if ((char) stack.peek() == '[') {
                    if (str[i] == ']') {
                        stack.pop();
                    } else if (str[i] == ')' || str[i] == '}') {
                        return false;
                    } else {
                        stack.push(str[i]);
                    }
                } else if ((char) stack.peek() == '{') {
                    if (str[i] == '}') {
                        stack.pop();
                    } else if (str[i] == ')' || str[i] == ']') {
                        return false;
                    } else {
                        stack.push(str[i]);
                    }
                } else {
                    return false;
                }
            }
        }
        if (stack.isEmpty())
            return true;
        else return false;
    }
}