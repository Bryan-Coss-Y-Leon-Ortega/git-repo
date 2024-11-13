#-------------------------------------------
# Program Name: Module 2: Critical Thinking Option #1
# Author: Bryan Coss Y Leon Ortega 
# Date: 10/23/2024
# ------------------------------------------
# Pseudocode:
# Read user input String S, S > 50 characters
# 1. if S has any alphanumeric characters, print true, else False
# 2. If S has any alphabeltical characters, print true, else False
# 3. If S has any digits, print true, else, print False
# 4. if S has any lowercase characters, print true, else False
# 5. If S has any uppercase characters, print true, else False
# -----------------------------------------
# Program Inputs: QWerty125
# Program Outputs: 
# Are any characters in the string alphanumerical: True
# Are any characters in the string alphabetical: True  
# Are any characters in the string digits: True        
# Are any characters in the string lowercase: True     
# Are any characters in the string uppercase: True 
#-------------------------------------------

# In this line of code, we prompt the user for an input
S = input("Please input a string of less than 50 characters: ")
#print(S)

# Here we have a loop that checks in the string if ANY char
# fits the description of the psuedocode. True if it does, false if it does not.
# Each element will be a boolean
# in the 'any' loop, it will go through the input of the string S
# and check if it has the following characters: Alphanumerical, alphabetic, digits, lower/upper-case
has_alphanum = any(char.isalnum() for char in S)
has_alpha = any(char.isalpha() for char in S)
has_digit = any(char.isdigit() for char in S)
has_lower = any(char.islower() for char in S)
has_upper = any(char.isupper() for char in S)
 
# From the booleans above, the print statement will return the result of the loop. 

print(f"Are any characters in the string alphanumerical: {has_alphanum}")
print(f"Are any characters in the string alphabetical: {has_alpha}")
print(f"Are any characters in the string digits: {has_digit}")
print(f"Are any characters in the string lowercase: {has_lower}" )
print(f"Are any characters in the string uppercase: {has_upper}")



s