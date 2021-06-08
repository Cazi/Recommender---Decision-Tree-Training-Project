package src;

public class LowCarb extends Attribute{
    /**
     * boolean value field for LowCarb
     */
    boolean value;

    /**
     * LowCarb attribute constructor
     * @param value - representing whether this attribute is true or not
     */
    public LowCarb (boolean value) {
        this.attributeName = "lowCarb";
        this.value = value;
    }

    /** Javadoc is in IAttributeDatnum interface
     */
    @Override
    public Object getValueOf(String s) {
        return null;
    }
}
