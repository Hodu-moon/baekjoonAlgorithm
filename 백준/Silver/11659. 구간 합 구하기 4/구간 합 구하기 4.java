import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] arr ;
    static StringTokenizer st;
    static BufferedReader br;

    static int[] sumArr;


    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        sumArr = new int[N + 1];

        makeArr();
        int sum;

        for(int i = 0; i < M; i++){
            sum = 0;

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // 5 5
            if(start == end){
                bw.write(arr[start] + "\n");
                continue;
            }

            // start가 첫번째 부터이면
            if(start == 1){
                bw.write(sumArr[end] + "\n");
                continue;
            }

            
            int s = sumArr[end] - sumArr[start - 1];
            bw.write(s + "\n");

        }

        bw.flush();


    }

    static void makeArr() throws IOException{
        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());

            if(i == 1)
                sumArr[i] = arr[i];
            else
                sumArr[i] = arr[i] + sumArr[i - 1];
        }
    }
}
