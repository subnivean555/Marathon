package algoAndStructure.graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class AdjcentGraph implements Graph {

    private int V;
    private int E;
    private ArrayList<ArrayList<Node>> adjcent;
    private Graph.GraphType type;

    private class Node{
        Integer vertex;
        float weight;
        public Node(Integer v , float w){
            this.vertex = v;
            this.weight = w;
        }
    }

    public AdjcentGraph(GraphType type){
        this.type = type;
    }

    public AdjcentGraph(){
        this.type = GraphType.undirected;
    }

    @Override
    public void initialize(int v, int e) {
        this.V = v;
        this.E = e;
        this.adjcent = new ArrayList<>(v);
        for (int i = 0; i < v; i++){
            ArrayList<Node> line = new ArrayList<>();
            adjcent.add(line);
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
                this.adjcent.get(v1).add(new Node(v2, weight));
                if (type == GraphType.undirected){
                    this.adjcent.get(v2).add(new Node(v1, weight));
                }
            }
            br.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public void print() {
        System.out.println("V : " + getV());
        System.out.println("E : " + getE());
        for (int i = 0; i < this.getV(); i++){
            for (int j = 0; j < this.getV(); j++) {
                System.out.println(i + " " + this.adjcent.get(i).get(j).vertex + " " + this.adjcent.get(i).get(j).weight);
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
        return adjcent.get(v).size();
    }

    @Override
    public int maxDegree() {
        int max = 0;
        for (int i = 0; i < this.getV(); i++){
            if (max < this.adjcent.get(i).size()){
                max = this.adjcent.get(i).size();
            }
        }
        return max;
    }

    @Override
    public float weight(int v1, int v2) {
        for (Node node : adjcent.get(v1)){
            if (node.vertex == v2){
                return node.weight;
            }
        }
        return INFINITY;
    }

    @Override
    public boolean isAdjacent(int v1, int v2) {
        ArrayList<Node> nodeList = adjcent.get(v1);
        for (Node node : nodeList){
            if (node.vertex == v2){
                return true;
            }
        }
        return false;
    }

    @Override
    public void dfs(int v) {
        boolean[] visited = new boolean[this.getV()];
        dfsMethod(v, visited);
    }

    private void dfsMethod(int v, boolean[] mark) {
        mark[v] = true;
        adjcent.get(v).stream().filter(node -> !mark[node.vertex]).forEach(node -> {
            System.out.println(node.vertex + " ");
            dfsMethod(node.vertex, mark);
        });
    }

    @Override
    public void bfs(int v) {
        boolean[] visited = new boolean[this.getV()];
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(v);
        visited[v] = true;
        while (!queue.isEmpty()){
            int d = queue.remove();
            adjcent.get(d).stream().filter(node -> !visited[node.vertex]).forEach(node -> {
                visited[node.vertex] = true;
                System.out.println(node.vertex + " ");
                queue.add(node.vertex);
            });
        }
    }

    @Override
    public float shortestPath(int s, int t) {
        return 0;
    }



}
