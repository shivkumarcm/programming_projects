class Solution:
  def romanToInt(self, s: str) -> int:
    v = {'M': 1000, 'D': 500, 'C': 100, 'L': 50, 'X': 10, 'V': 5, 'I': 1}
    n = len(s)
    m = [1] * len(s)  # multiplier

    # set the multiplier to negative if the previous value is less
    for i in range(1, n):
      if v[s[i - 1]] < v[s[i]]:
        m[i - 1] = -1

    r = 0
    for i in range(0, n):
      r += m[i] * v[s[i]]

    return r
