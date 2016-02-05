# Yet... ANOTHER.. TRIVIAL. TASK. I SWEAR IF DAY 5 IS ANOTHER ONE I WILL STOP
# DOING THIS THING.
# LEGIT THIS IS A BRUTE FORCE -_-

import hashlib

key = "iwrupvqb"
n = 1

# Part 1
while True:
    k = key + str(n)
    m = hashlib.md5()
    m.update(k.encode('utf-8'))
    h = m.hexdigest()
    if str(h)[0:5] == "00000":
        print("N = %d yields hash: %s" % (n, h))
        break
    n += 1

# Part 2
# Reset
n = 1

# Seriously. This. Is the MOST. TRIVIAL. PART 2. IN EXISTENCE. I LEGIT NEEDED TO
# CHANGE A *SINGLE* CHARACTER. THAT IS **NOT** A GOOD FOLLOWUP QUESTION.

while True:
    k = key + str(n)
    m = hashlib.md5()
    m.update(k.encode('utf-8'))
    h = m.hexdigest()
    if str(h)[0:6] == "000000":
        print("N = %d yields hash: %s" % (n, h))
        break
    n += 1

