#-------------------------------------------
# Program Name: Option #1: String Values in Reverse Order
# Author: Bryan Coss Y Leon 
# Date:
#-------------------------------------------
# Pseudocode: [See suggestions below]
#-------------------------------------------
# Program Inputs: [See suggestions below]
# Program Outputs: [See suggestions below]
#-------------------------------------------


def string_Reverse(str1, str2, str3):

    

    return str3[::-1]+ " " + str2[::-1]+ " " + str1[::-1]

print("This program will intake 3 strings and return it in a concatenated reversed order. \n")
String1 = input("Please input a string: ")
String2 = input("Please input a string: ")
String3 = input("Please input a string: ")

result = string_Reverse(String1, String2, String3)

print(result)