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
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int abso1 = Math.abs(o1);
                int abso2 = Math.abs(o2);

                if(abso1 == abso2) {
                    if( o1 > o2){  // o1이 o2 보다 크면 바꾸겠다.
                        return 1;
                    }else
                        return -1;
                }else
                    return abso1 - abso2;
            }
        });
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