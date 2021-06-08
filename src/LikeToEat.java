package src;

public class LikeToEat extends Attribute implements IAttributeDatum{
    /**
     * boolean value field for LikeToEat
     */
    boolean value;

    /**
     * LikeToEat Constructor
     * @param value - representing whether this attribute is true or not
     */
    public LikeToEat (boolean value) {
        this.attributeName = "likeToEat";
        this.value = value;
    }

    /** Javadoc in IAttributeDatnum
     */
    @Override
    public Object getValueOf(String s) {
        return null;
    }
}
