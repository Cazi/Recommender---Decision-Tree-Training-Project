Group Members: Angelina Ossimetha, Caziah Mayers

Bugs: There aren't any known bugs in our code at this time.

Our decision trees are stored in ITreeNode objects and built by the
buildClassifier method in the treeGenerator class. The nodes store the attribute
that a dataset is split on as well as a list of edge objects. Each edge stores
the attribute value for that branch of the tree and the following node. At the
bottom of the tree, leaf objects contain the final decisions of the tree.
Since we had to implement vegetables as objects to train our decision trees,
they're also stored in dataset objects.

We have a DataTable class which contains IAttributeDatums (i.e Vegetables in
our case). The datatable to generate a tree which is of type ITreeNode, where
the Node, Leaf, and Edge classes make up the tree.