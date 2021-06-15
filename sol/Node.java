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
        this.mostCommonDecision = mostCommDecision;
        this.edges = new ArrayList<>();
    }

    @Override
    public Object lookupDecision(IAttributeDatum datum) {
        for (Edge edge : this.edges) {
            Object datumValue = datum.getValueOf(this.attribute);
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
        System.out.println(this.attribute + "\n");

        //System.out.println("-----------------");
        for (Edge edge : this.edges) {
            System.out.println("        " + edge.getValue());
            leadSpace += "      ";
            edge.getNextNode().printNode(leadSpace);
        }
        //edge.getNextNode().printNode(leadSpace);
    }
}