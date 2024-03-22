# Source: https://www.educative.io/courses/grokking-coding-interview-patterns-python/remove-nth-node-from-end-of-list
# Template for linked list node class

class LinkedListNode:
    # __init__ will be used to make a LinkedListNode type object.
    def __init__(self, data, next=None):
        self.data = data
        self.next = next
