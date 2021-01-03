/* CMSC Project 4
 * Date: 12 July 2020
 * Author: Steven Thaw
 * Description: Builds a graph from the input file */


import java.util.*;

public class DirectedGraph<E> {

    //class variables
    private Vertex<E> firstVertex;
    private enum Marks {UNDISCOVERED, DISCOVERED, FINISHED}

    //nested class for verticies
    private static class Vertex<E> {

        private final E element;
        private Edge<E> firstEdge;
        private Vertex<E> nextVertex;
        private Marks mark;


        public Vertex(E label) {
            element = label;
            mark = Marks.UNDISCOVERED;
        }

        public boolean hasNext() {
            return (nextVertex != null);
        }

        public Vertex<E> next() {
            return nextVertex;
        }

    }

    //nested class for edges
    private static class Edge<E> {

        private final Vertex<E> vertex;
        private Edge<E> nextEdge;

        public Edge(Vertex<E> v) {
            vertex = v;
        }

        public Edge<E> next() {
            return nextEdge;
        }

        public boolean hasNext() {
            return (nextEdge != null);
        }

        public String toString() {
            return vertex.element.toString();
        }
    }

    //method to create an edge between verticies. will create the vertex if it doesn't exist
    public void createEdge(E from, E to) {
        Vertex<E> fromVertex = findAddVertex(from);
        Vertex<E> toVertex = findAddVertex(to);

        if (fromVertex.firstEdge == null) {
            fromVertex.firstEdge = new Edge<>(toVertex);
        } else {
            Edge<E> currentEdge = fromVertex.firstEdge;
            while (currentEdge.hasNext()) {
                currentEdge = currentEdge.next();
            }
            currentEdge.nextEdge = new Edge<>(toVertex);
        }
    }

    //method to find a vertex or create it if vertex does not exist
    public Vertex<E> findAddVertex(E value) {
        if (firstVertex == null) {
            return firstVertex = new Vertex<>(value);
        }
        Vertex<E> current = firstVertex;
        while (current.hasNext()) {
            if (Objects.equals(current.element, value)) {
                return current;
            }
            current = current.next();
        }
        //if the vertex doesn't exist, create it
        return current.nextVertex = new Vertex<>(value);
    }

    //method to mark all verticies as undiscovered
    private void markUndiscovered(Vertex<E> firstVertex) {
        firstVertex.mark = Marks.UNDISCOVERED;
        Vertex<E> currentVertex = firstVertex;
        while (currentVertex != null) {
            if (currentVertex.firstEdge != null) {
                currentVertex.mark = Marks.UNDISCOVERED;
                Edge<E> currentEdge = currentVertex.firstEdge;
                currentEdge.vertex.mark = Marks.UNDISCOVERED;
                while (currentEdge.hasNext()) {
                    currentEdge.next().vertex.mark = Marks.UNDISCOVERED;
                    currentEdge = currentEdge.next();
                }
            }
            currentVertex = currentVertex.next();
        }
    }

    //recursive method to perform depth first search
    private void depthFirstSearch(Vertex<E> vertex, DFSActionsInterface<E> actions) {

        if (vertex.mark == Marks.DISCOVERED) {
            actions.cycleDetected();
            return;
        }
        actions.processVertex(vertex.element);
        vertex.mark = Marks.DISCOVERED;
        actions.descend();
        if (vertex.firstEdge != null) {
            Edge<E> currentEdge = vertex.firstEdge;
            depthFirstSearch(currentEdge.vertex, actions);
            while (currentEdge.hasNext()) {
                depthFirstSearch(currentEdge.next().vertex, actions);
                currentEdge = currentEdge.next();
            }
        }
        actions.ascend();
        vertex.mark = Marks.FINISHED;
    }

    //method which marks all verticies as undiscovered and then performs a depth first search
    public void performDFS(DFSActionsInterface<E> actions) {
        markUndiscovered(this.firstVertex);
        depthFirstSearch(this.firstVertex, actions);
    }

    //method to print all undiscovered verticies
    public String unreachable() {
        String out = "";
        Vertex<E> currentVertex = firstVertex;
        while (currentVertex != null) {
            if (currentVertex.firstEdge != null) {
                if (currentVertex.mark == Marks.UNDISCOVERED) {
                    out += currentVertex.element + " is unreachable";
                    currentVertex.mark = Marks.DISCOVERED;
                }
                Edge<E> currentEdge = currentVertex.firstEdge;
                while (currentEdge.hasNext()) {
                    if ((currentEdge.next().vertex.mark == Marks.UNDISCOVERED)) {
                        out += currentEdge.next().vertex.element + " is unreachable";
                        currentEdge.next().vertex.mark = Marks.DISCOVERED;
                    }
                    currentEdge = currentEdge.next();
                }
            }
            currentVertex = currentVertex.next();
        }
        return out;
    }

    //toString method to print all verticies and edges
    @Override
    public String toString() {
        StringBuilder stringBuild = new StringBuilder();
        stringBuild.append("All Vertices:\n");
        Vertex<E> currentVertex = firstVertex;
        while (currentVertex != null) {
            if (currentVertex.firstEdge != null) {
                stringBuild.append(currentVertex.element).append(": ");
                Edge<E> currentEdge = currentVertex.firstEdge;
                stringBuild.append(currentEdge).append(" ");
                while (currentEdge.hasNext()) {
                    stringBuild.append(currentEdge.next()).append(" ");
                    currentEdge = currentEdge.next();
                }
                stringBuild.append('\n');
            }
            currentVertex = currentVertex.next();
        }
        return stringBuild.toString();
    }
}