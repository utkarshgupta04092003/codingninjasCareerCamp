public class TrieNode{
    char data;
    TrieNode children[];
    boolean isTerminal;
    int countChild;
    
    public TrieNode(char data){
        this.data = data;
        this.children = new TrieNode[26];
        this.isTerminal = false;
        this.countChild = 0;
    }

}
