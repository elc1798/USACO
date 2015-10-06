#include <iostream>
#include <algorithm>

using namespace std;

int main() {

	int x[5];
	for (int i = 0; i < 5; i++) {
		x[i] = 10;
	}
	x[4] = 5;
	int test = distance(x , find(x , x+5 , 5));
	cout << test << endl;
	return 0;

}
