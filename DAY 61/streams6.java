/*Mr Madan is given a line of words as a string, LoW and another set of words as
excluded[].

Your task is to help Mr Madam to return the most repeated word in LoW that is 
not an excluded word. It is guaranteed that there exists at least one word
that is not in excluded list, and the answer is unique.

Note:
The words in 'LoW' are case-insensitive but the answer should be returned in 
lowercase. Consider special characters as split symbols while processing the LoW.

Input Format:
-------------
Line-1: Single line of space separated words, line.
Line-2: Space seprated words, excluded[] the words are in lowercase.

Output Format:
--------------
Print the word, W.

Sample Input:
-------------
KMIT college is having FS classes in KMit Fs Labs
kmit

Sample Output:
--------------
fs


Sample Input-2:
---------------
hello HellO, world
world

Sample Output-2:
----------------
hello
*/
import java.util.*;
import java.util.stream.*;

class ma{
    static String findword(List<String> include,List<String> exclude){
        String ans = include.stream().filter(str -> !exclude.contains(str))
        .collect(Collectors.groupingBy(e->e,Collectors.counting()))
        .entrySet()
        .stream()
        .sorted((e1,e2) -> (int) (e2.getValue() - e1.getValue()))
        .findFirst()
        .get()
        .getKey();
        
        return ans;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String s1 = sc.nextLine();
        List<String> include = Arrays.asList(s.toLowerCase().split("[^a-z]+"));
        List<String> exclude = Arrays.asList(s1.split(" "));
        System.out.println(findword(include,exclude));
    }
}
