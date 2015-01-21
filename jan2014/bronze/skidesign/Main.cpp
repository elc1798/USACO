#include <fstream>
#include <iostream>
#include <algorithm>

using namespace std;

int numSkiSlopes;
int slopeHeights[100];
int minimum;
int minIndex;
int maximum;
int maxIndex;

/*
int minMoney() {

	cout << "Final min: " << minimum << endl << "Final max: " << maximum << endl;

	int toPay = 0;

	while (maximum - 17 - minimum > 0) {
		int toModify = maximum - 17 - minimum;
		if (toModify <= 0) {
			return 0;
		}
		cout << "Modified amount: " << toModify << endl;
		if (toModify % 2 == 0) {
			toPay += 2 * (toModify / 2) * (toModify / 2);
			cout << "Payment: " << toPay << endl;
			slopeHeights[maxIndex] -= (toModify / 2);
			slopeHeights[minIndex] += (toModify / 2);
		} else {
			toPay += (toModify - 1) / 2 * (toModify - 1) / 2;
			toPay += ((toModify - 1) / 2 + 1) * ((toModify - 1) / 2 + 1);
			slopeHeights[maxIndex] -= (toModify - 1) / 2;
                        slopeHeights[minIndex] += (toModify - 1) / 2 + 1;
		}
		minimum = *min_element(slopeHeights , slopeHeights+numSkiSlopes);
		maximum = *max_element(slopeHeights , slopeHeights+numSkiSlopes);
		maxIndex = distance(slopeHeights , find(slopeHeights , slopeHeights+numSkiSlopes , maximum));
		minIndex = distance(slopeHeights , find(slopeHeights , slopeHeights+numSkiSlopes , minimum));
	}
	return toPay;

}
*/

int minMoney() {
	sort(slopeHeights , slopeHeights+numSkiSlopes);
	int prices[100];
	int minPrice = 10000;
	int tempPrice;
	for (int i = 0; i + 17 < slopeHeights[numSkiSlopes - 1]; i++) {
		tempPrice = 0;
		for (int m = 0; slopeHeights[m] < i; m++) {
			tempPrice += (i - slopeHeights[m]) * (i - slopeHeights[m]);
		}
		for (int n = numSkiSlopes - 1; slopeHeights[n] > i + 17; n++) {
			tempPrice += (slopeHeights[n] - i - 17) * (slopeHeights[n] - i - 17);
		}
		if (tempPrice < minPrice) {minPrice = tempPrice;}
	}
	return minPrice;
}

int main() {

	ifstream fin("skidesign.in");
	fin >> numSkiSlopes;

	minimum = 9000;

	for (int i = 0; i < numSkiSlopes; i++) {
		fin >> slopeHeights[i];
		if (slopeHeights[i] < minimum) {
			minIndex = i;
			minimum = slopeHeights[i];
//			cout << "min: " << minimum << endl;
		}
		if (slopeHeights[i] > maximum) {
			maxIndex = i;
			maximum = slopeHeights[i];
//			cout << "max: " << maximum << endl;
		}
	}

	ofstream fout("skidesign.out");
	fout << minMoney() << endl;

	return 0;

}
