package sol;

import src.IAttributeDatum;
import src.ITreeNode;

/**
 * Class representing Leaf, an implementation of ITreeNode
 */

public class Leaf implements ITreeNode {
    /**
     * Field representing final decision
     */
    Object decision;

    /**
     * A constructor for Leaf
     *
     * @param decision - Object representing final decision
     */
    public Leaf(Object decision) {
        this.decision = decision;
    }

    @Override
    public Object lookupDecision(IAttributeDatum datum) {
        return null;
    }

    @Override
    public void printNode(String leadSpace){ }
}