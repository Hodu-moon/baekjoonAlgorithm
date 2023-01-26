
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] Narray = new int[N];
        int i = 0;
        while(st.hasMoreTokens()){
            Narray[i] = Integer.parseInt(st.nextToken());
            i++;
        }


        int M = Integer.parseInt(br.readLine());
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        int[] Marray = new int[M];
        i = 0;
        while(st3.hasMoreTokens()){
            Marray[i] = Integer.parseInt(st3.nextToken());
            i++;
        }
        StringBuilder sb = new StringBuilder();

        Arrays.sort(Narray);
        for(int j = 0; j < Marray.length; j++){
            if(Arrays.binarySearch(Narray, Marray[j]) > -1){
                sb.append(1);
            }else {
                sb.append(0);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
