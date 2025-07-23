class Solution {
    private static final int LIMIT = 10_000_000;

    public int[] solution(long begin, long end) {
        long lenLong = end - begin + 1;
        int len = (int) lenLong; 

        int[] answer = new int[len];

        for (int idx = 0; idx < len; idx++) {
            long n = begin + idx;
            answer[idx] = getBlock(n);
        }

        return answer;
    }

    static int getBlock(long n) {
        if (n == 1) return 0;

        int candidate = 1;

        long sqrt = (long) Math.sqrt(n);
        for (long i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                long pair = n / i; 

                if (pair <= LIMIT) {
                    return (int) pair;
                }

                if (i <= LIMIT) {
                    candidate = (int) i;
                }
            }
        }

        return candidate;
    }
}
