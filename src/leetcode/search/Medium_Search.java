package leetcode.search;

/**
 *  leetcode 33
 */
public class Medium_Search {

    public int search(int[] nums, int target) {
        int small = 0, big = nums.length - 1;

        while (small < big){
            int mid = small + ((big - small) >> 1);
            if (nums[mid] > nums[big]){
                small = mid + 1;
            } else {
                big = mid;
            }
        }

        int start = small;
        big = nums.length - 1;
        small = 0;

        while (small <= big){
            int mid = small + ((big - small) >> 1);
            int realMid = (mid + start) % nums.length;
            System.out.println("mid : " + mid);
            System.out.println("big : " + big);
            System.out.println("small : " + small);
            System.out.println("realMid : "+realMid);
            if (nums[realMid] == target){
                return realMid;
            }
            if (nums[realMid] < target){
                small = mid + 1;
            } else {
                big = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Medium_Search demo = new Medium_Search();
        int[] arr = {4,5,6,7,8,0,1,2,3};
        demo.search(arr,0);
    }
}
