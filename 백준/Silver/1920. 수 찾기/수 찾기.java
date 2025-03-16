
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 정렬 되어있어야 함
        Arrays.sort(arr);

        // 2. 찾기
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++){
            int target = Integer.parseInt(st.nextToken());

            sb.append(binarySearch(target) ? 1 : 0).append("\n");
        }

        System.out.println(sb);

    }

    static boolean binarySearch(int target){

        int start = 0, end = N - 1;
        while(start <= end){
            int mid = (start + end) / 2;

            if(arr[mid] == target){
                return true;
            }else if(arr[mid] > target){
                end = mid - 1;
            }else{ // arr[mid] < target
                start = mid + 1;
            }
        }

        return false;
    }
}

//5
//4 1 5 2 3
//5
//1 3 7 9 5

//1
//1
//0 ...
