
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    // 수 이어가기?

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> list = findSequence(n);

        System.out.println(list.size());
        for(int x : list){
            System.out.print(x + " ");
        }


    }
    public static List<Integer> generateSequence(int first, int second){
        List<Integer> list = new ArrayList<>();
        list.add(first);
        list.add(second);

        while(true){
            int next = list.get(list.size() - 2) - list.get(list.size() - 1);
            if(next < 0){
                break;
            }
            list.add(next);
        }

        return list;
    }

    public static List<Integer> findSequence(int n){
        List<Integer> bestSequence = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            List<Integer> sequence = generateSequence(n, i);
            if(bestSequence.size() < sequence.size()){
                bestSequence = sequence;
            }
        }

        return bestSequence;

    }
}
