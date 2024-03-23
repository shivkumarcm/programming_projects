from .utils.sum_of_squared_digits import sum_of_squared_digits

def is_happy_number(n):
  """
  Given a number n, determine if it is a happy number.
  See: https://www.educative.io/courses/grokking-coding-interview-patterns-python/happy-number
  """
  slow_ptr = n
  fast_ptr = sum_of_squared_digits(n)

  while fast_ptr != 1 and fast_ptr != slow_ptr:
    slow_ptr = sum_of_squared_digits(slow_ptr)
    fast_ptr = sum_of_squared_digits(sum_of_squared_digits(fast_ptr))

  if fast_ptr == 1:
    return True

  return False


def detect_cycle(head):

  if not head:
    return False

  slow_ptr = head
  fast_ptr = head

  while True:
     slow_ptr = slow_ptr.next
     fast_ptr = fast_ptr.next
     if fast_ptr:
        fast_ptr = fast_ptr.next
     if fast_ptr == None:
        return False
     if fast_ptr == slow_ptr:
        return True

def get_middle_node(head):
  if not head:
    return None

  slow_ptr = head
  fast_ptr = head

  while True:
    if not fast_ptr:
      return slow_ptr
    elif fast_ptr and not fast_ptr.next:
      return slow_ptr

    slow_ptr = slow_ptr.next
    fast_ptr = fast_ptr.next
    if fast_ptr:
      fast_ptr = fast_ptr.next