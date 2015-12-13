# Constants

input_file = "badmilk.in"
output_file = "badmilk.out"

# Read

fin = open(input_file);
lines = fin.readlines();
fin.close()

data_1 = [int(s) for s in lines[0].split(" ")]
num_people = data_1[0]
num_milk = data_1[1]
log = [s.strip() for s in lines[1 : 1 + data_1[2]]]
sick = [s.strip() for s in lines[1 + data_1[2] : len(lines)]]

# Filter out possible milks from the sick log
# If the person was sick, all the milks drank AFTER that time are eliminated
# Moreover, if a person was sick but did NOT drink a milk 'm', then milk 'm'
# is not the bad milk

poss_milks = [True] * num_milk

milk_drunk_by_sick = [i + 1 for i in range(0, num_milk)]

for s in sick:
    data = [int(val) for val in s.split(" ")]
    tmp = []
    # For convenience
    person = data[0]
    time = data[1]
    for line in log:
        intified_line = [int(val) for val in line.split(" ")]
        if person == intified_line[0] and intified_line[2] < time:
            tmp.append(intified_line[1])
    milk_drunk_by_sick = list(set(tmp).intersection(milk_drunk_by_sick))

print milk_drunk_by_sick

for i in range(0, num_milk):
    if i + 1 not in milk_drunk_by_sick:
        poss_milks[i] = False

cures = 0

for i in range(0, len(poss_milks)):
    if not poss_milks[i]:
        continue
    milk = i + 1
    tmp = []
    for line in log:
        intified_line = [int(val) for val in line.split(" ")]
        if milk == intified_line[1]:
            if intified_line[0] not in tmp:
                tmp.append(intified_line[0])
    if len(tmp) > cures:
        cures = len(tmp)

fout = open(output_file, 'w')
fout.write(str(cures))
fout.close()

