#-------------------------------------------
# Program Name: Option #2: Repetition Control Structure - Grade Statistics
# Author: Bryan Coss Y Leon Ortega
# Date: 11/4/24
#-------------------------------------------
# Pseudocode: 
# The user will input 5 different sets of grades
# These grades will be floating point values 
# I will perform three different operations with these numbers:
# First I will find the average
#   Because I will need 5 values, i will have a running total and then divide by 5.
# Then i will find the minimum value
#   For this, i will assign the first value to minimum and compare the rest of the inputs. if there is a smaller values, it will become the new minimum
# and the Maximum value
#   For this, i will assign the first value to maximum and compare the rest of the inputs. if there is a smaller values, it will become the new maximum
#-------------------------------------------
# Program Inputs: 75 80 87 72 74
# Program Outputs: 
# Average: 77.60
# Maximum: 87
# Minimum: 72
#-------------------------------------------

total = 0
i = 0


grades = int(input("Please insert the grades of the five students. "))
Max = grades
Min = grades
total += grades


while i < 4:
    grades = int(input("Please insert the grades of the five students. "))
    total += grades
    if(grades > Max):
        Max = grades
    if(grades < Min):
        Min = grades
    i += 1

total = total / 5
print('Average: ', total)
print("Maximum: ", Max)
print("Minimum: ", Min)