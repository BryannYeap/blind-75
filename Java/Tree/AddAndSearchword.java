class WordDictionary {
    HashSet<String> set;

    public WordDictionary() {
        set = new HashSet<>();
    }
    
    public void addWord(String word) {
        set.add(word);
    }
    
    public boolean search(String word) {
        if (set.contains(word)) return true;

        if (word.contains(".")) {
            String[] arr = set.toArray(new String[set.size()]);
            boolean found = true;
            for (String s : arr) {
                if (s.length() != word.length()) continue;

                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == '.') continue;
                    if (word.charAt(i) != s.charAt(i)) {
                        found = false;
                        break;
                    }
                }

                if (found) return true;
                found = true;
            }
        } 
            
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */