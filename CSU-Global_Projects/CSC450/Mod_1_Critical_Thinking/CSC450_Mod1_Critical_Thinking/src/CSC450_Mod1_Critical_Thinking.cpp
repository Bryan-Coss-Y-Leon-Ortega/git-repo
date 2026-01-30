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
	std::string firstName = "Bryan";
	std::string lastName = "Leon";
	std::string addy = "904 N 111th Dr.";
	std::string city = "Avondale";
	int zip = 85323;

	std::cout << "Hello, my name is " << firstName << " " << lastName <<endl;
	std::cout << "I am allegedly located at " << addy + " " << city + ", " << zip << endl;
	return 0;
}
