class Trie {
    class TrieNode {
        boolean end = false;
        TrieNode[] children = new TrieNode[26]; 
    }

    private TrieNode trie;

    public Trie() {
        trie = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = trie;
        for (char c : word.toCharArray()) {
            TrieNode child = curr.children[c - 'a'];
            if (child == null) {
                child = new TrieNode();
                curr.children[c - 'a'] = child;
            }
            curr = child;
        }
        curr.end = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = trie;
        for (char c : word.toCharArray()) {
            TrieNode child = curr.children[c - 'a'];
            if (child == null) {
                return false;
            }
            curr = child;
        }
        return curr.end;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = trie;
        for (char c : prefix.toCharArray()) {
            TrieNode child = curr.children[c - 'a'];
            if (child == null) {
                return false;
            }
            curr = child;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */