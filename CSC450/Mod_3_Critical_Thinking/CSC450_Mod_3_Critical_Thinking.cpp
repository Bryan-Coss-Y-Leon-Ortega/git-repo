//============================================================================
// Name        : CSC450_Mod_3_Critical_Thinking.cpp
// Author      : Bryan Coss Y Leon
// Version     :
// Copyright   : Your copyright notice
// Description : Program: Create a C++ program that asks the user to enter three integer values as input. Store the values into three different variables.
// 				 For each variable, create an integer pointer to dynamic memory. Display the contents of the variables and pointers.
//				 In your program, be sure to use the new operator and delete operators to management memory.
//============================================================================

#include <iostream>
#include <limits>
using namespace std;

// This function will check if valid integers are inputed by the user.
// This function will not throw an exception when a user does not insert a non integer,
//		but return a message not allowing the input, and requesting a different input.
//		This will allow the user to keep until there is an integer and finish the prompt
int validInts(){
	int value;
	cout << "Please input an integer value " << endl;
	bool flag = false;
	while (flag == false){
		if(!(cin >> value)){
			cin.clear();
			//This will ignore the rest of the line
			cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
			cout << "Invalid input, please enter an integer" << endl;
			//throw runtime_error("Invalid input, please enter an integer");
		}else{

			flag = true;
			return value;
		}
	}
	return value;
}

int main() {
	// Values for user input
	int first;
	int second;
	int third;

	//Pointer we will use to reference the values of the user input
	int * fPntr;
	int * sPntr;
	int * tPntr;

	//This try will make sure there us proper memory allocation for the pointers.
	// There will not be a catch for invalid input as the validInts() function will check for that
	try{
	first = validInts();
	second = validInts();
	third = validInts();


	fPntr  = new int(first);
	sPntr =  new int (second);
	tPntr = new int(third);

	//Variable results
	cout << "Variable 1: " << first << endl;
	cout << "Variable 2: " << second << endl;
	cout << "Variable 3: " << third << endl;

	cout << "Pointer 1 address " << fPntr << " and value: " << *fPntr << endl;
	cout << "Pointer 2 address " << sPntr << " and value: " << *sPntr << endl;
	cout << "Pointer 3 address " << tPntr << " and value: " << *tPntr << endl;
	}catch(bad_alloc& e){
		cerr << "Memory Allocation failed: " << e.what() << endl;
	}


	// Here we will clean the memory and pointers that we have used
	fPntr = nullptr;
	sPntr = nullptr;
	tPntr = nullptr;

	delete fPntr;
	delete sPntr;
	delete tPntr;



	return 0;
}
