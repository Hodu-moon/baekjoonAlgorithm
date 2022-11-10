
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();




        int count = 0;
        int jari = 1;
        int num = 10;
        for(int i = 1; i <= n;i++){
            if(i % num == 0 ){
                jari++;
                num *= 10;
            }
            count += jari;
        }
        System.out.println(count);



//        for(int i = 1; i <= n ; i++){
//            sb.append(Integer.toString(i));
//        }
//        String user = sb.toString();
//
//        System.out.println(user.length());
    }
}
