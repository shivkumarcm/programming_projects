def find_repeated_sequences(s, k):
  hashmap = {}
  start = 0
  end = k
  while end < len(s):
    substr = s[start:end]
    val = hashmap.get(substr)
    if val:
      hashmap[substr] = val + 1
    else:
      hashmap[substr] = 1
    start += 1
    end += 1

  retval = set()
  for substr in hashmap.keys():
    if hashmap[substr] > 1:
      retval.add(substr)
  return retval

def find_max_sliding_window(nums, w):
  n = len(nums);
  if w > n:
    w = n

  deque = []
  # compute the first running_max
  for i in range(0, w):
    deque.append(nums[i])
  deque.sort()

  retval = []
  retval.append(deque[w-1])

  start = 0
  end = w
  while end < n:
    newval = nums[end]
    if newval > retval[start]:
      retval.append(newval)
      deque.remove(nums[start])
      deque.append(newval)
    else:
      deque.remove(nums[start])
      index = 0
      while index < w-1 and deque[index] < newval:
        index += 1
      deque.insert(index, newval)
      retval.append(deque[w-1])
    start += 1
    end += 1

  return retval