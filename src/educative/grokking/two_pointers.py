def is_palindrome(s):
  """
  Given a string, s, as an input and determines whether or
  not it is a palindrome
  """
  if s == None:
    return False
  
  start = 0
  end = len(s) - 1
  
  while start < end:
    if s[start] != s[end]:
      return False
    start = start + 1
    end = end - 1
  return True


def find_sum_of_three(nums, target):
   """
   Given an array of integers, nums, and an integer value, target,
   determine if there are any three integers in nums whose sum is
   equal to the target.
   """
   if len(nums) < 3:
      return False
   nums.sort()
   for i in range(len(nums)):
      newtarget = target - nums[i]
      start = i + 1
      end = len(nums) - 1
      while start < end:
         sum = nums[start] + nums[end]
         if sum > newtarget:
            end = end - 1;
         elif sum < newtarget:
            start = start + 1
         else:
            return True
   return False

from utils.linked_list import LinkedList
from utils.linked_list_node import LinkedListNode

def remove_nth_last_node(head, n):
    """
    Given a singly linked list, remove the nth node from the end
    of the list and return its head.
    """
    prev_start = None
    start = head
    end = head.next

    for i in range(n-1):
        if end == None:
            raise ValueError("n is greater than length of the linked list!")
        end = end.next
    
    while end:
        prev_start = start
        start = start.next
        end = end.next
    
    if prev_start:
        prev_start.next = start.next
    else:
        head = head.next

    return head

def sort_colors(colors):
    """
    Given an array, colors, which contains a combination of the following three elements: 0, 1, 2
    Returned a sorted array
    """
    start0s = -1
    current1 = 0
    end2s = len(colors)

    while(current1 < end2s):
        if colors[current1] == 0:
            start0s = start0s + 1
            __swap(colors, start0s, current1)
            current1 = current1 + 1
        elif colors[current1] == 1:
            current1 = current1 + 1
        else:
            end2s = end2s - 1
            __swap(colors, current1, end2s)
    return colors

def __swap(colors, i, j):
    temp = colors[i]
    colors[i] = colors[j]
    colors[j] = temp
