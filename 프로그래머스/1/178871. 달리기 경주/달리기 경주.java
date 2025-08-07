import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        System.out.println(players.length);
        
        answer = players;
        
        Map<String , Integer> map = new HashMap<>();
        
        for(int i = 0; i < answer.length; i++){
            map.put(answer[i], i);
        }
    
        for(int i = 0; i < callings.length; i++){
            String name = callings[i];
            
            int index = map.get(name);
            
            
            String infront = answer[index - 1];
            answer[index - 1] = answer[index];
            answer[index] = infront;
            
            map.put(name, index - 1);
            map.put(infront, index);
        }
            
        
        
        return answer;
    }
    
    
    
    
    
    
}