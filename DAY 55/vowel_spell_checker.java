/*Mr NOkayya is AI developer, He is given a dictionary, he want to implement a 
an Word-Corrector application that checks user-word and corrects it.

For a given user-word, the Word-Corrector handles two types of validations:

1) If the user-word matches a word in the dictionary (case-insensitive), 
then the user-word is returned with the matched word in the dictionary.
    Ex-1: dict = ["kmit"], user-word = "KmIt": word-corrector = "kmit"
	Ex-2: dict = ["Kmit"], user-word = "kmit": word-corrector = "Kmit"
	Ex-3: dict = ["kmit"], user-word = "kmit": word-corrector = "kmit"
	
2) If after replacing the vowels of the user-word with any vowel individually,
it matches a word in the dictionary (case-insensitive), 
then the user-word is returned with the matched word in the dictionary.
	Ex-1: dict = ["KmIt"], user-word = "kmet": word-corrector = "KmIt"
	Ex-2: dict = ["KmIt"], user-word = "kmmit": word-corrector = "" (no match)
	Ex-3: dict = ["KmIt"], user-word = "kit": word-corrector = "" (no match)

In addition to the above conditions, the word-corrector app works
with the following precedence rules:
 - When the user-word exactly matches a word in the dictionary (case-sensitive), 
    you should return the same word back.
 - When the user-word matches a word up to validation-1, 
    you should return the first such match in the dictionary.
 - When the user-word matches a word up to validation-2, 
    you should return the first such match in the dictionary.
 - If the user-word has no matches in the dictionary, 
    you should return the empty string.

You are given some user-words[], return a list of words result[], 
where result[i] is the corrected words by the Word-Corrector app for 
user-word = user-words[i].


Input Format:
-------------
Line-1: comma separated strings, dictionary[].
Line-2: comma separated strings, user-words[].

Output Format:
--------------
List of corrected user-words[] by Word-Corrector app.


Sample Input-1:
---------------
LiTe,lite,bare,Bare
lite,Lite,LiTe,Bare,BARE,Bear,bear,leti,leet,leto

Sample Output-1:
----------------
[lite, LiTe, LiTe, Bare, bare, , , LiTe, , LiTe]


Sample Input-2:
---------------
kmit,ngit,kmec
KmOT,NHIT,KMIC

Sample Output-2:
----------------
[kmit, , kmec]
*/
import java.util.*;
import java.lang.*;
class ma{
    public static String[] spellchecker(String[] words, String[] queries) {
        Map<String, Integer> strictMap = new HashMap<>();
        Map<String, Integer> capMap = new HashMap<>();
        Map<String, Integer> vowelMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            final String word = words[i];
            if (!strictMap.containsKey(word)) strictMap.put(word, i);
            if (!capMap.containsKey(getCap(word))) capMap.put(getCap(word), i);
            if (!vowelMap.containsKey(deVowel(word))) vowelMap.put(deVowel(word), i);
        }
        String[] res = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            final String query = queries[i];
            int index = -1;
            if(strictMap.containsKey(query)) index = strictMap.get(query);
            else if(capMap.containsKey(getCap(query))) index = capMap.get(getCap(query));
            else if(vowelMap.containsKey(deVowel(query))) index = vowelMap.get(deVowel(query));
            res[i]  = index >= 0 ? words[index]: "";
        }
        return res;
    }

    private static String deVowel(String word) {
        return word.toLowerCase().replaceAll("[aeiou]", "a");
    }

    private static String getCap(String word) {
        return Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        String s=sc.next();
        String dict[]=str.split(",");
        String words[]=s.split(",");
        String ans[]=spellchecker(dict,words);
    System.out.println(Arrays.toString(ans));
    }
}