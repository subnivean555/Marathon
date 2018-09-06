package algoAndStructure.uf;

import java.util.Random;

public class QuickUnion {

    private int[] parent;
    private int count;

    public QuickUnion(int n){
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++){
            parent[i] = i;
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
     *  在连接时, 只要将
     * @param p
     * @param q
     */
    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot){
            return;
        }
        parent[pRoot] = qRoot;
    }


    public static void main(String[] args) {
        int n = 100000;
        long start = System.currentTimeMillis();
        QuickUnion uf = new QuickUnion(n);
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
