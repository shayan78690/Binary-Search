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
        int low = min;
        int high = max;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(possible(bloomDay, mid, m, k)) {
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }
        return low;
        
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
            return true;
        } else {
            return false;
        }
    }
}
