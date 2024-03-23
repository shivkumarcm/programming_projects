import unittest
from educative.grokking.sliding_window import find_repeated_sequences

class TestRepeatedSequence(unittest.TestCase):
  def test_cases(self):
    print("hello")
    self.assertEqual(find_repeated_sequences("AAAAACCCCCAAAAACCCCCC", 8),
                {"AAAAACCC", "AAACCCCC", "AAAACCCC"})

if __name__ == '__main__':
  unittest.main()

