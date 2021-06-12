package sol;

import src.IAttributeDataset;
import tester.Tester;

import java.util.ArrayList;
import java.util.List;
public class RecommenderTestSuite {

    // TODO: write unit tests for your implementations of IAttributeDatum,
    //  IAttributeDataset, and ITreeNode

    /**
     * For methods with expected outputs for each input, you will be expected to write unit tests.
     * In this project, that means that you should write tests for any public method that you write in classes that
     * implement IAttributeDatum, IAttributeDataset, or ITreeNode. You should write these tests
     * inRecommenderTestSuite.java in the sol package. These are the only tests you’re required to write.
     *
     * Note that since the tree you generate in TreeGenerator differs every time you execute,
     * you are not expected to write unit tests for methods in this class.
     */

    /**
     *   name      color    lowCarb     highFiber     likeToEat
     *   ------------------------------------------------------
     *   spinach   green     true         true         false
     *   kale      green     true         true         true
     *   peas      green     false        true         true
     *   carrot    orange    false        false        false
     *   lettuce   green     true         false        true
     */
    Vegetable spinach;
    Vegetable kale;

    public void vegetableHandoutSetup () {
        spinach = new Vegetable("Spinach", "green", true, true, false);
        kale = new Vegetable("Kale", "green", true, true, true);
        Vegetable peas = new Vegetable("Peas", "green", false, true, true);
        Vegetable carrot = new Vegetable("Carrot", "orange", false, false, false);
        Vegetable lettuce = new Vegetable("Lettuce", "green", true, false, true);
        List<String> attributes =  new ArrayList<>();
        attributes.add("color");
        attributes.add("lowCarb");
        attributes.add("highFiber");
        attributes.add("likeToEat");

        List<Vegetable> vegList = new ArrayList<Vegetable>();
        vegList.add(spinach);
        vegList.add(kale);
        vegList.add(peas);
        vegList.add(carrot);
        vegList.add(lettuce);

        DataTable givenTable = new DataTable(attributes, vegList);

    }

    /**
     * Testing getValueOf in Vegetable class
     * @param t - tester object
     */
    public void testGetValOf (Tester t) {
        vegetableSetup();
        t.checkExpect(spinach.getValueOf("color").equals("green"),true);
        t.checkExpect(kale.getValueOf("lowCarb").equals(true),true);
        t.checkExpect(peas.getValueOf("highFiber").equals(true),true);
        t.checkExpect(carrot.getValueOf("likeToEat").equals(false),false);

        t.checkException(new RuntimeException("Unexpected Attribute in getValueOf"), spinach, "getValueOf", "price");
    }

    /*  DataTable Tests */

    /**
     * Testing getAttributes in the DataTable class
     * @param t - tester object
     */
    public void testGetAttributes (Tester t) {

    }

    /**
     * Testing getDataObjects in the DataTable class
     * @param t - tester object
     */
    public void testGetDataObjects (Tester t) {

    }




    public static void main(String[] args) {
        Tester.run(new RecommenderTestSuite());
    }
}
