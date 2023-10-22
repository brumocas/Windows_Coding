import os

file_path = '/Users/bruco/Downloads/sample.pdf'


print(file_path)

if os.path.isfile(file_path):
    os.remove(file_path)
    print("File has successfully been deleted")
else:
    print("This file does NOT exist")