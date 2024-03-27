from .utils.tree_node import TreeNode

def flatten_tree(root):
  """
  Pre-order flattening of tree into a doubly linked list
  """
  if not root:
    return None

  left_list = flatten_tree(root.left)
  right_list = flatten_tree(root.right)
  root.right = left_list

  prev, ptr = None, root.right
  while ptr:
    prev = ptr
    ptr = ptr.right

  if prev:
    prev.right = right_list
  return root

def height_and_dia_of_binaryTree(root, dia):
  if not root:
    return 0, dia
  left_ht, ldia = height_and_dia_of_binaryTree(root.left, dia)
  right_ht, rdia = height_and_dia_of_binaryTree(root.right, dia)
  dia = max(dia, ldia, rdia, left_ht + right_ht)
  return max(left_ht, right_ht) + 1, dia

def diameter_of_binaryTree(root):
  """
  Longest path between any two nodes
  """
  if not root:
    return 0

  ht, dia = height_and_dia_of_binaryTree(root, 0)
  return dia


