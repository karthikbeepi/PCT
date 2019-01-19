/* IMPORTANT: Multiple classes and nested static classes are supported */

//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    public static void main(String args[] ) throws Exception {

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        String[] str = br.readLine().split(" ");
        int sum =0;
        for(String s : str)
        {
        	sum+= Integer.parseInt(s);
        }
        if(sum== 2*(N-1))
        	System.out.println("Yes");
        else
        	System.out.println("No");
    }
}
