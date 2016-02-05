# Once again... trivial problem. Start at (0,0), add the coordinate you are at
# to a dictionary... since dictionaries in Python are A+ Awesomeness. Return the
# length of the dictionary. Duh.

f = open("in")
data = str(f.readlines()[0]) # good thing f only has 1 line. Thanks problem writer
f.close()

def part1():
    visited = {}
    coor = [0,0]

    for c in data:
        coor_as_string = "%d,%d" % (coor[0], coor[1])
        visited[coor_as_string] = True # Doesn't really matter what value we store
        if c == '^':
            coor[1] += 1
        elif c == '>':
            coor[0] += 1
        elif c == 'v':
            coor[1] -= 1
        elif c == '<':
            coor[0] -= 1
        else:
            print "Wtf random character"

    print("[Part 1] Visited %d houses" % (len(visited)))

def part2():
    # Same concept, just 2 dictionaries, then merge them, duplicate keys are
    # inherently thus removed, return the length.. duh
    santa = {}
    bot = {}
    santa_coor = [0,0]
    bot_coor = [0,0]

    turn = 0
    for c in data:
        coor_as_string = ""
        if turn % 2 == 0:
            coor_as_string = "%d,%d" % (santa_coor[0], santa_coor[1])
        else:
            coor_as_string = "%d,%d" % (bot_coor[0], bot_coor[1])
        if c == '^':
            if turn % 2 == 0:
                santa[coor_as_string] = True
                santa_coor[1] += 1
            else:
                bot[coor_as_string] = True
                bot_coor[1] += 1
        elif c == '>':
            if turn % 2 == 0:
                santa[coor_as_string] = True
                santa_coor[0] += 1
            else:
                bot[coor_as_string] = True
                bot_coor[0] += 1
        elif c == 'v':
            if turn % 2 == 0:
                santa[coor_as_string] = True
                santa_coor[1] -= 1
            else:
                bot[coor_as_string] = True
                bot_coor[1] -= 1
        elif c == '<':
            if turn % 2 ==0:
                santa[coor_as_string] = True
                santa_coor[0] -= 1
            else:
                bot[coor_as_string] = True
                bot_coor[0] -= 1
        else:
            print "Wtf random character"
        turn += 1

    # Double Off-By-One errors, fix
    santa["%d,%d" % (santa_coor[0], santa_coor[1])] = True
    bot["%d,%d" % (bot_coor[0], bot_coor[1])] = True

    # Merge
    for key in bot:
        santa[key] = True

    print("[Part 2] Visited %d houses" % (len(santa)))

part1()
part2()

