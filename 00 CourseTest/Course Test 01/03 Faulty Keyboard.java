/*********************************************************************************************

Some of the keys on your keyboard are faulty. When you press a key, it may register more 
than once. That means if you want to type "code", the keyboard may interpret it as "code",
"cccoddee" or "coode" or "codeeeee", etc. So, by pressing the keys C, O, D, and E in that
order, you may get any of the above-mentioned words.
However, there are certain words that you will not get like, "cddde", "cod", "coeeeeed",
etc.
You will be given 'N' pairs of words. The first word of each pair is what you intended
to write and the second one is what the keyboard interprets it as. You need to figure 
out whether the second word can actually be a possible interpretation of the first word.
Input format
The first line of the input contains a positive integer, N which represents the number
of pairs of words
Every two lines after it will contain two words. The first one is what you typed,
the second one is a potential interpretation of that word by the faulty keyboard.
Output format
The output will contain 'N' lines. Each line will be either "true" if the second
word is a possible interpretation of the first word and "false" if it's not.
Constraints
1 <= N <= 10^5
1 <= L <= 10^6
where L is the total number of letters in all of the 2*N words
Time limit: 1 sec
Sample Input 1
2
code
cooodeee
hello
hheeeloo
Sample Output 1
true
false

***********************************************************************************************/


import java.util.*;
public class Solution {
    
    static boolean check(String good,String bad){
        
        int n1 = good.length();
        int n2 = bad.length();
        
        if(n2 < n1)
            return false;
        if(n1 == n2 && good.equals(bad))
            return true;
        
        
        
        int i=0;
        int j=0;
        
        
        while(i<n1 && j<n2){
            if(good.charAt(i) == bad.charAt(j)){
                i++;
                j++;
            }
            else if(i > 0 && good.charAt(i - 1) == bad.charAt(j)) {
                j++;
            } 
            else{
                return false;
            }
        }
        
        while(j < bad.length()) {
            if(bad.charAt(j) != good.charAt(i - 1)) 
                return false;
            	
            j++;
        }
        if(i == n1)
            return true;
        
        return false;
        
    }
    public static void main(String[] args) {
		// Write your code here
        Scanner s = new Scanner(System.in);
        
        int t = s.nextInt();
        
        while(t>0){
            
            String goodString = s.next();
            String badString = s.next();
            
            
            System.out.println(check(goodString,badString));
            
            t--;
            
        }
    }
}




