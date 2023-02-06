import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (N --> 0){
            int n = Integer.parseInt(br.readLine());
            if(n == 0 ){
                if(heap.peek() == null){
                    sb.append("0").append("\n");
                }else
                    sb.append(heap.remove()).append("\n");
            }else
                heap.add(n);
        }

        System.out.println(sb);
    }
}