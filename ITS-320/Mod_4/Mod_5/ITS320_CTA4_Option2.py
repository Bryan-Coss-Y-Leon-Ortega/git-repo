#-------------------------------------------
# Program Name: Option #2: Repetition Control Structure - Grade Statistics
# Author: Bryan Coss Y Leon Ortega
# Date: 11/4/24
#-------------------------------------------
# Pseudocode: 
# I will use a for loop for user input. I will  
#-------------------------------------------
# Program Inputs: 75 80 87 72 74
# Program Outputs: 
# Average: 77.60
# Maximum: 87
# Minimum: 72
#-------------------------------------------

total = 0;

# This is a loop that will be taking all the grades into a list
# This list grades will have 5 grades total
grades = []
for i in range(5):
    grade = int(input("Enter a grade: "))
    grades.append(grade)

# This Max and Min are here assigned to the first object in the list grades.
# This is to ensure the max and min are numbers in the list and not any arbituray number

Min = grades[0];
Max = grades[0];

# This for loop will go through each element in the list Grade
# 3 things are happening: 
# total is adding all the elements together
# there is a min and max if statement comparing every element to the element in the lsit looking for the min and max,
for j in range(5):
    total += grades[j]
    if(Min > grades[j]):
        Min = grades[j]
    if(Max < grades[j]):
        Max = grades[j]

#test
#print(grades)

# Here are the prints, Average, Max, and Min to 2 decimal points since it is a floating number.
print(f"Total grade average is: {total / 5:.2f}")
print(f'Maximum grade: {Max:.2f}')
print(f'Minimum grade: {Min:.2f}')