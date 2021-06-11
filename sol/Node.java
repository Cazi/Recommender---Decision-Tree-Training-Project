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
     * A constructor for Node
     *
     * @param attribute - String representing Node attribute name
     * @param edges     -  List representing Node edges
     */
    public Node(String attribute, List<Edge> edges) {
        this.attribute = attribute;
        this.edges = edges;
    }

    @Override
    public Object lookupDecision(IAttributeDatum datum) {
        return null;
    }

    @Override
    public void printNode(String leadSpace) {
    }
}