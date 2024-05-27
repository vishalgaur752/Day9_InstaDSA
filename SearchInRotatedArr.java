public class SearchInRotatedArr {
    public static boolean searchRotatedArr(int nums[], int target) {
        //time complexity : O(log n)
        int start = 0;
        int end  = nums.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(nums[mid] == target) {
                return true;
            }
            if(nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
            } else if(nums[start] <= nums[mid]) {
                if(nums[start] <= target && target <= nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if(nums[mid] <= target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid-1;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int nums[] = {2, 5, 6, 0, 0, 1, 2};
        int target = 2;
        System.out.println(searchRotatedArr(nums, target));
    }
}