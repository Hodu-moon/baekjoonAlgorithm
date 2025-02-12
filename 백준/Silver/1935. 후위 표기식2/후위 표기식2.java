
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[] s = {'+', '-', '*', '/'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double []arr = new double[N];

        String input = br.readLine();
        Deque<Character> stack = new ArrayDeque<>();
        Set<Character> s = new HashSet<>();
        s.add('+');
        s.add('-');
        s.add('*');
        s.add('/');

        for(int i= 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Deque<Double> iDeque = new ArrayDeque<>();
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(s.contains(c)){
                double x = 0;
                double second = iDeque.pop();
                double first = iDeque.pop();
//                System.out.println(first + " : " + second);
                switch (c){
                    case '-':
                        x = first - second;
                        break;
                    case '+':
                        x = first + second;
                        break;
                    case '*':
                        x = first * second;
                        break;
                    case '/':
                        x = first / second;
                        break;
                }
                iDeque.push(x);

            }else{
                iDeque.push(arr[input.charAt(i) - 'A']);
            }

        }

        System.out.printf("%.2f", iDeque.pop());



    }


}

//5
//ABC*+DE/-
//1
//2
//3
//4
//5