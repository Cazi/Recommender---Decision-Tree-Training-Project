package sol;

import src.IAttributeDatum;
import src.ITreeNode;

/**
 * Decision Tree Leaf Class
 */
public class Leaf implements ITreeNode {
    /**
     * field representing the boolean contained in the leaf at the end of the tree
     */
    public boolean value;

    /**
     * Leaf Constructor
     */

    public Leaf() {

    }

    @Override
    public Object lookupDecision(IAttributeDatum iAttributeDatum) {
        return null;
    }

    @Override
    public void printNode(String s) {

    }
}
