class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            max = Math.max(weights[i], max);
        }

        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += weights[i];
        }

        int low = max;
        int high = sum;
        while(low <= high) {
            int mid = (low + high) / 2;
            int req_days = calculate_Days(weights, mid);
            if(req_days <= days) {
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }
        return low;
    }

    public int calculate_Days(int weights[], int capacity) {
        int days = 1;
        int load = 0;
        for(int i = 0; i < weights.length; i++) {
            if(load + weights[i] > capacity) {
                days = days + 1;
                load = weights[i];
            } else{
                load += weights[i];
            }
        }
        return days;
    }
}
