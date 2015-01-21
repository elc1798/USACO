#include <fstream>
#include <iostream>
#include <algorithm>

using namespace std;

int N , K;

int patches[9001];
int maxInPatches = 0;

int lengthOfPatchesToCheck = 0;

int getMaxInField(int patches) {
	int max = 0;
	int maxIndex = 0;
	int temp = 0;
/*
	for (int i = K; i < maxInPatches - K + 1; i++) {
		for (int x = i - K ; x < i + K + 1; x++) {
			temp += patches[x];
		}
		if (temp > max) { max = temp; }
		temp = 0;
	}
*/

	for (int i = 0; i < lengthOfPatchesToCheck; i++) {

	}
	return max;

}

int main() {

	ifstream fin("lazy.in");
	fin >> N;
	fin >> K;

	int temp1 , temp2;

	for (int i = 0; i < N; i++) {
		fin >> temp1;
		fin >> temp2;
		if (temp2 > maxInPatches) { maxInPatches = temp2; }
		//patchesToCheck[i] = temp2;
		cout << patchesToCheck[i] << " ";
		patches[temp2] = temp1;
		lengthOfPatchesToCheck++;
	}

	sort(patchesToCheck , patchesToCheck + lengthOfPatchesToCheck);
	for (int i = 0; i < lengthOfPatchesToCheck; i++) {
		cout << patchesToCheck[i] << " ";
	}
	cout << endl;
	int ans = getMaxInField();

	ofstream fout("lazy.out");
	fout << ans << endl;

	return 0;

}
