import unittest
from educative.grokking.two_pointers import is_almost_palindrome


class TestAlmostPalindrome(unittest.TestCase):

  def test_cases(self):
    self.assertTrue(is_almost_palindrome("madame"))
    self.assertTrue(is_almost_palindrome("dead"))
    self.assertTrue(is_almost_palindrome("abca"))
    self.assertFalse(is_almost_palindrome("tebbem"))
    self.assertFalse(is_almost_palindrome("eeccccbebaeeabebccceea"))

  def test_empty(self):
    self.assertTrue(is_almost_palindrome(""))
    self.assertFalse(is_almost_palindrome(None))


if __name__ == '__main__':
  unittest.main()

