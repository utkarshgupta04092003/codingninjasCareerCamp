/****************************************************************************************************

Given a string, find and return all the possible permutations of the input string.
Note : The order of permutations are not important.
Sample Input :
abc
Sample Output :
abc
acb
bac
bca
cab
cba
*****************************************************************************************************/




import java.util.ArrayList;
import java.util.List;
 
public class solution {
	
    
    public static String[] permutationOfString(String str, int l, int r) 
    { 
       
        // base case
        if (str == null || str.length() == 0) {
            return null;
        }
 
        // create an empty ArrayList to store (partial) permutations
        List<String> partial = new ArrayList<>();
 
        // initialize the list with the first character of the string
        partial.add(String.valueOf(str.charAt(0)));
 
        // do for every character of the specified string
        for (int i = 1; i < str.length(); i++)
        {
            // consider previously constructed partial permutation one by one
 
            // (iterate backward to avoid ConcurrentModificationException)
            for (int j = partial.size() - 1; j >= 0 ; j--)
            {
                // remove current partial permutation from the ArrayList
                String s = partial.remove(j);
 
                // Insert the next character of the specified string at all
                // possible positions of current partial permutation. Then
                // insert each of these newly constructed strings in the list
 
                for (int k = 0; k <= s.length(); k++)
                {
                    // Advice: use StringBuilder for concatenation
                    partial.add(s.substring(0, k) + str.charAt(i) + s.substring(k));
                }
            }
        }
 	return partial.toArray(new String[0]);	
	}
    
    public static String[] permutationOfString(String input){
        return permutationOfString(input,0,input.length());
    }
    
	
}

