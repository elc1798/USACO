#include <fstream>
#include <iostream>

using namespace std;

int numTestCases;
int tests[100];

void runThrough(int x , int y) {

	bool grid[x][y];

	

}

int main() {

	ifstream fin("test.in");
	fin >> numTestCases;

	for (int i = 0; i < numTestCases; i++) {
		fin >> tests[2 * i];
		fin >> tests[2 * i + 1];
	}

//	bool test;
//	cout << test << endl;

	return 0;

}
