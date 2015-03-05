def readfile(src):
    lines = []
    _f = open(src , 'r')
    lines.append(_f.readline().strip())
    lines.append(_f.readline().strip())
    _f.close()
    return lines

def writeout(dst , _DATA):
    _f = open(dst , 'w')
    _f.write(str(_DATA))
    _f.close()
    return

def power2(strnum):
    exp = 0
    num = int(strnum)
    N = 0
    while num > 0:
        N += (num % 10) * (2 ** exp)
        exp += 1
        num = num / 10
    return N

def power3(strnum):
    exp = 0
    num = int(strnum)
    N = 0
    while num > 0:
        N += (num % 10) * (3 ** exp)
        exp += 1
        num = num / 10
    return N

def process(_DATA):
    possible = []
    temp = ""
    for i in range(0 , len(_DATA[0])):
        temp = _DATA[0]
        if int(_DATA[0][i]) == 0:
            temp = temp[0:i] + "1" + temp[i + 1:]
            possible.append(power2(temp))
        else:
            temp = temp[0:i] + "0" + temp[i + 1:]
            possible.append(power2(temp))

    print possible

    for i in range(0 , len(_DATA[1])):
        temp = _DATA[1]
        cache = -1
        for tick in range(0 , 3):
            if int(_DATA[1][i]) != tick:
                temp = temp[0:i] + str(tick) + temp[i + 1:]
                cache = power3(temp)
                print temp + " : " + str(cache)
                if cache in possible:
                    return cache
    return -1 # Not found

def main():
    data_in = readfile("digits.in")
    writeout("digits.out" , process(data_in))
    return

# EXECUTE #

main()
