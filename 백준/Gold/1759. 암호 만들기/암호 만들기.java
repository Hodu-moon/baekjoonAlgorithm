
import java.util.*;
import java.util.Scanner;

public class Main {
    static int L, C, count1, count2;
    static int[] arr, reuslt;
    static boolean[] visited;
    static Set<Character> aeiou = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        arr = new int[C];
        reuslt = new int[L];
        visited = new boolean[C];
        aeiou.add('a');
        aeiou.add('e');
        aeiou.add('i');
        aeiou.add('o');
        aeiou.add('u');

        for(int i = 0; i < C; i++){
            arr[i] = sc.next().charAt(0);
        }

        Arrays.sort(arr);
//        printArr();

        back(0, 0, 0, 0);
        System.out.println(sb);

    }

    static void back(int depth, int startWith, int count1, int count2){
        if(depth == L){

//            System.out.println("=================");
//            printResult();
//            System.out.println(count1 + " " + count2);

            // check
//            if(count1 < 2 &&  count2 < 3){
//                return;
//            }

            if( !(count1 >= 1 && count2 >= 2 )){
                return ;
            }



            for(int i = 0; i < L; i++){
                sb.append( (char)reuslt[i]);
            }

            sb.append("\n");
            return;

        }


        for(int i = startWith; i < C; i++){
            if(visited[i])
                continue;

            visited[i] = true;
            reuslt[depth] = arr[i];


            if(aeiou.contains((char)arr[i])){
                back(depth + 1, i + 1, count1 + 1, count2);
            }else{
                back(depth + 1, i + 1, count1, count2 + 1);
            }

            visited[i] = false;


        }

    }


    static void printArr(){
        for(int a : arr){
            System.out.print((char)a + " ");
        }
    }

    static void printResult(){
        for(int a : reuslt){
            System.out.print((char)a + " ");
        }
    }

}
