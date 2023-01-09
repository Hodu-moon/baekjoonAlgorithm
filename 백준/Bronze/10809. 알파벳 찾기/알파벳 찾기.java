


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String user = scanner.next();

        int []alph = new int[26];
        Arrays.fill(alph, -1);

        for(int i = 0; i < user.length(); i++){
            if(alph[user.charAt(i)- 97] == -1){
                alph[user.charAt(i) - 97] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < alph.length; i++){
            sb.append(alph[i]);
            sb.append(' ');
        }
        System.out.println(sb.toString());
    }
}
