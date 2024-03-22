import unittest
from educative.grokking.two_pointers import is_palindrome

class TestPalindrome(unittest.TestCase):

  def test_cases():
    assertTrue(is_palindrome("kayak"))
    assertFalse(is_palindrome("hello"))
    assertFalse(is_palindrome("RACEACAR"))
    assertTrue(is_palindrome("A"))
    assertFalse(is_palindrome("ABCDABCD"))

if __name__ == '__main__':
    unittest.main()
  
