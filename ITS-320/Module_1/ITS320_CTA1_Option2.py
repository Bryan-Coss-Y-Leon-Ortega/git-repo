#Bryan Coss Y Leon Ortega
#Module 1 Critical thinking 
#ITS 320


#Read two integers and print three lines. The first line should contain integer division, //, 
#the second line should contain float division, /, and the third line should contain modulo division, %.
#You do not need to perform any rounding or formatting operations.0
#Input Format The first line contains the first integer. The second line contains the second integer.
#Output Format Print the three lines as described above.
#Sample Input43
#Sample Output11.33333333333333331

int1 = int(input("Enter the first integer "))

int2 = int(int1 / 10)  #this will grab the 10s
int3 = int1 % 10 #this will grab the 1s

div = int(int2 / int3)
flo = float (int2 / int3)
mod = int2 % int3

print(f"{div}{flo}{mod}")