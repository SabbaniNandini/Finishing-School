/*Charlie Brown is working with strings,
He is a given a string S. He wants to find out the maximum substring 'MaxSub'.

MaxSub is a substring which appears atleast twice in S with Maximum length. 

Your task is to help Charlie Brown to find the Maximum Substring MaxSub,
and print the length of MaxSub. If there is MaxSub, return 0.

Input Format:
-------------
A string S.

Output Format:
--------------
Print an integer, length of MaxSub


Sample Input-1:
---------------
babababba

Sample Output-1:
----------------
5

Explanation: 
------------
The Maximum substring is 'babab' , which occurs 2 times.


Sample Input-2:
---------------
abbbbba

Sample Output-2:
----------------
4

Explanation: 
------------
The Maximum substring is 'bbbb' , which occurs 2 times.


Sample Input-3:
---------------
vignesh

Sample Output-3:
----------------
0

*/
/*import java.util.*;
import java.lang.*;
public class ma{
    public static long robin_karp(String s)
    {
        int temp=0;
        for(int i=0;i<s.length();i++)
        {
            temp=temp+i*(int)Math.pow(26,(s.charAt(i)-'a'));
        }
        return temp;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        HashMap<Long,String> h=new HashMap<>();
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<str.length();i++)
        {
            for(int j=i;j<str.length();j++)
            {
                long k=robin_karp(str.substring(i,j+1));
                System.out.println(" k is "+k+" substring is "+str.substring(i,j+1));
                if(h.containsKey(k))
                {
                    ans=Math.max(ans,(j-i+1));
                    //System.out.println(str.substring(i,j+1));
                }
                h.put(k,str.substring(i,j+1));
            }
        }
        System.out.println(ans);
    }

*/
import java.util.*;
import java.lang.*;
public class ma{
    public static  String longestDupSubstring(String s) {
        char[] sChars = s.toCharArray();
        int len = sChars.length;
        int[] sInts = new int[len];
        for (int i = 0; i < len; i++) {
            sInts[i] = sChars[i] - 'a';
        }
        int high = len;
        int low = 1;
		
        int[] pos = {-1, -1}; 
			// This part is kind of like a global variable to be modified multiple times by help function.
			
        while (low < high) {
            int mid = (high + low) / 2;
            if (existDupSubstring(sInts, mid, pos)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return pos[0] == -1 ? new String("") : s.substring(pos[0], pos[1]);
    }

   public static  boolean  existDupSubstring(int[] s, int length, int[] pos) {
        long mod = 1000000007L;
        long base = 29L;
        long pow = 1L;
        long hash = 0L;
        Map<Long, List<Integer>> hashes = new HashMap<>();
        for (int i = 0; i < length; ++i) {
            hash = (hash * base + s[i]) % mod;
            pow = pow * base % mod;
        }
		
        hashes.put(hash, new ArrayList<>()); 
			// We record the hash and where it appears to avoid collisions.
				
        hashes.get(hash).add(0);
        for (int start = 1; start <= s.length - length; ++start) {
		
            hash = hash * base - s[start - 1] * pow % mod + mod; 
				// Java doesn't support unsigned, so it's essential to maintain our hash to be positive.
				
            hash = (hash + s[start + length - 1]) % mod;
            if (hashes.containsKey(hash)) { 
			
                for(int i : hashes.get(hash)) {
					// Once a hash is found existing, we need to check all substrings with the same hash. 
					// Since the hash table has a limited size, collisions happen. 
					// A char-to-char(in this code, char is transformed to int) comparison will finally confirm if a substring appears ever. 
				
                    boolean match = true;
                    for (int j = 0; j < length; j++) {
                        if(s[i + j] != s[start + j]) {
                            match = false;
                            break;
                        }
                    }
                    if(match) {
                        pos[0] = start;
                        pos[1] = start + length;
                        return true;
                    }
                }
                hashes.get(hash).add(start);
            } else {
                hashes.put(hash, new ArrayList<>());
                hashes.get(hash).add(start);
            }
        }
        return false;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        
        System.out.println(longestDupSubstring(str).length());
    }
}
