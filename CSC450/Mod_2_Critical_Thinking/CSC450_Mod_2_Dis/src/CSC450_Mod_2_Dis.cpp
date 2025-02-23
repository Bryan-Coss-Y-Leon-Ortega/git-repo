//============================================================================
// Name        : CSC450_Mod_2_Dis.cpp
// Author      : Bryan Coss Y Leon
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <cstring>


using namespace std;

int main() {

	string first;
	string second;
	const int MAX = 100;
	char third[MAX];
	char word1[6] = {'F', 'A', 'R', 'M', 'S'};
	char word2[7] = {'F', 'A', 'R', 'M', 'S', '\0'};

	cout << "Please enter a strings" << endl;
	cin >> first;
	cout << "Please enter a second string" << endl;
	cin >> second;

	cout << first << " and " << second << endl;

	cout << "Enter a third string"<< endl;
	cin >> third;
	cout << "Third string is " << third << endl;

	cout << "String 1 length " << first.length()  << endl;
	cout << "String 2 length " << second.size() << endl;
	cout << "String 3 length " << strlen(third)  << endl;

	cout << "The C strings word 1: " << word1 << endl;
	cout << "The C strings word 2: " << word2 << endl;

	return 0;
}
