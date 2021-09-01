Overview:
The Reccomender project focuses on Building decision trees recursively. The project's goals are to create data objects (e.g. Vegetables)
with various attributes and dataset objects (e.g a list of vegetables) which the tree generator class employs to generate a decision tree.
Here, based on the desired value (e.g The boolean likeToEat being true), the tree will determine which vegetable attributes lead to the desired value.
The tree can then recieve a new piece of data that wasn't included in the training dataset, and accurately determine whether or not it satisfies the desired value. 

How it works:
Our decision trees are stored in ITreeNode objects and built by the buildClassifier method in the treeGenerator class. The nodes store the attribute
that a dataset is partitioned on as well as a list of edge objects. Each edge stores the attribute value for that branch of the tree and the following
node. At the bottom of the tree, leaf objects contain the final decisions of the tree. Since I had to implement vegetables as objects to train our decision trees,
they're also stored in dataset objects. The DataTable class contains IAttributeDatums (i.e Vegetables in
this case). The datatable is used to generate a tree which is of type ITreeNode, where the Node, Leaf, and Edge classes make up the tree.

Here's an example:
A vegetable has the following attributes:
name
color
lowCarb
likeToEat

The name attribute is irrelevant, so we can exclude it from the list of attributes through which we can construct the tree. 
Here is our dataset:
[carrot, celery, apple]
  carrot:
    color - orange
    lowCarb - true
    likeToEat - true
    
  celery:
    color - green
    lowCarb - true
    likeToEat - true
    
  apple:
    color - red
    lowCarb - false
    likeToEat - false
    
If we randomly select lowCarb as the attributed to partition our dataset on, then we get the following tree.
                      lowcarb
                      --------
        true                      false
        ----[celery, carrot]      -------[apple]
        
lowCarb is then removed from the list of attributes, and the tree continues by choosing color as the next attribute.

                                                      lowcarb
                                                      --------
                               true                                                   false
                             -------[celery, carrot]                                  -------[apple]  
                           color                                                              Decision
                          --------                                                             --------
            green[celery]           orange[carrot]                                               false
             --------                 ----------
    Decision                                  Decision
    --------                                      --------
    true                                               true
    
                                       
Since the shared attribute value for all the data in the false edge of the lowCarb tree is false, the final decision of the right subtree is false. This is because when we split the tree on an attribute, we check if all the data in the subset have the same value for the target attribute. Since apple has the same value for the target attribute as itself, we can safely return false as the decision for this subtree. 

On the true edge of the lowCarb node, the tree splits on color leading to the green edge and the orange edge. Finally, for the same reason explained previously the green edge creates a leaf object with the decision true, and the orange edge creates a leaf object with the decision true.

So, if the user gave this decision tree a new vegetable, it would be able to determine whether or not the user liked to eat it or not.
   
      
    
