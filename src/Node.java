package src;

/**
 * Decision Tree Node Class
 */
public class Node implements ITreeNode{
    /**
     * field representing the attribute contained in the node??
     */
    public Attribute value;

    /**
     * field representing the left child of the node, an ITreeNode
     */
    public ITreeNode left;

    /**
     * field representing the right child of the node, an ITreeNode
     */
    public ITreeNode right;

    /**
     * Node Constructor
     */
    public Node () {

    }


    @Override
    public Object lookupDecision(IAttributeDatum iAttributeDatum) {
        return null;
    }

    @Override
    public void printNode(String s) {

    }
}
