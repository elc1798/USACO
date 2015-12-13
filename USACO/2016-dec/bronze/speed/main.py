# Constants

input_file = "speeding.in"
output_file = "speeding.out"

# Vars

segments = []
limits = []

# Read

fin = open(input_file);
lines = fin.readlines();
fin.close()

data_1 = lines[0].split(" ")

for i in range(0, int(data_1[0])):
    tmp = lines[i + 1].strip().split(" ")
    segments.append(int(tmp[0]))
    limits.append(int(tmp[1]))

# Solve

over = 0
curr_segment = 0
i = 0

while i < int(data_1[1]):
    tmp = lines[1 + int(data_1[0]) + i].strip().split(" ")
    tmp_d = int(tmp[0])
    tmp_l = int(tmp[1])
    # tmp[0] = distance
    # tmp[1] = speed
    if tmp_d < segments[curr_segment]:
        if tmp_l - limits[curr_segment] > over:
            over = tmp_l - limits[curr_segment]
        segments[curr_segment] -= tmp_d
        i += 1
    elif tmp_d == segments[curr_segment]:
        if tmp_l - limits[curr_segment] > over:
            over = tmp_l - limits[curr_segment]
        curr_segment += 1
        i += 1
    else:
        if tmp_l - limits[curr_segment] > over:
            over = tmp_l - limits[curr_segment]
        tmp[0] = str(tmp_d - segments[curr_segment])
        newline = tmp[0] + " " + tmp[1]
        lines[1 + int(data_1[0]) + i] = newline
        curr_segment += 1

# Outfile

fout = open(output_file, 'w')
fout.write(str(over))
fout.close()

