


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] fruits = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int maxLength = 0;

        HashMap<Integer, Integer> fruitCount = new HashMap<>();

        for(int right = 0; right < N; right++){
            fruitCount.put(fruits[right], fruitCount.getOrDefault(fruits[right], 0) + 1);

            while( fruitCount.size() > 2){
                fruitCount.put(fruits[left] , fruitCount.get(fruits[left]) - 1);

                if(fruitCount.get(fruits[left]) == 0 ){
                    fruitCount.remove(fruits[left]);
                }

                left++;

            }

            // 여기 잘 모르겠네
            maxLength = Math.max(maxLength, right - left + 1);

//            maxLength =  right - left   + 1;

        }

        System.out.println(maxLength);

    }
}
