class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        for(int d = 1; d <= max; d++) {
            int sum = sum_by_D(nums, d);
            if(sum <= threshold) {
                return d;
            }
         }
         return -1;
    }

    public int sum_by_D(int nums[], int div) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += Math.ceil((double)(nums[i]) / (double)(div));
        }
        return sum;
    }
}
