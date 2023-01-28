
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long N  = scanner.nextInt();

        long i = 1;
        int j = 1;
        while ( N > i ) {
            i =  i + (j * 6);
            j++;
        }
        System.out.println(j);
    }

}
