# Constants

input_file = "highcard.in"
output_file = "highcard.out"

# Read

fin = open(input_file)
lines = fin.readlines()
fin.close()

elsie = [int(s.strip()) for s in lines[1:]]
bessie = [i + 1 for i in range(0, 2 * int(lines[0].strip())) if i + 1 not in elsie]

# Play the game? Optimally?
# This game is similar to war. If Bessie knows Elsie will place down her higher
# cards at certain turns, if Bessie can beat it, she will, otherwise, give
# lowest card.

def fuzzySearch(alist, item):
    first = 0
    last = len(alist)-1
    found = False

    while first<=last and not found:
        midpoint = (first + last) / 2
        if alist[midpoint - 1] <= item and item <= alist[midpoint]:
            found = True
        else:
            if item < alist[midpoint]:
                last = midpoint-1
            else:
                first = midpoint+1

    return midpoint

def bad_fuzzySearch(alist, item):
    """
    Returns what index an item should come BEFORE
    """
    if item < alist[0]:
        return 0
    if item > alist[len(alist) - 1]:
        return len(alist)
    for i in range(1, len(alist)):
        if alist[i - 1] <= item and item <= alist[i]:
            return i
    return -1

points = 0

while len(elsie) > 0:
    e_card = elsie.pop(0)
    b_card = fuzzySearch(bessie, e_card)
    # If bessie can't beat it, toss the lowest card
    if b_card == len(bessie):
        bessie.pop(0)
    else:
        # Bam Bessie beats it
        bessie.pop(b_card)
        points += 1

# Outfile

fout = open(output_file, 'w')
fout.write(str(points))
fout.close()

