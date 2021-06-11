package sol;

import src.IAttributeDataset;
import src.IAttributeDatum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Class for a table (collection of rows) of data.
 *
 * @param <T> the type of the data objects
 */
public class DataTable<T extends IAttributeDatum> implements
        IAttributeDataset<T> {
    /**
     * Field representing list of table attributes
     */
    List<String> attributes; // can we assume fixed???
    /**
     * Field representing rows/data objects of table
     */
    List<T> rows; // list of rows/data objects // can we assume fixed???
    /**
     * Field representing mutable rows of table
     */
    LinkedList<T> mutableRows = new LinkedList<>(rows);

    /**
     * A constructor for DataTable
     *
     * @param attributes  list of strings representing table attributes
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
        Object value = this.rows.get(0).getValueOf(ofAttribute);
        for (int i = 1; i < this.size(); i++) {
            if (!value.equals(this.rows.get(i).getValueOf(ofAttribute))) {
                return false;
            }
        }
        return true;

    }

    @Override
    public Object getSharedValue(String ofAttribute) {
        return this.rows.get(0).getValueOf(ofAttribute);
    }

    @Override
    public Object mostCommonValue(String ofAttribute) {
        List<IAttributeDataset<T>> partitions = this.partition(ofAttribute);
        IAttributeDataset<T> mostCommon = partitions.get(0);
        int mostCommonSize = mostCommon.size();

        // is there a sort (descending order)  function to first sort then
        // just return the first thing in list aka better runtime????
        for (int i = 1; i < partitions.size(); i++) {
            if (mostCommonSize < partitions.get(i).size()) {
                mostCommon = partitions.get(i);
                mostCommonSize = mostCommon.size();
            }
        }
        return mostCommon.getSharedValue(ofAttribute);

    }

    @Override
    public List<IAttributeDataset<T>> partition(String onAttribute) {
        List<IAttributeDataset<T>> partitions =
                new ArrayList<IAttributeDataset<T>>();
        List<Object> uniqueValues = this.uniqueValues(onAttribute);

        for (Object value : uniqueValues) {
            List<T> currentData = new ArrayList<T>();
            int i = 0;
            while (this.mutableRows != null) {
                T row = this.mutableRows.get(i);
                Object currentValue = row.getValueOf(onAttribute);
                if (value.equals(currentValue)) {
                    currentData.add(row);
                    this.mutableRows.remove(row);
                } else {
                    i++;
                }
            }
            IAttributeDataset<T> currentDataset =
                    new DataTable<T>(this.getAttributes(), currentData);
            partitions.add(currentDataset);
        }
        return partitions;

    }

    /**
     * Unique values for a given attribute
     *
     * @param onAttribute the given attribute
     * @return a list of unique values
     */
    public List<Object> uniqueValues(String onAttribute) {
        List<Object> unique = new ArrayList<Object>();
        for (T row : rows) {
            Object currentValue = row.getValueOf(onAttribute);
            if (!unique.contains(currentValue)) {
                unique.add(currentValue);
            }
        }
        return unique;
    }

}