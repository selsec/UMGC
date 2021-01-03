/* CMSC 350 Project 3
 * Date: 27 April 2020
 * Author: Steve Thaw
 * Conains code to create a binary tree as well as a nested static class which defines the nodes of the binary tree.
 * Contains methods to build the binary tree and determine if tree is balanced, full, proper, the height of the tree,
 * the number of nodes in the tree, and print the information in the tree using an in order traversal
 */

import java.util.*;

public class BinaryTree {

    //nested class to define nodes of binary tree
    public static class Node {
        //class variables
        private String info;
        private Node left;
        private Node right;

        //constructor for node class
        public Node(String info) {
            this.info = info;
        }

        //method to add child
        private void addChild(Node child) throws InvalidTreeSyntax {
            if (this.left == null) {
                this.setLeft(child);
            } else if (this.right == null) {
                this.setRight(child);
            } else {
                throw new InvalidTreeSyntax("Only two children per node in a Binary Tree");
            }
        }

        //method to set left node
        private void setLeft(Node newLeft) {
            left = newLeft;
        }

        //method to set right node
        private void setRight(Node newRight) {
            right = newRight;
        }

        //overridden toString method
        @Override
        public String toString() {
            return toString(this);
        }

        //overridden recursive toString method
        private static String toString(Node root) {
            return (root == null) ? "" : "(" + root.info  + toString(root.left) + toString(root.right) + ")";
        }
    }

    //binary tree class variables
    Node parent;
    Node child;

    //constructor for binary tree
    public BinaryTree(String input) throws InvalidTreeSyntax {
        Stack<Node> nodeStack = new Stack<>();
        String[] inputArray = input.substring(1, input.length()-1).split("(?<=\\()|(?=\\()|(?<=\\))|(?=\\))");
        parent = new Node(inputArray[0]);

        for (int i = 1; i < inputArray.length - 1; i++) {
            if (inputArray[i].equals("(")) {
                nodeStack.push(parent);
                if (child != null) {
                    parent = child;
                }
            } else if(inputArray[i].equals(")")) {
                try {
                    child = parent; parent = nodeStack.pop();
                } catch (EmptyStackException emptyStack){ throw new InvalidTreeSyntax("Incorrect parenthesis"); }
            } else {
                child = new Node(inputArray[i]);
                if (parent != null) {
                    parent.addChild(child);
                }
            }
        }

        if (this.recursiveNumNodes(parent) * 3 != input.length()) {
            throw new InvalidTreeSyntax("Incorrect Syntax");
        }
    }

    //public method to determine if tree is balanced. calls recursive method recIsBalanced
    public boolean isBalanced() {
        return recursiveIsBalanced(this.parent);
    }

    //private recursive method to determine if tree is balanced
    private boolean recursiveIsBalanced(Node root){
        if (root == null) {
            return true;
        }
        return (Math.abs(recursiveHeight(root.left) - recursiveHeight(root.right)) <= 1) && (recursiveIsBalanced(root.left) && recursiveIsBalanced(root.right));
    }

    //public method to determine if the tree is full
    public boolean isFull() {
        return recursiveIsFull(this.parent, recursiveHeight(this.parent), 0);
    }

    //private recursive method to determine if tree is full
    private boolean recursiveIsFull(Node root, int height, int index) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return (height == index + 1);
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        return recursiveIsFull(root.left, height, index+1) && recursiveIsFull(root.right, height, index+1);

    }

    //public method to determine if tree is proper
    public boolean isProper() {
        return recursiveIsProper(this.parent);
    }

    //private recursive method to determine if tree is proper
    private boolean recursiveIsProper(Node root) {
        if(root == null) {
            return true;
        }
        return ((root.left != null || root.right == null) && (root.left == null || root.right != null)) && (recursiveIsProper(root.left) && recursiveIsProper(root.right));
    }

    //public method to determine height
    public int height() {
        return recursiveHeight(this.parent)-1;
    }

    //private recursive method to determine height
    private int recursiveHeight(Node root) {
        return (root == null) ? 0 : 1 + Math.max(recursiveHeight(root.left), recursiveHeight(root.right));
        }

    //public method to determine number of nodes
    public int numNodes() {
        return recursiveNumNodes(this.parent);
    }

    //private recursive method to determine number of nodes
    private int recursiveNumNodes(Node root) {
        return (root == null) ? 0 : 1 + recursiveNumNodes(root.left) + recursiveNumNodes(root.right);
    }

    //public method to print nodes via inorder traversal
    public String inOrder() {
        return recursiveInOrder(this.parent);
    }

    //private recursive method to print nodes via inorder traversal
    private String recursiveInOrder(Node root) {
        return (root == null) ? "" : "("  + recursiveInOrder(root.left) + root.info  + recursiveInOrder(root.right) + ")";
    }

    //toString method
    @Override
    public String toString() {
        return parent.toString();
    }


}