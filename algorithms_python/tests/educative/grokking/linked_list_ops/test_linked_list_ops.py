import unittest

from educative.grokking.utils.linked_list import LinkedList
from educative.grokking.linked_list_ops import reverse
from educative.grokking.linked_list_ops import reverse_k_groups

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

  def generic_test_reverse(self, nums):
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
    self.generic_test_reverse([1,-1,-2,3,-4,5])

  def test_reverseNone(self):
    r = reverse(None)
    self.assertIsNone(r)

  def test_reverseEdgeCases(self):
    self.generic_test_reverse([])
    self.generic_test_reverse([1])

  def test_reverse2(self):
    self.generic_test_reverse([3, -1, 0, 1, 2])

  def generic_test_reverse_k_groups(self, nums1, k, nums2):
    ll1 = LinkedList()
    ll1.create_linked_list(nums1)
    ll1.head = reverse_k_groups(ll1.head, k)

    ll2 = LinkedList()
    ll2.create_linked_list(nums2)
    self.assertEqualList(ll1.head, ll2.head)

  def test_reverse_k_groups(self):
    self.generic_test_reverse_k_groups([1,2,3,4,5,6,7,8,9], 3,
                                       [3,2,1,6,5,4,9,8,7])

    self.generic_test_reverse_k_groups([1,2,3,4,5,6,7,8,9], 9,
                                       [9,8,7,6,5,4,3,2,1])

    self.generic_test_reverse_k_groups([1,2,3,4,5,6,7,8,9], 1,
                                       [1,2,3,4,5,6,7,8,9])

    self.generic_test_reverse_k_groups([1,2,3,4,5,6,7,8,9], 2,
                                       [2,1,4,3,6,5,8,7,9])


if __name__ == '__main__':
  unittest.main()
