# Source: https://www.educative.io/courses/grokking-coding-interview-patterns-python/happy-number
def sum_of_squared_digits(number):  # Helper function that calculates the sum of squared digits.
  total_sum = 0
  while number > 0:
    digit = number % 10
    number = number // 10
    total_sum += digit ** 2
  return total_sum