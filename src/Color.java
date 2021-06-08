package src;

public class Color extends Attribute implements IAttributeDatum{
    /**
     * Color Constructor
     * @param name - representing the color of this Color object
     */
    public Color (String name) {
        this.attributeName = name;
    }

    /**Javadoc in IAttributeDatnum interface
     */
    @Override
    public Object getValueOf(String s) {
        return null;
    }
}
