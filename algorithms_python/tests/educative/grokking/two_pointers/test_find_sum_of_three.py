import unittest
from educative.grokking.two_pointers import find_sum_of_three

class TestSumOfThree(unittest.TestCase):
  def test_cases(self):
    self.assertFalse(find_sum_of_three([1, -1, 0], -1))
    self.assertTrue(find_sum_of_three([3,7,1,2,8,4,5], 10))
    self.assertFalse(find_sum_of_three([3,7,1,2,8,4,5] , 21))
    self.assertTrue(find_sum_of_three([-1,2,1,-4,5,-3] , -8))
    self.assertTrue(find_sum_of_three([-1,2,1,-4,5,-3] , 0))

if __name__ == '__main__':
    unittest.main()
  
