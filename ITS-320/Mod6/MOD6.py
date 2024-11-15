def square(x):

    
    return print("The area of the square is = " + str(x * x))

def rectangle(x, y):
    
    return print("The area of the rectangle is = " + str(x * y))

print("Hello, we are learning the difference between squares and rectangles")
print("The area of a rectangle is defined as A = W * L")
print("The area of a square is defined as A = W * W")
print("Here are some examples:")

x = int(input("input a length for a square: "))
y = int(input("Input the width of a rectangle: "))
z = int(input("Input the length of a rectangle: "))

square(x)

rectangle( y , z)