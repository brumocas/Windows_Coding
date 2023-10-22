import tkinter as tk
from tkinter import filedialog
from tkinter import ttk
from tkinter import PhotoImage
import img2pdf 

def select_input_file():
    input_file = filedialog.askopenfilename(title="Select Input File")
    input_file_entry.delete(0, tk.END)
    input_file_entry.insert(0, input_file)

def select_output_directory():
    output_directory = filedialog.askdirectory(title="Select Output Directory")
    output_directory_entry.delete(0, tk.END)
    output_directory_entry.insert(0, output_directory)

def process_file():
    input_file = input_file_entry.get()
    output_directory = output_directory_entry.get()
    # Implement your processing logic here
    print("Input File:", input_file)
    print("Output Directory:", output_directory)
    with open(input_file,'rb') as f:
        img = f.read()
        pdf_bytes = img2pdf.convert(img)
    
    output_directory = output_directory + '/' + input_file.rsplit('/')[-1].rsplit('.')[0] + '.pdf'

    with open(output_directory,'wb') as f:
        f.write(pdf_bytes)
    root.destroy()

# Create the main window
root = tk.Tk()
root.title("Image2Pdf Converter")
root.geometry("500x600")


# Set dark mode theme
root.tk_setPalette(background="#333333", foreground="white", activeBackground="#444444", activeForeground="white")

# Create custom style for ttk widgets
style = ttk.Style()
style.theme_use("clam")  # Use the "clam" theme for dark mode

# Load the background image
bg_image = PhotoImage(file="python_logo.png")  # Replace with your image file

# Create a label to hold the background image
bg_label = tk.Label(root, image=bg_image)
bg_label.place(relwidth=1, relheight=1)  # Place the label to cover the whole window


# Create and place widgets
input_frame = ttk.Frame(root)
input_frame.pack(padx=20, pady=20)

input_file_label = ttk.Label(input_frame, text="Select Input File:")
input_file_label.grid(row=0, column=0, sticky="w")

input_file_entry = ttk.Entry(input_frame, width=40)
input_file_entry.grid(row=0, column=1, padx=10)

input_file_button = ttk.Button(input_frame, text="Browse", command=select_input_file)
input_file_button.grid(row=0, column=2)

output_frame = ttk.Frame(root)
output_frame.pack(padx=20, pady=20)

output_directory_label = ttk.Label(output_frame, text="Select Output Directory:")
output_directory_label.grid(row=0, column=0, sticky="w")

output_directory_entry = ttk.Entry(output_frame, width=40)
output_directory_entry.grid(row=0, column=1, padx=10)

output_directory_button = ttk.Button(output_frame, text="Browse", command=select_output_directory)
output_directory_button.grid(row=0, column=2)

process_button = ttk.Button(root, text="Process File", command=process_file)
process_button.pack(padx=20, pady=20)

# Start the GUI event loop
root.mainloop()
