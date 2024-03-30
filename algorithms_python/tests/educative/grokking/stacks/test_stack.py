import io
import unittest

import educative.grokking.stacks as stacks

class TestStack(unittest.TestCase):
  def test_get_next_token(self):
    expr = "40 - 25 - 5"
    sb = io.StringIO()
    sb.write(expr)
    sb.seek(0)
    token = stacks.get_next_token(sb)
    tokens = [token]
    while token != stacks.EOS:
      token = stacks.get_next_token(sb)
      tokens.append(token)
    self.assertEqual(tokens, [40, '-', 25, '-', 5, ''])

  def test_calculator(self):
    self.assertEqual(stacks.calculator("(27 + (7 + 5) - 3) + (6 + 10)"), 52)
    self.assertEqual(stacks.calculator("(8 + 100) + (13 - 8 - (2 + 1))"), 110)
    self.assertEqual(stacks.calculator(" 1-8  -  (-5-1)  "), -1)
    self.assertEqual(stacks.calculator("(-1)-(-(-2+3)-4)"), 4)

if __name__ == '__main__':
  unittest.main()
