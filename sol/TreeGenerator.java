package sol;

import src.IAttributeDatum;
import src.ITreeGenerator;
import src.ITreeNode;

/**
 * TreeGenerator Class
 */
public class TreeGenerator<D extends IAttributeDatum> implements ITreeGenerator {

    /**
     * TreeGenerator Constructor
     */
    public TreeGenerator() {
    }

    /**
     * Trains a decision tree to predict the value of a target attribute.
     *
     * @param targetAttribute the attribute that the decision tree will predict the value of
     * @return a trained decision tree that will predict the value of the target attribute for a given datum
     */
    @Override
    public ITreeNode buildClassifier(String targetAttribute) {
        return null;
    }

    /**
     * Uses the decision tree trained by buildClassifier to get the predicted value of the target attribute for
     * a given datum.
     *
     * @param datum the datum to classify
     * @return the predicted value (recommendation) of the target attribute for the given datum
     */
    @Override
    public Object lookupRecommendation(IAttributeDatum datum) {
        return null;
    }

    /**
     * Prints the decision tree trained by buildClassifier.
     */
    @Override
    public void printTree() {

    }
}
