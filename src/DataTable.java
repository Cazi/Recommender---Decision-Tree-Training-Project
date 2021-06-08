package src;

import java.util.List;

/**
 * DataTable Class
 */
public class DataTable implements IAttributeDataset{

    /** Javadoc is in IAttributeDataset interface
     */
    @Override
    public List<String> getAttributes() {
        return null;
    }

    /** Javadoc is in IAttributeDataset interface
     */
    @Override
    public List getDataObjects() {
        return null;
    }

    /** Javadoc is in IAttributeDataset interface
     */
    @Override
    public int size() {
        return 0;
    }

    /** Javadoc is in IAttributeDataset interface
     */
    @Override
    public boolean allSameValue(String s) {
        return false;
    }

    /** Javadoc is in IAttributeDataset interface
     */
    @Override
    public Object getSharedValue(String s) {
        return null;
    }

    /** Javadoc is in IAttributeDataset interface
     */
    @Override
    public Object mostCommonValue(String s) {
        return null;
    }

    /** Javadoc is in IAttributeDataset interface
     */
    @Override
    public List<IAttributeDataset> partition(String s) {
        return null;
    }
}
