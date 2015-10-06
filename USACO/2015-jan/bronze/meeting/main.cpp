#include <fstream>
#include <iostream>

using namespace std;

int N , M;
int f1[16][2] , f2[16][2] , f3[16][2] , f4[16][2];
int f5[16][2] , f6[16][2] , f7[16][2] , f8[16][2];
int f9[16][2] , f10[16][2] , f11[16][2] , f12[16][2];
int f13[16][2] , f14[16][2] , f15[16][2] , f16[16][2];

int getShortestRoute() {
	//Start in field 1:
	int start;
	int dest;
	int b_time = 0;
	int e_time = 0;
	for (int i = 1; i < 16; i++) {
		if (f1[i] != 0) {
			b_time += f1[i][0];

		}
	}
}

int main() {

	ifstream fin("meeting.in");
	fin >> N;
	fin >> M;
	int A , B , C , D;
	for (int i = 0; i < M; i++) {
		fin >> A;
		fin >> B;
		fin >> C;
		fin >> D;
		switch (A) {
			case 1:
				f1[B - 1][0] = C;
				f1[B - 1][1] = D;
				break;
			case 2:
                                f2[B - 1][0] = C;
                                f2[B - 1][1] = D;
                                break;
			case 3:
                                f3[B - 1][0] = C;
                                f3[B - 1][1] = D;
                                break;
			case 4:
                                f4[B - 1][0] = C;
                                f4[B - 1][1] = D;
                                break;
			case 5:
                                f5[B - 1][0] = C;
                                f5[B - 1][1] = D;
                                break;
			case 6:
                                f6[B - 1][0] = C;
                                f6[B - 1][1] = D;
                                break;
			case 7:
                                f7[B - 1][0] = C;
                                f7[B - 1][1] = D;
                                break;
			case 8:
                                f8[B - 1][0] = C;
                                f8[B - 1][1] = D;
                                break;
			case 9:
                                f9[B - 1][0] = C;
                                f9[B - 1][1] = D;
                                break;
			case 10:
                                f10[B - 1][0] = C;
                                f10[B - 1][1] = D;
                                break;
			case 11:
                                f11[B - 1][0] = C;
                                f11[B - 1][1] = D;
                                break;
			case 12:
                                f12[B - 1][0] = C;
                                f12[B - 1][1] = D;
                                break;
			case 13:
                                f13[B - 1][0] = C;
                                f13[B - 1][1] = D;
                                break;
			case 14:
                                f14[B - 1][0] = C;
                                f14[B - 1][1] = D;
                                break;
			case 15:
                                f15[B - 1][0] = C;
                                f15[B - 1][1] = D;
                                break;
			case 16:
                                f16[B - 1][0] = C;
                                f16[B - 1][1] = D;
                                break;
			default:
		}
	}

	return 0;
}
