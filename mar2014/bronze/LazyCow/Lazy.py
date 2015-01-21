N = 0
K = 0
patchesWithStuff = []
stuffInPatches = []

def ifstream():
	f = open("lazy.in" , "r")
	tempStream = f.readline().split(" ")
	N = int(tempStream[0])
	K = int(tempStream[1])
	for i in range(0 , N):
		tempStream = f.readline().split(" ")
		patchesWithStuff.append(int(tempStream[1]))
		stuffInPatches.append(int(tempStream[0]))
	f.close()

def getGreatest():
	tempVal = 0
	maxnum = 0
	for i in range(0 , max(patchesWithStuff)):
		#tempVal = stuffInPatches[i]
		for j in range(0 , len(patchesWithStuff)):
			if abs(i - patchesWithStuff[j]) <= K + 1:
				tempVal += stuffInPatches[j]
				
		if tempVal > maxnum:
			maxnum = tempVal
		tempVal = 0
	return maxnum

def ofstream(stdout):
	f = open("lazy.out" , "w")
	f.write(stdout)
	f.close()

def main():
	ifstream()
	ans = getGreatest()
	ofstream(str(ans) + "\n")

main()
