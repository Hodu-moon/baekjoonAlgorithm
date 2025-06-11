
import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    static int A, B, intersection;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        Set<Integer> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int aIndex = 0; aIndex < A; aIndex++){
            set.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());

        for(int bIndex = 0; bIndex < B; bIndex++){
            if(set.contains(Integer.parseInt(st.nextToken()))){
                intersection++;
            }
        }

        System.out.println(A + B - (2 * intersection));


    }
}

//3 5
//1 2 4
//2 3 4 5 6