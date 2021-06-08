package src;

/**
 * Decision Tree Leaf Class
 */
public class Leaf implements ITreeNode {
    /**
     * field representing the boolean contained in the leaf??
     */
    public boolean value;

    /**
     * Leaf Constructor
     */

    public Leaf () {

    }
    @Override
    public Object lookupDecision(IAttributeDatum iAttributeDatum) {
        return null;
    }

    @Override
    public void printNode(String s) {

    }
}
