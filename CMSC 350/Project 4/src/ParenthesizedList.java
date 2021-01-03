/* CMSC Project 4
 * Date: 12 July 2020
 * Author: Steven Thaw
 * Description: Provides methods required to print the graph in a parenthesized list using string builder */



public class ParenthesizedList<E> implements DFSActionsInterface<E> {

    private final StringBuilder stringBuild = new StringBuilder();

    @Override
    public void cycleDetected() {
        stringBuild.append(" * ");
    }

    @Override
    public void processVertex(E content) {
        stringBuild.append(content);
    }

    @Override
    public void descend() {
        stringBuild.append(" ( ");
    }

    @Override
    public void ascend() {
        stringBuild.append(" ) ");
    }

    @Override
    public String toString() {
        String replaceString = stringBuild.toString();
        return replaceString.replace(" (  )", "").replace("(  *  )", " * ");
    }

}