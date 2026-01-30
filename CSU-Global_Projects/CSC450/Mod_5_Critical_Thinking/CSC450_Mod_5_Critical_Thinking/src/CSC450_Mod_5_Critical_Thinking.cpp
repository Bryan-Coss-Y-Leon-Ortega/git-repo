//============================================================================
// Name        : CSC450_Mod_5_Critical_Thinking.cpp
// Author      : Bryan Coss Y Leon
// Version     :
// Copyright   :
// Description : text file, without deleting the existing data:
// Store the provided data in the CSC450_CT5_mod5.txt file.
// Create a reversal method that will reverse all of the characters in the CSC450_CT5_mod5.txt file and store the result in a CSC450-mod5-reverse.txt file.
//============================================================================

#include <iostream>
#include <fstream>
#include <string>

using namespace std;

// This is the reversal method.
// This takes in a string and reverses it by iterating the string from a loop backwards.
string reverseString(string str){

	int len = str.length();
	string temp;

	for(int i = len - 1; i >= 0; i-- ){
		temp += str[i];
	}
	//This will return the comment to the command line to verify the string has been reversed
	cout << temp << endl;
	return temp;
}

int main() {
	//The input and output files for what we are using.
	//ifstream file;
	ofstream MyFile;

	// Opening the files here to
	ofstream file("CSC450_CT5_mod5.txt", ios::app);
	MyFile.open("CSC450-mod5-reverse.txt", ofstream::trunc);

	string str;
	string user;
	string file_contents;
	string strReverse;


	// Checks if the file was opened correctly
	// Returns error message and a 1 to show error
	if(!file){
		cerr << "Error opening file" << endl;
		return 1;
	}

	// Here we are to write into the file
	// We have to create a ofstream to write into the file and then an ifstream to read the file for later.
	cout << "Please write into the file" << endl;
	getline(cin, user);
	file << user << endl;
	file.close();

	ifstream readFile("CSC450_CT5_mod5.txt");

	// Here it opens the file and reads out all the contents of the txt.
	// The content will be placed into file_contents string to be used
	if(readFile.is_open()){
		while(getline(readFile, str)){
				file_contents += str;
				file_contents.push_back('\n');

			}
	}else{
		cerr << "Error opening file to be read" <<endl;
		return 1;
	}
	// Here we are writing the string into the new txt file
	if(MyFile.is_open()){
		strReverse = reverseString(file_contents);
		MyFile << strReverse;
	}else{
		cerr<<"Error writing file." << endl;
		return 1;
	}

	// Closing the files here
	MyFile.close();
	readFile.close();

	//This comment checks what the file_content has.
	//file_content should contain everything from the file.
	//cout << file_contents << endl;



	return 0;
}
