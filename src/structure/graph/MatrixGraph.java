package structure.graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 *
 *  使用邻接矩阵实现一个图
 *
 *
 */
public class MatrixGraph implements Graph{

    private int V;
    private int E;
    private Graph.GraphType type;
    private float[][] matrix;

    public MatrixGraph(Graph.GraphType type){
        this.type = type;
    }

    public MatrixGraph(){
        this.type = GraphType.undirected;
    }


    @Override
    public void initialize(int v, int e) {
        this.V = v;
        this.E = e;
        this.matrix = new float[v][v];
        for (int i = 0; i < v; i++){
            for (int j = 0; j < v; j++){
                this.matrix[i][j] = INFINITY;
            }
        }
    }

    @Override
    public void createGraph(String fileName) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();
            int v = Integer.parseInt(line.split(" ")[0]);
            int e = Integer.parseInt(line.split(" ")[1]);
            this.initialize(v, e);

            while ((line = br.readLine()) != null){
                String[] args = line.split(" ");
                int v1 = Integer.parseInt(args[0]);
                int v2 = Integer.parseInt(args[1]);
                int weight = Integer.parseInt(args[2]);
                this.matrix[v1][v2] = weight;
                if (type == GraphType.undirected){
                    this.matrix[v2][v1] = weight;
                }
            }
            br.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public void print() {
        System.out.println("V : " + this.getV());
        System.out.println("E : " + this.getE());
        for (int i = 0; i < this.getV(); i++){
            for (int j = 0; j < this.getV(); j++){
                if (matrix[i][j] != INFINITY){
                    System.out.println(i + " " + j + " " + this.matrix[i][j]);
                }
            }
        }
    }

    @Override
    public int getV() {
        return this.V;
    }

    @Override
    public int getE() {
        return this.E;
    }

    @Override
    public int degree(int v) {
        int count = 0;
        for (int i = 0; i < this.getV(); i++){
            if (this.matrix[v][i] != INFINITY){
                count++;
            }
        }
        return count;
    }

    @Override
    public int maxDegree() {
        int max = 0;
        for (int i = 0; i < this.getV(); i++){
            int degree = this.degree(i);
            if (max < degree){
                max = degree;
            }
        }
        return max;
    }

    @Override
    public float weight(int v1, int v2) {
        return matrix[v1][v2];
    }

    @Override
    public boolean isAdjacent(int v1, int v2) {
        return weight(v1, v2) != INFINITY;
    }

    @Override
    public void dfs(int v) {
        boolean[] mark = new boolean[this.getV()];
        this.dfsMethod(v, mark);
    }

    private void dfsMethod(int v, boolean[] mark) {
        mark[v] = true;
        for (int i = 0; i < this.getV(); i++){
            if (isAdjacent(v, i) && !mark[i]){
                mark[i] = true;
                dfsMethod(i, mark);
                System.out.println(i + " ");
            }
        }
    }

    @Override
    public void bfs(int v) {
        boolean[] visited = new boolean[this.getV()];
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(v);
        visited[v] = true;
        while (!queue.isEmpty()){
            int d = queue.remove();
            for (int i = 0; i < this.getV(); i++){
                visited[i] = true;
                System.out.println(i + " ");
                queue.add(i);
            }
        }
    }

    @Override
    public float shortestPath(int s, int t) {

        return 0;
    }
}
