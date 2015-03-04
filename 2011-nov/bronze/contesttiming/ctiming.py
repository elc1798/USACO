def readFile(FILENAME):
    _f = open(FILENAME , 'r')
    CACHE = _f.readline().split(' ')
    _f.close()
    return CACHE

def writeFile(FILENAME , OUTPUT):
    _f = open(FILENAME , 'w')
    _f.write(OUTPUT)
    _f.close()

def process(CACHE):
    MINUTES_PAST = 0
    # CACHE[0] - 11 = DAYS PAST
    # CACHE[1] - 11 = HOURS PAST
    # CACHE[2] - 11 = MINUTES PAST
    MINUTES_PAST += int(CACHE[2]) - 11
    MINUTES_PAST += (int(CACHE[1]) - 11) * 60
    MINUTES_PAST += (int(CACHE[0]) - 11) * 60 * 24
    return MINUTES_PAST

def main():
    DATA = readFile("ctiming.in")
    writeFile("ctiming.out" , str(process(DATA)))

# RUN #

main()
