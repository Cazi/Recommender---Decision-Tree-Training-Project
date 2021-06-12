package sol;

import src.IAttributeDataset;
import src.IAttributeDatum;
import src.ITreeGenerator;
import src.ITreeNode;

import java.util.List;
import java.util.Random;

import java.util.LinkedList;

/**
 * Class representing a Tree Generator, an implementation of ITree Generator
 *
 * @param <T> the type of the data objects
 */

public class TreeGenerator<T extends IAttributeDatum> implements ITreeGenerator {
    /**
     * Field represents training dataset on which to train decision tree
     */
    IAttributeDataset<T> trainingData;
    /**
     * Field represents start ITreeNode of Tree
     */
    ITreeNode start;

    /**
     * Constructor for a tree generator.
     *
     * @param trainingData the training data on which to train the
     *                     decision tree
     */
    public TreeGenerator(IAttributeDataset<T> trainingData) {
        this.trainingData = trainingData;
    }

    @Override
    public ITreeNode buildClassifier(String targetAttribute) {
        if (!this.trainingData.getAttributes().contains(targetAttribute)) {
            throw new RuntimeException("targetAttribute not found");
        }
        LinkedList<String> mutableAttributes = new LinkedList<String>(this.trainingData.getAttributes());
        mutableAttributes.remove(targetAttribute);
        if (this.trainingData.allSameValue(targetAttribute)) {
            return new Leaf(this.trainingData.getSharedValue(targetAttribute));
        } else if (mutableAttributes.isEmpty()) {
            return new Leaf(this.trainingData.mostCommonValue(targetAttribute));
        } else {
            Random random = new Random();
            int upperBound = mutableAttributes.size();
            int randomNum = random.nextInt(upperBound);

            String newAttribute = mutableAttributes.get(randomNum);
            mutableAttributes.remove(newAttribute);
            Object mostCommonValue = this.trainingData.mostCommonValue(newAttribute);
            Node nextNode = new Node(newAttribute, mostCommonValue);
            //this.start = nextNode;
            List<IAttributeDataset<T>> partitions = this.trainingData.partition(newAttribute);

            //List<IAttributeDataset<T>> partitions = this.classifierHelper(mutableAttributes);

            for (IAttributeDataset<T> partition : partitions) {
                TreeGenerator newTree = new TreeGenerator(partition);
                newTree.buildClassifier(targetAttribute);
                Edge newEdge = new Edge(partition.getSharedValue(newAttribute),nextNode);
            }
            return nextNode; //?? or would we return start after setting equal to the tree we create?

        }
    }

    /**
     * classifierHelper for the buildClassifier method
     * @param mutableAttributes - shrinking list of attributes
     * @return A list of partitions
     */
    public List<IAttributeDataset<T>> classifierHelper(LinkedList<String> mutableAttributes) {
        return null;
    }

    /**
     * for each new subset:
     * recursively generate decision tree for subset
     * create an edge from new node to recursive subtree,
     * labeled by corresponding value of chosen attribute
     */


    @Override
    public Object lookupRecommendation(IAttributeDatum datum) {
        // TODO: implement
        return null;
    }

    @Override
    public void printTree() {
        // TODO: implement
    }

/**
 *
 * if all rows in subset have same value for targetAttribute:
 *     return decision node (leaf) with common value
 * else if no more unused attributes:
 *     return decision node (leaf) with most common value of targetAttribute
 *         across current subset
 * else:
 *     choose a previously unused attribute
 *     create new node for chosen attribute
 *     store most common value of targetAttribute across current subset
 *     partition subset into new subsets for each value of chosen attribute
 *
 *     for each new subset:
 *         recursively generate decision tree for subset
 *         create an edge from new node to recursive subtree,
 *             labeled by corresponding value of chosen attribute
 *
 *     return new node
 */


}