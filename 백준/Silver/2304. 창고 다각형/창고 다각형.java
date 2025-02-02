
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Map<Integer, Integer>  gidung = new HashMap<>();
        int tallest_position = 0;
        int tallest_height = 0;

        int[] positions = new int[N];
        for(int i = 0; i < N; i++){
            int position = sc.nextInt();
            int height = sc.nextInt();

            positions[i] = position;

            if(height > tallest_height){
                tallest_height = height;
                tallest_position = position;
            }

            gidung.put(position, height);
        }

        Arrays.sort(positions);

        int result = 0;

        int left = 0;

        int height = 0;

        for(int i = positions[0]; i < tallest_position; i++){
            if(positions[left] == i){
                if(height < gidung.get(positions[left])){
                    height = gidung.get(positions[left]);
                }

                left++;
            }

            result += height;
        }

        height = 0;

        int right = positions.length - 1;

        for(int i = positions[right]; i > tallest_position ; i--){
            if(positions[right] == i){

                if(height < gidung.get(positions[right])){
                    height = gidung.get(positions[right]);
                }

                right--;
            }

            result += height;

        }

        result += tallest_height;

        System.out.println(result);

    }
}
//7
//2 4
//11 4
//15 8
//4 6
//5 3
//8 10
//13 6
