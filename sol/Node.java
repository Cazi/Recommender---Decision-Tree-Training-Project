package sol;

import src.IAttributeDataset;
import src.IAttributeDatum;
import src.ITreeNode;

import java.util.List;

/**
 * Class representing Node, an implementation of ITreeNode
 */
public class Node implements ITreeNode {

    /**
     * Field representing Node attribute name
     */
    String attribute;
    /**
     * Field representing Node edges
     */
    List<Edge> edges;

    /**
     * Field representing the mostCommonDecision for the current subset
     */
    Object mostCommonDecision;

    /**
     * A constructor for Node
     *
     * @param attribute - String representing Node attribute name
     */
    public Node(String attribute, Object mostCommDecision) {
        this.attribute = attribute;
        /*
         List of edges should be added through a method, since the node doesn't always have that list when the node
         is being constructed.
         */
        this.edges = null;

        /*
        In order to set the field for mostCommonDecision, we need to keep track of the value of the given attribute
        for each datum, probably by counting the objects as we encounter them. We then set the mCD field equal to
        whichever object we've found to be the most common.
         */

    }

    @Override
    public Object lookupDecision(IAttributeDatum datum) {
        return null;
    }

    @Override
    public void printNode(String leadSpace) {
    }
}