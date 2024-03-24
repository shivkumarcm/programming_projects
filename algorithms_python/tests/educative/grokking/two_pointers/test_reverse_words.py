import unittest
from educative.grokking.two_pointers import reverse_words


class TestReverseWords(unittest.TestCase):
  def test_cases(self):
    self.assertEqual(reverse_words("Reverse this string"), "string this Reverse")
    self.assertEqual(reverse_words(" 1234 abc   XYZ"), "XYZ abc 1234")
    self.assertEqual(reverse_words(" 1234 abc   XYZ   "), "XYZ abc 1234")
    self.assertTrue(reverse_words("Greeting123"), "Greeting123")
    self.assertTrue(reverse_words(" Greeting123   "), "Greeting123")
    self.assertTrue(reverse_words(" Greeting123       test "), "test Greeting123")

  def test_empty(self):
    self.assertIsNone(reverse_words(None))
    self.assertEqual(reverse_words(" "), "")

if __name__ == '__main__':
  unittest.main()

