
import java.io.BufferedReader;
import java.util.Scanner;

public class Main {
    static long TARGET;
    static long max, start,end;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int t = 1 ; t <= T; t++){
            TARGET = sc.nextLong();

            if(TARGET == 1){
                sb.append(1).append("\n");
            }else{
                solve(TARGET);
                sb.append(start - 1).append("\n");
            }

        }

        System.out.println(sb);

    }

    static void solve(long TARGET){
        start = 0;
        end = 1_000_000_000L;

        while(start < end){
            long mid = start + (end - start) / 2;

            long sum = calc(mid);

//            System.out.println(start + " " + end + " " + sum);
            if(sum <= TARGET){
                start = mid + 1;
            }else{
                end = mid;
            }

        }



    }

    static long calc(long mid){
        return (mid * (  mid + 1)) / 2;


    }
}

//4
//1
//2
//100
//1000000