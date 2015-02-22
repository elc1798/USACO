def getinfo():
    f = open("cow.in" , 'r')
    l = []
    s = f.readline()
    l.append(s)
    s = f.readline()
    l.append(s)
    f.close()
    return l

def main():
    numCOW = 0
    info = getinfo()
    last_occurence_c = info[1].rfind("C")
    last_occurence_o = info[1].rfind("O")
    last_occurence_w = info[1].rfind("W")
#    print info[0]
#    print info[1]
#    print last_occurence_c
#    print last_occurence_o
    for i in range(0 , last_occurence_c + 1):
        if info[1][i:i+1] == "C":
            for o in range(i , last_occurence_o + 1):
                if info[1][o:o+1] == "O":
                    for w in range(o , last_occurence_w + 1):
                        if info[1][w:w+1] == "W":
                            numCOW += 1

    fout = open("cow.out" , 'w')
    fout.write(str(numCOW))
    fout.close()

if __name__ == "__main__":
    main()
