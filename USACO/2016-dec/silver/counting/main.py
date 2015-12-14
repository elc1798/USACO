import sqlite3 # huehuehue

infile = "bcount.in"
outfile = "bcount.out"

fin = open(infile)
lines = fin.readlines()
fin.close()

indices = [int(s) for s in lines[0].strip().split(" ")]
cows = [int(s.strip()) for s in lines[1 : 1 + indices[0]]]
queries = [s.strip() for s in lines[1 + indices[0] : ]]

# Name the database the outfile, since we don't know our permissions
conn = sqlite3.connect("mydb")
c = conn.cursor()
c.execute("DROP TABLE IF EXISTS cows;")
c.execute("CREATE TABLE IF NOT EXISTS cows (breed integer, i integer);")
conn.commit() # Commit the changes

for i in range(0, len(cows)):
    c.execute("INSERT INTO cows VALUES (?,?)", (cows[i], i + 1))
conn.commit()

outstring = ""

for q in queries:
    bounds = [int(s) for s in q.split(" ")]
    QUERY = "SELECT * FROM cows WHERE breed = ? AND i >= ? AND i <= ?;"
    for i in [1,2,3]:
        PARAMS = (i, bounds[0], bounds[1])
        result = list(c.execute(QUERY, PARAMS))
        outstring += str(len(result)) + " "
    outstring = outstring[:-1] + "\n"

conn.close()

fout = open(outfile, 'w')
fout.write(outstring)
fout.close()

