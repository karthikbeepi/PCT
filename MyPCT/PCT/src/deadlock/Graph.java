package deadlock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ERIC_LAI on 2017-06-17.
 */
class Graph {

    static HashMap<Integer, Vertex> graph = new HashMap<Integer, Vertex>();

    static class Vertex {
        int id;
        ArrayList<Edge> edges = new ArrayList<>();

        Vertex(int id) {
            this.id = id;
        }

        ArrayList<Edge> getEdges() {
            return edges;
        }

        void addEdges(Edge edge) {
            this.edges.add(edge);
        }
    }

    static class Edge {
        Vertex to;

        Edge(Vertex to) {
            this.to = to;
        }
    }
    
}
