def reverse(head):
  prev = None
  ptr = head

  while ptr:
    temp = ptr.next
    ptr.next = prev
    prev = ptr
    ptr = temp

  return prev


def reverse_k_groups(head, k):
  first_head = None
  prev, ptr = None, head
  counter = 0
  while ptr:
    i = 0
    prev = None # this will be the new head
    tail = ptr # this will be the new tail
    #print(str(counter) + ": tail=" + str(tail))
    # Reverse in place
    while i < k and ptr:
      temp = ptr.next
      ptr.next = prev
      prev = ptr
      ptr = temp
      i += 1
    #print(str(counter) + ": ptr=" + str(ptr))
    if counter == 0:    # in the first iteration, store the first head
      first_head = prev
    counter += 1

    # Set the tail to point to the next head
    prev, next_head, j = None, ptr, 1
    while next_head and j < k:
      prev = next_head
      next_head = next_head.next
      j += 1
    if next_head:
        tail.next = next_head
    else:
        tail.next = prev

  return first_head

def reverse_between(head, left, right):
  prev, ptr = None, head
  counter = 1
  # Traverse the first portion unchanged
  while ptr and counter < left:
    prev = ptr
    ptr = ptr.next
    counter += 1

  # print("prev =" + str(prev) + " ptr=" + str(ptr))
  leftptr = prev
  tail = ptr

  # Reverse the middle portion in place
  while ptr and counter <= right:
    temp = ptr.next
    ptr.next = prev
    prev = ptr
    ptr = temp
    counter += 1

  # print("prev =" + str(prev) + " ptr=" + str(ptr))

  # Attach the first portion of the list with the new head of the reversed portion
  if leftptr:
    leftptr.next = prev

  # Attach the tail of the reversed portion to the head of the remaining portion
  if tail:
    tail.next = ptr

  if left == 1:  # this means the head will change
    return prev
  else:  # else head remains unchanged
    return head
