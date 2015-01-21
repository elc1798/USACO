Xs = []
Ys = []

def getXY(i):
	xL = str(Xs[i])
	yL = str(Ys[i])
#	print xL
#	print yL
	x = [int(xL[0]) , int(xL[1]) , int(xL[2])]
	y = [int(yL[0]) , int(yL[1]) , int(yL[2])]
#	print x
#	print y

	for i in range(15000):
		

def main(writeout):
	f = open("whatbase.in" , 'r')
	K = int(f.readline())
	for i in range(K):
		s = f.readline().split(' ')
		if int(s[0]) < int(s[1]):
			Xs.append(s[0])
			Ys.append(s[1])
		else:
			Xs.append(s[1])
			Ys.append(s[0])
	print Xs
	print Ys
	for i in range(K):
		L = getXY(i)
		writeout += str(L[0]) + " " + str(L[1]) + "\n"
	f.close()
	g = open("whatbase.out" , "w")
	g.write(writeout)
	g.close()

main("")
