class Solution:
  def longestCommonPrefix(self, strs) -> str:
    """
    Returns the longest common prefix given a list of strings str
    ["flower","flow","flight"] should return "fl"
    """
    prefix = ""
    i = 0
    n = len(strs)

    # Find the shortest string
    shortest = strs[0]
    for i in range(1, n):
      if len(strs[i]) < len(shortest):
        shortest = strs[i]

    for i in range(0, len(shortest)):
      c = shortest[i]
      flag = True
      for j in range(0, n):
        if i < len(strs[j]) and strs[j][i] != c:
          flag = False
          break
      if flag:
        prefix += c
      else:
        break
    return prefix