
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        LinkedList<Integer> list = new LinkedList<>();

        for(int i = 1; i <= N; i++){
            list.add(i);
        }
        System.out.print("<");
        while(!list.isEmpty()){
            for(int i = 0; i < K; i++){
                if( i == K-1){
                    int a = list.remove();
                    if(list.size() == 0){
                        System.out.print(a);
                    }
                    else System.out.print(a + ", ");
                }
                else
                    list.add(list.remove());
            }
        }
        System.out.print(">");
    }
}
