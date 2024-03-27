import enum
from enum import Enum

TraversalType = Enum('TraversalType', ['DFS_PRE', 'DFS_IN', 'DFS_POST'])

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
      case TraversalType.BFS_L2R: pass
      case TraversalType.BFS_R2L: pass

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
