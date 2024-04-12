class Solution:
  """
    Validate if the given Sudoku board. It may be incomplete. Empty cells have "."
    Filled cells have digit "1", "2", etc.
  """
  def initMap(self):
    return {str(i): False for i in range(1, 10)}

  def isValidSudoku(self, board):
    """
    board is of type List[List[str]]
    """
    for i in range(0, 9):
      hash = self.initMap()
      for j in range(0, 9):
        if board[i][j] != '.' and hash[board[i][j]]:
          return False
        hash[board[i][j]] = True

    for i in range(0, 9):
      hash = self.initMap()
      for j in range(0, 9):
        if board[j][i] != '.' and hash[board[j][i]]:
          return False
        hash[board[j][i]] = True

    for i in range(0, 9, 3):
      for j in range(0, 9, 3):
        hash = self.initMap()
        for k in range(0, 3):
          for l in range(0, 3):
            if board[i + k][j + l] != "." and hash[board[i + k][j + l]]:
              return False
            hash[board[i + k][j + l]] = True
    return True

