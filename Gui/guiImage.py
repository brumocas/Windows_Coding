import tkinter as tk
from tkinter import PhotoImage

def main():
    root = tk.Tk()
    root.title("Background Image Example")
    root.geometry("500x500")  # Set the window size
    
    # Load the background image
    bg_image = PhotoImage(file="python_logo.png")  # Replace with your image file

    # Create a label to hold the background image
    bg_label = tk.Label(root, image=bg_image)
    bg_label.place(relwidth=1, relheight=1)  # Place the label to cover the whole window

    # Add other widgets on top of the background
    label = tk.Label(root, text="Hello, Background!", font=("Helvetica", 24))
    label.pack(pady=20)
    
    button = tk.Button(root, text="Click Me", command=lambda: print("Button clicked"))
    button.pack()

    root.mainloop()

if __name__ == "__main__":
    main()
