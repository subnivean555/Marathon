package leetcode.math;

import java.util.ArrayList;
import java.util.List;

public class Basic_Generate {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list;
        int[][] arr = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++){
            for (int j = 0; j < numRows; j++){
                if (j == 0 || i == j){
                    arr[i][j] = 1;
                } else if (i - 1 > 0 && j - 1 >= 0){
                  arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                }
            }
        }

        for (int i = 0; i < numRows; i++){
            list = new ArrayList<>();
            for (int j = 0; j <= i; j++){
                list.add(arr[i][j]);
            }
            lists.add(list);
        }

        return lists;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = generate(5);


    }

}
