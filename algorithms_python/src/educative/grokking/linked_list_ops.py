def reverse(head):
  # If head is null or is a single node, nothing to do!
  if not head:
    return None

  prev = None
  ptr = head
  rest = head.next

  while rest:
    ptr.next = prev
    prev = ptr
    ptr = rest
    rest = rest.next

  ptr.next = prev
  return ptr