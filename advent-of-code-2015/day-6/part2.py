on = [0] * 1000000

def turn_off(startcoor, endcoor):
    for i in range(startcoor[0], endcoor[0] + 1):
        for j in range(startcoor[1], endcoor[1] + 1):
            if on[1000 * i + j] > 0:
                on[1000 * i + j] -= 1

def turn_on(startcoor, endcoor):
    for i in range(startcoor[0], endcoor[0] + 1):
        for j in range(startcoor[1], endcoor[1] + 1):
            on[1000 * i + j] += 1

def toggle(startcoor, endcoor):
    for i in range(startcoor[0], endcoor[0] + 1):
        for j in range(startcoor[1], endcoor[1] + 1):
            on[1000 * i + j] += 2

def TURN_DOWN_FOR_WHAT():
    f = open("in")
    data = f.readlines()
    f.close()
    trial = 0
    for command in data:
        trial += 1
        if trial % 100 == 0:
            print("Command %d of %d" % (trial, len(data)))
        args = command.split(" ")
        if args[0] == "toggle":
            startcoor = [int(s) for s in args[1].split(",")]
            endcoor = [int(s) for s in args[3].split(",")]
            toggle(startcoor, endcoor)
        elif args[1] == "on":
            startcoor = [int(s) for s in args[2].split(",")]
            endcoor = [int(s) for s in args[4].split(",")]
            turn_on(startcoor, endcoor)
        elif args[1] == "off":
            startcoor = [int(s) for s in args[2].split(",")]
            endcoor = [int(s) for s in args[4].split(",")]
            turn_off(startcoor, endcoor)
        else:
            print("WTF?")

    total = 0
    for i in on:
        total += i
    print("[Part 2] Total Brightness: %d" % (total))

TURN_DOWN_FOR_WHAT()

