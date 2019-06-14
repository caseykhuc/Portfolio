#!c:\python\python.exe
import cgi

print("Content-Type: text/html \n\n")
#import the xlrd module
import xlrd

# opent the speardsheet file (or workbook)
workbook = xlrd.open_workbook("dataFile.xlsx")

# open a sheet:
worksheet = workbook.sheet_by_index(0)

n = worksheet.nrows-1
info = set()

try:
    # loop through every line
    for i in range(n):
        # split firstname, lastname and email
        dataTuple = (format(worksheet.cell(i+1, 0).value), format(worksheet.cell(i+1, 1).value), format(worksheet.cell(i+1, 2).value))
        info.add(dataTuple)
    #print(info)
except:
    print("DataFile ERROR")

# access to the form
formData = cgi.FieldStorage()
# read from fields
group_size = int(formData.getvalue('group-size'))
group_number = int(n/group_size)
waiting_number = n - (group_number * group_size)

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