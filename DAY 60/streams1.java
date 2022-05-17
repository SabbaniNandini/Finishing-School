/*Mr Sudhakar is working with Strings,
He is given a String S, He wants to sort the characters in S in descending order
based on the frequency of the characters. If two or more characters have same 
frequency then arrange them in sorted-order.

Your task is to help Mr Sudhakar to convert the string S into sorted order of 
frequency.

Note: The frequency of a character is the number of times it appears in the string.

Input Format:
----------------
A String S, conatins bothe lower case and upper case letters.

Output Format:
------------------
Print a string after conversion.


Sample Input-1:
---------------
divide

Sample Output-1:
----------------
ddiiev

Explanation: 
------------
d and e have same frequecy and i and v have same frequency.
So sorted-order is ddeevi.


Sample Input-2:
---------------
TomAto

Sample Output-2:
----------------
ooATmt


Sample Input-3:
---------------
rrrppp

Sample Output-3:
----------------
ppprrr*/
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class streams1{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String str = s.next();
        System.out.println(orderOfHighFrequency(str));
    }
    
    static String orderOfHighFrequency(String str){
        String result = Stream.of(str.split(""))
        .collect(Collectors.groupingBy(e -> e,Collectors.counting()))
        .entrySet()
        .stream()
        .sorted((a,b) ->{
            if(a.getValue() == b.getValue()) return a.getKey().compareTo(b.getKey());
            return (int)(b.getValue()-a.getValue());
        })
        .map(e ->{
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<e.getValue();i++){
                sb.append(e.getKey());
            }
            return sb.toString();
        })
        .collect(Collectors.joining());
        return result;
    }
}
