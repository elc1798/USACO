#include <fstream>
#include <iostream>
#define MAX_LENGTH_POSSIBLE 9001

using namespace std;

int arrLength;
int A[MAX_LENGTH_POSSIBLE];
int B[MAX_LENGTH_POSSIBLE];
int locations[MAX_LENGTH_POSSIBLE];
int correct = 0;
int cycle_container[MAX_LENGTH_POSSIBLE];
int numCycles = 0;

int find(int a) {
	return locations[a];
}

bool inContained(int n) {
	return (n == cycle_container[n]);
}

int cycle(int n) {
	if (A[n] == B[n]) {
		correct++;
		return -1;
	}
	if (n > arrLength) {
		return -1;
	}
	int start = A[n];
	int next = B[find(start)];
	bool valid = false;
	int moved = 0;
	while (start != next && !inContained(start)) {
//		cout << start << " ->  B[" << find(start) << "] = " << next << endl;
		valid = true;
		cycle_container[start] = start;
		correct++; moved++;
		start = next;
		next = B[find(start)];
	}
	if (valid) {numCycles++;}
	return moved;
}

int main() {

	ifstream fin("reorder.in");
//	ifstream fin("8.in");
	fin >> arrLength;
	for (int i = 0 ; i < arrLength ; i++) {
		fin >> A[i];
//		cout << A[i] << " , ";
	}
//	cout << endl;
	for (int i = 0 ; i < arrLength ; i++) {
		fin >> B[i];
		locations[A[i]] = i;
//		cout << B[i] << " , ";
	}
//	cout << endl;
	int maxSteps = 0;
	for (int i = 0 ; correct < arrLength - 1; i++) {
//		cout << "========================" << endl;
		int temp = cycle(i);
		if (temp > maxSteps) {maxSteps = temp;}
	}
	if (maxSteps == 0) { maxSteps = -1; }
	ofstream fout("reorder.out");
	fout << numCycles << " " << maxSteps << endl;
	return 0;
}
