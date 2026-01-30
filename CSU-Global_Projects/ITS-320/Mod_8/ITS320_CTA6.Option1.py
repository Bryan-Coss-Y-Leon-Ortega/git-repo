#-------------------------------------------
# Program Name: Option #1: Working with Python Classes
# Author: Bryan Coss Y Leon 
# Date: 11/17/2024
#-------------------------------------------
# Pseudocode: 
# The program will prompt the user to input 2 different complex numbers
# The 2 complex numbers will go through a few mathematical operations
# Addition, subtraction, multiplication, division, and modulus
# These answers will be print in a + bi format at 2 decimal places.
# 
#-------------------------------------------
# Program Inputs: 
# 2 1
# 5 6

# Program Outputs: 
# 7.00 + 7.00i
# -3.00 - 5.00i
# 4.00 + 17.00i
# 0.26 - 0.11i
# 2.24 + 0.00i
# 7.81 + 0.00i
#-------------------------------------------
import math

class Complex(object):
    def __init__(self, real, imaginary):
        self.real = real
        self.imaginary = imaginary

    # This will be the addition of 2 complex numbers.  
    # To add complex numbers, you must add the real numbers separate from adding the imaginary numbers. 
    def __add__(self, no):
        
        return Complex(self.real + no.real, self.imaginary + no.imaginary)

    # This will be subtraction of 2 complex numbers.
    # To subtract complex numbers, you must subtract real and imaginary numbers.
    def __sub__(self, no):
        # enter your code here       
        return Complex(self.real - no.real, self.imaginary - no.imaginary)

    # This will be multiplying complex numbers
    # to multiply complex numbers: (a + bi)(c + di) = (ac - bd) + (ad + bc)i
    def __mul__(self, no):
        
        return Complex((self.real * no.real  - self.imaginary * no.imaginary), (self.real * no.imaginary + self.imaginary * no.real))

    #This will be dividing complex numbers
    # To divide complex numbers =   (a + bi) = (ac + bd)  +  (bc - ad)
    #                               (c + di)   (c2 + d2)  +  (c2 + d2)
    def __truediv__(self, no):
        denom = no.real**2 + no.imaginary**2
        return Complex((self.real * no.real  + self.imaginary * no.imaginary) / denom, (self.real * no.imaginary - self.imaginary * no.real) / denom)

    # This will be the modulus of complex number
    # (a + bi) -> sqrt(a2 + b2)
    def mod(self):
        # enter your code here
        results  = math.sqrt(self.real**2 + self.imaginary**2)
        return (Complex(results, 0))

    # This will return the complex number in correct order
    def __str__(self):
        return f"{self.real:.2f} + {self.imaginary:.2f}j"

# put this code in a main method
# Testing
# test1 = Complex(2, 1)
# test2 = Complex(5, 6)
# print("Addition:", test1 + test2)
# print("Subtraction:", test1 - test2)
# print("Multiplication:", test1 * test2)
# print("Division:", test1 / test2)
# print("Modulus: ", test1.mod())
# print("Modulus: ", test2.mod())
print("Please enter two complex equations in the format A B followed by a new line and C D, this will represent A + Bi ")
C = map(float, input().split())
D = map(float, input().split())
x = Complex(*C)
y = Complex(*D)
print ('\n'.join(map(str, [x+y, x-y, x*y, x/y, x.mod(), y.mod()]))) 