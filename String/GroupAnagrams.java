class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        
        for (String s : strs) {
            boolean added = false;
            for (List<String> ls : res) {
                String s1 = ls.get(0);
                
                if (s.length() != s1.length()) continue;

                int[] a1 = new int[26];

                for (int i = 0; i < s.length(); i++) {
                    a1[s.charAt(i) - 'a']++;
                    a1[s1.charAt(i) - 'a']--;
                }

                boolean anagram = true;
                for (int a : a1) {
                    if (a != 0) anagram = false;
                }

                if (anagram) {
                    ls.add(s);
                    added = true;
                    break;
                } 
            }

            if (!added) {
                List<String> newLs = new ArrayList<>();
                newLs.add(s);
                res.add(newLs);
            }
        }

        return res;        
    }
}

//===========================================================================================================

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for(String str: strs) {
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String key = new String(ca);

            if(map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> strList = new ArrayList<>();
                strList.add(str);
                map.put(key, strList);
            }
        }
        result.addAll(map.values());
        return result;
    }
}