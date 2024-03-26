import unittest
from educative.grokking.fast_and_slow_pointers import is_palindrome
from educative.grokking.utils.linked_list import LinkedList
from educative.grokking.utils.linked_list_node import LinkedListNode


class TestPalindrome(unittest.TestCase):

  def create_data(self, arr):
    ll = LinkedList()
    ll.create_linked_list(arr)
    return ll

  def test_cases(self):
    self.assertTrue(is_palindrome(self.create_data([1, 2, 3, 2, 1]).head))
    self.assertFalse(is_palindrome(self.create_data([4, 7, 9, 5, 4]).head))
    self.assertTrue(is_palindrome(self.create_data([2, 3, 5, 5, 3, 2]).head))
    self.assertFalse(is_palindrome(self.create_data([6, 1, 0, 5, 1, 6]).head))
    self.assertTrue(is_palindrome(self.create_data([3, 6, 9, 8, 4, 8, 9, 6, 3]).head))

  def test_empty(self):
    self.assertFalse(is_palindrome(None))
    self.assertTrue(is_palindrome(self.create_data([1]).head))
    self.assertTrue(is_palindrome(self.create_data([1, 1]).head))
    self.assertFalse(is_palindrome(self.create_data([1, 2]).head))

if __name__ == '__main__':
  unittest.main()

