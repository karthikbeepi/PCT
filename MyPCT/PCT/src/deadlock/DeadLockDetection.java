package deadlock;

import java.util.*;

/**
 * Created by ERIC_LAI on 2017-06-17.
 */
public class DeadLockDetection {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Graph.Vertex> graph = Graph.graph;

        int lineNum = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < lineNum; i++) {
            // read and extract data
            String[] data = scanner.nextLine().split("\\s+");
            int processId = Integer.parseInt(data[0]);
            int holdResId = Integer.parseInt(data[1]);
            int wantResId = Integer.parseInt(data[2]);

            // get the vertex, if id is -1, the corresponding
            // vertex will be null
            Graph.Vertex pv = getVertex(processId);
            assert pv != null;
            graph.put(processId, pv);
            Graph.Vertex hv = getVertex(holdResId);
            Graph.Vertex wv = getVertex(wantResId);

            // connect the vertices with edges
            if (hv != null) {
                graph.put(holdResId, hv);
                Graph.Edge edge = new Graph.Edge(pv);
                hv.addEdges(edge);
            }
            if (wv != null) {
                graph.put(wantResId, wv);
                Graph.Edge edge = new Graph.Edge(wv);
                pv.addEdges(edge);
            }
        }// end of for loop (reading data)

        HashSet<Graph.Vertex> visited = new HashSet<>(graph.size());
        Stack<Graph.Vertex> dfcStack = new Stack<>();
        Stack<Graph.Vertex> cycleStack = new Stack<>();


        for (Graph.Vertex v : graph.values()) {
            // if current vertex has been visited, check the next one
            if (visited.contains(v)) continue;
            dfcStack.add(v);
            visited.add(v);
            cycleStack.clear();
            while (!dfcStack.isEmpty()) {
                Graph.Vertex curV = dfcStack.pop();
                ArrayList<Graph.Edge> edges = curV.getEdges();

                // loop all the reachable vertices
                for (int i = edges.size() - 1; i >= 0; i--) {
                    Graph.Vertex newV = edges.get(i).to;

                    // if there is a cycle
                    if (cycleStack.contains(newV)) {
                        System.out.println("YES");

                        // print out the cycle
                        for (Graph.Vertex _v : cycleStack) {
                            System.out.print(_v.id + "->");
                        }
                        System.out.print(newV.id);

                        System.exit(0);
                    }

                    // otherwise, continue
                    dfcStack.add(newV);
                    cycleStack.add(newV);
                    visited.add(newV);
                }
            }

        }// end of for loop (using DFS to check cycles)

        System.out.println("NO");
        scanner.close();
    }// end of main

    private static Graph.Vertex getVertex(int id) {
        if (id == -1) return null;
        Graph.Vertex v;
        if (Graph.graph.containsKey(id)) {
            v = Graph.graph.get(id);
        } else {
            v = new Graph.Vertex(id);
        }
        return v;
    }
}
