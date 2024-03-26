import unittest

from educative.grokking.utils.linked_list import LinkedList
from educative.grokking.linked_list_ops import reverse

class TestLinkedListOps(unittest.TestCase):

  def assertEqualList(self, list1, list2):
    ptr1, ptr2 = list1, list2
    # compare every data in the list
    while ptr1 and ptr2:
      self.assertEqual(ptr1.data, ptr2.data,
               "List data mismatch: " + str(ptr1.data) + "<>" + str(ptr2.data))
      ptr1 = ptr1.next
      ptr2 = ptr2.next

    # that both are empty
    self.assertIsNone(ptr1, "first list is longer")
    self.assertIsNone(ptr2, "second list is longer")

  def reverse_generic_test(self, nums):
    # create the first linked list and reverse it
    ll = LinkedList()
    ll.create_linked_list(nums)
    ll.head = reverse(ll.head)

    # Create a new reverse linked list
    lr = LinkedList()
    nums.reverse()
    lr.create_linked_list(nums)

    # assert that the two linked lists are equal
    self.assertEqualList(ll.head, lr.head)

  def test_reverse1(self):
    self.reverse_generic_test([1,-1,-2,3,-4,5])

  def test_reverseEdgeCases(self):
    self.reverse_generic_test([])
    self.reverse_generic_test([1])

  def test_reverse3(self):
    self.reverse_generic_test([3, -1, 0, 1, 2])


if __name__ == '__main__':
  unittest.main()