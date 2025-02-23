//============================================================================
// Name        : CSC450_Mod_2.cpp
// Author      : Bryan Coss Y Leon
// Version     :
// Copyright   : Your copyright notice
// Program: Create a simple C++ console application that will write a program that will take two string inputs from a user.
// Your program should concatenate the two strings and then print the resulting output to the screen.
// Take the two string inputs from the user 3 times for varying string lengths.
//
//============================================================================

#include <iostream>
#include <cstring>

using namespace std;


int main() {
	//Strings for the first string, second string and a temp string
	//temp string will be the string i use to concat both strings together
	string first;
	string second;
	string temp;


	// We wull create an array to hold the 3 inputs of the user
	string stringArray[3];
	// this is the counter for the loop. It should be initialized at 0 and count every time
	// the loop is iterated
	int count = 0;

	// this will while loop that will ask for the user input of the 3 strings.
	// This method will ask for the first and second string using strings, concatenate, and store in array
	while(count < 3){
		cout <<"what is the first string "<< endl;
		getline(cin, first);
		cout << "What is the second string " << endl;
		getline(cin, second);
		temp = first + " " + second;
		stringArray[count] = temp;
		count++;
	}

	//a for loop that will print the concat strings in a seperate line held in the array of strings on separated lines.
	for(int i = 0; i <3; i++){
		cout<< stringArray[i] << endl;
	}
	//this ends the program
	return 0;
}
