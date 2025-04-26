

import java.util.Scanner;

//체스는 총 16개의 피스를 사용하며, 킹 1개, 퀸 1개, 룩 2개, 비숍 2개, 나이트 2개, 폰 8개로 구성되어 있다.
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] chess = {1, 1, 2, 2, 2, 8};

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 6; i++){
            chess[i] = chess[i] - sc.nextInt();
            sb.append(chess[i]).append(" ");
        }

        System.out.println(sb);
    }
}
