package src;

public class Vegetable implements IAttributeDatum{

    /**
     * String name field for Vegetable
     */
    String name;

    /**
     * Color Attribute field for Vegetable
     */
    Color color;

    /**
     *  LowCarb Attribute field for Vegetable
     */
    LowCarb lowCarb;

    /**
     *  HighFiber Attribute field for Vegetable
     */
    HighFiber highFiber;

    /**
     *  LikeToEat Attribute field for Vegetable
     */
    LikeToEat likeToEat;

    public Vegetable (String name, Color color, LowCarb lowCarb, HighFiber highFiber, LikeToEat likeToEat) {
        this.name = name;
        this.color = color;
        this.lowCarb= lowCarb;
        this.highFiber = highFiber;
        this.likeToEat = likeToEat;
    }
    /**
     *Javadoc is in IAttributeDatum
     */
    @Override
    public Object getValueOf(String s) {


        return null;
    }
}
