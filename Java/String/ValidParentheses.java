import java.util.*;

class Solution {
    public boolean isValid(String s) {
        ArrayList<Character> stack = new ArrayList<>();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (c == '(' || c == '[' || c == '{') {
              stack.add(c);
            } else {
              if (stack.isEmpty()) return false;
              char top = stack.get(stack.size() - 1);
              if ((top == '(' && c == ')') || (top == '[' && c == ']') || (top == '{' && c == '}')) {
                  stack.remove(stack.size() - 1);
              } else {
                  return false;
              }
            }
        }

        return stack.size() == 0;
    }
}