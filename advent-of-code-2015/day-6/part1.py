# This isn't *AS* trivial... but still trivial. Store the 'on' lights in a
# dictionary, if it's turned off or toggled, pop the key from dictionary. Return
# the length of the dictionary at the end.

on = {}

def turn_off(startcoor, endcoor):
    for i in range(startcoor[0], endcoor[0] + 1):
        for j in range(startcoor[1], endcoor[1] + 1):
            key = "%d,%d" % (i,j)
            if key in on:
                on.pop(key, None)

def turn_on(startcoor, endcoor):
    for i in range(startcoor[0], endcoor[0] + 1):
        for j in range(startcoor[1], endcoor[1] + 1):
            key = "%d,%d" % (i,j)
            on[key] = True

def toggle(startcoor, endcoor):
    for i in range(startcoor[0], endcoor[0] + 1):
        for j in range(startcoor[1], endcoor[1] + 1):
            key = "%d,%d" % (i,j)
            if key in on:
                on.pop(key, None)
            else:
                on[key] = True

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
    print("[Part 1] Lit up: %d" % (len(on)))

TURN_DOWN_FOR_WHAT()

