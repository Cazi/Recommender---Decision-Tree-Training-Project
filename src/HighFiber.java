package src;

/**
 * HighFiber Class
 */
public class HighFiber extends Attribute implements  IAttributeDatum{
    /**
     * boolean value field for LowCarb
     */
    boolean value;

    /**
     * HighFiber Constructor
     * @param value - representing whether this attribute is true or not
     */
    public HighFiber (boolean value) {
        this.attributeName = "highFiber";
        this.value = value;
    }

    /** Javadoc is in IAttributeDatnum
     */
    @Override
    public Object getValueOf(String s) {
        return null;
    }
}
