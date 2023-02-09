
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static boolean isNumeric(String user){
        try{
            Double.parseDouble(user);
            return true;

        }catch (Exception e){
            return false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-|+",true);

        double sum = 0;

        boolean minus = false;


        sum += Double.parseDouble(st.nextToken());

        while (st.hasMoreTokens()){
            String user = st.nextToken();

            if(user.equals("-")){
                if(!minus){
                    minus = !minus;
                }
            }

            if (isNumeric(user)){
                if(!minus){
                    sum+= Integer.parseInt(user);
                }else {
                    sum-= Integer.parseInt(user);
                }
            }

        }
        System.out.println((int)sum);

    }

}

