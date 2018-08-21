package problems;

import java.util.*;

public class FindLongestSt {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int row = scanner.nextInt();
            Map<String, Integer> vertex = new HashMap<>();

            Map<String, List<String>> graph = new HashMap<>();

            for (int i = 0; i < row; i++) {
                String a = scanner.next();
                String b = scanner.next();

                if (!vertex.containsKey(a)) {
                    vertex.put(a, 1);
                }
                if (!vertex.containsKey(b)) {
                    vertex.put(b, 1);
                }

                List<String> list = graph.get(a);
                if (list == null) {
                    list = new ArrayList<>();
                    graph.put(a, list);
                }

                list.add(b);
                visitAll(a, b, vertex, graph);
            }

            int max = 0;
            for (Integer val : vertex.values()) {
                if (val > max) {
                    max = val;
                }
            }
            System.out.println(max);
        }
    }

    private static void visitAll(String a, String b, Map<String, Integer> vertex, Map<String, List<String>> graph) {
        int val = vertex.get(b);
        int t = vertex.get(a) + 1;
        if (val < t) {
            vertex.put(b, t);
            List<String> list = graph.get(b);
            if (list != null) {
                for (String s : list) {
                    visitAll(b, s, vertex, graph);
                }
            }
        }
    }
}
