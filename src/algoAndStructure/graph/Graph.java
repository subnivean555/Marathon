package algoAndStructure.graph;

import java.io.IOException;

public interface Graph {

    float INFINITY = Float.MIN_VALUE;

    enum GraphType{
        directed, undirected
    }

    void initialize(int v, int e);
    void createGraph(String fileName) throws IOException;
    void print();
    int getV();
    int getE();
    int degree(int v);
    int maxDegree();
    float weight(int v1, int v2);
    boolean isAdjacent(int v1, int v2);
    void dfs(int v);
    void bfs(int v);
    float shortestPath(int s, int t);
}
