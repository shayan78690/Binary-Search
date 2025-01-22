class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < stalls.length; i++) {
            max = Math.max(stalls[i], max);
            min = Math.min(stalls[i], min);
        }
        for(int d = 1; d <= (max-min); d++) {
            if(can_We_Place(stalls, d, k)) {
                continue;
            } else{
                return d-1;
            }
        }
        return -1;
    }
    public static boolean can_We_Place(int stalls[], int distance, int k) {
        int count_of_cows = 1;
        int last_cow = stalls[0];
        for(int i = 1; i < stalls.length; i++) {
            if((stalls[i] - last_cow) >= distance) {
                count_of_cows++;
                last_cow = stalls[i];
            }
            if(count_of_cows >= cows) {
                return true;
            }
        }
        return false;
    }
}
