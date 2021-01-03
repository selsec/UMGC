/* CMSC Project 4
 * Date: 12 July 2020
 * Author: Steven Thaw
 * Description: Provides methods to print the graph in a hierarchal style using string builder */


public class Hierarchy<E> implements DFSActionsInterface<E> {

    private final StringBuilder toPrint = new StringBuilder();
    private int indentCounter = 0;

    @Override
    public void ascend() {
        indentCounter -= 4;
    }

    @Override
    public void descend() {
        indentCounter += 4;
    }

    @Override
    public void processVertex(E content) {
        toPrint.append(" ".repeat(Math.max(0, indentCounter)));
        toPrint.append(content).append("\n");
    }

    @Override
    public void cycleDetected() {
        toPrint.setLength(toPrint.length() - 1);
        toPrint.append(" * ").append("\n");

    }

    @Override
    public String toString() {
        return toPrint.toString();
    }
}