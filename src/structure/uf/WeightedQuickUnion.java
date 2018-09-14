package structure.uf;

import java.util.Random;

public class WeightedQuickUnion {

    private int[] parent;
    private int[] size;
    private int count;

    public WeightedQuickUnion(int n){
        count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int p){
        while (p != parent[p]){
            p = parent[p];
        }
        return p;
    }

    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }

    /**
     *  使用 size 数组记录已经连接到节点上的数量
     *  在合并时, 将 size 小的合并到 size 大的节点中
     * @param p
     * @param q
     */
    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot){
            return;
        }
        if (size[pRoot] < size[qRoot]){
            parent[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        } else {
            parent[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
    }


    public static void main(String[] args) {
        int n = 1000000;
        long start = System.currentTimeMillis();

        WeightedQuickUnion uf = new WeightedQuickUnion(n);

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
