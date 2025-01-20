class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        long val = (long)m * k;
        if(val > n) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            min = Math.min(bloomDay[i], min);
            max = Math.max(bloomDay[i], max);
        }

        for(int i = min; i <= max; i++) {
            if(possible(bloomDay, i, m, k)) {
                return i;
            } 
        }
        return -1;
    }
    public boolean possible(int bloomDay[], int day, int m, int k) {
        int count = 0;
        int no_of_bouquets = 0;
        for(int i = 0; i < bloomDay.length; i++) {
            if(bloomDay[i] <= day) {
                count++;
            } else {
                no_of_bouquets += count / k;
                count = 0;
            }
        }
        no_of_bouquets += count / k;
        if(no_of_bouquets >= m) {
            return True;
        } else {
            return False;
        }
    }
}
