class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> tFreq = new HashMap<>();
        HashMap<Character,Queue<Integer>> sIndex = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            tFreq.put(t.charAt(i), 
                tFreq.getOrDefault(t.charAt(i), 0) + 1);
        }

        int minLength = 100001;
        int currMin = 100001;
        int currMax = -1;
        int totalMin = 100001;
        int totalMax = -1;
        boolean done = false;
        for (int i = 0; i < s.length(); i++) {
            currMax = i;
            char sChar = s.charAt(i);

            int sCharFreq = tFreq.getOrDefault(sChar, 0);
            if (sCharFreq > 0) {
                currMin = Math.min(currMin, i);

                tFreq.put(sChar, sCharFreq - 1);
                
                Queue<Integer> ls = sIndex.get(sChar);
                if (ls == null) {
                    ls = new LinkedList<>();
                    sIndex.put(sChar, ls);
                } 
                ls.add(i);

                boolean currDone = true;
                for (Integer freq : tFreq.values()) {
                    if (freq > 0) {
                        currDone = false;
                        break;
                    } 
                }

                done = currDone;

                if (done) {
                    minLength = currMax - currMin + 1;
                    totalMin = currMin;
                    totalMax = currMax;                
                }
            } else {
                Queue<Integer> ls = sIndex.get(sChar);
                if (ls != null) {
                    int index = ls.poll();
                    ls.add(i);
                    if (index == currMin) {
                        int min = 100001;
                        for (Queue<Integer> q : sIndex.values()) {
                            for (Integer j : q) {
                                if (j < min) min = j;
                            }
                        }
                        currMin = min;
                    }

                    if (done && minLength > currMax - currMin + 1) {
                            totalMin = currMin;
                            totalMax = currMax;
                            minLength = currMax - currMin + 1;
                    }
                }
            }
        }
        
        return done ? s.substring(totalMin, totalMax + 1) : "";
    }
}

//================================================================================================================================

class OptimalSolution {
    public String minWindow(String s, String t) {
        int[] map= new int[123];
        int left=0,right=0, count=t.length(),sub_len= Integer.MAX_VALUE,start=0;

        for(char c: t.toCharArray()) 
            map[c]++;

        char[] ch = s.toCharArray();
        while(right<s.length())
        {
            if(map[ch[right++]]-->0) count--;

            while(count==0)
            {
                if((right-left)<sub_len) sub_len= right-(start=left);
                if(map[ch[left++]]++==0) count++;
            }
        }

        return sub_len==Integer.MAX_VALUE? "": s.substring(start,start+sub_len);
    }
}