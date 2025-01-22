class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < stalls.length; i++) {
            max = Math.max(stalls[i], max);
            min = Math.min(stalls[i], min);
        }
        int low = 0;
        int high = max-min;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(can_We_Place(stalls, mid, k)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
        
    }
    public static boolean can_We_Place(int stalls[], int distance, int k) {
        int count_of_cows = 1;
        int last_cow = stalls[0];
        for(int i = 1; i < stalls.length; i++) {
            if((stalls[i] - last_cow) >= distance) {
                count_of_cows++;
                last_cow = stalls[i];
            }
            if(count_of_cows >= k) {
                return true;
            }
        }
        return false;
    }
}
