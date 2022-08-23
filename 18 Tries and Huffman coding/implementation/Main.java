// Trie only for lowercase letter's word
/*************************************************
insert() - add a word in trie,
remove() - remvoe given word if exist in trie,
search() - serach for a word and return true if
           word exist in trie otherwise return
           false.
countWord() -  return the total number of word
               added into trie

*************************************************/




public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		
		Trie t = new Trie();
		t.insert("abc");
		t.insert("abcdd");
		
		
		System.out.println(t.countWord());

		System.out.println(t.search("abc"));
		System.out.println(t.search("abcdd"));
		
		
		
		t.remove("abcdd");
		
		System.out.println(t.search("abc"));
		System.out.println(t.search("abcdd"));
		
		t.remove("abc");
		
		System.out.println(t.search("abc"));
		System.out.println(t.search("abcdd"));
    
    
		System.out.println(t.countWord());

		
		
		
	}
}
