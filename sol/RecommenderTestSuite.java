package sol;

import src.IAttributeDataset;
import src.IAttributeDatum;
import src.ITreeNode;
import tester.Tester;

import java.util.ArrayList;
import java.util.List;

public class RecommenderTestSuite {
    /**
     * Global variables for testing
     */
    Vegetable spinach;
    Vegetable kale;
    Vegetable peas;
    Vegetable carrot;
    Vegetable lettuce;
    Vegetable eggplant;
    Vegetable sweatPotato;
    Vegetable squash;
    Vegetable pinkSquash;
    List<String> attributes;
    List<Vegetable> vegList;
    DataTable givenTable;
    TreeGenerator treeGen;
    ITreeNode givenDecisionTree;

    /**
     * Setup method implementing the handout's datatable
     */
    public void HandoutSetup() {
        this.spinach = new Vegetable("Spinach", "green",
                true, true, false);
        this.kale = new Vegetable("Kale", "green", true,
                true, true);
        this.peas = new Vegetable("Peas", "green", false,
                true, true);
        this.carrot = new Vegetable("Carrot", "orange",
                false, false, false);
        this.lettuce = new Vegetable("Lettuce", "green",
                true, false, true);
        this.attributes = new ArrayList<String>();
        this.attributes.add("color");
        this.attributes.add("lowCarb");
        this.attributes.add("highFiber");
        this.attributes.add("likeToEat");

        this.vegList = new ArrayList<Vegetable>();
        this.vegList.add(this.spinach);
        this.vegList.add(this.kale);
        this.vegList.add(this.peas);
        this.vegList.add(this.carrot);
        this.vegList.add(this.lettuce);

        this.givenTable = new DataTable(this.attributes, this.vegList);
        this.treeGen = new TreeGenerator(this.givenTable);
        this.givenDecisionTree =
                treeGen.buildClassifier("likeToEat");
    }

    /**
     * Setup method implementing the GearUp's datatable
     */
    public void gearUpSetup() {
        this.spinach = new Vegetable("Spinach", "green",
                true, false, false);
        this.kale = new Vegetable("Kale", "green", true,
                true, true);
        this.peas = new Vegetable("Peas", "green", false,
                true, false);
        this.sweatPotato = new Vegetable("Sweet Potato", "orange",
                true, true, true);
        this.carrot = new Vegetable("Carrot", "orange",
                true,false, false);
        this.eggplant = new Vegetable("Eggplant", "purple",
                true, true, true);

        this.squash = new Vegetable("Squash", "orange",
                false, true, null);
        this.pinkSquash = new Vegetable("Squash", "pink",
                true, true, null);

        this.attributes = new ArrayList<>();
        this.attributes.add("color");
        this.attributes.add("lowCarb");
        this.attributes.add("highFiber");
        this.attributes.add("likeToEat");

        this.vegList = new ArrayList<Vegetable>();
        this.vegList.add(this.spinach);
        this.vegList.add(this.kale);
        this.vegList.add(this.peas);
        this.vegList.add(this.carrot);
        this.vegList.add(this.sweatPotato);
        this.vegList.add(this.eggplant);

        this.givenTable = new DataTable(this.attributes, this.vegList);
        this.treeGen = new TreeGenerator(this.givenTable);
        this.givenDecisionTree =
                treeGen.buildClassifier("likeToEat");
    }

    /*  Vegetable Tests */

    /**
     * Testing getValueOf in Vegetable class
     *
     * @param t - tester object
     */
    public void testGetValOf(Tester t) {
        this.HandoutSetup();
        t.checkExpect(spinach.getValueOf("color").equals("green"),
                true);
        t.checkExpect(kale.getValueOf("lowCarb").equals(true),
                true);
        t.checkExpect(peas.getValueOf("highFiber").equals(true),
                true);
        t.checkExpect(carrot.getValueOf("likeToEat").equals(false),
                true);
        t.checkException(
                new RuntimeException("Unexpected Attribute in getValueOf"),
                spinach, "getValueOf", "price");
    }

    /*  DataTable Tests */

    /**
     * Testing getAttributes in the DataTable class
     *
     * @param t - tester object
     */
    public void testGetAttributes(Tester t) {
        this.gearUpSetup();
        List<String> attributeTest = new ArrayList<>();
        attributeTest.add("color");
        attributeTest.add("lowCarb");
        attributeTest.add("highFiber");
        attributeTest.add("likeToEat");
        t.checkExpect(givenTable.getAttributes().equals(attributeTest),
                true);
    }

    /**
     * Testing getDataObjects in the DataTable class
     *
     * @param t - tester object
     */
    public <T> void testGetDataObjects(Tester t) {
        this.gearUpSetup();
        List testRows = new ArrayList<Vegetable>();
        testRows.add(spinach);
        testRows.add(kale);
        testRows.add(peas);
        testRows.add(carrot);
        testRows.add(sweatPotato);
        testRows.add(eggplant);
        t.checkExpect(givenTable.getDataObjects().equals(testRows),
                true);
    }

    /**
     * Testing size in the DataTable class
     *
     * @param t - tester object
     */
    public void testSize(Tester t) {
        this.gearUpSetup();
        List testRows = new ArrayList<Vegetable>();
        testRows.add(spinach);
        testRows.add(kale);
        testRows.add(peas);
        testRows.add(carrot);
        testRows.add(sweatPotato);
        testRows.add(eggplant);
        DataTable testTable = new DataTable(givenTable.attributes, testRows);
        t.checkExpect(givenTable.size() == testTable.size(),
                true);
    }

    /**
     * Testing allSameValue in the DataTable class
     *
     * @param t - tester object
     */
    public void testAllSameValue(Tester t) {
        this.gearUpSetup();
        List testRows = new ArrayList<Vegetable>();
        testRows.add(spinach);
        testRows.add(kale);
        testRows.add(peas);
        DataTable testTable = new DataTable(givenTable.attributes, testRows);
        t.checkExpect(givenTable.allSameValue("color"),
                false);
        t.checkExpect(testTable.allSameValue("color"),
                true);
    }

    /**
     * Testing getSharedValue in the DataTable class
     *
     * @param t - tester object
     */
    public void testGetSharedValue(Tester t) {
        this.gearUpSetup();
        List testRows = new ArrayList<Vegetable>();
        testRows.add(spinach);
        testRows.add(kale);
        DataTable testTable = new DataTable(givenTable.attributes, testRows);
        t.checkExpect(testTable.getSharedValue("lowCarb"),
                true);
    }

    /**
     * Testing mostCommonValue in the DataTable class
     *
     * @param t - tester object
     */
    public void testMostCommonValue(Tester t) {
        this.gearUpSetup();
        List testPartition = new ArrayList<Vegetable>();
        testPartition.add(spinach);
        testPartition.add(kale);
        testPartition.add(peas);
        DataTable testTable = new DataTable(givenTable.attributes,
                testPartition);

        t.checkExpect(testTable.mostCommonValue("lowCarb"),
                true);
    }

    /**
     * Testing uniqueValue in the DataTable class
     *
     * @param t - tester object
     */
    public void testUniqueValues(Tester t) {
        this.gearUpSetup();
        List testPartition = new ArrayList<Vegetable>();
        testPartition.add(spinach);
        testPartition.add(carrot);
        testPartition.add(eggplant);
        DataTable testTable = new DataTable(givenTable.attributes,
                testPartition);
        List<Object> uniqueValues = new ArrayList<Object>();
        uniqueValues.add("green");
        uniqueValues.add("orange");
        uniqueValues.add("purple");
        t.checkExpect(testTable.uniqueValues(
                "color").equals(uniqueValues), true);
    }


    /**
     * Testing partition in the DataTable class
     *
     * @param t - tester object
     */
    public void testPartition(Tester t) {
        this.gearUpSetup();
        List<IAttributeDataset<Vegetable>> lowCarbPartition =
                givenTable.partition("lowCarb");

        //Subset of lowCarb == true
        t.checkExpect(
                lowCarbPartition.get(0).getDataObjects().contains(spinach),
                true);
        t.checkExpect(
                lowCarbPartition.get(0).getDataObjects().contains(kale),
                true);
        t.checkExpect(
                lowCarbPartition.get(0).getDataObjects().contains(carrot),
                true);
        t.checkExpect(
                lowCarbPartition.get(0).getDataObjects().contains(sweatPotato),
                true);
        t.checkExpect(
                lowCarbPartition.get(0).getDataObjects().contains(eggplant),
                true);

        //Subset of lowCarb == false
        t.checkExpect(
                lowCarbPartition.get(1).getDataObjects().contains(peas),
                true);
    }

    /*Testing methods that implement ITreeNode*/

    /**
     * testing the lookupDecision methods in the Node and Leaf classes
     * @param t - tester object
     */
    public void testLookupDecisionITreeNode(Tester t) {
        this.gearUpSetup();
        Object spinachDecision = givenDecisionTree.lookupDecision(spinach);
        t.checkExpect(spinachDecision.equals(false), true);

        Node lowCarbNode = new Node("lowCarb", false);
        Node highFiberNode = new Node("highFiber",
                true);
        List<Edge> lowCarbEList = new ArrayList<>();
        List<Edge> highFiberEList = new ArrayList<>();

        lowCarbNode.edges = lowCarbEList;
        highFiberNode.edges = highFiberEList;
        Edge lCTrue = new Edge(true, highFiberNode);
        Edge lCFalse = new Edge(false, new Leaf(false));
        lowCarbEList.add(lCTrue);
        lowCarbEList.add(lCFalse);

        Edge hFTrue = new Edge(true, new Leaf(true));
        Edge hFFalse = new Edge(false, new Leaf(false));
        highFiberEList.add(hFTrue);
        highFiberEList.add(hFFalse);

        Leaf testLeaf = new Leaf(false);
        t.checkExpect(lowCarbNode.lookupDecision(squash).equals(false),
                true);
        t.checkExpect(lowCarbNode.lookupDecision(pinkSquash).equals(true),
                true);
        t.checkExpect(testLeaf.lookupDecision(squash).equals(false),
                true);
    }

    public static void main(String[] args) {
        Tester.run(new RecommenderTestSuite());
    }
}