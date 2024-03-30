from queue import LifoQueue as Stack
from io import StringIO as StringBuffer

# "12 - (6 + 2) + 5"
# "(27 + (7 + 5) - 3) + (6 + 10)"

WS = ' ' # white space
EOS = '' # end of string
PLUS = '+'
MINUS = '-'
OPEN_PAR = '('
CLOSE_PAR = ')'

def get_next_token(buffer):
  c = buffer.read(1)
  while c == WS:
    c = buffer.read(1)
  if c == EOS or c == OPEN_PAR or c == CLOSE_PAR or c == PLUS or c == MINUS:
    return c
  numstr = []
  if c.isdigit():
    while c.isdigit():
      numstr.append(c)
      c = buffer.read(1)
    if c != EOS:  # if its not the end of the buffer
      buffer.seek(buffer.tell()-1) # go back one character
    return int("".join(numstr))
  return None #unknown input!

def calculator(s):
  sb = StringBuffer()
  sb.write(s)
  sb.seek(0)
  stack = Stack()
  #cur_val = None
  cur_op = None
  result = None
  while True:
    next_token = get_next_token(sb)
    #print("======================")
    #print("result: " + str(result))
    #print("processing token: " + str(next_token))
    if next_token == EOS:
      return result
    if isinstance(next_token, int):
      if not result:
        if cur_op == MINUS: #unary minus operation
          result = - next_token
        else:
          result = next_token
      elif cur_op == PLUS:
        result += next_token
        cur_op = None
      elif cur_op == MINUS:
        result -= next_token
        cur_op = None
      else:
        print("ERROR Processing int(" + str(next_token) + ")::Unknown operator: " + str(cur_op))
        return None # unknown scenario!!!
    elif next_token == OPEN_PAR:
      if isinstance(result, int): # note that if result is 0, then that is considered False boolean
        #print("stack::push int(" + str(result) + ") and op: " + cur_op)
        stack.put(result)
        stack.put(cur_op)
        result = None
        cur_op = None
    elif next_token == CLOSE_PAR:
      if not stack.empty():
        cur_op = stack.get()
        stack_top = stack.get()
        if cur_op == PLUS:
          result = stack_top + result
          cur_op = None
        elif cur_op == MINUS:
          result = stack_top - result
          cur_op = None
        else:
          print("ERROR Processing CLOSE_PAR::Unknown operator: " + str(cur_op))
          return None # unknown scenario
    elif next_token == PLUS:
      cur_op = PLUS
    elif next_token == MINUS:
      cur_op = MINUS
      if not result: # handle negative integer case
        #print("Unary minus case")
        result = 0


def remove_duplicates(string):
  """
  Remove successive duplicates in string
  abbc -> ac
  azxxzy -> ay
  """
  stack = Stack()
  for letter in string:
      if stack.empty():
          stack.put(letter)
      else:
          prev = stack.get()
          if prev != letter:
              stack.put(prev)
              stack.put(letter)
  retval = []
  while not stack.empty():
      retval.append(stack.get())
  retval.reverse()
  return ''.join(retval)

def min_remove_parentheses(s):
  """
  Remove the minimum number of parentheses to make
  it a proper expression and return.
  """
  stack = Stack()

  i = 0
  for letter in s:
    if letter == '(':
      stack.put((i, letter))
    if letter == ')':
      if not stack.empty():
        stack_top = stack.get()
        if stack_top[1] != '(':
          stack.put(stack_top)
          stack.put((i, letter))
      else:
        stack.put((i, letter))
    i += 1

  lst = [letter for letter in s]
  while not stack.empty():
    i, _ = stack.get()
    lst[i] = ''

  return ''.join(lst)