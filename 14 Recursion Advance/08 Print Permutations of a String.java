/***********************************************************************************************

Given a string, find and print all the possible permutations of the input string.
Note : The order of permutations are not important. Just print them in different lines.
Sample Input :
abc
Sample Output :
abc
acb
bac
bca
cab
cba


************************************************************************************************/


public class solution {

    public static void permutations(String candidate, String remaining)
    {
        // base case
        if (remaining == null) {
            return;
        }
 
        if (remaining.length() == 0) {
            System.out.println(candidate);
        }
 
        for (int i = 0; i < remaining.length(); i++)
        {
            String newCandidate = candidate + remaining.charAt(i);
 
            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
 
            permutations(newCandidate, newRemaining);
        }
    }
	public static void permutations(String input){
		// Write your code here
		permutations("", input);
	}
}
