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
    # To divide complex numbers =   (a + bi) = (ac + bd)  +  (bc-ad)
    #                               (c + di)   (c2 + d2)  +  (c2 + d2)
    def __truediv__(self, no):
        denom = no.real**2 + no.imaginary**2
        return Complex((self.real * no.real  - self.imaginary * no.imaginary) / denom, (self.real * no.imaginary + self.imaginary * no.real) / denom)

    # This will be the modulus of complex number
    # (a + bi) -> sqrt(a2 + b2)
    def mod(self):
        # enter your code here
        return Complex(math.sqrt(self.real**2 + self.imaginary**2))

    # This will return the complex number in correct order
    def __str__(self):
        # enter your code here
        return f"{self.real} + {self.imaginary}j"

# put this code in a main method
num1 = Complex(2, 1)
num2 = Complex(5, 6)

C = map(float, input().split())
D = map(float, input().split())
x = Complex(*C)
y = Complex(*D)
print ('\n'.join(map(str, [x+y, x-y, x*y, x/y, x.mod(), y.mod()]))) 