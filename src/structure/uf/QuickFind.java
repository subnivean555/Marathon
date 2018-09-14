package structure.uf;

import java.util.Random;

/**
 * 整体的时间复杂度为 O(n * n)
 */
public class QuickFind {

    private int[] id;
    private int count;

    public QuickFind(int n){
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++){
            id[i] = i;
        }
    }

    public int find(int p){
        return id[p];
    }

    /**
     *  判断是否相连只用将两个下标进行比较即可
     * @param p
     * @param q
     * @return
     */
    public boolean isConnected(int p , int q){
        return find(p) == find(q);
    }

    /**
     *  将 id 数组中所有 下标为 p下标 的节点全部修改为 下标节点为 q 的下标,
     *  时间复杂度度为 O(n)
     * @param p
     * @param q
     */
    public void union(int p, int q){
        int pId = find(p);
        int qId = find(q);

        if (pId == qId)
            return;

        for (int i = 0; i < count; i++){
            if (id[i] == pId)
                id[i] = qId;
        }
    }

    public static void main(String[] args) {
        int n = 100000;
        long start = System.currentTimeMillis();
        QuickFind uf = new QuickFind(n);
        Random rand = new Random();
        for (int i = 0; i < n; i++){
            int a = Math.abs(rand.nextInt() % n);
            int b = Math.abs(rand.nextInt() % n);
            uf.union(a, b);
        }

        for (int i = 0; i < n; i++){
            int a = Math.abs(rand.nextInt() % n);
            int b = Math.abs(rand.nextInt() % n);
            uf.isConnected(a, b);
        }

        System.out.println("run time : " + (System.currentTimeMillis() - start));
    }

}
