class Solution {
    public int findKRotation(List<Integer> arr) {
        int low = 0;
        int high = arr.size() - 1;
        int ans = Integer.MAX_VALUE; // This variable is unnecessary but kept for simplicity.
        int index = -1;

        while (low <= high) {
            // If the subarray is already sorted
            if (arr.get(low) <= arr.get(high)) {
                if (arr.get(low) < ans) {
                    index = low;
                    ans = arr.get(low);
                }
                break;
            }

            int mid = (low + high) / 2;

            // Update the minimum element and its index
            if (arr.get(mid) < ans) {
                ans = arr.get(mid);
                index = mid;
            }

            // Decide which part to explore next
            if (arr.get(mid) >= arr.get(low)) {
                // Left part is sorted, go right
                low = mid + 1;
            } else {
                // Right part is sorted, go left
                high = mid - 1;
            }
        }

        return index;
    }
}
