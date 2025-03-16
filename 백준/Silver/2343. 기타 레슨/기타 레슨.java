
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static long start, end;
    static int[] lessonList;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(),  " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lessonList = new int[N];

        st = new StringTokenizer(br.readLine(),  " ");
        long sum = 0;
        for(int i = 0; i < N; i++){
            lessonList[i] = Integer.parseInt(st.nextToken());
            start = Math.max(start, lessonList[i]);
            sum += lessonList[i];
        }

        end = sum;

//        Arrays.sort(lessonList);

        solve();

        System.out.println(start);


    }

    static void solve(){
        long mid;


        while(start < end){

            mid = (start + end) / 2;

            int count = countBlueLay(mid);

            if(count > M){
                start = mid + 1;
            }else{
                end = mid;
            }
        }

    }

    static int countBlueLay(long size){
        int sum = 0;
        int count = 0;

        for(int i = 0; i < N; i++){
            if(sum + lessonList[i] > size){
                sum = 0;
                count++;
            }

            sum += lessonList[i];
        }


        if(sum >= 0)
            count++;

        return count;

    }
}
