import io
import unittest

from educative.grokking.utils.tree import Tree
from educative.grokking.utils.tree_node import TreeNode
from educative.grokking.utils.tree_node import TraversalType

from math import inf

#setup some lambda functions
line_printer = lambda x, args: print(x)
adder = lambda x, args: x + (0 if not args else args)
counter = lambda x, args: 1 + (0 if not args else args)
find_max = lambda x, args: max(x, -inf if not args else args)
find_min = lambda x, args: min(x, inf if not args else args)
find_avg = lambda x, args: (1, x) if not args else (args[0] + 1, (args[0] * args[1] + x) / (args[0] + 1))
serializer = lambda x, args: (args.append(x), args)[1]

class TestTreeOps(unittest.TestCase):

  sample_trees = [
      {
        "tree": Tree(TreeNode(5,
                    TreeNode(2,
                             TreeNode(1),
                             TreeNode(4)),
                    TreeNode(23,
                             TreeNode(13,
                                      TreeNode(10)),
                             TreeNode(25)))),
        "count": 8, "total": 83, "max": 25, "min": 1,
        TraversalType.DFS_PRE.name: [5, 2, 1, 4, 23, 13, 10, 25],
        TraversalType.DFS_IN.name: [1, 2, 4, 5, 10, 13, 23, 25],
        TraversalType.DFS_POST.name: [1, 4, 2, 10, 13, 25, 23, 5],
        TraversalType.BFS_L2R.name: [5, 2, 23, 1, 4, 13, 25, 10],
        TraversalType.BFS_R2L.name: [5, 23, 2, 25, 13, 4, 1, 10],
      },
      {
        "tree": Tree(TreeNode(100,
                              TreeNode(50,
                                       TreeNode(25),
                                       TreeNode(75)),
                              TreeNode(200,
                                       None,
                                       TreeNode(350)))),
        "count": 6, "total": 800, "max": 350, "min": 25,
        TraversalType.DFS_PRE.name: [100, 50, 25, 75, 200, 350],
        TraversalType.DFS_IN.name: [25, 50, 75, 100, 200, 350],
        TraversalType.DFS_POST.name: [25, 75, 50, 350, 200, 100],
        TraversalType.BFS_L2R.name: [100, 50, 200, 25, 75, 350],
        TraversalType.BFS_R2L.name: [100, 200, 50, 350, 75, 25],
      },
      {
        "tree": Tree(TreeNode(100)),
        "count": 1, "total": 100, "max": 100, "min": 100,
        TraversalType.DFS_PRE.name: [100],
        TraversalType.DFS_IN.name: [100],
        TraversalType.DFS_POST.name: [100],
        TraversalType.BFS_L2R.name: [100],
        TraversalType.BFS_R2L.name: [100],

      },
      {
        "tree": Tree(TreeNode(1, None,
                              TreeNode(2,None,
                                       TreeNode(3,None,
                                                TreeNode(4, None,
                                                         TreeNode(5)))))),
        "count": 5, "total": 15, "max": 5, "min": 1,
        TraversalType.DFS_PRE.name: [1, 2, 3, 4, 5],
        TraversalType.DFS_IN.name: [1, 2, 3, 4, 5],
        TraversalType.DFS_POST.name: [5, 4, 3, 2, 1],
        TraversalType.BFS_L2R.name: [1, 2, 3, 4, 5],
        TraversalType.BFS_R2L.name: [1, 2, 3, 4, 5],
      },
      {
        "tree": Tree(TreeNode(-1,
                              TreeNode(-2,
                                       TreeNode(-3,
                                                TreeNode(-4,
                                                         TreeNode(-5)))))),
        "count": 5, "total": -15, "max": -1, "min": -5,
        TraversalType.DFS_PRE.name: [-1, -2, -3, -4, -5],
        TraversalType.DFS_IN.name: [-5, -4, -3, -2, -1],
        TraversalType.DFS_POST.name: [-5, -4, -3, -2, -1],
        TraversalType.BFS_L2R.name: [-1, -2, -3, -4, -5],
        TraversalType.BFS_R2L.name: [-1, -2, -3, -4, -5],
      },
    ]

  def generic_test_traverse(self, tree, traversal_type,
                            num_nodes, total, max_val, min_val, serialized_list):
    #tree.traverse(traversal_type, line_printer)

    #print(traversal_type)
    self.assertEqual(tree.traverse(traversal_type, counter), num_nodes,
                     "Node count does not match!")
    self.assertEqual(tree.traverse(traversal_type, adder), total,
                     "Total does not match!")
    self.assertEqual(tree.traverse(traversal_type, find_max), max_val,
                     "Maximum value does not match!")
    self.assertEqual(tree.traverse(traversal_type, find_min), min_val,
                     "Minimum value does not match!")
    self.assertTupleEqual(tree.traverse(traversal_type, find_avg), (num_nodes, total/num_nodes),
                     "Average value does not match!")
    self.assertEqual(tree.traverse(traversal_type, serializer, list()), serialized_list,
                     "Lists differ for " + traversal_type.name)
    #print(tree.traverse(traversal_type, serializer, list()))

  def test_traversal_all_trees(self):
    for tree_data in self.sample_trees: # for every tree_data the list of sample trees
      for traversal_type in TraversalType:  # for every traversal type known
        self.generic_test_traverse(tree_data["tree"],traversal_type,
                                   tree_data["count"],
                                   tree_data["total"],
                                   tree_data["max"],
                                   tree_data["min"],
                                   tree_data[traversal_type.name])
  def test_serialize_tree(self):
    orig_tree = self.sample_trees[0]["tree"]
    output_string = orig_tree.serialize()
    print(output_string)

    new_tree = Tree()
    new_tree.deserialize(output_string)

    print(orig_tree.traverse(TraversalType.DFS_PRE, serializer, []))
    print(new_tree.traverse(TraversalType.DFS_PRE, serializer, []))
    #orig_tree.root.pretty_print()
    #new_tree.root.pretty_print()

if __name__ == "__main__":
  unittest.main()