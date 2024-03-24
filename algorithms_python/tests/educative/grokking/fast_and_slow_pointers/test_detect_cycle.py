import unittest
from educative.grokking.fast_and_slow_pointers import detect_cycle
from educative.grokking.utils.linked_list import LinkedList
from educative.grokking.utils.linked_list_node import LinkedListNode

class TestDetectCycle(unittest.TestCase):

  def create_data(self, arr, pos):
    ll = LinkedList()
    ll.create_linked_list(arr)
    if pos != -1:
      length = ll.get_length(ll.head)
      ll_last = ll.get_node(ll.head, length-1)
      ll_last.next = ll.get_node(ll.head, pos)
    return ll

  def test_cases(self):
    self.assertTrue(detect_cycle(self.create_data([2, 4, 6, 8, 10], 2).head))
    self.assertFalse(detect_cycle(self.create_data([1, 3, 5, 7, 9], -1).head))
    self.assertTrue(detect_cycle(self.create_data([1, 2, 3, 4, 5], 3).head))
    self.assertFalse(detect_cycle(self.create_data([0, 2, 3, 5, 6], -1).head))

  def test_empty(self):
    self.assertFalse(detect_cycle(None))
    self.assertFalse(detect_cycle(LinkedListNode(1)))

if __name__ == '__main__':
  unittest.main()

