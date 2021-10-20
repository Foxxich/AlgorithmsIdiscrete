with open(r'C:\\Users\\Vadym\\Documents\\Lista1\\src\\demofile.txt', 'r') as infile, \
     open(r'C:\\Users\\Vadym\\Documents\\Lista1\\src\\write.txt', 'w') as outfile:
    data = infile.read()
    data = data.replace("(", "")
    data = data.replace(")", "")
    data = data.replace(",", "")
    outfile.write(data)