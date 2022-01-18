/*Given two strings S1 and S2, find if S2 can match S1 or not.

A match that is both one-to-one (an injection) and onto (a surjection), 
i.e. a function which relates each letter in string S1 to a separate and 
distinct non-empty substring in S2, where each non-empty substring in S2
also has a corresponding letter in S1.

Return true,if S2 can match S1.
Otherwise false.

Input Format:
-------------
Line-1 -> Two strings S1 and S2

Output Format:
--------------
Print a boolean value as result.


Sample Input-1:
---------------
abab kmitngitkmitngit

Sample Output-1:
----------------
true


Sample Input-2:
---------------
aaaa kmjckmjckmjckmjc

Sample Output-2:
----------------
true

Sample Input-3:
---------------
mmnn pqrxyzpqrxyz

Sample Output-3:
----------------
false
*/
import java.util.*;
import java.lang.*;
class ma{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String word=sc.next();
        String pattern=sc.next();
        HashMap<Character,String>h=new HashMap<>();
        HashSet<String> set=new HashSet<>();
        if(word.length()==0&&pattern.length()==0)
        {
            System.out.println(true);
            System.exit(0);
        }
        if(word.length()==0)
        {
            System.out.println(false);
            System.exit(0);
        }
       System.out.println(bt(word,pattern,0,0,h,set));
    }
    public static boolean bt(String pattern,String str,int i,int j,HashMap<Character,String>map,HashSet<String> set)
    {if(i==pattern.length() && j==str.length()){
        return true;
    }
 
    if(i>=pattern.length() || j>=str.length())
        return false;
 
    char c = pattern.charAt(i);
    for(int k=j+1; k<=str.length(); k++){
        String sub = str.substring(j, k);
        if(!map.containsKey(c) && !set.contains(sub)){
            map.put(c, sub);
            set.add(sub);
            if(bt(pattern, str, i+1, k, map, set))
                return true;
            map.remove(c);
            set.remove(sub);
        }else if(map.containsKey(c) && map.get(c).equals(sub)){
            if(bt(pattern, str, i+1, k, map, set))
                return true;
        }
    }
 
    return false;
    }
    
}
