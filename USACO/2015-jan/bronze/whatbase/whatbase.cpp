#include <fstream>
#include <iostream>

using namespace std;

int K[100][2];

int getN(int index) {
	char X[3] , Y[3];
	K[index][0] >> X;
	K[index][1] >> Y;
	int decodeX , decodeY;
	int xbase , ybase;

	//First try: Base 7500

	decodeX = (int)X[0] * 7500 * 7500 + (int)X[1] * 7500 + (int)X[2];
	
	return N;
}

int main() {
	ifstream fin("whatbase.in");
	int temp;
	fin >> temp;
	for (int i = 0; i < temp; i++) {
		fin >> K[i][0];
		fin >> K[i][1];
	}
	fin.close();

	int ans[2];
	ofstream fout("whatbase.out");
	for (int i = 0; i < temp; i++) {
		getN(i) >> ans;
		cout << ans[0] << " " << ans[1] << endl;
	}
	fout.close();
}
