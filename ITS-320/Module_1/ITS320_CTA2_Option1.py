#-------------------------------------------
# Program Name: Module 2: Critical Thinking Option #1
# Author: Bryan Coss Y Leon Ortega 
# Date: 10/17/2024
# ------------------------------------------
# Pseudocode:
# Read user input String S, S > 50 characters
# 1. if S has any alphanumeric characters, print true, else False
# 2. If S has any alphabeltical characters, print true, else False
# 3. If S has any digits, print true, else, print False
# 4. if S has any lowercase characters, print true, else False
# 5. If S has any uppercase characters, print true, else False
# 6. 
# -----------------------------------------


S = input("Please input a string of less than 50 characters: ")
#print(S)


has_alphanum = any(char.isalnum() for char in S)
has_alpha = any(char.isalpha() for char in S)
has_digit = any(char.isdigit() for char in S)
has_lower = any(char.islower() for char in S)
has_upper = any(char.isupper() for char in S)
 
print(f"Are any characters in the string alphanumerical: {has_alphanum}")
print(f"Are any characters in the string alphabetical: {has_alpha}")
print(f"Are any characters in the string digits: {has_digit}")
print(f"Are any characters in the string lowercase: {has_lower}" )
print(f"Are any characters in the string uppercase: {has_upper}")




