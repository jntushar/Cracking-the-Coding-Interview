package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

enum State{
    UNVISITED, VISITED, VISITING;
}

class Node{
    public State state;
    private List<Node> adjacent;
    private String vertex;

    public Node(String vertex){
        this.vertex = vertex;
        adjacent = new ArrayList<>();
    }

    public void addAdjacent(Node node){
        adjacent.add(node);
    }

    public List<Node> getAdjacent(){
        return adjacent;
    }

    public String getVertex(){
        return vertex;
    }
}

class Graph{
    private List<Node> vertices;

    public Graph(){
        vertices = new ArrayList<>();
    }

    public void addNode(Node node){
        vertices.add(node);
    }

    public List<Node> getNodes(){
        return vertices;
    }
}

public class RouteBetweenNodes {
    public static void main(String[] args) {
        Graph graph = createNewGraph();
        List<Node> nodes = graph.getNodes();
        Node source = nodes.get(3);
        Node destination = nodes.get(5);
        System.out.println(search(graph, source, destination));
    }

    public static Graph createNewGraph(){
        Graph graph = new Graph();
        Node[] temp = new Node[6];

        temp[0] = new Node("a");
        temp[1] = new Node("b");
        temp[2] = new Node("c");
        temp[3] = new Node("d");
        temp[4] = new Node("e");
        temp[5] = new Node("f");

        temp[0].addAdjacent(temp[1]);
        temp[0].addAdjacent(temp[2]);
        temp[0].addAdjacent(temp[3]);
        temp[3].addAdjacent(temp[4]);
        temp[4].addAdjacent(temp[5]);

        for (Node node : temp) {
            graph.addNode(node);
        }
        return graph;
    }


    public static boolean search(Graph graph, Node source, Node destination){
        if(source == destination) return true;

        // operates as queue
        LinkedList<Node> queue = new LinkedList<Node>();
        for(Node node: graph.getNodes()){
            node.state = State.UNVISITED;
        }

        source.state = State.VISITING;
        queue.add(source);
        Node n;
        while (!queue.isEmpty()){
            n = queue.removeFirst();
            if(n != null) {
                for(Node v: n.getAdjacent()){
                    if(v.state == State.UNVISITED){
                        if(v == destination){
                            return true;
                        }else {
                            v.state = State.VISITING;
                            queue.add(v);
                        }
                    }
                }
                n.state = State.VISITED;
            }
        }
        return false;
    }
}
