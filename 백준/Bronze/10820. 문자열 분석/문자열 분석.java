
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String user;
        while((user = br.readLine()) != null){
            int small=0, capital=0, num=0, space=0;

            for(int i = 0; i < user.length(); i++){
                char c = user.charAt(i);
                if(Character.isLowerCase(c)){
                    small++;
                } else if (Character.isUpperCase(c)) {
                    capital++;
                } else if (Character.isDigit(c)) {
                    num++;
                } else if (Character.isSpaceChar(c)) {
                    space++;
                }
            }

            sb.append(small);
            sb.append(' ');
            sb.append(capital);
            sb.append(' ');
            sb.append(num);
            sb.append(' ');
            sb.append(space);
            sb.append(" \n");

        }
        System.out.println(sb.toString());
    }
}
