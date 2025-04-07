
import java.util.*;

public class Main {
    static List<Meeting> meetingList;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        meetingList = new ArrayList<>();

        for(int i = 0; i < N; i++){
            int start =sc.nextInt();
            int end = sc.nextInt();

            meetingList.add(new Meeting(start, end));

        }

        Collections.sort(meetingList);

        int end = 0;
        int cnt = 0;
        for(Meeting meeting : meetingList){
//            System.out.println(meeting.end);
            if(end <= meeting.start){
                end = meeting.end;
                cnt++;
            }
        }


        System.out.println(cnt);

    }

    static class Meeting implements Comparable<Meeting>{
        int start, end;
        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {

            if(end == o.end){
                return Integer.compare(start, o.start);
            }

            return Integer.compare(end, o.end);
        }
    }
}

//11
//1 4
//3 5
//0 6
//5 7
//3 8
//5 9
//6 10
//8 11
//8 12
//2 13
//12 14
