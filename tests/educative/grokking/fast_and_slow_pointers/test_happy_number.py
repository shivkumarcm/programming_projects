import unittest
from educative.grokking.fast_and_slow_pointers import is_happy_number


class TestHappyNumber(unittest.TestCase):

  def test_cases(self):
    self.assertFalse(is_happy_number(2147483646))
    self.assertFalse(is_happy_number(4))
    self.assertTrue(is_happy_number(1))
    self.assertTrue(is_happy_number(19))
    self.assertFalse(is_happy_number(8))
    self.assertTrue(is_happy_number(7))

if __name__ == '__main__':
  unittest.main()

