/*/*
Write a Java Program which read atmost 5 files and a dictionary of pair of words,
A pair of word looks like, pair[]=["first","second"], in one operation 
replace all occurences of first word with second word.
for example, pair[]={"hello", "hi"}, you need to replace all the occurneces 
of "hello" with "hi" in every file.

You need to create callables for each file, and you need to perform the 
above operation for every pair of words in the dictionary.

Return the result as single string, 
String s=data from (paragraph1.txt+pragraph2.txt+..+pragraph5.txt)

Hint:
Available file names:
paragraph1.txt
paragraph2.txt
paragraph3.txt
paragraph4.txt
paragraph5.txt

Input Format:
-------------
Line-1: Space separated pair of words, dictionary.
        each pair is '-' separated.
Line-2: space separated strings, filenames.


Output Format:
--------------
Print a string result.

Sample Input-1:
---------------
india-bharath from-to bitter-sweeter
paragraph1.txt paragraph2.txt paragraph3.txt

Sample Output-1:
----------------
Large output:

*/
import java.util.concurrent.*;
import java.util.*;
import java.io.*;

class Convert implements Callable<String>{
    String str,dic[];
    Convert(String str,String[] dic){
        this.str = str;
        this.dic = dic;
    }
    
    public String call() throws Exception{
        for(String pairs : dic){
            String[] pair = pairs.split("-");
            str = str.replaceAll(pair[0],pair[1]);
        }
        
        return str;
    }
}
class ReplaceWords{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String[] dics = (sc.nextLine()).split(" ");
        String[] files = (sc.nextLine()).split(" ");
        StringBuilder finalstring = new StringBuilder();
        try{
            ExecutorService executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(files.length);
            List<Future<String>> resultList = new ArrayList<>();
            for(String file : files){
                File f = new File(file);
                Scanner sc1 = new Scanner(f);
                String data = sc1.nextLine();
                Convert cvt = new Convert(data,dics);
                Future<String> res = executor.submit(cvt);
                resultList.add(res);
            }
            for(Future<String> res : resultList){
                while(!res.isDone()){}
                finalstring.append(res.get());
            }
            executor.shutdown();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(finalstring);
        
    }
}

*/

