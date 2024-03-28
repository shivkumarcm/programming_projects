import enum
import queue
from enum import Enum

TraversalType = Enum('TraversalType', ['DFS_PRE', 'DFS_IN', 'DFS_POST', 'BFS_L2R', 'BFS_R2L'])

# Definition for a binary tree node
class TreeNode:
  def __init__(self, data, left=None, right=None):
    self.data = data
    self.left = left
    self.right = right

  def __str__(self):
    return str(self.data)

  def traverse(self, traversalType, nodeVisitor, args):
    match traversalType:
      case TraversalType.DFS_PRE: return self.__traverse_dfs_preorder(nodeVisitor, args)
      case TraversalType.DFS_IN: return self.__traverse_dfs_inorder(nodeVisitor, args)
      case TraversalType.DFS_POST: return self.__traverse_dfs_postorder(nodeVisitor, args)
      case TraversalType.BFS_L2R: return self.__traverse_bfs_l2r(nodeVisitor, args)
      case TraversalType.BFS_R2L: return self.__traverse_bfs_r2l(nodeVisitor, args)

  def __traverse_dfs_preorder(self, nodeVisitor, args=None):
    retVal = args
    # print("I(" + str(self) +") got:" + str(retVal))  # for debugging
    retVal = nodeVisitor(self.data, retVal)
    if self.left:
      retVal = self.left.__traverse_dfs_preorder(nodeVisitor, retVal)
    if self.right:
      retVal = self.right.__traverse_dfs_preorder(nodeVisitor, retVal)
    return retVal

  def __traverse_dfs_inorder(self, nodeVisitor, args=None):
    retVal = args
    # print("I(" + str(self) +") got:" + str(retVal))  # for debugging
    if self.left:
      retVal = self.left.__traverse_dfs_inorder(nodeVisitor, retVal)
    retVal = nodeVisitor(self.data, retVal)
    if self.right:
      retVal = self.right.__traverse_dfs_inorder(nodeVisitor, retVal)
    return retVal

  def __traverse_dfs_postorder(self, nodeVisitor, args=None):
    retVal = args
    # print("I(" + str(self) +") got:" + str(retVal))  # for debugging
    if self.left:
      retVal = self.left.__traverse_dfs_postorder(nodeVisitor, retVal)
    if self.right:
      retVal = self.right.__traverse_dfs_postorder(nodeVisitor, retVal)
    retVal = nodeVisitor(self.data, retVal)
    return retVal

  def __traverse_bfs_l2r(self, nodeVisitor, args=None):
    nodeQueue = queue.SimpleQueue()
    nodeQueue.put(self)
    while not nodeQueue.empty():
      node = nodeQueue.get()
      args = nodeVisitor(node.data, args)
      if node.left:
        nodeQueue.put(node.left)
      if node.right:
        nodeQueue.put(node.right)
    return args

  def __traverse_bfs_r2l(self, nodeVisitor, args=None):
    nodeQueue = queue.SimpleQueue()
    nodeQueue.put(self)
    while not nodeQueue.empty():
      node = nodeQueue.get()
      args = nodeVisitor(node.data, args)
      if node.right:
        nodeQueue.put(node.right)
      if node.left:
        nodeQueue.put(node.left)

    return args

  def serialize(self, buffer):
    buffer.write(str(self))
    if not self.left and not self.right:
      return
    if self.left:
      buffer.write(",")
      self.left.serialize(buffer)
    else: buffer.write(",null")
    if self.right:
      buffer.write(",")
      self.right.serialize(buffer)
    else: buffer.write(",null")

  def read_chunk(self, buffer):
    chunk = []
    while True:
      c = buffer.read(1)
      if c == ',' or c == ']':
        return ''.join(chunk)
      elif c == '': # end of buffer
        return ''
      else:
        chunk.append(c)

  def deserialize(self, buffer):
    # Deserialize does not work perfectly at the moment
    next_chunk = self.read_chunk(buffer)
    if next_chunk == "":
      return

    if next_chunk == "null":
      self.left = None
      right_chunk = self.read_chunk(buffer)
      if right_chunk != "":
        self.right = TreeNode(int(right_chunk))
        self.right.deserialize(buffer)
      return

    next_value = int(next_chunk)
    if next_value < self.data:
      self.left = TreeNode(next_value)
      self.left.deserialize(buffer)
      right_chunk = self.read_chunk(buffer)
      if right_chunk != "":
        self.right = TreeNode(int(right_chunk))
        self.right.deserialize(buffer)
      return

    self.right = TreeNode(next_value)
    self.right.deserialize(buffer)

  def pretty_print(self, level=0, tag="Rt"):
    print((" " * level) + tag + ":" + str(self.data))
    if self.left:
      self.left.pretty_print(level+1, "L"+str(self.data))
    if self.right:
      self.right.pretty_print(level+1, "R"+str(self.data))

