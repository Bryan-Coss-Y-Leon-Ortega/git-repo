#-------------------------------------------
# Program Name: Creating a Program to Calculate the Value of a Ferrari
# Author: Bryan Coss Y Leon Ortega 
# Date: 10/25
#-------------------------------------------
# Pseudocode: 
# Prompt for user to input a year, the input has to be an int
# from a table, The table has values of years from 1962 - 2014
# We will look into the table and return the dollar value 
# 
#-------------------------------------------

#
# Program Inputs:                   Program outputs:
# 1962                                  $18,500
# 1966                                  $ 6,000
# 1971                                  $12,000
# 1974                                  $48,000 
# =================================================
#
# ==  Key  == 
#
# Year      Value
# 1962-1964	$18,500
# 1965-1968	$6,000
# 1969-1971	$12,000
# 1972-1975	$48,000
# 1976-1980	$200,000
# 1981-1985	$650,000
# 1986-2012	$35,000,000
# 2013-2014	$52,000,000
#-------------------------------------------
# We need the users input for the car year
year =  int(input('Enter year:\n'))

# The year will be compared to the years of the key above.
# The value will compare to each if statement until it finds the appropriate year and will print the value. 
# if the year is not within the key, then the program will throw an else statement. 
if 1962 <= year <=1964 :
    print('$18,500')
elif 1965 <= year <= 1968:
    print('$6,000')
elif 1969 <= year <= 1971:
    print('$12,000')
elif 1972 <= year <= 1975:
    print('$48,000')
elif 1976 <= year <= 1980:
    print('$200,000')
elif 1981 <= year <= 1985:
    print('$650,000')
elif 1986 <= year <= 2012:
    print('$35,000,000')
elif 2013 <= year <= 2014:
    print('$52,000,000')
else:
    print('Not a valid year')
