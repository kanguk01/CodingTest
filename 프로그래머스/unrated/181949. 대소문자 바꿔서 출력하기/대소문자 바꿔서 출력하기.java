
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String result = "";
        char tmp;
        
        
        
        for (int i=0; i< a.length(); i++ ){
        	tmp = a.charAt(i);
        	if(Character.isUpperCase(tmp)) {
        		result += (String.valueOf(tmp)).toLowerCase();
        	}
        	else {result += (String.valueOf(tmp)).toUpperCase();}
        	
        	
            
        }
        
        System.out.println(result);
    }
}