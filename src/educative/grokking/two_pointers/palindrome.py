def is_palindrome(s):
  
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
