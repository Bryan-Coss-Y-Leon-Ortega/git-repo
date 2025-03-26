//============================================================================
// Name        : CSC450_Mod_7_Critical_Thinking.cpp
// Author      : Bryan Coss Y Leon
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <thread>
#include <mutex>
using namespace std;

int counter = 0;
mutex mtx;

void countPlus(){
	mtx.lock(); //This will lock the shared resource for this project to run
	for(int i = 0; i < 20; ++i){
		cout << "Count up: " << counter << endl;
		counter++;
	}
	mtx.unlock(); //This will unlock the resource
}

void countMinus(){

	//Automatic lock and unlock for the object.
	lock_guard<mutex>lock(mtx);

	for(int i = 20; i > 0; --i){
		cout << "Count down: " << counter << endl;
		counter--;
	}

}

int main() {
	//This thread is to start and finish before the countdown thread
	thread t1(countPlus);
	t1.join();

	//This thread is to start after the countup and countdown to zero.
	thread t2(countMinus);
	t2.join();

	cout << "Counter = " << counter << endl;
	return 0;
}
