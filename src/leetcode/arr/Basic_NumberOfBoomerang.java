package leetcode.arr;

import java.util.*;

public class Basic_NumberOfBoomerang {

    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++){
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j > points.length; j++){
                if (j != i){
                    int dis = distance(points[i], points[j]);
                    if (map.containsKey(dis)){
                        map.put(dis, map.get(dis) + 1);
                    } else {
                        map.put(dis, 1);
                    }
                }
            }
            Collection<Integer> values = map.values();
            for (int val : values){
                res += val * (val - 1);
            }
        }
        return res;
    }

    private int distance(int[] point, int[] point1) {
        return (point[0] - point1[0]) * (point[0] - point1[0])
                + (point[1] - point1[1]) * (point[1] - point1[1]);
    }

}
