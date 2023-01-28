
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int array[] = new int[N];
        for(int i = 0; i < array.length; i++){
            array[i] = scanner.nextInt();
        }
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < array.length; i++){
            sb.append(array[i]);
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
