/*Ms Akhila has a habit of reading the words in reverse order.
For Example: if the word is 'hello', she will read it as 'olleh'.

Your task is to help her reading the words in original order.

Note: You have to process each word into reverse order of characaters,
and the given line of words in the original order.

Input Format:
-------------
A line of words as a string S

Output Format:
--------------
Print the processed string S.


Sample Input-1:
---------------
this is EPAM bootcamp

Sample Output-1:
----------------
siht si MAPE pmactoob


Sample Input-2:
---------------
It's My Life

Sample Output-2:
----------------
s'tI yM efiL
-*/
import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;
public class ma{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        StringBuilder sb = new StringBuilder();
        String ans= Stream.of(str.split(" "))
         .map(e->{
             StringBuilder s=new StringBuilder(e);
             return s.reverse()+" ";
             })
         .collect(Collectors.joining());                   
                              
           System.out.println(ans);
                       
    }
    }

