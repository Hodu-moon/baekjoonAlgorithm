
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] LIS = new int[N];

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int size = 0;
        for(int i = 0; i < N; i++){
            LIS[i] = 1;
            int target = arr[i];


            int temp = Arrays.binarySearch(LIS, 0, size,  target);

            int pos = Math.abs(temp) - 1;

            if(pos == size)
                size++;

            LIS[pos] = arr[i];

        }

        System.out.println(N - size);

    }
}
