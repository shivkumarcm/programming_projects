# Definition for a binary tree node.
class TreeNode(object):
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right

class Solution(object):
  def sortedArrayToBST(self, nums):
    """
    :type nums: List[int]
    :rtype: TreeNode
    """
    if nums == None:
      return None
    n = len(nums)
    if n == 0:
      return None
    if n == 1:
      return TreeNode(nums[0])

    m = int(n / 2)
    return TreeNode(nums[m],
                    self.sortedArrayToBST(nums[0:m]),
                    self.sortedArrayToBST(nums[m + 1:]))
