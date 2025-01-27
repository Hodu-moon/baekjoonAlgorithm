
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(), M = sc.nextInt(), num = sc.nextInt();

        int [] map = new int[num + 1];

        int sum = 0;

        int security = 0;
        for(int i = 0; i < num + 1; i++){
            int directions = sc.nextInt();
            int distance = sc.nextInt();

            int real_path = 0;
            switch (directions ){
                case 1: // 북 을 기준으로
                    real_path = distance;
                    break;
                case 2:
                    real_path = N + M + N - distance;
                    break;
                case 3:
                    real_path = ((N + M) * 2) - distance;
                    break;
                case 4:
                    real_path = N  + distance;
                    break;

            }
            if(i < num){
                map[i] = real_path;
            }else{
                security = real_path;
            }

        }

        for(int i = 0; i < num; i++ ){
            int path1 = Math.abs(map[i] - security);
            int path2 = ((N + M) * 2) - path1;

            sum += Math.min(path1, path2);
        }

        System.out.println(sum);
    }
}
