import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Map<String, Integer> map = new HashMap<>();

        int max = 0;
        for(int i = 0; i < n; i++){
            String input = sc.nextLine();
            map.put(input, map.getOrDefault(input, 0) + 1);
            max = Math.max(max, map.get(input));
        }

        List<String> list = new ArrayList<>();

        for( Map.Entry<String,Integer> entrySet: map.entrySet()){
                if(entrySet.getValue() == max) 
                    list.add(entrySet.getKey());
                
        }

        Collections.sort(list);

        System.out.println(list.get(0));

        



    }
}
