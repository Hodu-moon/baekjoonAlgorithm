import java.util.*;

public class Main {
    // 에라토스테네스의 체를 쓰면 O(NlogN)
    // 이미 체크된 배열 검사 X -> O(Nlog(logN))
    public static boolean[] eratostenes;
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        makePrime(m);

        for(int i = n; i < eratostenes.length; i++){
            if(!eratostenes[i]){
                System.out.println(i);
            }
        }
    }

    public static void makePrime(int n){
        eratostenes = new boolean[n + 1];// 0~ N
        /*
        소수가 아닌 index = true
        소수인 index = false
         */

        if(n < 2){
            return;
        }

        eratostenes[0] = eratostenes[1] = true;

        for(int i = 0; i <=Math.sqrt(n); i++){
           if(eratostenes[i]){ continue; }

           for(int j = i*i; j < eratostenes.length; j = j + i) {
               eratostenes[j] = true;

           /*
           eratostenes[i] = true;
           if(i*i >= eratostenes.length ){continue;}
           for(int j = i*i; j <= eratostenes.length; j = j + i){
               eratostenes[j] = true;

            */
           }
        }

    }

    /* 시간 초과
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        for(int i = x; i <= y ; i++){
            makePrime(i);
        }

    }


    public static void makePrime(int n) {

        if(n < 2){
            return;
        }

        if(n == 2){
            System.out.println("2");
        }


        for(int i = 2; i <= Math.sqrt(n); i++){
            if((n % i) == 0){
                return;
            }
        }
        System.out.println(n);
        return;

    }

     */
}


