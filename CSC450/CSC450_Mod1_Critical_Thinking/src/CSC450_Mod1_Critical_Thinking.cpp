//============================================================================
// Name        : CSC450_Mod1_Critical_Thinking.cpp
// Author      : Bryan Coss Y Leon
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <string>
using namespace std;

int main() {
	string firstName = "Bryan";
	string lastName = "Leon";
	string addy = "904 N 111th Dr.";
	string city = "Avondale";
	int zip = 85323;

	cout << "Hello, my name is " << firstName << " " << lastName <<endl;
	cout << "I am allegedly located at " << addy + " " << city + " " << zip <<endl;
	return 0;
}
