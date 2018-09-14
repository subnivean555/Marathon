package leetcode.list;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 *  java 中默认的 PriorityQueue 的实现底层是最小堆
 */
public class Medium_topKFrequent {

    private class Freq implements Comparable<Freq>{
        int e, freq;

        public Freq(int e, int freq){
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq that) {
            if (this.freq < that.freq)
                return -1;
            else if (this.freq == that.freq)
                return 0;
            else
                return 1;
        }
    }

    public List<Integer> topKFrequent(int nums[], int k){
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums){
            if (map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Freq> queue = new PriorityQueue<>();
        for (int key : map.keySet()){
            if (queue.size() < k){
                queue.add(new Freq(key, map.get(key)));
            } else if (map.get(key) > queue.peek().freq){
                queue.remove();
                queue.add(new Freq(key, map.get(key)));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while (!queue.isEmpty()){
            res.add(queue.remove().e);
        }
        return res;
    }
}
