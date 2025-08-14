import java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            Integer cInt = map.get(c);
            if (cInt == null || cInt == 0) {
                return false;
            } 
            map.put(c, cInt - 1);
            if (cInt - 1 == 0) {
              map.remove(c);
            }
        }

        return map.isEmpty();
    }
}