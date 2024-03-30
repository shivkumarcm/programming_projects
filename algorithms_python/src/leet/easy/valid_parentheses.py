from queue import LifoQueue
class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        stack = LifoQueue()
        for c in s:
            if c == '(' or c == '[' or c == '{':
                stack.put(c)
            if c == ')':
                if stack.empty() or stack.get() != '(':
                    return False
            if c == ']':
                if stack.empty() or stack.get() != '[':
                    return False
            if c == '}':
                if stack.empty() or stack.get() != "{":
                    return False
        return stack.empty()