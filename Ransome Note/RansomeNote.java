import java.util.*;
import java.io.*;
public class RansomeNote{

	public static Hashtable<Character, ArrayList<String>> hashTable = new Hashtable<Character, ArrayList<String>>();

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }
        createHashTable(magazine);
        System.out.println(isRansomeNote(ransom));
   }
   
   public static void createHashTable(String[] input){
   	   ArrayList<String> temp;
   	   for(int i = 0; i<input.length;i++){
   	   	   char tempChar = input[i].charAt(0);   
   	   	   if(hashTable.containsKey(tempChar)){  	   	   	   
   	   	   	   temp = new ArrayList<String>(hashTable.get(tempChar));
   	   	   	   temp.add(input[i]);
   	   	   	   hashTable.put(tempChar,temp);	
   	   	   }
   	   	   else{
   	   	   	   temp = new ArrayList<String>();
   	   	   	   temp.add(input[i]);
   	   	   	   hashTable.put(tempChar,temp);
   	   	   }
   	   }
   	   printHashTable();
   }
   
   public static String isRansomeNote(String[] note){
   	   int count = 0;
   	   for(int i = 0;i<note.length;i++){
   	   	   char tempChar = note[i].charAt(0);
   	   	   if(hashTable.get(tempChar) != null){
   	   	   	   ArrayList<String> temp = new ArrayList<String>(hashTable.get(tempChar));
   	   	   	   if(temp.contains(note[i])){
   	   	   	   	   count += 1;
   	   	   	   	   temp.remove(note[i]);
   	   	   	   	   hashTable.put(tempChar,temp);
   	   	   	   }else{
   	   	   	   	   break;
   	   	   	   }
   	   	   }
   	   }
   	   if(count == note.length)
   	   	   return "YES";
   	   else
   	   	   return "NO";
   }
   
   public static void printHashTable(){
   	   Set<Character> keys = hashTable.keySet();
        for(char key: keys){
            System.out.println("Value of "+key+" is: "+hashTable.get(key));
        }
   }
   
}