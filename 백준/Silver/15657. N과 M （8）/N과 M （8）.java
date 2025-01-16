

import java.util.*;

public class Main {

    static int N;
    static int M;
    static List<Integer> input;

    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        input = new ArrayList<>();
        arr = new int[M];

        for(int i = 0; i < N; i++) {
            input.add(scanner.nextInt());
        }

        Collections.sort(input);
        back(0, 0);

        System.out.println(sb.toString());
    }

    public static void back(int depth, int start){
        if(depth == M){
            for(int a : arr){
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i < N; i++ ){
            arr[depth] = input.get(i);
            back(depth + 1, i);

        }

    }

}
