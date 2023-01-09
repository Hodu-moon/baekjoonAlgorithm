
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String user = scanner.nextLine();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < user.length(); i++){
            char c = user.charAt(i);
            if(Character.isLowerCase(c)){
                int d = c + 13;
                if(d >= 123){
                    d -= 26;
                }
                sb.append(Character.toChars(d) );
            } else if (Character.isUpperCase(c)) {
                int e = c + 13;
                if( e >= 91){
                    e -= 26;
                }
                sb.append(Character.toChars(e));
            } else
                sb.append(c);
        }
        System.out.println(sb.toString());

    }
}
