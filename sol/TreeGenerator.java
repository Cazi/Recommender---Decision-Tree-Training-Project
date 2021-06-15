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

public class TreeGenerator<T extends IAttributeDatum> implements ITreeGenerator
{
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
     * @throws RuntimeException if trainingData is empty
     */
    public TreeGenerator(IAttributeDataset<T> trainingData) {
        if (trainingData == null) {
            throw new RuntimeException("Dataset is empty");
        }
        this.trainingData = trainingData;
    }

    @Override
    public ITreeNode buildClassifier(String targetAttribute) {
        List<String> attributes = this.trainingData.getAttributes();
        if (!attributes.contains(targetAttribute)) {
            throw new RuntimeException("targetAttribute not found");
        }
        LinkedList<String> mutableAttributes =
                new LinkedList<String>(attributes);
        mutableAttributes.remove(targetAttribute);

        return this.classifierHelper(targetAttribute, mutableAttributes);
    }

    /**
     * classifierHelper for the buildClassifier method
     * @param mutableAttributes - shrinking list of attributes
     * @return A list of partitions
     */
    //Handle if mutAtt size = 0!!
    public ITreeNode classifierHelper(String targetAttribute,
                                       LinkedList<String> mutableAttributes) {
        Object mostCommonValue =
                this.trainingData.mostCommonValue(targetAttribute);
        if (this.trainingData.allSameValue(targetAttribute)) {
            Object sharedValue =
                    this.trainingData.getSharedValue(targetAttribute);
            return new Leaf(sharedValue);
        } else if (mutableAttributes.isEmpty()) {
            return new Leaf(mostCommonValue);
        } else {
            int randomNum = this.getRandomNumber(mutableAttributes);
            String newAttribute = mutableAttributes.get(randomNum);
            mutableAttributes.remove(newAttribute);
            Node newNode = new Node(newAttribute, mostCommonValue);
            List<IAttributeDataset<T>> partitions =
                    this.trainingData.partition(newAttribute);

            for (IAttributeDataset<T> partition : partitions) {
                LinkedList<String> mutableAttSecond =
                      new LinkedList<String>(mutableAttributes);
                TreeGenerator newTree = new TreeGenerator(partition);
                ITreeNode tree =
                        newTree.classifierHelper(targetAttribute,
                                mutableAttSecond);
                Object sharedValue = partition.getSharedValue(newAttribute);
                Edge edge = new Edge(sharedValue, tree);
                newNode.edges.add(edge);
            }
            this.start = newNode;
        }

        return this.start;
    }

    /**
     *
     * @param mutableAttributes
     * @return
     */
    public int getRandomNumber(LinkedList<String> mutableAttributes) {
        Random random = new Random();
        int upperBound = mutableAttributes.size();
        int randomNum = random.nextInt(upperBound);
        return randomNum;
    }

    @Override
    public Object lookupRecommendation(IAttributeDatum datum) {
        return this.start.lookupDecision(datum);
    }

    @Override
    public void printTree() {
        this.start.printNode("");
    }
}