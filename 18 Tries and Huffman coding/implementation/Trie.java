public class Trie{
    
    private TrieNode root;
    public Trie(){
        root = new TrieNode('\0');
    }
    
    private void insertHelper(TrieNode root,String word){
        
        if(word.length() == 0){
            root.isTerminal= true;
            return;
        }
        
        int childIndex = word.charAt(0)-'a';
        TrieNode child = root.children[childIndex];
        
        if(child == null){
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.countChild++;
        }
        
        insertHelper(child,word.substring(1));
    }
    public void insert(String word){
        insertHelper(root,word);
    }
    
    private boolean searchHelper(TrieNode root,String word){
        if(word.length() == 0)
            return root.isTerminal;
            
        int childIndex = word.charAt(0)-'a';
        TrieNode child = root.children[childIndex];
        if(child == null)
            return false;
            
        return searchHelper(child,word.substring(1));
    }
    public boolean search(String word){
        return searchHelper(root,word);
        
    }
    
    private void removeHelper(TrieNode root,String word){
        if(word.length() == 0){
            root.isTerminal = false;
            return;
        }
        int childIndex = word.charAt(0)-'a';
        TrieNode child = root.children[childIndex];
        if(child == null)
            return;
            
        removeHelper(child,word.substring(1));
        
        
        if(!root.isTerminal && root.countChild == 0){
            root.children[childIndex] = null;
            root.countChild--;
        }
            
        
    }
    public void remove(String word){
        removeHelper(root,word);
    }
    
    private int countWordHelper(TrieNode root){
        int countChildWord = 0;
        
        for(int i=0;i<26;i++){
            if(root.children[i] != null){
                countChildWord += countWordHelper(root.children[i]);
            }
        }
        
        if(root.isTerminal)
            countChildWord++;
            
        return countChildWord;
    }
    public int countWord(){
        
        return countWordHelper(root);
    }
}
