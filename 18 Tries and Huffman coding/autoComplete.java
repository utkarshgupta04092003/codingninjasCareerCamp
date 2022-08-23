/****************************************************************
Given n number of words and an incomplete word w. You need to auto-complete that word w.
That means, find and print all the possible words which can be formed using the incomplete word w.
Note : Order of words does not matter

Input:
7
do dont no not note notes den
no

Output:
no
not
note
notes
****************************************************************/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 

class TrieNode{
	char data;
	boolean isTerminating;
	TrieNode children[];
	int childCount;

	public TrieNode(char data) {
		this.data = data;
		isTerminating = false;
		children = new TrieNode[26];
		childCount = 0;
	}
}

class Trie {
	private TrieNode root;
	public int count;
	public Trie() {
		root = new TrieNode('\0');
	}


    // Add words in trie
	private void add(TrieNode root, String word){
		if(word.length() == 0){
			root.isTerminating = true;
			return;
		}		
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		add(child, word.substring(1));
	}

	public void add(String word){
		add(root, word);
	}
	
    
    // find all possible word that can be suggest
    private void allPossibleWords(TrieNode root,String word){
         if(root == null){
            return;
        }
        
        if(root.isTerminating){
            System.out.println(word);
            
        }
        if(root.childCount == 0)
            return;
        for(int i=0;i<26;i++){
            if(root.children[i] != null){
                allPossibleWords(root.children[i],word+root.children[i].data);
            }
        }
    }
    
    
    // check whether pattern is exist or not,
    // if pattern is not exist just return from here
    // if  pattern is  exist go and find all possible words that can be suggest
	private void findWord(TrieNode root,String word,String word2){
        
        if(word.length() == 0){
            
            // call all possible word format
            String output = "";
            allPossibleWords(root,word2);
            return;
            
        }
        
        int childIndex = word.charAt(0)-'a';
        TrieNode child = root.children[childIndex];
        if(child == null)
            return;
        
        
        findWord(child,word.substring(1),word2);
        
        
    }
	public void autoComplete(ArrayList<String> input, String word) {

        // put all the words in the trie and search for suggestion words
        for(int i=0;i<input.size();i++){
            add(input.get(i));
        }
        
        findWord(root,word,word);

    }
    
}
public class Main{
    public static void main(String[] args){
		Trie t = new Trie();
		
		String words[] ={"hello", "dog", "hell", "cat", "a", "hel","help","helps","helping"}; 
        ArrayList<String> input = new ArrayList<String>();
		for(int i = 0; i < words.length; i++) {
			
			input.add(words[i]);
		}
        String pattern = "hel";
		t.autoComplete(input, pattern);
	}
	
	// This code is contributed by utkarshgupta04092003
    
   
}

