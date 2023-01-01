import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        String user;
        String users[];
        StringBuffer bf = new StringBuffer();
        for(int i = 0; i < num; i++){
            user = scanner.nextLine();
            users = user.split(" ");
            for(int j = 0; j < users.length; j++) {
                bf.append(users[j]);
                System.out.print(bf.reverse()+ " ");
                bf.delete(0, bf.length());
            }
            System.out.println();
        }

    }
}
