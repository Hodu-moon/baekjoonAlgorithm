import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Map<String,String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            String input = sc.nextLine();
            String[] split = input.split(" ");

            if(split[1].equals("enter")){
                set.add(split[0]);
            }else
                set.remove(split[0]);
        }

        String[] members = set.toArray(new String[0]);
        Arrays.sort(members, (a, b) -> a.compareTo(b) * - 1 );

        for(String s : members){
            System.out.println(s);
        }
    }
}
