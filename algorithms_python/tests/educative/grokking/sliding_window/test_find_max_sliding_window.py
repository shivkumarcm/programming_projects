import unittest
from educative.grokking.sliding_window import find_max_sliding_window

class TestMaxSlidingWindow(unittest.TestCase):
  def test_cases(self):
    self.assertEqual(find_max_sliding_window([10,6,9,-3,23,-1,34,56,67,-1,-4,-8,-2,9,10,34,67], 3),
                [10,9,23,23,34,56,67,67,67,-1,-2,9,10,34,67])
    self.assertEqual(find_max_sliding_window([9, 5, 3, 1, 6, 3], 2),
                     [9,5,3,6,6])

  def test_empty(self):
    self.assertEqual(find_max_sliding_window([1], 3), [1])
    self.assertEqual(find_max_sliding_window([9, 5, 3, 1, 6, 3], 6), [9])
if __name__ == '__main__':
  unittest.main()

