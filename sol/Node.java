package sol;

import src.IAttributeDatum;
import src.ITreeNode;

import java.util.ArrayList;
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
     * Field representing Node most common decision of IAttributeDataset
     */
    Object mostCommonDecision;

    /**
     * A constructor for Node
     *
     * @param attribute        - String representing Node attribute name
     * @param mostCommDecision - Object representing Node most common decision
     *                         of IAttributeDataset
     */
    public Node(String attribute, Object mostCommDecision) {
        this.attribute = attribute;
        this.mostCommonDecision = mostCommDecision;
        this.edges = new ArrayList<>();
    }

    @Override
    public Object lookupDecision(IAttributeDatum datum) {
        Object datumValue = datum.getValueOf(this.attribute);
        for (Edge edge : this.edges) {
            Object edgeValue = edge.getValue();
            if (datumValue.equals(edgeValue)) {
                ITreeNode edgeNextNode = edge.getNextNode();
                return edgeNextNode.lookupDecision(datum);
            }
        }
        return this.mostCommonDecision;
    }

    @Override
    public void printNode(String leadSpace) {
        System.out.println(leadSpace + "Node: " + this.attribute + "\n");
        leadSpace += "      ";
        for (Edge edge : this.edges) {
            System.out.println(leadSpace + "Edge: " + edge.getValue());
            edge.getNextNode().printNode(leadSpace);
        }
    }
}