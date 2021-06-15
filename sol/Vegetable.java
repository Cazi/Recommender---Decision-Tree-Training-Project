package sol;

import src.IAttributeDatum;

/**
 * Class representing a Vegetable, an implementation of IAttributeDatum
 */

public class Vegetable implements IAttributeDatum {
    /**
     * Field representing the name of vegetable
     */
    String name;
    /**
     * Field representing the color of the vegetable
     */
    String color;
    /**
     * Field representing whether the vegetable is low in carbohydrates
     */
    Boolean lowCarb;
    /**
     * Field representing whether the vegetable is high in fiber
     */
    Boolean highFiber;
    /**
     * Field representing whether the vegetable is liked to eat
     */
    Boolean likeToEat;

    /**
     * A constructor for Vegetable
     *
     * @param name - String representing the name of the vegetable
     * @param color - String representing the color of the vegetable
     * @param lowCarb - Boolean representing whether the vegetable is high in
     *        fiber
     * @param highFiber - Boolean representing whether the vegetable is high in
     *        fiber
     * @param likeToEat - Boolean representing whether the vegetable is liked
     *        to eat
     */
    public Vegetable(String name, String color, Boolean lowCarb,
                     Boolean highFiber, Boolean likeToEat) {
        this.name = name;
        this.color = color;
        this.lowCarb = lowCarb;
        this.highFiber = highFiber;
        this.likeToEat = likeToEat;
    }

    @Override
    public Object getValueOf(String attributeName) {
        if (attributeName.equals("name")) {
            return this.name;
        } else if (attributeName.equals("color")) {
            return this.color;
        } else if (attributeName.equals("lowCarb")) {
            return this.lowCarb;
        } else if (attributeName.equals("highFiber")) {
            return this.highFiber;
        } else if (attributeName.equals("likeToEat")) {
            return this.likeToEat;
        } else {
            throw new RuntimeException("Unexpected Attribute in getValueOf");
        }
    }
}