#-------------------------------------------
# Program Name: Option #1: String Values in Reverse Order
# Author: Bryan Coss Y Leon 
# Date: 11/10/2024
#-------------------------------------------
# Pseudocode: 
# The program will prompt the user to input three different strings
# These strings will then be sent into a function string_Reversed
# In string_Reversed, the 3 strings the user inputted will be reversed order and concatenated together in the return
# The string returned will be the 3 strings reversed in 3-2-1 order

#-------------------------------------------
# Program Inputs: 
# Please input a string: I love you
# Please input a string: to the moon
# Please input a string: and back

# Program Outputs: 
# kcab dna noom eht ot  uoy evol I
#-------------------------------------------


def string_Reverse(str1, str2, str3):

    return str3[::-1]+ " " + str2[::-1]+ " " + str1[::-1]

print("This program will intake 3 strings and return it in a concatenated reversed order. \n")
String1 = input("Please input a string: ")
String2 = input("Please input a string: ")
String3 = input("Please input a string: ")

result = string_Reverse(String1, String2, String3)

print(result)