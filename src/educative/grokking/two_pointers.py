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
