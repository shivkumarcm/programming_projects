import unittest
from educative.grokking.fast_and_slow_pointers import get_middle_node
from educative.grokking.utils.linked_list import LinkedList
from educative.grokking.utils.linked_list_node import LinkedListNode

class TestGetMiddle(unittest.TestCase):

  def create_data(self, arr):
    ll = LinkedList()
    ll.create_linked_list(arr)
    return ll

  def test_cases(self):
    self.assertEqual(get_middle_node(self.create_data([1, 2, 3, 4, 5]).head).data, 3)
    self.assertEqual(get_middle_node(self.create_data([1, 2, 3, 4, 5, 6]).head).data, 4)
    self.assertEqual(get_middle_node(self.create_data([1, 2]).head).data, 2)
  
  def test_empty(self):
    self.assertEqual(get_middle_node(self.create_data([10]).head).data, 10)
    self.assertIsNone(get_middle_node(None))

if __name__ == '__main__':
  unittest.main()

