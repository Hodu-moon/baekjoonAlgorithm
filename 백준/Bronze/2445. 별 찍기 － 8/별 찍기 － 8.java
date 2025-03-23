
import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        solve(N);
        System.out.print(sb);
    }

    static void solve(int n){
        int start = 0, end = 2 * n -1;
        for(int i = 0; i < 2 * n  ; i++){
            for(int j = 0; j < 2 * n ; j++){
                if(j <= start){
                    sb.append("*");
                }else if(j >= end){
                    sb.append("*");
                }else{
                    sb.append(" ");
                }
            }

            if(i < n-1){
                start++;
                end--;
            }else{
                start--;end++;
            }

            sb.append("\n");
        }

    }
}
//*        *
//**      **
//***    ***
//****  ****
//**********
//****  ****
//***    ***
//**      **
//*        *
