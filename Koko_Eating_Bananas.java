class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = maximumElement(piles);
        for(int i = 1; i <= max; i++) {
            int reqTime = calculateTotal_Time(piles, i);
            if(reqTime <= h) {
                return i;
            }
        }
        return max;
    }

    public int calculateTotal_Time(int piles[], int hourly) {
        int total_time = 0;
        for(int i = 0; i < piles.length; i++) {
            total_time += Math.ceil((double)(piles[i]) / (double)(hourly));
        }
        return total_time;
    }
    public int maximumElement(int piles[]) {
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < piles.length; i++) {
            maxi = Math.max(maxi, piles[i]);
        }
        return maxi;
    }
}
