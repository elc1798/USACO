SQUIRTLE = {
        "water":0,
        "fire":1,
        "grass":-1,
        "electric":-1,
        "rock":1,
        "flying":0
        }

CHARMANDER = {
        "water":-1,
        "fire":0,
        "grass":1,
        "electric":0,
        "rock":-1,
        "flying":0
        }

BULBASAUR = {
        "water":1,
        "fire":-1,
        "grass":0,
        "electric":0,
        "rock":1,
        "flying":-1
        }

f = open("ChooseYourStarterIN.txt")
cases = f.read().split("\n")
f.close()

OUTSTRING = ""

for case in cases:
    types = case.split(" ")
    if len(types) != 3:
        break
    efficiencies = [0,0,0]
    for type in types:
        efficiencies[0] += SQUIRTLE[type]
        efficiencies[1] += CHARMANDER[type]
        efficiencies[2] += BULBASAUR[type]

    if max(efficiencies) == efficiencies[0]:
        OUTSTRING += "squirtle\n"
    elif max(efficiencies) == efficiencies[1]:
        OUTSTRING += "charmander\n"
    else:
        OUTSTRING += "bulbasaur\n"

print OUTSTRING

f = open("run_result.txt", 'w')
f.write(OUTSTRING)
f.close()

