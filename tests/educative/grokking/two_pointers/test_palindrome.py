import unittest
from educative.grokking.two_pointers import is_palindrome

class TestPalindrome(unittest.TestCase):

  def test_cases(self):
    self.assertTrue(is_palindrome("kayak"))
    self.assertFalse(is_palindrome("hello"))
    self.assertFalse(is_palindrome("RACEACAR"))
    self.assertTrue(is_palindrome("A"))
    self.assertFalse(is_palindrome("ABCDABCD"))

if __name__ == '__main__':
    unittest.main()
  
