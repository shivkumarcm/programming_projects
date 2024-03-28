from .tree_node import TreeNode
import io
class Tree:
  def __init__(self, root=None):
    self.root = root

  def traverse(self, traversalType, nodeVisitor, args=None):
    if self.root:
      return self.root.traverse(traversalType, nodeVisitor, args)
    return None


  def serialize(self):
    """
    Serializes a binary tree in the form of [5,2,1,4,23,13,10,null,25]
    where null means empty node
    """
    buffer = io.StringIO()
    buffer.write("[")
    if self.root:
      self.root.serialize(buffer)
    buffer.write("]")
    return buffer.getvalue()

  def deserialize(self, serialized_input):
    """
    Works only for binary tree
    """
    buffer = io.StringIO()
    buffer.write(serialized_input)
    buffer.seek(1) # ignore the leading '['

    self.root = TreeNode(-10000)
    chunk = self.root.read_chunk(buffer)
    if chunk == "": #this is an empty tree
      self.root = None
      return

    self.root.data = int(chunk)
    self.root.deserialize(buffer)

