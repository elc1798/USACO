# Another trivial question.

vowels = ['a', 'e', 'i', 'o', 'u']
bad = ["ab", "cd", "pq", "xy"]

f = open("in")
data = f.readlines()
f.close()

# Part 1

nice = 0

for s in data:
    s = s.strip()
    dl = False
    vowel = 0
    bw = False
    for i in range(0, len(s) - 1):
        chunk = s[i:i+2]
        if chunk in bad:
            bw = True
            break
        if chunk[0] == chunk[1]:
            dl = True
        if chunk[0] in vowels:
            vowel += 1
    if chunk[-1:] in vowels:
        vowel += 1
    if dl and vowel >= 3 and not bw:
        nice += 1

print("[Part 1] %d nice words" % (nice))

# Part 2

# OMG FINALLY SOMETHING NOT COMPLETELY TRIVIAL SINCE I DONT WANT THIS THING TO
# RUN FOR ETERNITY!!!

# Update: JK it turned out to be trivial

nice = 0

for s in data:
    s = s.strip()
    pair = False
    separated_dupe = False
    for i in range(0, len(s) - 2):
        if not pair and s.count(s[i:i+2]) > 1: # Because Python is awesome
            pair = True
        if s[i] == s[i+2] and not separated_dupe:
            separated_dupe = True
    if pair and separated_dupe:
        nice += 1

print("[Part 2] %d nice words" % (nice))

