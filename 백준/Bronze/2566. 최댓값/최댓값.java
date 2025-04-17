

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = 0;
        int y = 0;
        int max = Integer.MIN_VALUE;
        for(int i =1; i <= 9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j= 1; j <= 9; j++){
                int next = Integer.parseInt(st.nextToken());
                if(next > max){
                    x = i;
                    y = j;
                    max = next;
                }
            }
        }

        System.out.println(max);
        System.out.println(x + " " + y);
    }

}
