import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       for(int i = 3; i > 0; i --){
           String s = br.readLine();
           if(s.matches("^[0-9]*$")){
                int n = Integer.parseInt(s) + i;
                if( n % 3 == 0){
                    if(n % 5 == 0){
                        System.out.println("FizzBuzz");
                        return;
                    }
                    System.out.println("Fizz");
                    return;
                }else if(n % 5 == 0){
                    System.out.println("Buzz");
                    return;
                }else {
                    System.out.println(n);
                    return;
                }
           }
       }
    }

}
