package leetcode.arr;

public class Medium_MaxArea {

    public int maxArea(int[] height) {

        int i = 0, j = height.length - 1;
        int max = 0;

        while (i != j){
            int currH = Math.min(height[i], height[j]);
            int fill = currH * (j - i);

            max = Math.max(max, fill);

            if (height[i] > height[j]){
                j--;
            } else {
                i++;
            }
        }


        return max;
    }

}
