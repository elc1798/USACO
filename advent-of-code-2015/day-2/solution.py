# This is a trivial task... read the lines in the file, split by the x, multiply
# them and add them to a sum + the area for the smallest side

f = open("in")
data = f.readlines()
f.close()

total_wrapping = 0
total_ribbon = 0

for line in data:
    dimensions = [int(s.strip()) for s in line.split("x")]
    assert(len(dimensions) == 3) # srsly...
    # Solve part 1
    areas = [ dimensions[0] * dimensions[1],
              dimensions[0] * dimensions[2],
              dimensions[1] * dimensions[2] ]
    for area in areas:
        total_wrapping += 2 * area
    total_wrapping += min(areas)
    # Solve part 2
    total_ribbon += 2 * (sum(dimensions) - max(dimensions))
    # Add the stupid bow on...
    total_ribbon += dimensions[0] * dimensions[1] * dimensions[2]

print("[Part 1] The elves need %d sq ft of wrapping paper" % (total_wrapping))
print("[Part 2] The elves need %d ft of ribbon" % (total_ribbon))

