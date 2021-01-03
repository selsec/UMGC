/* CMSC 350 Project 3
 * Date: 27 April 2020
 * Author: Steve Thaw
 * Conains code to create a binary tree as well as a nested static class which defines the nodes of the binary tree.
 * Contains methods to build the binary tree and determine if tree is balanced, full, proper, the height of the tree,
 * the number of nodes in the tree, and print the information in the tree using an in order traversal
 */

public class InvalidTreeSyntax extends Exception {

    public InvalidTreeSyntax() {
        super();
    }

    public InvalidTreeSyntax(String errorMessage){
        super(errorMessage);
    }
}