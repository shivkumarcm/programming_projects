from .tree_node import TreeNode
class Tree:
  def __init__(self, root=None):
    self.root = root

  def traverse(self, traversalType, nodeVisitor, args=None):
    if self.root:
      return self.root.traverse(traversalType, nodeVisitor, args)
    return None


