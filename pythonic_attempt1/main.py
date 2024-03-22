# https://www.educative.io/courses/learn-python-3-from-scratch/project-pythonic-attempt-1
# Take input from user, ask their name, and save it in a variable.
import random
import math
user_name = input("Enter your name: ")
print("Hello, " + user_name +"! Welcome to this program!")
print("Please answer these five arithmetic questions. Press any key to continue...")
input("")
ops = ['+', '-', '*', '/']
score = 0
for i in range(5):
    arg1 = random.randint(1, 9)
    arg2 = random.randint(1, 9)
    op = random.choice(ops)
    user_inp = input("" + str(arg1) + " " + op + " " + str(arg2) + " = ")
    corr_val = 0
    if op == '+':
        corr_val = arg1 + arg2
    elif op == '-':
        corr_val = arg1 - arg2
    elif op == '*':
        corr_val = arg1 * arg2
    else:
        corr_val = arg1 / arg2

    corr_val = math.floor(corr_val)
    try:
        if corr_val == int(user_inp):
            score = score + 1
            print("Correct!")
        else:
            print("Incorrect. The correct answer is : " + str(corr_val))
    except:
        print("Incorrect. The correct answer is : " + str(corr_val))

if score > 0:
    print("Congratulations, " + user_name + "! You got " + str(score) + " answers correct!")
else:
    print("Sorry, " + user_name + "! None of your answers were correct. Please try again!")
