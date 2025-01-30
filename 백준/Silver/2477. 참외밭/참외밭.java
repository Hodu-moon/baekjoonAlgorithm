
import java.util.*;

public class Main {
    // 7
    //4 50
    //2 160
    //3 30
    //1 60
    //3 20
    //1 100
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int carrot = sc.nextInt();

        List<Integer> directions = new LinkedList<>();
        List<Integer> distances = new LinkedList<>();

        int[] count = new int[5];

        for (int i = 0; i < 6; i++) {
            int direction = sc.nextInt();
            int distance = sc.nextInt();

            count[direction] += 1;

            directions.add(direction);
            distances.add(distance);
        }

        // 1,4 | 23, 13, 24
        List<Integer> longDistance = new ArrayList<>();

        for (int i = 1; i < 5; i++) {
            if (count[i] == 1) {
                longDistance.add(i);
            }
        }

        int x = longDistance.get(0), y = longDistance.get(1);
        // 1 4 , 3 1
        if (x == 1) {
            if (y == 3) {
                int temp = x;
                x = y;
                y = temp;
            }
        } else { // x == 2  2 3, 4 2
            if (y == 4) {
                int temp = x;
                x = y;
                y = temp;
            }
        }


        while (true) {
            int first = directions.get(0);
            int second = directions.get(1);

            if (first == x && second == y) {
                break;
            }
            // 돌리기
            int i1 = directions.remove(0);
            directions.add(i1);
            int i2 = distances.remove(0);
            distances.add(i2);

        }


        int m = (distances.get(0) * distances.get(1)) - (distances.get(3) * distances.get(4));

        System.out.println(m * carrot);



    }
}
