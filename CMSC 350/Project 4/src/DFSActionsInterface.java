/* CMSC Project 4
 * Date: 12 July 2020
 * Author: Steven Thaw
 * Description: An interface which has required methods for depth first search implemented by ParenthesizedList and Hierarchy.
 */


public interface DFSActionsInterface<E> {

    void ascend();

    void descend();

    void processVertex(E content);

    void cycleDetected();
}