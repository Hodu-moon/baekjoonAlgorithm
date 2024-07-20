import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T;
    static int N;
    static Map<String, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());


        // T번 실행
        for(int i = 0; i < T; i++){
            //의상 수
            N = Integer.parseInt(br.readLine());
            map = new HashMap<>();

            for(int j = 0; j < N; j++){

                String s = br.readLine();
                StringTokenizer st = new StringTokenizer(s);
                st.nextToken();

                addKey(st.nextToken());

            }

            int result = 1;

            for(int a  :map.values()){
                result *= a + 1;
            }

            System.out.println(result - 1);

        }


    }

    static void addKey(String key){
        // 만약 키를 이미 가지고 있다면
        if(map.containsKey(key)){
            int c = map.get(key);
            map.put(key, c + 1);
        }else // 키가 없다면
            map.put(key, 1);

    }
}
