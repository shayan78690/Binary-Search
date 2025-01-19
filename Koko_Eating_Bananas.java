class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxi = findMax(piles);
        int low = 1;
        int high = maxi;
        while(low <= high) {
            int mid = (low + high) / 2;
            int total_hour = calculate_Total_Hour(piles, mid);
            if(total_hour <= h) {
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }
        return low;
    }

    public int calculate_Total_Hour(int piles[], int hourly){
        int total_hour = 0;
        for(int i = 0; i < piles.length; i++) {
            total_hour += Math.ceil((double)(piles[i]) / (double)(hourly));
        }
        return total_hour;
    }
    public int findMax(int piles[]) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }
        return max;
    }
}


// class Solution {
//     public int minEatingSpeed(int[] piles, int h) {
//         int max = maximumElement(piles);
//         for(int i = 1; i <= max; i++) {
//             int reqTime = calculateTotal_Time(piles, i);
//             if(reqTime <= h) {
//                 return i;
//             }
//         }
//         return max;
//     }

//     public int calculateTotal_Time(int piles[], int hourly) {
//         int total_time = 0;
//         for(int i = 0; i < piles.length; i++) {
//             total_time += Math.ceil((double)(piles[i]) / (double)(hourly));
//         }
//         return total_time;
//     }
//     public int maximumElement(int piles[]) {
//         int maxi = Integer.MIN_VALUE;
//         for(int i = 0; i < piles.length; i++) {
//             maxi = Math.max(maxi, piles[i]);
//         }
//         return maxi;
//     }
// }
