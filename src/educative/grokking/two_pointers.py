
def find_sum_of_three(nums, target):
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
