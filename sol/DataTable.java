package sol;

import src.IAttributeDataset;
import src.IAttributeDatum;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for a table (collection of rows) of data.
 * @param <T> the type of the data objects
 */

public class DataTable<T extends IAttributeDatum> implements
        IAttributeDataset<T> {
    /**
     * Field representing list of table attributes
     */
    List<String> attributes;
    /**
     * Field representing rows/data objects of table
     */
    List<T> rows;

    /**
     *  A constructor for DataTable
     *
     * @param attributes list of strings representing table attributes
     * @param dataObjects list of data objects representing rows of table
     */
    public DataTable(List<String> attributes, List<T> dataObjects) {
        this.attributes = attributes;
        this.rows = dataObjects;
    }

    @Override
    public List<String> getAttributes() {
        return this.attributes;
    }

    @Override
    public List<T> getDataObjects() {
        return this.rows;
    }

    @Override
    public int size() {
        return this.rows.size();
    }

    @Override
    public boolean allSameValue(String ofAttribute) {
        T firstRow = this.getDataObjects().get(0);
        Object value = firstRow.getValueOf(ofAttribute);

        for (int i = 1; i < this.size(); i ++) {
            T currentRow = this.getDataObjects().get(i);
            Object currentValue = currentRow.getValueOf(ofAttribute);
            if (!value.equals(currentValue)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public Object getSharedValue(String ofAttribute) {
        T firstRow = this.getDataObjects().get(0);
        Object value = firstRow.getValueOf(ofAttribute);

        return value;
    }

    @Override
    public Object mostCommonValue(String ofAttribute) {
        List<IAttributeDataset<T>> partitions = this.partition(ofAttribute);
        IAttributeDataset<T> mostCommonDataset = partitions.get(0);
        int mostCommonSize = mostCommonDataset.size();

        for (int i = 1; i < partitions.size(); i ++) {
            IAttributeDataset<T> currentDataset = partitions.get(i);
            int currentSize = currentDataset.size();
            if (mostCommonSize < currentSize) {
                mostCommonDataset = currentDataset;
                mostCommonSize = currentSize;
            }
        }
        Object mostCommonValue = mostCommonDataset.getSharedValue(ofAttribute);

        return mostCommonValue;
    }

    @Override
    public List<IAttributeDataset<T>> partition(String onAttribute) {
        List<IAttributeDataset<T>> partitions =
                new ArrayList<IAttributeDataset<T>>();
        List<Object> uniqueValues = this.uniqueValues(onAttribute);

        for (Object value : uniqueValues) {
            IAttributeDataset<T> currentDataset =
                    this.createSubset(onAttribute, value);
            partitions.add(currentDataset);
        }

        return partitions;
    }

    /**
     * Method to create a dataset/partition - helper for partition method
     *
     * @param onAttribute the given attribute
     * @param value a unique value for the given attribute
     * @return a dataset with given value
     */
    public IAttributeDataset<T> createSubset(String onAttribute, Object value)
    {
        List<T> currentData = new ArrayList<T>();

        for (T row : this.getDataObjects()) {
            Object currentValue = row.getValueOf(onAttribute);
            if (value.equals(currentValue)) {
                currentData.add(row);
            }
        }
        IAttributeDataset<T> currentDataset =
                new DataTable<T>(this.getAttributes(), currentData);

        return currentDataset;
    }

    /**
     * Method to create a list of unique values for a given attribute
     *
     * @param onAttribute the given attribute
     * @return a list of unique values for a given attribute
     */
    public List<Object> uniqueValues(String onAttribute) {
        List<Object> unique = new ArrayList<Object>();

        for (T row : this.getDataObjects()) {
            Object currentValue = row.getValueOf(onAttribute);
            if (!unique.contains(currentValue)) {
                unique.add(currentValue);
            }
        }

        return unique;
    }
}