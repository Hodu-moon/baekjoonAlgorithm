
import java.util.Scanner;

public class Main {
    static char[] alph = {'a','b','c','d','e','f','g','h', 'i', 'j','k', 'l','m', 'n', 'o','p'
            ,'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String user = scanner.next();

        int []alph_num = new int[26];
        for(int i = 0; i < user.length(); i++){
            alph_num[(int)user.charAt(i) - 'a'] += 1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < alph_num.length; i++){
            sb.append(alph_num[i]);
            sb.append(' ');
        }
        System.out.println(sb.toString());
    }
}
