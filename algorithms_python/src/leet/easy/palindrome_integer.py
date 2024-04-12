class Solution:
  def isPalindrome(self, x: int) -> bool:
    """
    Validate if integer x is palindrome 121 is. 34 is not.
    -121 is not because reverse is 121-
    """
    if x < 0:
      return False
    digits = []
    while x > 0:
      digits += [x % 10]
      x = int(x / 10)

    n = len(digits)
    for i in range(0, int(n / 2)):
      if digits[i] != digits[n - i - 1]:
        return False
    return True