package structure.trie;

import java.util.TreeMap;

/**
 *  451
 */
public class WordDictionary {

    private class Node{
        public boolean isWord;
        public TreeMap<Character, WordDictionary.Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node(){
            this(false);
        }
    }

    private Node root;

    public WordDictionary(){
        root = new Node();
    }

    public void addWord(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (cur.next.get(c) == null){
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
        }
    }

    public boolean search(String word){
        return match(root, word, 0);
    }

    private boolean match(Node node, String word, int index) {
        if (index == word.length()){
            return node.isWord;
        }
        char c = word.charAt(index);
        if (c != '.'){
            if (node.next.get(c) == null){
                return false;
            }
            return match(node.next.get(c), word, index + 1);
        } else {
            for (char next : node.next.keySet()){
                if (match(node.next.get(next), word, index + 1)){
                    return true;
                }
            }
            return false;
        }
    }
}
