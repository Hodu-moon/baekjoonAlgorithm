import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        
        int target = targets[0][1];
        
        for(int i = 0; i < targets.length; i++){
            int start = targets[i][0];
            int end = targets[i][1];
            
            if(target <= start){
                answer++;
                target = end;
                continue;
            }
            
            if(end < target){
                target = end;
            }    
        }
       

        return answer + 1;
    }
}