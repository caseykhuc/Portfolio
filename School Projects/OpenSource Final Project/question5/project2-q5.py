#!c:\python\python.exe
import cgi

print("Content-Type: text/html \n\n")

# set of candidates information
info = set()
# number of candidates
n = 0

try:
    with open("dataFile.txt") as f:
        # save each line of file into a list
        content = f.read().split()
        n = len(content)
        try:
            # loop through every line
            for i in content:
                # split firstname, lastname and email
                data = i.split(",")
                dataTuple = (data[0], data[1], data[2])
                info.add(dataTuple)
            #print(info)
        except:
            print("DataFile ERROR")
except:
    print("File not found ERROR")

# access to the form
formData = cgi.FieldStorage()
# read from fields
group_size = int(formData.getvalue('group-size'))
group_number = int(n/group_size)
waiting_number = n % group_size

for i in range(group_number):
    print('<h3 align="center">Group', i+1, '</h3>')
    print("<table border='1' align='center' cellpadding='3'>")
    print("<tr><th>Firstname</th><th>Lastname</th><th>Email</th></tr>")
    for j in range(group_size):
        data = info.pop()
        print('<tr>')
        print('<td>', data[0], '</td>')
        print('<td>', data[1], '</td>')
        print('<td>', data[2], '</td>')
        print('</tr>')
    print("</table><br>")

if (waiting_number):
    print('<h3 align="center">Group', group_number + 1, '</h3>')
    print('<h4 align="center">Not verified, waiting for more people</h4>')

    print("<table border='1' align='center' cellpadding='3'>")
    print("<tr><th>Firstname</th><th>Lastname</th><th>Email</th></tr>")
    for j in range(waiting_number):
        data = info.pop()
        print('<tr>')
        print('<td>', data[0], '</td>')
        print('<td>', data[1], '</td>')
        print('<td>', data[2], '</td>')
        print('</tr>')
    print("</table><br>")