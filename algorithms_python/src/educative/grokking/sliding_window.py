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
