import os
import customtkinter

import tkinter as tk
from tkinter import filedialog
from tkinter import ttk
from tkinter import PhotoImage

def select_output_directory():
    output_directory = filedialog.askdirectory(title="Select Output Directory")
    output_directory_entry.delete(0, tk.END)
    output_directory_entry.insert(0, output_directory)

def create_folders(root_path):
    
    # TODO :Change here the subjects you are going to have
    subjects = ["ACE", "PSW", "SIC", "SCP", "CI"]
    subjects_path = []
        
    for i in range(len(subjects)):
        subjects_path.append(os.path.join(root_path, subjects[i]))
        
    for i in range(len(subjects_path)):
        create_folder(subjects_path[i], subjects[i])
        
    root.destroy()

def create_folder(path, subject):
    # Check if the folders already exist, and create them if not
    if not os.path.exists(path):
        os.makedirs(path)
        print(f"Created {subject} at {path}")
        
        # TODO: Subfolders that you wuant to have
        subfolders = ["books", "T", "TP"]
        for i in range(len(subfolders)):
            os.makedirs(os.path.join(path, subfolders[i]))
            
        

# Create the main window
root = tk.Tk()
root.title("Subjects Folder Maker")
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

output_frame = ttk.Frame(root)
output_frame.pack(padx=20, pady=20)

output_directory_label = ttk.Label(output_frame, text="Select Output Directory:")
output_directory_label.grid(row=0, column=0, sticky="w")

output_directory_entry = ttk.Entry(output_frame, width=40)
output_directory_entry.grid(row=0, column=1, padx=10)

output_directory_button = ttk.Button(output_frame, text="Browse", command=select_output_directory)
output_directory_button.grid(row=0, column=2)


process_button = ttk.Button(root, text="Create Folders", command=lambda: create_folders(output_directory_entry.get()))
process_button.pack(padx=20, pady=20)

# Start the GUI event loop
root.mainloop()
