
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static int N, personIdx, stairIdx, result;
    static int[] temp;
    static int[][] map;

    static List<Person> movePerson;
    static List<Person> waitingPerson;

    static StringBuilder sb = new StringBuilder();
    static Stair[] stairs;
    static List<Person> persons;

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            stairs = new Stair[2];
            persons = new ArrayList<>();
            result = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            stairIdx = 0;
            personIdx = 0;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                    if (map[i][j] == 1) {
                        Person person = new Person(i, j);
                        persons.add(person);
                        personIdx++;
                    }

                    if (map[i][j] >= 2) {
                        stairs[stairIdx++] = new Stair(i, j, map[i][j]);
                    }
                }

            }

//            printMap();

            // 1. permutation
            permutation(0);

            sb.append("#").append(t).append(" ").append(result + 1).append("\n");
        }

        System.out.println(sb);
    }

    static void permutation(int depth) {
        if (depth == personIdx) {
//            System.out.println("here1");
            solve();

            return;
        }

        for (int i = 0; i < 2; i++) {
            persons.get(depth).stairIdx = i;
            permutation(depth + 1);
        }

    }

    static void solve() {

//		System.out.println("print persons");
        // 초기화 해주고

        for (Stair stair : stairs) {
            stair.init();
        }
        movePerson = new ArrayList<>();
        waitingPerson = new ArrayList<>();

        for (Person person : persons) {
            person.calcRemainMoveTime();

            movePerson.add(person);
//            System.out.println(person);
        }

        int count = 0;
        int time = 0;



        // count != personIdx
        while(count != personIdx) {

            List<Person> tempMove = new ArrayList<>();
            List<Person> tempWait = new ArrayList<>();

            time++;
//            System.out.println("time  : " + time + " count : " + count) ;

            for(Person person : movePerson) {
                person.remainMoveTime--;

                if(person.remainMoveTime == 0) {
                    tempMove.add(person);
                }
            }


            for(Stair stair : stairs) {
                //1. waiting 없고 안에 사람들만 있는 경우
                for(Person person : stair.movingPerson) {
                    person.remainStairTime--;

                    if(person.remainStairTime == 0) {
                        tempWait.add(person);
                        count++;
                        stair.curPerson--;
                    }

//                    System.out.println(person);
                }

            }


            // 계단에 사람 넣기
            for(Person person : tempMove) {
                stairs[person.stairIdx].addPerson(person);
                movePerson.remove(person);
            }

            // 계단에 있는 사람 빼기
            for(Person person : tempWait) {
                stairs[person.stairIdx].movingPerson.remove(person);
            }

            for(Stair stair : stairs) {
                stair.fill();
            }
        }

        result = Math.min(result, time);

    }

    static void printMap() {
        for (int[] xx : map) {
            System.out.println(Arrays.toString(xx));
        }
    }

    static class Person {
        int originX, originY;

        int remainMoveTime, remainStairTime;

        int stairIdx;

        public Person(int originX, int originY) {
            super();
            this.originX = originX;
            this.originY = originY;
        }

        @Override
        public String toString() {
            return "Person [originX=" + originX + ", originY=" + originY + ", remainMoveTime=" + remainMoveTime
                    + ", remainStairTime=" + remainStairTime + ", stairIdx=" + stairIdx + "]";
        }

        void calcRemainMoveTime() {
            this.remainMoveTime = Math.abs(originX - stairs[stairIdx].x) + Math.abs(originY - stairs[stairIdx].y);
            this.remainStairTime = stairs[stairIdx].maxPerson;
        }

    }

    static class Stair {
        int x, y, maxPerson, curPerson;
        Queue<Person> movingPerson;
        Queue<Person> waitingPerson;

        public Stair(int x, int y, int maxPerson) {
            this.x = x;
            this.y = y;
            this.maxPerson = maxPerson;
        }

        public void init() {
            movingPerson = new ArrayDeque<>();
            waitingPerson = new ArrayDeque<>();
        }

        private boolean canMove() {
            return curPerson < 3;
        }

        public void fill() {
            while(curPerson < 3){
                if(waitingPerson.isEmpty()){
                    break;
                }

                Person person = waitingPerson.poll();
                addPerson(person);

            }
        }

        public void addPerson(Person person) {

            if(canMove()) {
                addMovePerson(person);
            }else {
                addWaitingPerson(person);
            }


        }

        private void addMovePerson(Person person ) {
            curPerson++;
            movingPerson.add(person);
        }

        private void addWaitingPerson(Person person) {
            waitingPerson.add(person);
        }


    }
}

//T
//5
//0 1 1 0 0
//0 0 1 0 3
//0 1 0 1 0
//0 0 0 0 0
//1 0 5 0 0