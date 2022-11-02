import java.util.*;

public class Main {
    static boolean prime[];
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        makePrime(1000000);
        while(true) {
            boolean x = false;
            int n = scanner.nextInt();
            if(n == 0) return;
            for(int i = 2; i <= n/2; i++){
                if(!prime[i] && !prime[n-i]){
                    System.out.println(n + " = "+ i + " + " + (n-i));
                    x = true;
                    break;
                }
            }

            /* time out!
            for (int i = 0; i <= Math.sqrt(n)+1; i++) {
                if (!prime[i]) {
                    a = i;
                    for (int j = n ; j >= Math.sqrt(n); j--) {
                        if (!prime[j]) {
                            if (n == i + j) {
                                a = i;
                                b = j;
                                System.out.println(n + " = "+ a + " + " + b);
                                x = true;
                                continue;
                            }
                        }
                    }
                }

            }

             */
            if(!x) System.out.println("Goldbach's conjecture is wrong.");
        }
    }

    public static void makePrime(int n){
        prime = new boolean[n+1];
        if(n < 2)
            return;

        prime[0]=prime[1]=true;

        for(int i = 2; i <= Math.sqrt(n); i++){
            if(prime[i]) continue;
            for(int j = i*i; j < n; j = j + i ){
                prime[j] = true;
            }
        }

    }
}

