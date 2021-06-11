package sol;

import src.ITreeNode;

/**
 * Class representing Edge
 */

public class Edge {
    /**
     * Field representing the value of edge
     */
    Object value;
    /**
     * Field representing the next ITreeNode
     */
    ITreeNode next;

    /**
     * A constructor for Edge
     *
     * @param value Object representing the value of edge
     * @param next ITreeNode representing the next ITreeNode
     */
    public Edge(Object value, ITreeNode next){
        this.value = value;
        this.next = next;
    }
}