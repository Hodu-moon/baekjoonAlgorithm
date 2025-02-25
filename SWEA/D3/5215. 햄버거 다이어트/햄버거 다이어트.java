
import java.util.ArrayList;
import java.util.*;

// 조합 -> Next Permutation
//
// 1 1 1 1 1 5개
// 0 1 1 1 1 4개
// 0 0 1 1 1 3개
// 0 0 0 1 1 2개
// 0 0 0 0 1 1개
public class Solution {
    static int T, N, L, maxScore;
    static List<int[]> components;

    static int[] selected;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for(int t = 1; t <= T; t++){
            N = sc.nextInt();
            L = sc.nextInt();
            maxScore = 0;
            components = new ArrayList<>();
            for(int i = 0; i < N; i++){
                int score = sc.nextInt();
                int calorie = sc.nextInt();
                components.add(new int[]{score, calorie});
            }

            // 재료 한개 썻을 때, --> N 개 썻을 때
            for (int i = 0; i < N; i++) {
                selected = new int[N];
                for(int j = 0; j <= i; j++){
                    selected[j] = 1;
                }
                Arrays.sort(selected);
//                System.out.println(Arrays.toString(selected));

                // np 들어가기

                do {
                    // 0011
                    // 0100
                    // 이런게 나올거임
//                    System.out.println(Arrays.toString(selected));
                    // 0 0 1 0 1 ->
                    // 내 방식대로 첫번째 나오는게 0이면 pass
                    int sumScore = 0;
                    int sumCalorie = 0;
                    boolean canMake = true;
                    for(int k = 0; k < N; k++){
                        if(selected[k] == 1){ //찾았다.
                            int[] cur = components.get(k);
                            sumScore += cur[0];
                            sumCalorie += cur[1];
                            if(sumCalorie > L){
                                canMake = false;
                                break;
                            }
                        }
                    }
                    if(canMake && sumScore > maxScore){
                        maxScore = sumScore;
                    }
                }while (np());


            }
            sb.append("#").append(t).append(" ").append(maxScore).append("\n");

        }

        System.out.println(sb.toString());

    }

    static boolean np(){
        // 꼭대기 찾기
        int i = N - 1;
        while( i > 0 && selected[i - 1] >= selected[i])
            i--;

        if(i == 0){
            return false;
        }

        // i - 1 꼭대기랑 바꿀 값 찾기
        int j = N - 1;
        while(selected[i - 1] >= selected[j])
            j--;

        // i -1, j 꼭대기랑 교환
        swap(i-1, j);

        // 오름차순 정렬
        int k = N - 1;
        while(i < k)
            swap(i++, k--);

        return true;
    }

    static void swap(int i, int j){
        int temp = selected[i];
        selected[i] = selected[j];
        selected[j] = temp;
    }
}
